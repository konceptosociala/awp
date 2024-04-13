package org.verstiukhnutov.awp.model;

import java.util.ArrayList;
import java.util.HashSet;

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

    public void removeGroup(Group group) {
        groups.remove(group);
    }

    public void editGroup(Group group, GroupName name, String description) {
        group.setName(name);
        group.setDescription(description);
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

    public Product[] findProducts(SearchPattern pattern) {
        return groups
            .stream()
            .flatMap(g -> g.getProducts().stream())
            .filter(p -> pattern.pertains(p.getName().toString()))
            .toArray(Product[]::new);
    }
}
