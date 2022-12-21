package com.techelevator;

import java.text.NumberFormat;

public class Items  {

    private final int MAX_STOCK = 5;
    private String name;
    private double price;
    private String location;
    private int stock;

    public Items(String name, double price, String location) {
        this.name = name;
        this.price = price;
        this.location = location;
        stock = MAX_STOCK;
    }

    public Items() {

    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }


    public String getLocation() {
        return location;
    }

   public int getStock() {
        return stock;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        if (stock == 0) {
            return location + ") " + this.name + " " + currency.format(this.price) + " | SOLD OUT";
        }
        return location + ") " + this.name + " " + currency.format(this.price) + " | " + stock + " Available";

    }
    public  String dispensingMessage() {
        return "";
    }


    public void sellProduct (){

        this.stock -= 1;



    }
    public void setStock(int stock) {
        this.stock = stock;
    }
}
