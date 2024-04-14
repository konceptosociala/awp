package org.verstiukhnutov.awp.model;

public class Product {
    private ProductName name;
    private Manufacturer manufacturer;
    private String description;
    private int amount;
    private int price;

    private Group group;

    public Product(
        ProductName name, 
        Manufacturer manufacturer, 
        String description, 
        int amount, 
        int price,
        Group group
    ){
        this.name = name;
        this.manufacturer = manufacturer;
        this.description = description;
        this.amount = amount;
        this.price = price;
        this.group = group;
    }

    public Product() {}
    
    public ProductName getName() {
        return name;
    }

    public void setName(ProductName name) {
        this.name = name;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
