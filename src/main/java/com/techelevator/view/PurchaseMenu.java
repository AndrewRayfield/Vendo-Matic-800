package com.techelevator.view;

import com.techelevator.Inventory;
import com.techelevator.Items;
import com.techelevator.Logger;
import com.techelevator.ProductSelection;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Scanner;

public class PurchaseMenu extends Menu{
    //Purchase Menu Options
    private static final String PURCHASE_MENU_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_FEED_MONEY , PURCHASE_MENU_SELECT_PRODUCT, PURCHASE_MENU_FINISH_TRANSACTION };

    //Feed Money Options
    private static final String FEED_MONEY_1 = "$1";
    private static final String FEED_MONEY_2 = "$2";
    private static final String FEED_MONEY_5 = "$5";
    private static final String FEED_MONEY_10 = "$10";
    private static final String FEED_MONEY_20 = "$20";
    private static final String [] FEED_MONEY_OPTIONS = {FEED_MONEY_1,FEED_MONEY_2,FEED_MONEY_5,FEED_MONEY_10,FEED_MONEY_20};

    public PurchaseMenu(InputStream input, OutputStream output) {
        super(input, output);

    }

    public void showPurchaseMenu() {
        while (true) {
            NumberFormat currency = NumberFormat.getCurrencyInstance();
            System.out.println("Current Money Provided: " + currency.format(currentMoneyProvided));

            String purchaseChoice = (String) getChoiceFromOptions(PURCHASE_MENU_OPTIONS, true);

            //Feed Money Option
            if (purchaseChoice.equals(PURCHASE_MENU_FEED_MONEY)) {
                double moneyBefore = currentMoneyProvided;
                String feedMoneyChoice = (String) getChoiceFromOptions(FEED_MONEY_OPTIONS, true);

                /////Add money
                if (feedMoneyChoice.equals(FEED_MONEY_1)) {
                    currentMoneyProvided += 1.0;
                } else if (feedMoneyChoice.equals(FEED_MONEY_2)) {
                    currentMoneyProvided += 2.0;
                } else if (feedMoneyChoice.equals(FEED_MONEY_5)) {
                    currentMoneyProvided += 5.0;
                } else if (feedMoneyChoice.equals(FEED_MONEY_10)) {
                    currentMoneyProvided += 10.0;
                } else if (feedMoneyChoice.equals(FEED_MONEY_20)) {
                    currentMoneyProvided += 20.0;
                }

                //Logs starting amount and end amount in Log.txt
                Logger.log("FEED MONEY", moneyBefore, currentMoneyProvided);

            } else if (purchaseChoice.equals(PURCHASE_MENU_SELECT_PRODUCT)) {
                Items itemsChoice = (Items) getChoiceFromOptions(Inventory.INVENTORY_ARRAY, false);

                // Creates instance of ProductSelection, taking the currently fed money in machine
                // then validates the user selection as one that actually exists in the machine
                //System.out.println();
                ProductSelection ps = new ProductSelection(currentMoneyProvided);
                //ps.checkSelection(stringChoice);
                ps.checkSelection((itemsChoice.getLocation()));


            } else if (purchaseChoice.equals(PURCHASE_MENU_FINISH_TRANSACTION)) {
                double moneyBefore = currentMoneyProvided;

                System.out.println(makeChange(currentMoneyProvided));
                currentMoneyProvided = 0.0;

                Logger.log("GIVE CHANGE", moneyBefore, currentMoneyProvided);
                break;
            }
        }
    }

    public static String makeChange(double moneyRemaining){
        int moneyInCents = (int) (moneyRemaining * 100);

        int numOfQuarters = moneyInCents / 25;
        moneyInCents = moneyInCents % 25;

        int numOfDimes = moneyInCents / 10;
        moneyInCents = moneyInCents % 10;

        int numOfNickles = moneyInCents / 5;

        return "Returning "+ numOfQuarters + " quarters, " + numOfDimes + " dimes, and " + numOfNickles + " nickles.";
    }

    //AE: Changes the balance from select product
    // if/when we split the menu further or make a class for cash handling,
    // this method can move into that class
    public static void setNewBalance(double newBalance){
        currentMoneyProvided = newBalance;

    }

}

