package com.leycarno.oop.views;

import java.util.Scanner;

public class SimpleView {

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayError(String errorMessage) {
        System.err.println(errorMessage);
    }

    public int nextIntInput(String errorMessage) {
        int selected;
        try {
            Scanner scanner = new Scanner(System.in);
            selected = scanner.nextInt();
        } catch (Throwable th) {
            System.err.println(errorMessage);
            return nextIntInput(errorMessage);
        }
        return selected;
    }
}