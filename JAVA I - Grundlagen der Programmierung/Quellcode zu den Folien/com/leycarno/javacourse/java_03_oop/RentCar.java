package com.leycarno.javacourse.java_03_oop;

public class RentCar {

    private int rentDays;

    public void run() {

        // create a person and a car I could rent for x days
        Person me = new Person();
        Car hireCar = new Car();

        // rent the car for x days
        rentCar(me, hireCar, 3) ;

        // pass some nice days with a car, as long as I own it
        int currentDay = 1;
        while (me.getCar() != null) {
            System.out.println(currentDay++ + ". Tag mit meinem Mietwagen!");
            useCar(me);
        }

        System.out.println("Ich muss das Auto wieder abgeben...");

    }

    /**
     * a person can rent a car for a specific amount of days
     *
     * @param person
     * @param car
     * @param days
     */
    private void rentCar(Person person, Car car, int days) {
        person.setCar(car);
        rentDays = days;
    }

    /**
     * a person use a hireCar as long as he has paid for
     *
     * @param person
     */
    private void useCar(Person person) {
        // if this person does not have a car - don't use any
        if (person.getCar() == null) return;

        // when rent days are used, give off the car
        if (--rentDays <= 0) {
            person.setCar(null);    // the car still exists, we just remove the reference to the car for this person!
        }
    }


}
