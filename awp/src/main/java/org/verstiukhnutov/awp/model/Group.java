package org.verstiukhnutov.awp.model;

import java.util.HashSet;


public class Group {
    private GroupName name;
    private String description;
    private HashSet<Product> products;

    public Group(GroupName name, String description) {
        this.name = name;
        this.description = description;
        this.products = new HashSet<>();
    }

    public GroupName getName() {
        return name;
    }

    public void setName(GroupName name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HashSet<Product> getProducts() {
        return products;
    }
}
