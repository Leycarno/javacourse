package com.leycarno;

import java.util.Scanner;

public class Task04 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a, b, kgvA, kgvB;

        System.out.print("Please insert the first number: ");
        a = scanner.nextInt();
        System.out.print("Please insert the second number: ");
        b = scanner.nextInt();

        kgvA = a;
        kgvB = b;

        while (kgvA != kgvB) {
            if (kgvA < kgvB) {
                kgvA += a;
            } else {
                kgvB += b;
            }
        }

        System.out.print("kgV = " + kgvA);

    }

}
