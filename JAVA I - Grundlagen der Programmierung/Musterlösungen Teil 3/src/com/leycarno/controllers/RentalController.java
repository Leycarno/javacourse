package com.leycarno.controllers;


import com.leycarno.models.Car;
import com.leycarno.models.Person;
import com.leycarno.services.CarService;
import com.leycarno.services.PersonService;
import com.leycarno.views.StaticView;

public class RentalController {

    private PersonService personService = new PersonService();
    private CarService carService = new CarService();

    public void run() {

        do {
            StaticView.displayMessage("********************************************************************************"
                    + "\n\t***** VERMIETUNGEN *****"
                    + "\n\tBitte wählen Sie die nächste Aktion aus:"
                    + "\n\t1 - Alle Vermietungen auflisten"
                    + "\n\t2 - Fahrzeug an Kunden vermieten"
                    + "\n\t3 - Fahrzeug wieder zurücknehmen"
                    + "\n\t0 - Zurück zum Hauptmenü"
                    + "\n********************************************************************************");
            switch (StaticView.nextIntInput("Bitte eine Ganzzahl eingeben!")){
                case 1:
                    showRentals();
                    break;
                case 2:
                    rentCar();
                    break;
                case 3:
                    giveBackCar();
                    break;
                case 0:
                    return; // back to main-menu
                default:
                    StaticView.displayError("Diese Aktion ist unbekannt und kann nicht verarbeitet werden");
            }
        } while (true);
    }

    private void showRentals() {
        Person[] personsWithCar = personService.getPeopleWithCar().toArray(new Person[0]);
        if (personsWithCar.length == 0) {
            StaticView.displayMessage("Es sind kein Fahrzeug vermietet.");
        }

        for (Person person: personsWithCar) {
            StaticView.displayMessage("ID: " + person.getCar().getId() + " - " + person.getCar().getType()
                    + " - vermietet an: " + person.getName());
        }
    }

    private void rentCar() {
        // get all persons without a car and all free cars
        Car[] freeCars = carService.getFreeCars().toArray(new Car[0]);
        Person[] personsWithoutCar = personService.getPeopleWithoutCar().toArray(new Person[0]);

        // there are @least one car and one person?
        if (freeCars.length == 0) {
            StaticView.displayMessage("Es gibt keine freien Fahrzeuge mehr.");
            return;
        }
        if (personsWithoutCar.length == 0) {
            StaticView.displayMessage("Es gibt keine Kunden ohne Auto.");
            return;
        }

        // show possibilities to the user
        StaticView.displayMessage("*** Verfügbare Kunden ohne Wagen ***");
        for (Person person : personsWithoutCar) {
            StaticView.displayMessage("ID: " + person.getId() + " - " + person.getName());
        }
        StaticView.displayMessage("*** Verfügbare Wagen ***");
        for (Car car : freeCars) {
            StaticView.displayMessage("ID: " + car.getId() + " - " + car.getType());
        }

        // let the user choose
        StaticView.displayMessage("Bitte einen Kunden wählen (per ID): ");
        int personId = StaticView.nextIntInput("Bitte eine Ganzzahl für die ID eingeben");

        StaticView.displayMessage("Bitte eine Fahrzeug wählen (per ID): ");
        int carId = StaticView.nextIntInput("Bitte eine Ganzzahl für die ID eingeben");

        // do it - or show the error
        try {
            Person person = personService.findPersonById(personId);
            carService.rentCar(person, carId);
        } catch (Throwable th) {
            StaticView.displayError(th.getMessage());
        }
    }

    private void giveBackCar() {
        Person[] personsWithCar = personService.getPeopleWithCar().toArray(new Person[0]);
        if (personsWithCar.length == 0) {
            StaticView.displayMessage("Es gibt keine Kunden mit Auto.");
            return;
        }

        StaticView.displayMessage("*** Verfügbare Kunden mit gemieteten Fahrzeugen ***");
        for (Person person : personsWithCar) {
            StaticView.displayMessage("ID: " + person.getId() + " - " + person.getName());
        }

        StaticView.displayMessage("Bitte einen Kunden wählen (per ID): ");
        int personId = StaticView.nextIntInput("Bitte eine Ganzzahl für die ID eingeben");

        try {
            Person person = personService.findPersonById(personId);
            carService.giveBackCar(person);
        } catch (Throwable th) {
            StaticView.displayError(th.getMessage());
        }
    }


}
