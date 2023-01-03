package com.techelevator;

import com.techelevator.view.Menu;
import com.techelevator.view.PurchaseMenu;

import java.text.NumberFormat;
import java.util.Map;

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
    SalesReport sr = new SalesReport();
    PurchaseMenuApp purchaseMenuApp = new PurchaseMenuApp();

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

    public void selectProduct(String selection){
        // double reserved for adding to the log file
        double startBalance = balance;

        for(Items entry : INVENTORY_ARRAY){
            if(entry.getLocation().equalsIgnoreCase(selection) && entry.getStock() > 0 && balance >= entry.getPrice() ) {
                balance -= entry.getPrice();
                purchaseMenuApp.writeText("Purchased: " + entry.getName() + " | Price: " + currency.format(entry.getPrice()) + " | Remaining: " + currency.format(balance) + "\n"
                + "\t\t    " + entry.dispensingMessage());
                entry.sellProduct();
                Logger.log(entry.getName() + " " + entry.getLocation(), startBalance, balance);
                sr.addToReport(entry.getName());
                PurchaseMenu.setNewBalance(balance);
                break;

            }
            if(entry.getLocation().equalsIgnoreCase(selection) && entry.getStock() < 1) {
                System.out.println("Sorry, out of stock.");
                break;
            }
            if(entry.getLocation().equalsIgnoreCase(selection) && balance < entry.getPrice()) {
                System.out.println("Insufficient funds.");
                break;
            }

        }
    }
}
