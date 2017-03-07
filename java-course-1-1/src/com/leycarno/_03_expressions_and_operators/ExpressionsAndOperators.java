package com.leycarno._03_expressions_and_operators;

public class ExpressionsAndOperators {

    public static void main(String[] args) {

        // ****************************************************************************************************
        // arithmetic operators
        // ****************************************************************************************************
        System.out.println("************************************************************");
        System.out.println("*** arithmetic operators");
        System.out.println("************************************************************");

        int x = 3, y = 5;
        System.out.println("with the variables x = " + x + " and y = " + y);

        int addition = x + y;
        int subtraction = x - y;
        int multiplication = x * y;
        float division = x / y;
        int modulo = x % y;

        System.out.println("addition x + y = " + addition);
        System.out.println("subtraction x - y = " + subtraction);
        System.out.println("multiplication x * y = " + multiplication);
        System.out.println("division x / y = " + division);
        System.out.println("modulo x % y = " + modulo);

        // increment (and decrement) variables with "++" (and "--"):
        System.out.println("\nbefore incrementing: " + x);
        System.out.println("while (post-)incrementing (x++): " + x++);
        System.out.println("after incrementing: " + x);
        System.out.println("\nbefore decrementing: " + x);
        System.out.println("while (pre-)decrementing (--x): " + --x);
        System.out.println("after decrementing: " + x);

        // ****************************************************************************************************
        // a simple example for casting
        // ****************************************************************************************************
        System.out.println("\n************************************************************");
        System.out.println("*** a simple example for 'casting'");
        System.out.println("************************************************************");

        System.out.println("How to fix the error with divide two integer numbers?");
        System.out.println("One of the numbers has to be float - by 'explicit casting'!");
        System.out.println("((float)x / y)   =   (float)3 / 5   =   3.0 / 5   =   " + ((float)x / y));

        // ****************************************************************************************************
        // relational operators
        // ****************************************************************************************************
        System.out.println("\n************************************************************");
        System.out.println("*** relational operators");
        System.out.println("************************************************************");

        int a = 2, b = 6;
        System.out.println("with the variables a = " + a + " and b = " + b);

        boolean isSmaller = a < b;
        boolean isSmallerOrEqual = a <= b;
        boolean isBigger = a > b;
        boolean isBiggerOrEqual = a >= b;
        boolean isEqual = a == b;
        boolean isUnequal = a != b;

        System.out.println("isSmaller? (a < b) = " + isSmaller);
        System.out.println("isSmallerOrEqual? (a <= b) = " + isSmallerOrEqual);
        System.out.println("isBigger? (a > b) = " + isBigger);
        System.out.println("isBiggerOrEqual? (a >= b) = " + isBiggerOrEqual);
        System.out.println("isEqual? (a == b) = " + isEqual);
        System.out.println("isUnequal? (a != b) = " + isUnequal);

        // ****************************************************************************************************
        // logical operators
        // ****************************************************************************************************
        System.out.println("\n************************************************************");
        System.out.println("*** logical operators");
        System.out.println("************************************************************");

        System.out.println("NOT isSmaller? !(a < b) = " + isSmaller);
        System.out.println("isSmaller AND isEqual? (a < b) && (a==b) = " + (isSmaller && isEqual));
        System.out.println("isSmaller ODER isBigger? (a < b) && (a > b) = " + (isSmaller || isBigger));

        // more about logical operators in a moment...
    }
}
