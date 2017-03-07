package com.leycarno.tasks;

import java.util.Scanner;

/**
 * Created by leyca on 14.11.2016.
 */
public class Task03 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        float a, b;
        String operator;

        System.out.print("Please insert the first number: ");
        a = scanner.nextFloat();
        System.out.print("Please insert the second number: ");
        b = scanner.nextFloat();

        // Eat the new line
        scanner.nextLine(); // there are better ways (using BufferedReader...)

        System.out.print("Please insert the operator (+, -, *, / ): ");
        operator = scanner.nextLine();

        switch (operator) {

            case "+":
                System.out.println("The result of the addition is: " + (a+b));
                break;
            case "-":
                System.out.println("The result of the subtraction is: " + (a-b));
                break;
            case "*":
                System.out.println("The result of the multiplication is: " + (a*b));
                break;
            case "/":
                if (b == 0) {
                    System.out.println("Error: division by zero !");
                }
                else {
                    System.out.println("The result of the division is: " + (a / b));
                }
                break;
            default:
                System.out.println("unknown operator");
                break;
        }
    }
}
