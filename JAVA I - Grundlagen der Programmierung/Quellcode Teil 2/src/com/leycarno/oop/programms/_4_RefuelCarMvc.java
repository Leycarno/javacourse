package com.leycarno.oop.programms;

import com.leycarno.oop.services.CarService;
import com.leycarno.oop.services.PersonService;
import com.leycarno.oop.models.Car;
import com.leycarno.oop.models.Person;

/**
 * this example has no specific view classes...
 */
public class _4_RefuelCarMvc {

    private static final float fuelPricePerUnit = 1.09f;

    private CarService carService = new CarService();
    private PersonService personService = new PersonService();

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

                System.out.println("Verfügbares Geld von " + me.getName() + ": " + me.getMoney() + "€");

                if (!personService.pay(me, myCar.getFuelMax() * fuelPricePerUnit)) break;
                System.out.print("Ich bezahle " + refuelPrice + "€");

                carService.refuel(myCar, myCar.getFuelMax());
                System.out.println("und das Auto wurde wieder komplett befüllt!");

            }

            carService.useFuel(myCar, myCar.getFuel());
            System.out.println("Fahren wir wieder " + myCar.getFuel() + " Liter Diesel leer!");

            System.out.println("");
        } while (--maxLoops > 0); // drive your car as long as you can pay for the gas (or max. 100 times)

        System.out.println("Ich habe nicht genug Geld für einen vollen Tank....");
    }

}
