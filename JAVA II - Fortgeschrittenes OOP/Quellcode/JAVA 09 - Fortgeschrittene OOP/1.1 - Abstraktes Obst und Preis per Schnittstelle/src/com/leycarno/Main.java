package com.leycarno;

import com.leycarno.controller.FruitController;
import com.leycarno.model.Fruit;
import com.leycarno.model.FruitType;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    private static FruitController controller = new FruitController();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // vorher die möglichen Optionen anhand aller Obstsorten definieren
        int option = 2;
        HashMap<Integer, FruitType> fruitOptions = new HashMap<>();
        for (Fruit fruit : controller.getFruits().values()) {
            fruitOptions.put(option++, fruit.getFruitType());
        }

        do {
            System.out.println("\nWas möchten Sie als nächstes tun?");
            System.out.println("1. Aktuelles Lager (Anzahl und Euro-Wert)");
            for (int i : fruitOptions.keySet()) {
                System.out.println(i + ". Anzahl der Sorte " + fruitOptions.get(i).getName() + " verändern");
            }
            System.out.println("0. Programm beenden\n");

            int nextOption = 0;
            try {
                nextOption = scanner.nextInt();
            } catch (Exception ex) {
                scanner.nextLine();
                System.err.println("Bitte eine Zahl von 0-" + (fruitOptions.size() + 1) + " eingeben");
                continue;
            }

            switch (nextOption) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    showStorage();
                    break;
                default:
                    if (fruitOptions.keySet().contains(nextOption)) {
                        changeAmount(scanner, fruitOptions.get(nextOption));
                    } else
                        System.err.println("Bitte eine Zahl von 0-" + (fruitOptions.size() + 1) + " eingeben");
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
        HashMap<FruitType, Float> values = controller.getStorageValues();

        System.out.println("In unserem Lager befinden sich:");

        for (Fruit fruit : controller.getFruits().values()) {
            System.out.println(fruit.getAmount() + " * " + fruit.getFruitType().getName()
                    + " zum Stückpreis " + fruit.getUnitPrice() + "€ - Summe: " + values.get(fruit.getFruitType()) + "€");
        }

        System.out.println("Gesamtsumme: " + controller.getPriceSum());
    }
}
