package com.codecool.servlet;

import java.util.HashSet;

public class Stock {
    HashSet<Item> shopStock;

    public Stock() {
        this.shopStock = new HashSet<Item>();

    }

    public void add(Item product) {
        this.shopStock.add(product);
    }


}
