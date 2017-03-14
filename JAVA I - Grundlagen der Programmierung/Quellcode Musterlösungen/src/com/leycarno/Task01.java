package com.leycarno;

import java.util.Scanner;

public class Task01 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please insert the name: ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name);
    }
}
