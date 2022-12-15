package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {
    public static final Items[] INVENTORY_ARRAY = createAllInventory();

    private static Items[] createAllInventory () {
        List<Items> inventoryList = new ArrayList<>();

        File inventory = new File ("vendingmachine.csv");

        try (Scanner inventoryReader = new Scanner (inventory)) {
            while (inventoryReader.hasNextLine()) {
                String lineOfText = inventoryReader.nextLine();
                String [] informationForTheProduct = lineOfText.split("\\|");
                String productLocation = informationForTheProduct [0];
                String productName = informationForTheProduct [1];
                double productPrice = Double.parseDouble(informationForTheProduct [2]);
                String productType = informationForTheProduct [3];
                Items newItems = new Items (productName, productPrice, productType, productLocation);
                inventoryList.add (newItems);
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }
        Items [] itemsArray = new Items [inventoryList.size ()];
        return inventoryList.toArray(itemsArray);
    }
    public static void restock () {
        for (Items items : INVENTORY_ARRAY) {
            items.setStock(5);
        }
    }
    public static void displayInventory(){
        for (Items items : INVENTORY_ARRAY) {
            System.out.println(items + " | " + items.getStock() + " available");
        }
    }


}

