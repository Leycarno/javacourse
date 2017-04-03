package com.leycarno.javacourse.java_08_awt.views;

import com.leycarno.javacourse.java_08_awt.controllers.PersonController;
import com.leycarno.javacourse.java_08_awt.models.Person;

import java.awt.*;
import java.util.ArrayList;

public class PersonView {

    // without parts of JAVA 2, this is a quick and dirty-solution
    // ! make it static for now -> BETTER WOULD BE A DISPATCHER!
    private static PersonController controller = new PersonController();

    public void showAllPeople(ArrayList<Person> allPeople) {
        MainView.viewPort.removeAll(); // clear the whole content

        if (allPeople.isEmpty()) {
            // there is no person in the list
            MainView.viewPort.add(new Label("Es gibt noch gar keine Kunden!"));
        } else {
            // list all the people
            MainView.viewPort.add(buildPeoplePanel(allPeople));
        }

        MainView.viewPort.revalidate(); // refresh the view (show the new content)
    }

    public void showPersonForm() {
        MainView.viewPort.removeAll(); // clear the whole content

        MainView.viewPort.add(buildCreatePersonFormPanel());

        MainView.viewPort.revalidate(); // refresh the view (show the new content)
    }

    public Panel buildPeoplePanel(ArrayList<Person> allPeople) {
        Panel panel = new Panel();
        panel.setLayout(new GridLayout(allPeople.size(), 4)); // set a GridLayout
        for (Person person : allPeople) {
            panel.add(new Label("" + person.getId()));
            panel.add(new Label(person.getName()));
            panel.add(new Label(person.getCar() == null
                    ? "--- kein Fahrzeug ---"
                    : "FahrzeugId: " + person.getCar().getId()));
            panel.add(new Label(person.getCar() == null ? "" : person.getCar().getType()));
        }
        return panel;
    }

    public Panel buildCreatePersonFormPanel() {
        // create a panel as container of the form-elements
        Panel formPanel = new Panel();
        formPanel.setLayout(new GridLayout(4, 1));

        // create a Label
        formPanel.add(new Label("Bitte einen Namen eingeben:"));
        // create an InputTextField
        TextField nameInput = new TextField() {{
            // react on ENTER
            addActionListener(e -> controller.createNewPerson(getText()));
        }};
        formPanel.add(nameInput);
        // create a button, onClick:
        // -> get the text from the inputField
        // -> send this text to the controller to create the person
        formPanel.add(new Button("Person erstellen") {{
            addActionListener(e -> controller.createNewPerson(nameInput.getText()));
        }});

        return formPanel;
    }

}
