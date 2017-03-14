package com.leycarno;

import java.io.Console;

public class ConsoleOnly {

    public static void main(String[] args) {
        Console c = System.console();
        // show the text and wait for the next key to quit
        // runs only within a console...
        if (c != null) {
            c.format("Hallo Console!", args);
            c.format("\nPress ENTER to proceed.\n");
            c.readLine();
        }

    }

}
