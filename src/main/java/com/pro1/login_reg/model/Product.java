package com.pro1.login_reg.model;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @Column(unique = true, nullable = false)
    private int id;
    private String name;
    private int quantity;
    private int price;
    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false)
    private ProductCategory category;

    public Product() {

    }

    public Product(int id, String name, int quantity, int price,ProductCategory category) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
