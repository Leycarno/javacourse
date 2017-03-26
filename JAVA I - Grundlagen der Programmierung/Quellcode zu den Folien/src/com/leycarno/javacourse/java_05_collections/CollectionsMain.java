package com.leycarno.javacourse.java_05_collections;

import java.util.Scanner;

public class CollectionsMain {

    public static void main(String[] args) {

        System.out.println("Welches Programm starten?");
        System.out.println("1. Beispiele - Arrays");
        System.out.println("2. Beispiele - Collections");
        System.out.println("3. Beispiele - Enums");
        System.out.println("Bitte die Zahl eingeben: ");

        int option = nextIntInput("Bitte eine Zahl für das gewünschte Programm eingeben!");

        switch (option) {
            case 1:
                Arrays arrays = new Arrays();
                arrays.run();
                break;
            case 2:
                Collections collections = new Collections();
                collections.run();
                break;
            case 3:
                Enums enums = new Enums();
                enums.run();
                break;
            default:
                System.err.println("Unbekanntes Programm!");
        }

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
