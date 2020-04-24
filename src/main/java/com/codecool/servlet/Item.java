package com.codecool.servlet;

public class Item {
    private static int productCounter = 0;
    int id;
    String name;
    double price;

    {
        productCounter += 1;
    }

    public Item(String name, double price) {
        this.id = productCounter;
        this.name = name;
        this.price = price;
    }
}
