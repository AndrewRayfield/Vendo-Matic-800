package com.techelevator;

import junit.framework.TestCase;
import org.junit.Test;

public class SalesReportTest extends TestCase {
    SalesReport sr = new SalesReport();

    @Test
    public void testAddToReport() {
        sr.createReport();
        sr.addToReport("Moonpie");
    }

    @Test(expected = Exception.class)
    public void testWrongName() {
        sr.createReport();
        sr.addToReport("Snickers");
    }

    @Test(expected = Exception.class)
    public void testMultipleItems() {
        sr.createReport();
        sr.addToReport("Moonpie Heavy");
    }
}