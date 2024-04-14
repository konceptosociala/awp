package org.verstiukhnutov.awp.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import org.verstiukhnutov.awp.model.search.SearchPattern;
import org.verstiukhnutov.swelm.utils.MsgBox;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AwpModel {
    private HashSet<Group> groups;

    public AwpModel() {
        groups = new HashSet<>();
    }

    public static AwpModel fromJson() {
        try {
            File file = new File("awp.json");
            Scanner scanner = new Scanner(file);
            String json = new String();
            while (scanner.hasNextLine()) {
                json += scanner.nextLine();
            }
            scanner.close();

            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, AwpModel.class);
        } catch (FileNotFoundException fnfe) {
            File file = new File("awp.json");
            AwpModel university = new AwpModel();

            try {
                file.createNewFile();
                ObjectMapper mapper = new ObjectMapper();        
                String json = mapper.writeValueAsString(university);

                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write(json);
                writer.close();
            } catch (IOException ioe) {
                MsgBox.error("Fatal error", "I/O error: "+ioe.getMessage());
                System.exit(-1);
            }

            return university;
        } catch (JsonProcessingException jpe) {
            MsgBox.error("Fatal error", "Cannot process JSON: "+jpe.getMessage());
            System.exit(-1);
            return null;
        }
    }

    public void toJson() {
        try {
            ObjectMapper mapper = new ObjectMapper();        
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);

            BufferedWriter writer = new BufferedWriter(new FileWriter("awp.json"));
            writer.write(json);
            writer.close();
        } catch (JsonProcessingException jpe) {
            jpe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
    }

    public ArrayList<Group> getGroups() {
        return new ArrayList<>(groups);
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public boolean containsGroup(String name) {
        return groups
            .stream()
            .anyMatch(g -> g.getName().toString().equals(name));
    }

    public void removeGroup(Group group) {
        groups.remove(group);
    }

    public Group findGroup(GroupName name) {
        return groups
            .stream()
            .filter(g -> g.getName().toString().equals(name.toString()))
            .findFirst()
            .orElse(null);
    }

    public Group[] findGroups(SearchPattern pattern) {
        return groups
            .stream()
            .filter(g -> pattern.pertains(g.getName().toString()))
            .toArray(Group[]::new);
    }

    public ArrayList<Product> getProducts() {
        return groups
            .stream()
            .flatMap(g -> g.getProducts().stream())
            .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public Product[] findProducts(SearchPattern pattern) {
        return groups
            .stream()
            .flatMap(g -> g.getProducts().stream())
            .filter(p -> pattern.pertains(p.getName().toString()))
            .toArray(Product[]::new);
    }

    public void removeProduct(Product product) {
        groups
            .stream()
            .filter(g -> g.getProducts().contains(product))
            .findFirst()
            .ifPresent(g -> g.getProducts().remove(product));
    }
}
