package org.verstiukhnutov.awp.model;

import java.util.ArrayList;
import java.util.HashSet;

import org.verstiukhnutov.awp.model.error.NoSuchGroupException;
import org.verstiukhnutov.awp.model.search.SearchPattern;

public class AwpModel {
    private HashSet<Group> groups;

    public AwpModel() {
        groups = new HashSet<>();
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

    public void addProduct(Product product) throws NoSuchGroupException {
        Group productGroup = findGroup(product.getGroup().getName());
        if (productGroup == null) {
            throw new NoSuchGroupException(product.getGroup().getName().toString());
        }

        productGroup.addProduct(product);
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
}
