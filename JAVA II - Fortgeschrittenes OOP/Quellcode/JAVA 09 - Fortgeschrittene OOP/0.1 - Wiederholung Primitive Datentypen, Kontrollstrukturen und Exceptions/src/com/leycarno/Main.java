package com.leycarno;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int appleAmount = 0;
        int peachAmount = 0;
        int orangeAmount = 0;

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
                case 1:
                    showStorage(appleAmount, peachAmount, orangeAmount);
                    break;
                case 2:
                    appleAmount = changeAmount(scanner, appleAmount);
                    break;
                case 3:
                    peachAmount = changeAmount(scanner, peachAmount);
                    break;
                case 4:
                    orangeAmount = changeAmount(scanner, orangeAmount);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Bitte eine Zahl von 0-4 eingeben");
            }

        } while (true);
    }

    private static int changeAmount(Scanner scanner, int amount) {
        System.out.println("Um wieviel soll die Anzahl verändert werden?");
        int addAmount = 0;
        try {
            addAmount = scanner.nextInt();
            if (amount + addAmount < 0) {
                System.err.println("Die Anzahl kann nicht unter 0 sinken!");
                return changeAmount(scanner, amount);
            }
        } catch (Exception ex) {
            scanner.nextLine();
            System.err.println("Bitte eine Zahl eingeben!");
            return changeAmount(scanner, amount);
        }
        return amount + addAmount;
    }

    private static void showStorage(int apelAmount, int peachAmount, int orangeAmount) {
        float applePrice = 0.56f;
        float peachPrice = 0.74f;
        float orangePrice = 0.46f;

        // Berechnung der Werte mit enorm simpler Rundungsfehlerabsicherung...
        float appleSum = (int)(applePrice * apelAmount * 100) / 100f;
        float peachSum = (int)(peachPrice * peachAmount * 100) / 100f;
        float orangeSum = (int)(orangePrice * orangeAmount * 100) / 100f;
        float sum = (int)((appleSum + peachSum + orangeSum) * 100) / 100f;

        System.out.println("In unserem Lager befinden sich:");
        System.out.println(apelAmount + " Äpfel zum Stückpreis " + applePrice + "€ - Summe: " + appleSum + "€");
        System.out.println(peachAmount + " Pfirsiche zum Stückpreis " + peachPrice + "€ - Summe: " + peachSum + "€");
        System.out.println(orangeAmount + " Orangen zum Stückpreis " + orangePrice + "€ - Summe: " + orangeSum + "€");
        System.out.println("Gesamtsumme: " + sum);
    }
}
