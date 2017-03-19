package com.leycarno.collections.views;

import java.util.Scanner;

public class StaticView {

    public static void displayMessage(String message) {
        System.out.println(message);
    }

    public static void displayError(String errorMessage) {
        System.err.println(errorMessage);
    }

    public static int nextIntInput(String errorMessage) {
        int selected;
        Scanner scanner = new Scanner(System.in);
        try {
            selected = scanner.nextInt();
        } catch (Throwable th) {
            System.err.println(errorMessage);
            scanner.nextLine(); // error source...
            return nextIntInput(errorMessage);
        }
        return selected;
    }
}