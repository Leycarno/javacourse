package com.leycarno.oop;

public class _4_Exceptions {

    public void run() {

        // how to catch any exception and how to create our own exceptions?

        try {

            this.giveMeException();

        } catch (Throwable exeption) {

            System.out.print("We caught an exception! The error-message is: ");
            System.out.println(exeption.getMessage());

        }

        // You've got the idea?

    }

    /**
     * it's important to tell the world, that this method could throw an excepetion...
     *
     * @throws Exception
     */
    private void giveMeException() throws Exception {
        throw new Exception(" I AM AN EXCEPTION ! ");
    }

}
