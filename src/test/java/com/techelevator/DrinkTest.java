package com.techelevator;

import junit.framework.TestCase;
import org.junit.Assert;

public class DrinkTest extends TestCase {
    private Drink drink;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        drink = new Drink();
    }

    public void testDispensingMessage() {
        String expected = "Glug Glug, Yum!";
        Assert.assertEquals(expected, drink.dispensingMessage());
    }
}