package com.leycarno.javacourse.java_07_json_files.controllers;

import com.leycarno.javacourse.java_07_json_files.services.RepositoryService;
import com.leycarno.javacourse.java_07_json_files.views.StaticView;

public class MainController {

    private static final String FILE_NAME = "repository.json";

    public void run() {
        do {
            StaticView.displayMessage("********************************************************************************"
                    + "\n\t***** HAUPTMENÜ *****"
                    + "\n\tWillkommen bei der Kieler Förde Autovermietung"
                    + "\n\tBitte wählen Sie die nächste Aktion aus:"
                    + "\n\t1 - Kunden"
                    + "\n\t2 - Fahrzeuge"
                    + "\n\t3 - Vermietungen"
                    + "\n\t8 - Daten in Datei speichern"
                    + "\n\t9 - Daten aus Datei auslesen"
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
                case 8:
                    RepositoryService.store(FILE_NAME);
                    break;
                case 9:
                    RepositoryService.load(FILE_NAME);
                    break;
                case 0:
                    System.exit(0);
                default:
                    StaticView.displayError("Diese Aktion ist unbekannt und kann nicht verarbeitet werden");
            }
        } while (true);
    }
}
