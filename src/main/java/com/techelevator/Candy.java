package com.techelevator;

public class Candy extends Items {
    public Candy() {}

    public Candy(String name, double price, String location) {
        super(name, price, location);
    }

    @Override
    public String dispensingMessage() {
        return "Munch Munch, Yum!";
    }
}
