package com.leycarno._02_names_vars_and_types;

public class NamesVarsAndTypes {

    public static void main(String[] args) {

        // ****************************************************************************************************
        // Variables, Definition and Allocation
        // ****************************************************************************************************
        // we can define a variable
        // this DEFINES an integer variable with the identifier "aNumber"
        int aNumber;

        // "int" is a keyword of JAVA - intelliJ helps to see that by the blue color
        // JAVA "knows" what you want, when you use these keywords!

        // now we can ALLOCATE the variable with a value
        aNumber = 10;
        // and whenever you want you can assign another value and override the old
        aNumber = 20;

        // you can combine definition and allocation in explicit allocations:
        int anotherNumber = 30;

        // also possible/allowed:
        // multiple definitions
        int age, weight, size;
        // multiple explicit allocations
        int height = 3, width = 5;

        // ****************************************************************************************************
        // Primitive DataTypes
        // ****************************************************************************************************
        // JAVA knows 8 primitive data types

        // - boolean
        boolean isReady = true;

        // - integer
        int pos = 123, neg = -987;  // default numeric dataType
        byte aByte = 123;           // very small numbers (-128 ... 127)
        short aShort = 123;         // -32.768 ... 32.787
        long aLong = 999999;        // really big numbers!

        // - floating numbers (important to use points instead of decimal points)
        float number = 12.34f;  // important: add the "f" for "float"
        double big = 123.45;    // "double" precision compare to "float"

        // - characters (just one letter)
        char letter = 'A';

        // ****************************************************************************************************
        // Strings
        // ****************************************************************************************************
        // strings are not primitive datatypes, but important enough to show you the basics:

        String string1 = "Hello";
        String string2 = "World";
        String message = string1 + " "  + string2;  // you can concat strings with the "+" symbol!
        // important - you can't compare on equal by "==" - you need to use the equals-method:
        if (string1.equals(string2));   // string1 == string2;  WRONG!!!

        // more about the keyword "if" and comparision of variables in one of the next

    }
}
