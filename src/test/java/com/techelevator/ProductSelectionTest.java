package com.techelevator;

import org.junit.Test;

public class ProductSelectionTest extends ProductSelection {

    ProductSelection ps = new ProductSelection();

    @Test
    public void validPurchaseTest(){
        ps = new ProductSelection(5);
        ps.userInput = "B1";
        ps.selectProduct(ps.userInput);
        System.out.println("");

    }

    @Test
    public void multiPurchaseTest(){
        ps = new ProductSelection(5);
        ps.userInput = "A2";
        ps.selectProduct(ps.userInput);

        ps.userInput = "A1";
        ps.selectProduct(ps.userInput);

        System.out.println("");
    }

    @Test
    public void multiPurchaseToLowFunds(){
        ps = new ProductSelection(5);
        ps.userInput = "A2";
        ps.selectProduct(ps.userInput);

        ps.userInput = "A3";
        ps.selectProduct(ps.userInput);

        ps.userInput = "B2";
        ps.selectProduct(ps.userInput);
    }

    @Test
    public void lowFundsTest(){
        ps = new ProductSelection(5);
        ps.userInput = "B1";
        ps.selectProduct(ps.userInput);

        ps.userInput = "A2";
        ps.selectProduct(ps.userInput);

        ps.userInput = "A1";
        ps.selectProduct(ps.userInput);
        System.out.println("");
    }

    @Test
    public void noStockTest(){
        ps = new ProductSelection(5);
        ps.userInput = "B4";

        for(Items item : INVENTORY_ARRAY){
            while (item.getLocation().equalsIgnoreCase(ps.userInput)) {
                item.setStock(0);
                ps.selectProduct(ps.userInput);
                break;
            }
        }
        //ps.selectProduct(ps.userInput);
    }

    @Test
    public void validCheckTest(){
        ps.checkSelection("A1");
    }

    @Test
    public void invalidCheckTest(){
        ps.checkSelection("G8");
    }

    @Test
    public void selectionTest(){
        //ps.checkSelection();

    }


}
