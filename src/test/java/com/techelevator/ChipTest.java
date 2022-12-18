package com.techelevator;

import junit.framework.TestCase;
import org.junit.Assert;

public class ChipTest extends TestCase {
    private Chip chip;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        chip = new Chip();
    }

    public void testDispensingMessage() {
        String expected = "Crunch Crunch, Yum!";
        Assert.assertEquals(expected, chip.dispensingMessage());
    }
}
