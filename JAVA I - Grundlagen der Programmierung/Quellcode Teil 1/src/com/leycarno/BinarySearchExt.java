package com.leycarno;

import java.util.Scanner;

public class BinarySearchExt {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int min, max, searchNumber;

        System.out.print("What is the MIN: ");
        min = scanner.nextInt();
        System.out.print("What is the MAX: ");
        max = scanner.nextInt();

        if (min >= max) {
            System.out.print("MIN has to be smaller than MAX! EXIT APPLICATION");
            System.exit(0);
        }

        System.out.print("What is the number we are looking for: ");
        searchNumber = scanner.nextInt();

        if (searchNumber < min || searchNumber > max) {
            System.out.print("The number has to be between MIN and MAX");
            System.exit(0);
        }

        // ****************************************************************************************************

        int index = 1, maxGuesses = 20, guess;
        do {
            guess = min + (max - min) / 2;
            System.out.print("Loop index: " + (index++) + ", Guess = " + guess);

            if (guess > searchNumber) {
                System.out.println(" is bigger");
                max = guess;
            } else if (guess < searchNumber) {
                System.out.println(" is smaller");
                min = guess + 1; // need to be 1 bigger, otherwise you never match the max!
            } else {
                System.out.println(" >>> MATCH ");
            }

        } while (guess != searchNumber && index <= maxGuesses);


    }

}
