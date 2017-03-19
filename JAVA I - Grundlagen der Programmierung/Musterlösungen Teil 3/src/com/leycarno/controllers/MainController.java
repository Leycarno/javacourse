package com.leycarno.controllers;

import com.leycarno.views.StaticView;

public class MainController {

    public void run() {
        do {
            StaticView.displayMessage("********************************************************************************"
                    + "\n\t***** HAUPTMENÜ *****"
                    + "\n\tWillkommen bei der Kieler Förde Autovermietung"
                    + "\n\tBitte wählen Sie die nächste Aktion aus:"
                    + "\n\t1 - Kunden"
                    + "\n\t2 - Fahrzeuge"
                    + "\n\t3 - Vermietungen"
                    + "\n\t0 - Programm beenden"
                    + "\n********************************************************************************");
            switch (StaticView.nextIntInput("Bitte eine Ganzzahl eingeben!")){
                case 1:
                    PersonController personMenu = new PersonController();
                    personMenu.run();
                    break;
                case 2:
                    CarController carMenu = new CarController();
                    carMenu.run();
                    break;
                case 3:
                    RentalController rentalMenu = new RentalController();
                    rentalMenu.run();
                    break;
                case 0:
                    System.exit(0);
                default:
                    StaticView.displayError("Diese Aktion ist unbekannt und kann nicht verarbeitet werden");
            }
        } while (true);
    }
}
