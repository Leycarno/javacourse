package com.leycarno.javacourse.java_08_awt.views;

import com.leycarno.javacourse.java_08_awt.controllers.CarController;
import com.leycarno.javacourse.java_08_awt.models.Car;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CarView {

    // without parts of JAVA 2, this is a quick and dirty-solution
    // ! make it static for now -> BETTER WOULD BE A DISPATCHER!
    private static CarController controller = new CarController();

    public void showAllCars(ArrayList<Car> allCars) {
        MainView.viewPort.removeAll(); // clear the whole content

        if (allCars.isEmpty()) {
            // there is no car in the list
            MainView.viewPort.add(new Label("Es gibt noch gar keine Fahrzeuge!"));
        } else {
            // list all the cars
            MainView.viewPort.add(buildCarsPanel(allCars));
        }

        MainView.viewPort.revalidate(); // refresh the view (show the new content)
    }

    public void showCarForm() {
        MainView.viewPort.removeAll(); // clear the whole content

        MainView.viewPort.add(buildCarFormPanel());

        MainView.viewPort.revalidate(); // refresh the view (show the new content)
    }

    public Panel buildCarsPanel(ArrayList<Car> allCars) {
        Panel panel = new Panel();
        panel.setLayout(new GridLayout(allCars.size(), 3)); // set a GridLayout
        for (Car car : allCars) {
            panel.add(new Label("" + car.getId()));
            panel.add(new Label(car.getType()));
            panel.add(new Label(car.isLeased() ? "VERLIEHEN" : "verfügbar"));
        }
        return panel;
    }

    public Panel buildCarFormPanel() {
        // create a panel as container of the form-elements
        Panel formPanel = new Panel();
        formPanel.setLayout(new GridLayout(4, 1));

        // create a Label
        formPanel.add(new Label("Bitte einen Fahrzeugtypen eingeben:"));
        // create an InputTextField
        TextField nameInput = new TextField() {{
            // react on ENTER
            addActionListener(e -> controller.createNewCar(getText()));
        }};
        formPanel.add(nameInput);
        // create a button, onClick:
        // -> get the text from the inputField
        // -> send this text to the controller to create the car
        formPanel.add(new Button("Fahrzeug erstellen") {{
            addActionListener(e -> controller.createNewCar(nameInput.getText()));
        }});

        return formPanel;
    }

}
