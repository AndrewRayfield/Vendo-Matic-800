package com.techelevator;

import junit.framework.TestCase;
import org.junit.Assert;

public class CandyTest extends TestCase {
    private Candy candy;
    @Override
    public void setUp() throws Exception {
        super.setUp();
        candy = new Candy();
    }

    public void testDispensingMessage() {
        String expected = "Munch Munch, Yum!";
        Assert.assertEquals(expected, candy.dispensingMessage());

    }
}