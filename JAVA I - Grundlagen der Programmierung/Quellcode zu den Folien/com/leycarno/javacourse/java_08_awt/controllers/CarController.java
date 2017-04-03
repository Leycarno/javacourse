package com.leycarno.javacourse.java_08_awt.controllers;

import com.leycarno.javacourse.java_08_awt.models.Car;
import com.leycarno.javacourse.java_08_awt.services.CarService;
import com.leycarno.javacourse.java_08_awt.views.CarView;
import com.leycarno.javacourse.java_08_awt.views.MainView;

import java.util.ArrayList;

public class CarController {

    private CarService carService = new CarService();

    // without parts of JAVA 2, this is a quick and dirty-solution
    // ! make it static for now -> BETTER WOULD BE A DISPATCHER!
    private static CarView carView = new CarView();

    public void listAllCars() {
        ArrayList<Car> allCars = carService.getAllCars();

        carView.showAllCars(allCars);
    }

    public void createNewCar(String type) {
        try {
            carService.createCar(type);
            listAllCars(); // success - just list all the cars
        } catch (Throwable th) {
            // show the error message
            MainView.showErrorDialog(th.getMessage());
        }
    }
}
