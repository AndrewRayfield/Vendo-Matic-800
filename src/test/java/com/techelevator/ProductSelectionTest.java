package com.techelevator;

import org.junit.Test;
import org.mockito.internal.matchers.Null;

public class ProductSelectionTest extends ProductSelection {

    ProductSelection ps = new ProductSelection();
    SalesReport sr = new SalesReport();

    @Test
    public void validPurchaseTest(){
        sr.createReport();
        ps = new ProductSelection(5);
        ps.userInput = "B1";
        ps.selectProduct(ps.userInput);
        System.out.println("");
    }

    @Test
    public void multiPurchaseTest(){
        sr.createReport();
        ps = new ProductSelection(5);
        ps.userInput = "A2";
        ps.selectProduct(ps.userInput);

        ps.userInput = "A1";
        ps.selectProduct(ps.userInput);

        System.out.println("");
    }

    @Test
    public void multiPurchaseToLowFunds(){
        sr.createReport();
        ps = new ProductSelection(5);
        //String test = "A2";
        ps.selectProduct("A2");

        //ps.userInput = "A3";
        ps.selectProduct("A3");

        //ps.userInput = "B2";
        ps.selectProduct("B2");
    }

    @Test
    public void lowFundsTest(){
        sr.createReport();
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
        sr.createReport();
        ps.checkSelection("A1");
    }

    @Test
    public void invalidCheckTest(){
        ps.checkSelection("G8");
    }

//    @Test
//    public void selectionTest(){
//        //ps.checkSelection();
//
//    }


}
