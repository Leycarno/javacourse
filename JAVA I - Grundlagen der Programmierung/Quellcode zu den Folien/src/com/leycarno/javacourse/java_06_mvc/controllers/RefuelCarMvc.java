package com.leycarno.javacourse.java_06_mvc.controllers;

import com.leycarno.javacourse.java_06_mvc.models.Car;
import com.leycarno.javacourse.java_06_mvc.models.Person;
import com.leycarno.javacourse.java_06_mvc.services.CarService;
import com.leycarno.javacourse.java_06_mvc.services.PersonService;
import com.leycarno.javacourse.java_06_mvc.views.StaticView;

public class RefuelCarMvc {

    // ok for now - later we will use txt files for "i18n"
    private static final String TXT_START_MENU = "********************************************************************************"
            + "\n\tWillkommen bei der Kieler Förde Autovermietung (Ihr Geld: _MONEY_)"
            + "\n\tBitte wählen Sie die nächste Aktion aus:"
            + "\n\t1 - Auto auftanken"
            + "\n\t2 - Tank leer fahren..."
            + "\n\t0 - Programm beenden"
            + "\n********************************************************************************";
    private static final String TXT_UNKNOWN_ACTION = "Diese Aktion ist unbekannt und kann nicht verarbeitet werden";
    private static final String TXT_REFUEL_NOT_NECCASSARY = "Nicht nötig, der Tank ist noch voll!";
    private static final String TXT_REFUEL_SUCCESS = "Auto wurde für _PRICE_ vollgetankt!";
    private static final String TXT_REFUEL_ERROR = "Volltanken ist nicht möglich! (Kosten: _PRICE_)";
    private static final String TXT_USE_FUEL_SUCCESS = "Tank wurde leer gefahren...";
    private static final String TXT_USE_FUEL_ERROR = "Der Tank ist bereits leer... Volltanken?";
    private static final String TXT_INT_INPUT_ERROR = "Bitte eine Zahl eingeben!";

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

        do {
            StaticView.displayMessage(TXT_START_MENU.replace("_MONEY_", "" + me.getMoney()));
            switch (StaticView.nextIntInput(TXT_INT_INPUT_ERROR)) {
                case 1:
                    doActionRefuel(me, myCar);
                    break;
                case 2:
                    doActionUseFuel(myCar);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    StaticView.displayError(TXT_UNKNOWN_ACTION);
            }
        } while (true);
    }

    private void doActionRefuel(Person me, Car myCar) {
        // let's take a look at current fuel for correct price:
        float refuelPrice = (myCar.getFuelMax() - myCar.getFuel()) * fuelPricePerUnit;
        if (refuelPrice == 0) {
            StaticView.displayMessage(TXT_REFUEL_NOT_NECCASSARY.replace("_PRICE_", "" + refuelPrice));
        } else if (personService.pay(me, refuelPrice)) {
            carService.refuel(myCar, myCar.getFuelMax());
            StaticView.displayMessage(TXT_REFUEL_SUCCESS.replace("_PRICE_", "" + refuelPrice));
        } else {
            StaticView.displayError(TXT_REFUEL_ERROR.replace("_PRICE_", "" + refuelPrice));
        }
    }

    private void doActionUseFuel(Car myCar) {
        if (myCar.getFuel() == 0) {
            StaticView.displayError(TXT_USE_FUEL_ERROR);
        } else {
            carService.useFuel(myCar, myCar.getFuel());
            StaticView.displayMessage(TXT_USE_FUEL_SUCCESS);
        }
    }
}
