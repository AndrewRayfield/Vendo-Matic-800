package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.lang.reflect.*;

public class Inventory {

    private static final int MAX_STOCK = 5;
    static List<Items> inventoryList = new ArrayList<>();

    static Map <String, Items> inventoryMap = new TreeMap<>();
    public static final Items[] INVENTORY_ARRAY = createAllInventory();
    //public static final Map<String, Items> INVENTORY_MAP = createAllInventory();

    private static Items[] createAllInventory() {
    //private static Map<String, Items> createAllInventory() {


        File inventory = new File ("vendingmachine.csv");

        try (Scanner inventoryReader = new Scanner (inventory)) {
            while (inventoryReader.hasNextLine()) {
                String lineOfText = inventoryReader.nextLine();
                String[] informationForTheProduct = lineOfText.split("\\|");
                String productLocation = informationForTheProduct[0];
                String productName = informationForTheProduct[1];
                double productPrice = Double.parseDouble(informationForTheProduct[2]);
                String productType = informationForTheProduct[3];

                Items items = new Items();
                items.setName(productName);
                // AE: Comment for my clarification: looks through techelevator package referencing productType
                // Calls the constructor within the class of the item, building the parameters
                // Creates the instance of the constructor with the built parameters, typeset as an Items class
                Class<?> currentClass = Class.forName("com.techelevator." + productType);
                Constructor<?> currentClassConstructor = currentClass.getConstructor(String.class, double.class, String.class);
                Items newItem = (Items) currentClassConstructor.newInstance(productName, productPrice, productLocation);

                //Items newItems = (Items) con.newInstance(productName,productPrice,productLocation);
                //Items newItems = new Items (productName, productPrice, productType, productLocation);
                inventoryList.add(newItem);
                //inventoryMap.put(productLocation, newItem);

            }
        } catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
        Items [] itemsArray = new Items [inventoryList.size ()];
        return inventoryList.toArray(itemsArray);
        //return inventoryMap;
        }

    public static void restock() {
//        for (Items items : INVENTORY_MAP) {
//            items.setStock(MAX_STOCK);
//        }
    }
    public static void displayInventory(){
//        for (var entry : inventoryMap.entrySet()) {
//            System.out.println(entry.getKey() + ") " + entry.getValue());
//        }
        for (Items items : INVENTORY_ARRAY) {
            System.out.println(items);
        }
    }
private static void addToInventoryList(Items item){
    inventoryList.add (item);
}

}

