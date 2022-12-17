package com.techelevator;

import java.text.NumberFormat;

public class Items  {

    private final int MAX_STOCK = 5;
    private String name;
    private double price;
    //private String typeOfProduct;
    private String location;
    //the stock should be in the inventory?
    private int stock;

    public Items(String name, double price, String location) {
        this.name = name;
        this.price = price;
        //this.typeOfProduct = typeOfProduct;
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

//    public String getTypeOfProduct() {
//        return typeOfProduct;
//    }

    public String getLocation() {
        return location;
    }

   public int getStock() {
        return stock;
    }

    @Override
    public String toString() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return   this.name + " " + currency.format(this.price);

    }
    public  String dispensingMessage() {
        return "";
    }
//        if (typeOfProduct.equalsIgnoreCase("Chip")) {
//            return "Crunch Crunch, Yum!";
//        }
//        else if (typeOfProduct.equalsIgnoreCase("Candy")) {
//            return "Munch Munch, Yum!"; }
//
//        else if (typeOfProduct.equalsIgnoreCase("Drink")) {
//            return "Glug Glug, Yum!"; }
//
//        else if (typeOfProduct.equalsIgnoreCase("Gum")) {
//            return "Chew Chew, Yum!"; }
//
//        else {
//            return "Do Not Have Type";
//        }

    public void sellProduct (){

        this.stock -= 1;


    }
    public void setStock(int stock) {
        this.stock = stock;
    }
}
