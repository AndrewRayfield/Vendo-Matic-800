package com.techelevator;

public class Gum extends Items {
    public Gum(String name, double price, String location) {
        super(name, price, location);
    }

    public Gum() {
    }

    @Override
    public String dispensingMessage() {
        return "Glug Glug, Yum!";
    }
}
