package com.techelevator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
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


    // A method for validating the user's selection
    //if the selection is valid, will print the results from itemReader()
    public void selectProduct(String selection){
        //Items items = new Items();
        //Scanner sc = new Scanner(System.in);
        //System.out.println("Please make a selection: ");
        //userInput = sc.nextLine();
        //itemReader(userInput);
        for(Items entry : INVENTORY_ARRAY){
            if(entry.getLocation().equals(selection) && entry.getStock() > 0 ) {
                //print name, cost, money remaining
                balance -= entry.getPrice();
                System.out.println(entry.getName() + " " + entry.getPrice() + " " + balance);
                System.out.println(entry.dispensingMessage());
                entry.sellProduct();
                break;

            }else if(entry.getLocation().equals(userInput) && entry.getStock() < 1){
                System.out.println("Out of stock.");
                break;

            }else if(!entry.getLocation().equals(selection)){
                System.out.println("Please make a valid selection");
                break;
            }
        }
    }
}
