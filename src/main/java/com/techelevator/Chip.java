package com.techelevator;

public class Chip extends Items {
    public Chip(String name, double price, String location) {
        super(name, price, location);
    }

    public Chip() {

    }

    @Override
    public String dispensingMessage() {
        return "Crunch Crunch, Yum!";
    }
}
