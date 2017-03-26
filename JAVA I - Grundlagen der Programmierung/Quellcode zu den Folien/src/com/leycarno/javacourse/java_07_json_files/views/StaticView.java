package com.leycarno.javacourse.java_07_json_files.views;

import java.util.Scanner;

public class StaticView {

    public static void displayMessage(String message) {
        System.out.println(message);
    }

    public static void displayError(String errorMessage) {
        System.err.println(errorMessage);
    }

    public static int nextIntInput(String errorMessage) {
        int result;
        Scanner scanner = new Scanner(System.in);
        try {
            result = scanner.nextInt();
        } catch (Throwable th) {
            System.err.println(errorMessage);
            scanner.nextLine(); // error source...
            return nextIntInput(errorMessage);
        }
        return result;
    }

    public static String nextStringInput(String errorMessage) {
        String result;
        Scanner scanner = new Scanner(System.in);
        try {
            result = scanner.nextLine();
        } catch (Throwable th) {
            System.err.println(errorMessage);
            return nextStringInput(errorMessage);
        }
        return result;
    }
}
