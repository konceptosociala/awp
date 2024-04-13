package org.verstiukhnutov.awp.model;

import java.util.HashSet;

import org.verstiukhnutov.awp.model.search.SearchPattern;

public class AwpModel {
    private HashSet<Group> groups;

    public AwpModel() {
        groups = new HashSet<>();
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
