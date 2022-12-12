package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Logger {

    public static void log(String message){

        File logFile = new File ("resources/log.txt");
        try (PrintWriter logOutPut = new PrintWriter(new FileOutputStream(logFile, true))) {
            logOutPut.println(message);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
