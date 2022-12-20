package com.techelevator;

import junit.framework.TestCase;
import org.junit.Assert;

public class GumTest extends TestCase {
    private Gum gum;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        gum = new Gum();
    }

    public void testDispensingMessage() {
        String expected = "Chew Chew, Yum";
        Assert.assertEquals(expected, gum.dispensingMessage());
    }
}