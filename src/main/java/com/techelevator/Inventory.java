package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.lang.reflect.*;

public class Inventory {

    private static final int MAX_STOCK = 5;
    static List<Items> inventoryList = new ArrayList<>();

    public static final Items[] INVENTORY_ARRAY = createAllInventory();

    private static Items[] createAllInventory() {


        File inventory = new File("vendingmachine.csv");

        try (Scanner inventoryReader = new Scanner(inventory)) {
            while (inventoryReader.hasNextLine()) {
                String lineOfText = inventoryReader.nextLine();
                String[] informationForTheProduct = lineOfText.split("\\|");
                String productLocation = informationForTheProduct[0];
                String productName = informationForTheProduct[1];
                double productPrice = Double.parseDouble(informationForTheProduct[2]);
                String productType = informationForTheProduct[3];

                Items myItem = new Items(productName, productPrice, productLocation);

                inventoryList.add(myItem);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        Items[] itemsArray = new Items[inventoryList.size()];
        return inventoryList.toArray(itemsArray);
    }


    public static void displayInventory() {

        for (Items items : INVENTORY_ARRAY) {
            System.out.println(items);
        }
    }
}


