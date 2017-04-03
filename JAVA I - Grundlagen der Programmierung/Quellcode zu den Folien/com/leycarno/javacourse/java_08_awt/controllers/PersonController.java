package com.leycarno.javacourse.java_08_awt.controllers;

import com.leycarno.javacourse.java_08_awt.models.Person;
import com.leycarno.javacourse.java_08_awt.services.PersonService;
import com.leycarno.javacourse.java_08_awt.views.MainView;
import com.leycarno.javacourse.java_08_awt.views.PersonView;

import java.util.ArrayList;

public class PersonController {

    private PersonService personService = new PersonService();

    // without parts of JAVA 2, this is a quick and dirty-solution
    // ! make it static for now -> BETTER WOULD BE A DISPATCHER!
    private static PersonView personView = new PersonView();

    public void listAllPersons() {
        ArrayList<Person> allPeople = personService.getAllPeople();

        personView.showAllPeople(allPeople);
    }

    public void createNewPerson(String name) {
        try {
            personService.createPerson(name);
            listAllPersons(); // success - just list all people
        } catch (Throwable th) {
            // show the error message
            MainView.showErrorDialog(th.getMessage());
        }
    }
}
