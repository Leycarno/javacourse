package com.leycarno.javacourse.java_07_json_files.controllers;

import com.leycarno.javacourse.java_07_json_files.models.Person;
import com.leycarno.javacourse.java_07_json_files.services.PersonService;
import com.leycarno.javacourse.java_07_json_files.views.StaticView;

public class PersonController {

    private PersonService personService = new PersonService();

    public void run() {

        do {
            StaticView.displayMessage("********************************************************************************"
                    + "\n\t***** KUNDEN *****"
                    + "\n\tBitte wählen Sie die nächste Aktion aus:"
                    + "\n\t1 - Alle Kunden auflisten"
                    + "\n\t2 - Neuen Kunden aufnehmen"
                    + "\n\t0 - Zurück zum Hauptmenü"
                    + "\n********************************************************************************");
            switch (StaticView.nextIntInput("Bitte eine Ganzzahl eingeben!")){
                case 1:
                    listAllPersons();
                    break;
                case 2:
                    createNewPerson();
                    break;
                case 0:
                    return; // back to main-menu
                default:
                    StaticView.displayError("Diese Aktion ist unbekannt und kann nicht verarbeitet werden");
            }
        } while (true);
    }

    private void listAllPersons() {
        for (Person person : personService.getAllPeople()) {
            StaticView.displayMessage("ID: " + person.getId() + " - " + person.getName());
        }
    }

    private void createNewPerson() {
        StaticView.displayMessage("Bitte einen Namen eingeben.");
        String name = StaticView.nextStringInput("...");
        try {
            personService.createPerson(name);
        } catch (Throwable th) {
            StaticView.displayError(th.getMessage());
        }
    }

}
