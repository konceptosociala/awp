package org.verstiukhnutov.awp.model;

import java.util.HashSet;


public class Group {
    private GroupName name;
    private HashSet<Product> products;

    public Group(GroupName name) {
        this.name = name;
        this.products = new HashSet<>();
    }

    public GroupName getName() {
        return name;
    }

    public void setName(GroupName name) {
        this.name = name;
    }

    public HashSet<Product> getProducts() {
        return products;
    }
}
