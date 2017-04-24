package com.leycarno;

import com.leycarno.controller.FruitController;
import com.leycarno.model.Apple;
import com.leycarno.model.FruitType;
import com.leycarno.model.Orange;
import com.leycarno.model.Peach;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    private static FruitController controller = new FruitController();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\nWas möchten Sie als nächstes tun?");
            System.out.println("1. Aktuelles Lager (Anzahl und Euro-Wert)");
            System.out.println("2. Anzahl Äpfel verändern");
            System.out.println("3. Anzahl Pfirsiche verändern");
            System.out.println("4. Anzahl Orangen verändern");
            System.out.println("0. Programm beenden\n");

            int nextOption = 0;
            try {
                nextOption = scanner.nextInt();
            } catch (Exception ex) {
                scanner.nextLine();
                System.err.println("Bitte eine Zahl von 0-4 eingeben");
                continue;
            }

            switch (nextOption) {
                case 1: showStorage();  break;
                case 2: changeAmount(scanner, FruitType.Apple); break;
                case 3: changeAmount(scanner, FruitType.Peach); break;
                case 4: changeAmount(scanner, FruitType.Orange); break;
                case 0: System.exit(0); break;
                default: System.err.println("Bitte eine Zahl von 0-4 eingeben");
            }

        } while (true);
    }

    private static void changeAmount(Scanner scanner, FruitType fruitType) {
        System.out.println("Um wieviel soll die Anzahl verändert werden?");
        int addAmount = 0;
        try {
            addAmount = scanner.nextInt();
            try {
                // hier passierts:
                controller.changeFruitAmount(fruitType, addAmount);
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                changeAmount(scanner, fruitType);
            }
        } catch (Exception ex) {
            scanner.nextLine();
            System.err.println("Bitte eine Zahl eingeben!");
            changeAmount(scanner, fruitType);
        }
    }

    private static void showStorage() {
        HashMap<FruitType, Integer> amount = controller.getStorageAmounts();
        HashMap<FruitType, Float> values = controller.getStorageValues();

        System.out.println("In unserem Lager befinden sich:");
        System.out.println(amount.get(FruitType.Apple) + " Äpfel zum Stückpreis " + Apple.UNIT_PRICE + "€ - Summe: " + values.get(FruitType.Apple) + "€");
        System.out.println(amount.get(FruitType.Peach) + " Pfirsiche zum Stückpreis " + Peach.UNIT_PRICE + "€ - Summe: " + values.get(FruitType.Peach) + "€");
        System.out.println(amount.get(FruitType.Orange) + " Orangen zum Stückpreis " + Orange.UNIT_PRICE + "€ - Summe: " + values.get(FruitType.Orange) + "€");
        System.out.println("Gesamtsumme: " + controller.getPriceSum());
    }
}
