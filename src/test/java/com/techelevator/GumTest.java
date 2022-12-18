package com.techelevator;

import junit.framework.TestCase;
import org.junit.Assert;

public class GumTest extends TestCase {
    private Gum gum;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        gum = new Gum("gum", 1.00, "A1");
    }

    public void testDispensingMessage() {
        String expected = "Glug Glug, Yum!";
        Assert.assertEquals(expected, gum.dispensingMessage());
    }
}