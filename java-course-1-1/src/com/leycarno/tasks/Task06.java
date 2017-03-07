package com.leycarno.tasks;

import java.util.Scanner;

public class Task06 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int x, y;

        System.out.print("Please insert the first number: ");
        x = scanner.nextInt();
        System.out.print("Please insert the second number: ");
        y = scanner.nextInt();

        if (x % y == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO!");
        }

    }

}
