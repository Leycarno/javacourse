package com.leycarno;

import java.util.Scanner;

public class Task05 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int x, n, boxNum, rest;

        System.out.print("Please insert the amount of flasks: ");
        x = scanner.nextInt();
        System.out.print("Please insert the amount of flasks per box: ");
        n = scanner.nextInt();

        if (n == 0) {
            System.out.println("Error: division by zero !");
        }
        else {

            boxNum = x / n;
            rest = x % n;

            System.out.println("Amount of boxes = " + boxNum);
            System.out.println("Flasks rest (half-full boxes) = " + rest);

        }
    }

}
