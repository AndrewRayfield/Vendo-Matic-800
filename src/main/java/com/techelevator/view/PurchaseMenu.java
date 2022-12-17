package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class PurchaseMenu extends Menu{

    // AE: Simplified the purchase menu, previously it was a complete copy of our menu class
    // this now extends menu and calls the super, allowing for easy constructor use
    public PurchaseMenu(InputStream input, OutputStream output) {
        //this.out = new PrintWriter(output);
        //this.in = new Scanner(input);
        super(input, output);

    }
}

