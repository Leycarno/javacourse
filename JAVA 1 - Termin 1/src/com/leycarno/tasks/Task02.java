package com.leycarno.tasks;

import java.util.Scanner;

public class Task02 {

    /**
     * Example for a constant String
     */
    private static final String END = "END";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String name = "";

        while (!name.equals(END)) {
            System.out.print("Please insert the name (exit app with the name \"END\"): ");
            name = scanner.nextLine();
            if (name.equals(END)) break;
            System.out.println("Hello, " + name);
        }

    }
}
