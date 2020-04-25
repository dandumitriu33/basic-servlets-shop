package com.codecool.servlet;

import java.util.HashSet;

public class Stock {
    HashSet<Item> shopStock;

    public static Item p1 = new Item("Asus Laptop", 1600);
    public static Item p2 = new Item("Harry Potter Ebook", 50);
    public static Item p3 = new Item("Lego Set", 80);

    public Stock() {
        this.shopStock = new HashSet<Item>();

        add(p1);
        add(p2);
        add(p3);

    }

    public void add(Item product) {
        this.shopStock.add(product);
    }


}
