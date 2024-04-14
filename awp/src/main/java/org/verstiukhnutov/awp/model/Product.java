package org.verstiukhnutov.awp.model;

public class Product {
    private ProductName name;
    private Manufacturer manufacturer;
    private String description;
    private int amount;
    private int price;

    public Product() {
        this.name = new ProductName();
        this.manufacturer = new Manufacturer();
        this.description = "";
        this.amount = 0;
        this.price = 0;
    }

    public Product(
        ProductName name, 
        Manufacturer manufacturer, 
        String description, 
        int amount, 
        int price
    ){
        this.name = name;
        this.manufacturer = manufacturer;
        this.description = description;
        this.amount = amount;
        this.price = price;
    }
    
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
}
