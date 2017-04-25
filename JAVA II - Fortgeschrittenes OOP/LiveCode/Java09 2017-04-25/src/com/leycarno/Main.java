package com.leycarno;

import java.util.Scanner;

public class Main {

    static int apple = 3, peach = 7, orange = 1;

    public static void main(String[] args) {

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
                    apple += getAddAmount(scanner, apple);
                    break;
                case 3:
                    peach += getAddAmount(scanner, peach);
                    break;
                case 4:
                    orange += getAddAmount(scanner, orange);
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
//        int applePrice = 56;    // explizite Casting
//        int peachPrice = 74;          // implizite Casting
//        int orangePrice = 46;

            // Homework: Warum geht das nicht?
//        double appleSum = (applePrice * apple) / 100f;
//        double peachSum = (peachPrice * peach) / 100f;
//        double orangeSum = (orangePrice * orange) / 100f;
//        double sum = (appleSum + peachSum + orangeSum) / 100f;

        float applePrice = 0.56f;
        float peachPrice = 0.74f;
        float orangePrice = 0.46f;

        // Berechnung der Werte mit enorm simpler Rundungsfehlerabsicherung...
        float appleSum = (int) (applePrice * apple * 100) / 100f;
        float peachSum = (int) (peachPrice * peach * 100) / 100f;
        float orangeSum = (int) (orangePrice * orange * 100) / 100f;
        float sum = (int) ((appleSum + peachSum + orangeSum) * 100) / 100f;

        System.out.println("In unserem Lager befinden sich:");
        System.out.println(apple + " Äpfel zum Stückpreis " + applePrice + "Cent - Summe: " + appleSum + "€");
        System.out.println(peach + " Pfirsiche zum Stückpreis " + peachPrice + "Cent - Summe: " + peachSum + "€");
        System.out.println(orange + " Orangen zum Stückpreis " + orangePrice + "Cent - Summe: " + orangeSum + "€");
        System.out.println("Gesamtsumme: " + sum);


    }

    public static int getAddAmount(Scanner scanner, int amount) {
        System.out.println("Bitte eine Zahl eingeben:");
        int change = 0;
        try {
            change = scanner.nextInt();
        } catch (Exception ex) {
            scanner.nextLine();
            System.out.println("Bitte eine Zahl eingeben!!!");
            // rekursive Aufruf der Methode
            return getAddAmount(scanner, amount);
        }

        if (amount + change < 0) {
            System.out.println("Die Anzahl kann nicht <0 sein");
            return 0; // oder wieder rekursiv
        }
        return change;
    }
}
