package com.leycarno.javacourse.java_05_collections;

public class Arrays {

    public void run() {
        this.integerArrayDemo();
        this.integerArrayResizeDemo();
        this.carArrayDemo();
        this.useArraysClass();
    }

    /** ************************************************************
     * simple demo of an array
     */
    private void integerArrayDemo() {
        int[] integerArray;
        integerArray = new int[3];      // create a int-array with 3 positions

        System.out.println("\nInteger Array @Start: " + this.integerArrayToString(integerArray));

        integerArray[0] = 7;            // set the first position with the value of 7
        integerArray[2] = 13;           // set the last position with the value of 13
        int seven = integerArray[0];    // get the value of the first position
        int last = integerArray[2];     // get the value of the last position

        System.out.println("Integer Array @End:   " + this.integerArrayToString(integerArray));
    }

    /** ************************************************************
     * simple demo to resize an array
     */
    private void integerArrayResizeDemo() {
        int[] integerArray = { 1, 6, 8 };   // init the array with values (auto-size to 3)

        System.out.println("\nInteger RESIZE Array @Start: " + this.integerArrayToString(integerArray));

        // you cannot resize an array - you have to create another and copy the values:
        int[] biggerIntegerArray = new int[4];
        for (int i = 0; i <integerArray.length; i++) {
            biggerIntegerArray[i] = integerArray[i];
        }
        biggerIntegerArray[3] = 4;
        integerArray = biggerIntegerArray;  // at least you can override the original array

        System.out.println("Integer RESIZE Array @End:   " + this.integerArrayToString(integerArray));
    }

    /** ************************************************************
     * simple demo for an array with objects
     */
    private void carArrayDemo() {
        Car[] carArray = new Car[2];    // definition of an array of (car) objects

        // these cars are just defined - for now the objects are all NULL!
        System.out.println("\nCar Array @Start: " + this.carArrayToString(carArray));

        Car golf = new Car();   // you can create an object as usual...
        golf.setType("Golf");
        golf.setFuelMax(63);
        golf.setFuel(3);
        carArray[0] = golf;     // .. and add the object to an array later

        carArray[1] = new Car();        // you can also create an new object INTO the array
        carArray[1].setType("Opel");    // and always you can manipulate the attributes like this
        carArray[1].setFuelMax(45);     // ...
        carArray[1].setFuel(7);

        System.out.println("\nCar Array @End:   " + this.carArrayToString(carArray));
    }

    /** ************************************************************
     * simple demo of the use of the "Arrays"-class
     */
    private void useArraysClass() {
        int[] integerArray = { 5, 9, 3, 1, 8 };   // init the array with values (auto-size to 3)

        System.out.println("\nInteger Array USE ARRAYS @Start:  " + this.integerArrayToString(integerArray));

        java.util.Arrays.sort(integerArray);   // sort by value
        System.out.println("Integer Array USE ARRAYS @sort:   " + this.integerArrayToString(integerArray));

        java.util.Arrays.fill(integerArray, 7);   // set every value on 7
        System.out.println("Integer Array USE ARRAYS @fill:   " + this.integerArrayToString(integerArray));

        int[] smallerArray = java.util.Arrays.copyOf(integerArray, 3);   // resize to a smaller array (NOT change the original)
        System.out.println("Integer Array USE ARRAYS @copyOf: " + this.integerArrayToString(smallerArray));

        boolean equal= java.util.Arrays.equals(integerArray, smallerArray);  // compare the original with the copy
        System.out.println("Integer Array USE ARRAYS @equals: "
                + this.integerArrayToString(integerArray)
                + " == "
                + this.integerArrayToString(smallerArray)
                + " ? " + equal);
    }

    /* ==================================================================================================== */

    /**
     * helper-method for a nice display of integer arrays
     * @param integerArray
     * @return String
     */
    private String integerArrayToString(int[] integerArray) {
        String result = "";
        for (int value : integerArray) {
            result += "[" + value + "]";
        }
        return result;
    }

    /**
     * helper-method for a nice display of car arrays
     * @param carArray
     * @return
     */
    private String carArrayToString(Car[] carArray) {
        String result = "";
        for (Car car : carArray) {
            result += "\n[" + car + "]";    // There is a special "toString()" method in the car class!
        }
        return result;
    }
}
