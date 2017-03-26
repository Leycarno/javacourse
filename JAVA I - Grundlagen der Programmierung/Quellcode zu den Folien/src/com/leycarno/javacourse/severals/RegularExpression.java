package com.leycarno.javacourse.severals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {

    public static void main(String[] args) {

        String string = "Hello World!";
        String regex = "World";

        // ****************************************************************************************************
        // 1. you can use the java.regex-lib:

        // create a pattern object
        Pattern pattern = Pattern.compile(regex);
        // now create matcher object
        Matcher matcher = pattern.matcher(string);

        // try to find a match
        System.out.println("string = \"" + string + "\" regex = \"" + regex
                + "\" -> matcher.find() -> " + matcher.find());

        // replace the matched
        System.out.println("string = \"" + string + "\" regex = \"" + regex
                + "\" -> matcher.replaceFirst(\"Steffen\") -> " + matcher.replaceFirst("Steffen"));

        // there are some more methods available - google is your friend!
        // EXAMPLE: https://www.tutorialspoint.com/java/java_regular_expressions.htm

        // ****************************************************************************************************
        // 2. you can use built in methods of the string-class

        // is true, only if the WHOLE string can be matched:
        System.out.println("string.matches(\"Hello Steffen!\") ? " + string.matches("Hello Steffen!"));
        System.out.println("string.matches(\"Hello World!\") ? " + string.matches("Hello World!"));

        // There are some more methods for replacing and splitting the string into an array...
    }
}
