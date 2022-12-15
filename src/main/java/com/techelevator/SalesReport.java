package com.techelevator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SalesReport {
    public static Map<String, Integer> itemsSalesReport = new HashMap<>();
    public static Map<String, Double> itemPrice = new HashMap<>();
    public double totalSold = 0;

    public void createReport() {
        int startingAmount = 0;
        File inventory = new File("vendingmachine.csv");

        try(Scanner sc = new Scanner(inventory)) {
            while(sc.hasNextLine()) {
                String lineOfText = sc.nextLine();
                String[] snack = lineOfText.split("\\|");
                itemsSalesReport.put(snack[1], startingAmount);
                itemPrice.put(snack[1], Double.valueOf(snack[2]));
            }
        } catch (Exception e) {
            System.out.println("Inventory does not exist");
        }
    }

    public void addToReport(String name, int amount) {
        int itemSold = amount + itemsSalesReport.get(name);
        totalSold += itemPrice.get(name);

        itemsSalesReport.put(name, itemSold);

    }

    public void displayReport() {
        File salesFile = new File("SalesReport"+ LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE) +".txt");
        NumberFormat currency = NumberFormat.getCurrencyInstance();

        try(PrintWriter out = new PrintWriter(new FileOutputStream(salesFile))) {
            for(Map.Entry<String, Integer> entry : itemsSalesReport.entrySet()) {
                out.println(entry.getKey() + " | " + entry.getValue().toString());
            }

            out.println("\n**TOTAL SALES** " + currency.format(totalSold));
        } catch (IOException e) {
            System.out.println("File Not Found");
        }

    }

}