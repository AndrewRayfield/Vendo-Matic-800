package com.techelevator;

import org.junit.Test;

public class ProductSelectionTest extends ProductSelection {

    ProductSelection ps = new ProductSelection();

    @Test
    public void validPurchaseTest() throws Exception{
        ps = new ProductSelection(5);
        ps.userInput = "B1";
        ps.selectProduct(ps.userInput);
        System.out.println("");

    }

    @Test
    public void multiPurchaseTest() throws Exception{
        ps = new ProductSelection(5);
        ps.userInput = "A2";
        ps.selectProduct(ps.userInput);

        ps.userInput = "A1";
        ps.selectProduct(ps.userInput);

        System.out.println("");
    }

    @Test
    public void multiPurchaseToLowFunds() throws Exception{
        ps = new ProductSelection(5);
        ps.userInput = "A2";
        ps.selectProduct(ps.userInput);

        ps.userInput = "A3";
        ps.selectProduct(ps.userInput);

        ps.userInput = "B2";
        ps.selectProduct(ps.userInput);
    }

    @Test
    public void lowFundsTest() throws Exception{
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
    public void noStockTest() throws Exception{
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
    public void validCheckTest() throws Exception{
        ps.checkSelection("A1");
    }

    @Test
    public void invalidCheckTest() throws Exception{
        ps.checkSelection("G8");
    }


}
