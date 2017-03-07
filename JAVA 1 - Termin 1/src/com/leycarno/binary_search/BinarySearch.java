package com.leycarno.binary_search;

public class BinarySearch {

    public static void main(String[] args) {

        int min = 1;
        int max = 1000;

        int searchNumber = min + (int) (Math.random() * max); // generates a random number between MIN and MAX
        // randomNumber = 1000; // manually tests...
        System.out.println("The random number we are searching for is: " + searchNumber);

        // ***************************************************************************************************

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
