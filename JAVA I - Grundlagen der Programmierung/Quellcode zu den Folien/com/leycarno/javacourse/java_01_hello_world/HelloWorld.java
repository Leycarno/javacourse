package com.leycarno.javacourse.java_01_hello_world;

public class HelloWorld {

    // This is a comment (because the line starts with two slashes). It's just an info for you - nothing happens!

    /*
        This is another comment (starts with a slash and a stars),
        that does'nt stop with a new line but with the star and slash at the end.
        Perfect choice, if you want to disable whole blocks of code!
     */

    /**
     * This comment (starts with a slash and TWO stars) is a "Java-Doc" with annotations (starts with the @)
     * more about later - or just google it! ;-)
     * <p>
     * The "main" method is the start of every Java Program.
     * More about methods with the topic of the second date ("OOP")
     *
     * @param args
     */
    public static void main(String[] args) {

        /*
            You can print out stuff on the JAVA Console with hte expression "System.out.print("...");"

            You use the method "print" of the static member "out" of the default java class "System"...
            And I promise, you will understand that sentence after the second date ("OOP") ;-)
            For now - just use this to print out any stuff you want on the console!

            The first line for generations of coders:
        */
        System.out.print("Hello World");

        // when you enter printing you're not in a new line:
        System.out.print("!");

        // your need to use "\n" to force a new line
        System.out.print("\na new line... ");
        // or use println (for "print line") instead of print to make a new line AFTER the print
        System.out.println(" another new line AFTER using 'println'");

        // also you can use "tabs" by use "\t"
        System.out.print("\tenough for the first example...");


        // You can start any program with one of this options (If you use IntelliJ):
        // 1. navigate with the mouse to the top menu and choose "Run" -> "Run Main"
        // 2. you can do the same with the keyboard by "ALT" + U and U again
        // 3. you can use the shortcut "Shift" + F10
        // 4. you can run the program again by clicking on the green arrow on the left side of the console

    }
}
