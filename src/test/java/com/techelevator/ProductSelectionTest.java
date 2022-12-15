package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class ProductSelectionTest {

    @Test
    public void ProductSelection(){
        ProductSelection ps = new ProductSelection();
        //ps.fillProduct();
        ps.userInput = "A2";
        //ps.stock = 0;

        //ps.itemReader(ps.userInput);

        ps.selectProduct(ps.userInput);
        //Assert.assertEquals(ps.dispenseItem(testCode));
    }

}
