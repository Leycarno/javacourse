package com.leycarno;

import java.util.Scanner;

public class Task10 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n;

        System.out.print("give me a positive number >= 0 and <= 20: ");
        n = scanner.nextInt();

        if (n < 0 || n > 20) {
            System.out.print("Pleays a number >= 0 and <= 20! ");
        } else if (n == 0) {
            System.out.print("The result is 1");
        } else {

            int result = 1;
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
            System.out.print("The result is " + result);

        }
    }

}
