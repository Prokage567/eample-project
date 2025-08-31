package com.oop.oop;

public class Product {

    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public void SetName(String name) {
        this.name = name;
    }

    public void SetPrice(double price) {
        this.price = price;
    }

    public void SetQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String GetName() {
        if (price < 1) {
            price = 1;
        }
        return name;
    }

    public double GetPrice() {
        return price;
    }

    public int GetQuantity() {
        return quantity;
    }
}
