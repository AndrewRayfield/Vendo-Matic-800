package com.techelevator;

import junit.framework.TestCase;
import org.junit.Assert;

public class InventoryTest extends TestCase {

    public void testRestock() {
        int numOfRestockedProducts = 0;
        for (Items x : Inventory.INVENTORY_ARRAY) {
            if (x.getStock() == 5) {
                numOfRestockedProducts++;
            }
        }
        Assert.assertEquals(numOfRestockedProducts, Inventory.INVENTORY_ARRAY.length);

    }
}