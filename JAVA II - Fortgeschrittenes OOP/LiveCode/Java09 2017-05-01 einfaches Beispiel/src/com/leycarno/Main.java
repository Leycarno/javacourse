package com.leycarno;

import com.leycarno.controllers.FruitController;
import com.leycarno.models.FruitType;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static FruitController controller = new FruitController();

    public static void main(String[] args) {

        try {
            controller.changeAmount(FruitType.APPLE, 3);
            controller.changeAmount(FruitType.PEACH, 7);
            controller.changeAmount(FruitType.ORANGE, 1);
        } catch (Exception ex) {} // alles gut, Initialwerte für diese Demo

        Scanner scanner = new Scanner(System.in);

        int option = -1;
        do {
            System.out.println("\nWas möchten Sie als nächstes tun?");
            System.out.println("1. Aktuelles Lager (Anzahl und Euro-Wert)");
            System.out.println("2. Anzahl Äpfel verändern");
            System.out.println("3. Anzahl Pfirsiche verändern");
            System.out.println("4. Anzahl Orangen verändern");
            System.out.println("0. Programm beenden\n");

            try {
                option = scanner.nextInt();
            } catch (Exception ex) {
                String errorInput = scanner.nextLine();
                System.out.println("Bitte eine Zahl zwischen 0 und 4 benutzen und nicht " + errorInput);
                continue;
            }

            switch (option) {
                case 1:
                    showStorage();
                    break;
                case 2:
                    getAddAmount2(scanner, FruitType.APPLE);
                    // apple.setAmount(getAddAmount(scanner, apple.getAmount()) + apple.getAmount());
                    break;
                case 3:
                    getAddAmount2(scanner, FruitType.PEACH);
                    // peach.setAmount(getAddAmount(scanner, peach.getAmount()) + peach.getAmount());
                    break;
                case 4:
                    getAddAmount2(scanner, FruitType.ORANGE);
                    // orange.setAmount(getAddAmount(scanner, orange.getAmount()) + orange.getAmount());
                    break;
                case 0:
                    System.out.println("Programm wird beendet");
//                    System.exit(0);
                    break;
                default:
                    System.out.println("Bitte eine Zahl zwischen 0 und 4 benutzen");
                    break;
            }


        } while (option != 0);
    }


    public static void showStorage() {
        HashMap<FruitType, Float> storage = controller.getStorage();
        HashMap<FruitType, Float> prices = controller.getPrices();

        System.out.println("In unserem Lager befinden sich:");
        for (HashMap.Entry<FruitType, Integer> entry : controller.getAmounts().entrySet()) {
            FruitType type = entry.getKey();
            int amount = entry.getValue();
            System.out.printf(amount + " " + type.de
                    + " zum Stückpreis %.2f € - Summe: %.2f€ %n"
                    , prices.get(type)
                    , storage.get(type));
        }
        System.out.printf("Gesamtsumme: %.2f\n", controller.getStorageSum());


    }

//    public static int getAddAmount(Scanner scanner, int amount) {
//        System.out.println("Bitte eine Zahl eingeben:");
//        int change = 0;
//        try {
//            change = scanner.nextInt();
//        } catch (Exception ex) {
//            scanner.nextLine();
//            System.out.println("Bitte eine Zahl eingeben!!!");
//            // rekursive Aufruf der Methode
//            return getAddAmount(scanner, amount);
//        }
//
//        if (amount + change < 0) {
//            System.out.println("Die Anzahl kann nicht <0 sein");
//            return 0; // oder wieder rekursiv
//        }
//        return change;
//    }

    public static void getAddAmount2(Scanner scanner, FruitType type) {
        System.out.println("Bitte eine Zahl eingeben:");
        int change = 0;
        try {
            change = scanner.nextInt();
        } catch (Exception ex) {
            scanner.nextLine();
            System.out.println("Bitte eine Zahl eingeben!!!");
            // rekursive Aufruf der Methode
            getAddAmount2(scanner, type);
        }

        try {
            controller.changeAmount(type, change);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
