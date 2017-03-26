package com.leycarno.javacourse.java_03_oop;

import java.util.Scanner;

public class OopMain {

    public static void main(String[] args) {

        System.out.println("Welches Programm starten?");
        System.out.println("1. oop basics");
        System.out.println("2. rent a car");
        System.out.println("3. refuel and use my car");
        System.out.println("Bitte die Zahl eingeben: ");

        int option = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            option = scanner.nextInt();
        } catch (Throwable th) {
            System.err.println("Bitte eine Zahl für das gewünschte Programm eingeben!");
            System.exit(0);
        }

        switch (option) {
            case 1:
                OopBasics oopBasics = new OopBasics();
                oopBasics.run();
                break;
            case 2:
                RentCar rentCar = new RentCar();
                rentCar.run();
                break;
            case 3:
                RefuelCar refuelCar = new RefuelCar();
                refuelCar.run();
                break;
            default:
                System.err.println("Unbekanntes Programm!");
        }

    }
}
