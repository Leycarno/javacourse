package com.leycarno.javacourse.java_02_imperative_elements;

import java.util.Random;

public class ControlStructures {

    public static void main(String[] args) {

        // ****************************************************************************************************
        // if condition
        // else condition
        // do/while-LOOP
        // BONUS: random numbers
        // ****************************************************************************************************
        int randomNumber;
        int maxLoops = 30;
        do { // example fo a simple loop
            randomNumber = (int) (Math.random() * 11); // generates a random number between 0 and 10

            if (randomNumber < 5) {
                System.out.println("the randomNumber is SMALLER than the middle : " + randomNumber);
            } else if (randomNumber > 5) {
                System.out.println("the randomNumber is BIGGER than the middle : " + randomNumber);
            } else {
                System.out.println("the randomNumber is the middle (== 5) : " + randomNumber);
            }
        } while (randomNumber != 5 && maxLoops-- > 0);

        // ****************************************************************************************************
        // for-LOOP
        // jump conditions (continue and break)
        // ****************************************************************************************************
        boolean justOddNumbers = true;
        int externalMaxValue = 7;
        for (int i = 1; i < 10; i++) {
            if (justOddNumbers && i % 2 != 0) {
                continue;        // jump to the next loop
            }
            if (i > externalMaxValue) {
                break;            // LEAVE the loop
            }
            System.out.println(i);
        }

        // ****************************************************************************************************
        // SWITCH
        // ****************************************************************************************************
        randomNumber = 1 + (int) (Math.random() * 3); // generates a random number between 1 and 3
        System.out.println("Example of switch - case " + randomNumber + " leads to:");
        switch (randomNumber) {
            case 1: {
                System.out.println("First option!");
                break;
            }
            case 2: {
                System.out.println("Second option!");
                break;
            }
            default: {
                System.out.println("DEFAULT (third) option!");
                break;
            }
        }

        // ****************************************************************************************************
        // difference between & and &&
        // ****************************************************************************************************
        int aNumber = 0;
        boolean ignoreed = (false && (aNumber++ > 0));
        System.out.println("&& ignores everything if there is a break-condition (aNumber is still 0 : " + aNumber + ")");

        aNumber = 0;
        boolean complete = (false & (aNumber-- > 0));
        System.out.println("& doe's everything in the expression (aNumber has been changed to -1 : " + aNumber + ")");


        // ****************************************************************************************************
        // condition-expression
        // ****************************************************************************************************

        double anotherRandom = Math.random();

        // the long version
        if (anotherRandom > .5) {
            System.out.println("the random number is > 0.5 and < 1.0");
        } else {
            System.out.println("the random number is >= 0.0 and < 0.5");
        }

        // the short version
        System.out.println("the random number is "
                + (anotherRandom > .5
                ? "> 0.5 and < 1.0"
                : ">= 0.0 and < 0.5")
        );


        System.out.println("that's all folks!");

    }
}
