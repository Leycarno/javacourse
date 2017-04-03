package com.leycarno.javacourse.java_07_json_files.controllers;

import com.leycarno.javacourse.java_07_json_files.models.Car;
import com.leycarno.javacourse.java_07_json_files.services.CarService;
import com.leycarno.javacourse.java_07_json_files.views.StaticView;

public class CarController {

    CarService carService = new CarService();

    public void run() {

        do {
            StaticView.displayMessage("********************************************************************************"
                    + "\n\t***** FAHRZEUGE *****"
                    + "\n\tBitte wählen Sie die nächste Aktion aus:"
                    + "\n\t1 - Alle Fahrzeuge auflisten"
                    + "\n\t2 - Neues Fahrzeug aufnehmen"
                    + "\n\t0 - Zurück zum Hauptmenü"
                    + "\n********************************************************************************");
            switch (StaticView.nextIntInput("Bitte eine Ganzzahl eingeben!")){
                case 1:
                    listAllCars();
                    break;
                case 2:
                    createNewCar();
                    break;
                case 0:
                    return; // back to main-menu
                default:
                    StaticView.displayError("Diese Aktion ist unbekannt und kann nicht verarbeitet werden");
            }
        } while (true);
    }

    private void listAllCars() {
        for (Car car : carService.getAllCars()) {
            StaticView.displayMessage("ID: " + car.getId() + " - " + car.getType());
        }
    }

    private void createNewCar() {
        StaticView.displayMessage("Bitte den Fahrzeugtypen angeben.");
        String type = StaticView.nextStringInput("...");
        try {
            carService.createCar(type);
        } catch (Throwable th) {
            StaticView.displayError(th.getMessage());
        }
    }

}
