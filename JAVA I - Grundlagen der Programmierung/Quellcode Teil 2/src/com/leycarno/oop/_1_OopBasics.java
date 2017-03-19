package com.leycarno.oop;

public class _1_OopBasics {

    // a class member - unique attribute
    private static int created;

    // a class method - callable without an object
    public static int getCreated() {
        return created;
    }

    // count created objects of this class by using the constructor
    public _1_OopBasics() {
        created++;
    }

    public void run() {

        Car car = new Car();            // create a new Object of the class "Car"
        car.setType("Opel Zafira");     // set the type of the car (use "dot notation")
        System.out.println("Wir haben ein Auto erstellt und es ist ein " + car.getType()); // read value of a member


        // create some objects as simple example for static member and static methods:
        // (remember: there was an object of this class already created in the static main-method of the class Main)
        _1_OopBasics object;
        for (int i = 0; i < 10; i++) {
            object = new _1_OopBasics();
            // call the static method -> no object will be used:
            System.out.println(_1_OopBasics.getCreated() + " Objekte der Klasse _1_OopBasics erstellt...");
        }


        // a simple example to handle errors (without handling, the program would be terminated!)
        Car ideaOfACar = null;
        try {
            System.out.println(ideaOfACar.getFuel()); // this throw an exception!
        } catch (Throwable th) {
            System.out.println("Normalerweise würde das Programm beendet werden und folgender Fehler erscheinen:");
            System.err.println(th.toString() + " Message:" + th.getMessage());
            System.out.println("Stattdessen kann das Programm weiterlaufen und man kann diesen Text lesen...");
        }
    }

}
