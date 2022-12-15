package com.techelevator;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Scanner;

public class ProductSelection extends Inventory{

    // Class for product selection

    //Flow of product selection:
    //1. Show list of products and allow customer to enter code for selection
    //      for the list of products:
    //          if not valid selection, return to purchase
    //          if not enough stock, return to purchase
    //          otherwise, dispense product
    //2. when product is dispensed:
    //      print the item name, cost, money remaining
    //      print a secondary message related to product
    //      finally, update cash balance and return to purchase
    //

    ////////////////
    //Declarations//
    ////////////////
    public String userInput;
    private double balance = 5.00;
    NumberFormat currency = NumberFormat.getCurrencyInstance();

    Inventory inv = new Inventory();
    ////////////////
    //Constructors//
    ////////////////

    //Constructor that takes the balance from the feed money method,
    //adjusts the balance in selectProduct()
    public ProductSelection(double balance){
        this.balance = balance;
    }
    public ProductSelection(){

    }

    ///////////
    //Methods//
    ///////////

    public void checkSelection(String selection){
        boolean valid = false;
        for(Items entry : INVENTORY_ARRAY) {

            if (entry.getLocation().equalsIgnoreCase(selection)) {
                valid = true;
                selectProduct(selection);
                break;
            }
        }
        if(!valid){
            System.out.println("Invalid selection");
        }

    }

    // A method for validating the user's selection
    //if the selection is valid, will print the results from itemReader()
    public void selectProduct(String selection){
        //Scanner sc = new Scanner(System.in);
        //System.out.println("Please make a selection: ");
        //userInput = sc.nextLine();

        for(Items entry : INVENTORY_ARRAY){
            if(entry.getLocation().equalsIgnoreCase(selection) && entry.getStock() > 0 && balance >= entry.getPrice() ) {
                balance -= entry.getPrice();
                System.out.println("Purchased: " + entry.getName() + " | Price: " + currency.format(entry.getPrice()) + " | Remaining: " + currency.format(balance));
                System.out.println(entry.dispensingMessage());
                entry.sellProduct();
                // Log the purchase here
                // Call the purchase menu here
                // will render break redundant
                break;

            }
            if(entry.getLocation().equalsIgnoreCase(userInput) && entry.getStock() < 1) {
                System.out.println("Sorry, out of stock.");
                // Call to purchase menu here
                // will render break redundant
                break;
            }
            if(entry.getLocation().equalsIgnoreCase(userInput) && balance < entry.getPrice()) {
                System.out.println("Insufficient funds.");
                // Call to purchase menu here
                // will render break redundant
                break;
            }

        }
    }
}
