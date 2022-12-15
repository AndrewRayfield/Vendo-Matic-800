package com.techelevator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductSelection {

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
    private double balance = 5.00;
    public int stock = 5;

    private String[] lineSplit;
    private List<String> testList = new ArrayList<>();

    public String userInput;
    File inventory = new File("vendingmachine.csv");

    ////////////////
    //Constructors//
    ////////////////

    public ProductSelection(){

    }

    ///////////
    //Methods//
    ///////////

    // A method for reading the inventory, acting as a placeholder until all classes are combined
    public void fillProduct () {
        //Reads the inventory file
        try (Scanner sc = new Scanner(inventory)) {
            System.out.println("open inventory file");
            while (sc.hasNextLine()) {
                String textLine = sc.nextLine();
                //System.out.println(textLine);
                testList.add(textLine);
            }

        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    // A method for validating the user's selection
    //if the selection is valid, will print the results from itemReader()
    public void selectProduct(String userInput){
        //Scanner sc = new Scanner(System.in);
        for(String entry : testList){
            //Selection valid and has stock
            if(entry.contains(userInput) && stock > 0){
                //Dispensed product prints name, cost, money remaining, then special item message
                //System.out.println(entry.contains(userInput));
                //System.out.println(itemReader(userInput));
                break;

                //Selection valid but no stock
            }else if(entry.contains(userInput) && stock < 1){
                System.out.println("Sold out!");
                break;
            }else if(!entry.contains(userInput)){
                //System.out.println("false");
                //break;
            }

            // Invalid selection, stock irrelevant
//            if(entry.contains(userInput)){
//                System.out.println("Please make a valid selection.");
//            }
        }
    }

    //A method for getting the relevant inventory information from a valid user selection
    public String itemReader(String userChoice){
        String name = "";
        double price = 0.0;
        String type = "";

        //Loops through each row of the inventory file
        //Then splits each part of the row into a String array
        // Makes a switch specific iterator to fill the related item information

        for (String item : testList) {
            if(item.contains(userChoice)) {
                lineSplit = item.split("\\|");
                for (int i = 1; i < lineSplit.length; i++) {
                    // i is initialized at 1 to ignore the [0] index, which is the vending code
                    switch (i) {
                        case 1:
                            name = lineSplit[i];
                            break;

                        case 2:
                            price = Double.parseDouble(lineSplit[i]);
                            break;
                        case 3:
                            type = lineSplit[i];
                    }
                }
            }
        }
        return name + " " + price + " " + type;
    }
}
