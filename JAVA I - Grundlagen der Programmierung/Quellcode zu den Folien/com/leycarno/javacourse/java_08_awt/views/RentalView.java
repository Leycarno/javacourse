package com.leycarno.javacourse.java_08_awt.views;

import com.leycarno.javacourse.java_08_awt.controllers.RentalController;
import com.leycarno.javacourse.java_08_awt.models.Car;
import com.leycarno.javacourse.java_08_awt.models.Person;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class RentalView {

    // without parts of JAVA 2, this is a quick and dirty-solution
    // ! make it static for now -> BETTER WOULD BE A DISPATCHER!
    private static PersonView personView = new PersonView();
    private static RentalController controller = new RentalController();

    /** ************************************************************
     *
     */
    public void showAllRentals(ArrayList<Person> peopleWithCar) {
        MainView.viewPort.removeAll(); // clear the whole content

        if (peopleWithCar.isEmpty()) {
            // there is no rental in the list
            MainView.viewPort.add(new Label("Im Moment sind keine Fahrzeuge vermietet!"));
        } else {
            // list all the rentals (reuse the "smart" method of the peopleView!)
            MainView.viewPort.add(personView.buildPeoplePanel(peopleWithCar));
        }

        MainView.viewPort.revalidate(); // refresh the view (show the new content)
    }

    /** ************************************************************
     *
     */
    public void showCarRental(ArrayList<Car> freeCars, ArrayList<Person> peopleWithoutCar) {
        MainView.viewPort.removeAll(); // clear the whole content

        // create a "parent"-Panel for the sub-elements
        // 2 rows - one for the choice-lists and one for the button
        Panel layoutPanel = new Panel(new GridLayout(2, 1));

        if (freeCars.isEmpty()) {
            MainView.viewPort.add(new Label("Es sind keine freien Fahrzeuge verfügbar!"));
        } else if (peopleWithoutCar.isEmpty()) {
            MainView.viewPort.add(new Label("Es gibt keine Kunden ohne Auto!"));
        } else {
            // generate a map with labels and persons/cars
            // so we can find the selected person/car by the selected label
            HashMap<String, Person> selectablePeople = generatePersonChoiceMap(peopleWithoutCar);
            HashMap<String, Car> selectableCars = generateCarChoiceMap(freeCars);

            // put the arrayLists of cars and persons into nice AWT-Lists (Auswahlliste)
            List carList = new List(freeCars.size());
            for (String carLabel : selectableCars.keySet()) carList.add(carLabel);

            List peopleList = new List(peopleWithoutCar.size());
            for (String personLabel : selectablePeople.keySet()) peopleList.add(personLabel);

            // put the people and the cars side by side (sub-panel)
            Panel panel = new Panel(new GridLayout(1, 2));
            panel.add(carList);
            panel.add(peopleList);
            layoutPanel.add(panel); // and put the subPanel into the parent-layout-panel...

            // add a button to rent the car
            layoutPanel.add(new Button("Fahrzeug vermieten") {{
                // reaction on click:
                addActionListener(e -> {

                    // find the selected elements (=values of the map) by the selected label (=key of the map)
                    Person selectedPerson = selectablePeople.get(peopleList.getSelectedItem());
                    Car selectedCar = selectableCars.get(carList.getSelectedItem());

                    // prove, that there are proper selected elements
                    if (selectedPerson == null || selectedCar == null) {
                        // otherwise popup an error Dialog
                        MainView.showErrorDialog("Bitte einen Kunden und ein Fahrzeug auswählen!");
                    } else {
                        // use the selected elements to rent the car by the controller
                        controller.rentCar(selectedPerson.getId(), selectedCar.getId());
                    }
                });
            }});
        }

        MainView.viewPort.add(layoutPanel);
        MainView.viewPort.revalidate();
    }

    /** ************************************************************
     *
     */
    public void showWithdrawCar(ArrayList<Person> peopleWithCar) {
        MainView.viewPort.removeAll(); // clear the whole content

        // create a "parent"-Panel for the sub-elements
        // 2 rows - one for the choice-list and one for the button
        Panel layoutPanel = new Panel(new GridLayout(2, 1));

        if (peopleWithCar.isEmpty()) {
            MainView.viewPort.add(new Label("Momentan sind keine Fahrzeuge vermietet!"));
        } else {
            // generate a map with labels and people
            // so we can find the selected person by the selected label
            HashMap<String, Person> selectablePeople = generateWithdrawChoiceMap(peopleWithCar);

            // put the arrayLists of people into nice AWT-Choice-List
            List list = new List(peopleWithCar.size());
            for (String label : selectablePeople.keySet()) list.add(label);
            layoutPanel.add(list);

            // add a button to rent the car
            layoutPanel.add(new Button("Fahrzeug zurücknehmen") {{
                // reaction on click:
                addActionListener(e -> {

                    // find the selected person (=values of the map) by the selected label (=key of the map)
                    Person selectedPerson = selectablePeople.get(list.getSelectedItem());

                    // prove, that there are proper selected elements
                    if (selectedPerson == null) {
                        // otherwise popup an error Dialog
                        MainView.showErrorDialog("Bitte einen Kunden mit Fahrzeug auswählen!");
                    } else {
                        // use the selected elements to rent the car by the controller
                        controller.withdrawCar(selectedPerson.getId());
                    }
                });
            }});
        }

        MainView.viewPort.add(layoutPanel);
        MainView.viewPort.revalidate();
    }

    // ****************************************************************************************************

    /**
     * generate a map with labels and persons
     * so we can find the selected person by the selected label
     */
    private HashMap<String, Person> generatePersonChoiceMap(ArrayList<Person> people) {
        HashMap<String, Person> result = new HashMap<>();
        for (Person p : people) {
            result.put(p.getId() + ". " + p.getName(), p);
        }
        return result;
    }

    /**
     * generate a map with labels and cars
     * so we can find the selected car by the selected label
     */
    private HashMap<String, Car> generateCarChoiceMap(ArrayList<Car> cars) {
        HashMap<String, Car> result = new HashMap<>();
        for (Car car : cars) {
            result.put(car.getId() + ". " + car.getType(), car);
        }
        return result;
    }

    /**
     * generate a map with labels and persons with his car
     * so we can find the selected person and car by the selected label
     */
    private HashMap<String, Person> generateWithdrawChoiceMap(ArrayList<Person> people) {
        HashMap<String, Person> result = new HashMap<>();
        for (Person p : people) {
            result.put(p.getId() + ". " + p.getName() + " >>> " + p.getCar().getId() + ". " + p.getCar().getType(), p);
        }
        return result;
    }
}
