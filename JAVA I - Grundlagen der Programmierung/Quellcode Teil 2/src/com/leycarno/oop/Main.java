package com.leycarno.oop;

import com.leycarno.oop.programms.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welches Programm starten?");
        System.out.println("1. oop basics");
        System.out.println("2. rent a car");
        System.out.println("3. refuel and use my car");
        System.out.println("4. refuel and use my car with mvc");
        System.out.println("5. refuel and use my car endless with a menu");
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
                _1_OopBasics oopBasics = new _1_OopBasics();
                oopBasics.run();
                break;
            case 2:
                _2_RentCar rentCar = new _2_RentCar();
                rentCar.run();
                break;
            case 3:
                _3_RefuelCar refuelCar = new _3_RefuelCar();
                refuelCar.run();
                break;
            case 4:
                _4_RefuelCarMvc refuelCarMvc = new _4_RefuelCarMvc();
                refuelCarMvc.run();
                break;
            case 5:
                _5_RefuelCarMenu refuelCarMenu = new _5_RefuelCarMenu();
                refuelCarMenu.run();
                break;
            default:
                System.err.println("Unbekanntes Programm!");
        }

    }
}
