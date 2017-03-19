package com.leycarno.oop;

public class _3_RefuelCar {

    private static final float fuelPricePerUnit = 1.09f;

    public void run() {

        // create a person and his car
        Person me = new Person();
        me.setName("Steffen");
        me.setMoney(100);

        Car myCar = new Car();
        myCar.setFuelMax(50);

        me.setCar(myCar);


        float refuelPrice = fuelPricePerUnit * myCar.getFuelMax();
        int maxLoops = 100;
        do {
            // oh no, there is no fuel in the car!
            if (myCar.getFuel() <= 0) {

                // pay the price before you refuel!
                System.out.println("Verfügbares Geld von " + me.getName() + ": " + me.getMoney() + "€");

                if (me.getMoney() < refuelPrice) break;
                me.setMoney(me.getMoney() - refuelPrice);
                System.out.print("Ich bezahle " + refuelPrice + " Euro ");

                myCar.setFuel(myCar.getFuelMax());
                System.out.println("und das Auto wurde wieder komplett befüllt!");
            }

            myCar.setFuel(0);
            System.out.println("Fahren wir wieder " + myCar.getFuel() + " Liter Diesel leer!");

            System.out.println("");
        } while (--maxLoops > 0); // drive your car as long as you can pay for the gas (or max. 100 times)

        System.out.println("Ich habe nicht genug Geld für einen vollen Tank....");
    }

}
