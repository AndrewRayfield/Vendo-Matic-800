package com.techelevator;

public class Drink extends Items {
    public Drink(String name, double price, String location) {
        super(name, price, location);
    }

    public Drink() {
    }

    @Override
    public String dispensingMessage() {
        return "Glug Glug, Yum!";
    }
}
