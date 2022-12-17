package com.techelevator;

import org.junit.Test;

public class LoggerTest extends Logger {

    @Test
    public void testLogger(){
        Logger.log("Test Action", 0, 10);

    }

    @Test
    public void badNumberTest(){
        Logger.log("Test Number", 1.222, -3.00);
    }
}
