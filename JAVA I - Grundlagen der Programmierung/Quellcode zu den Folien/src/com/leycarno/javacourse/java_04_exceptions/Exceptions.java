package com.leycarno.javacourse.java_04_exceptions;

import java.util.Scanner;

public class Exceptions {

    public static void main(String[] args) {

        // how to catch any exception and how to create our own exceptions?

        try {

            giveMeException();

        } catch (Throwable exeption) {

            System.out.print("We caught an exception! The error-message is: ");
            System.out.println(exeption.getMessage());

        }

        // another practice example
        System.out.println("Bitte eine Ganzzahl eingaeben (oder auch nicht!):");
        System.out.println("Die Eingabe " + nextIntInput() + " ist eine gültige Ganzzahl!");

        // You've got the idea?

    }

    /**
     * it's important to tell the world, that this method could throw an excepetion...
     *
     * @throws Exception
     */
    private static void giveMeException() throws Exception {
        throw new Exception(" I AM AN EXCEPTION ! ");
    }

    /**
     * the method not throw an exception, it handle the error with a recursive call
     *
     * @return
     */
    private static int nextIntInput() {
        int selected;
        Scanner scanner = new Scanner(System.in);
        try {
            selected = scanner.nextInt();
        } catch (Throwable th) {
            System.err.println("Ich kann Ihre Eingabe leider nicht verarbeiten. Bitte eine Ganzzahl eingeben.");
            scanner.nextLine(); // error source...
            return nextIntInput(); // recursive call!
        }
        return selected;
    }

}
