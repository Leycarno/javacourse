package com.leycarno.oop.programms;

import com.leycarno.oop.services.CarService;
import com.leycarno.oop.services.PersonService;
import com.leycarno.oop.models.Car;
import com.leycarno.oop.models.Person;
import com.leycarno.oop.views.SimpleView;

public class _5_RefuelCarMenu {

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

    private SimpleView view = new SimpleView();

    public void run() {

        // create a person and his car
        Person me = new Person();
        me.setName("Steffen");
        me.setMoney(100);

        Car myCar = new Car();
        myCar.setFuelMax(50);

        me.setCar(myCar);


        do {
            view.displayMessage(TXT_START_MENU.replace("_MONEY_", "" + me.getMoney()));
            switch (view.nextIntInput(TXT_INT_INPUT_ERROR)) {
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
                    view.displayError(TXT_UNKNOWN_ACTION);
            }
        } while (true);
    }

    private void doActionRefuel(Person me, Car myCar) {
        // let's take a look at current fuel for correct price:
        float refuelPrice = (myCar.getFuelMax() - myCar.getFuel()) * fuelPricePerUnit;
        if (refuelPrice == 0) {
            view.displayMessage(TXT_REFUEL_NOT_NECCASSARY.replace("_PRICE_", "" + refuelPrice));
        } else if (personService.pay(me, refuelPrice)) {
            carService.refuel(myCar, myCar.getFuelMax());
            view.displayMessage(TXT_REFUEL_SUCCESS.replace("_PRICE_", "" + refuelPrice));
        } else {
            view.displayError(TXT_REFUEL_ERROR.replace("_PRICE_", "" + refuelPrice));
        }
    }

    private void doActionUseFuel(Car myCar) {
        if (myCar.getFuel() == 0) {
            view.displayError(TXT_USE_FUEL_ERROR);
        } else {
            carService.useFuel(myCar, myCar.getFuel());
            view.displayMessage(TXT_USE_FUEL_SUCCESS);
        }
    }
}
