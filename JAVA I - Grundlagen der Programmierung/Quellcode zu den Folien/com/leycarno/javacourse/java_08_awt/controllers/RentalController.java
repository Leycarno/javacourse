package com.leycarno.javacourse.java_08_awt.controllers;

import com.leycarno.javacourse.java_08_awt.models.Car;
import com.leycarno.javacourse.java_08_awt.models.Person;
import com.leycarno.javacourse.java_08_awt.services.CarService;
import com.leycarno.javacourse.java_08_awt.services.PersonService;
import com.leycarno.javacourse.java_08_awt.views.MainView;
import com.leycarno.javacourse.java_08_awt.views.RentalView;

import java.util.ArrayList;

public class RentalController {

    private PersonService personService = new PersonService();
    private CarService carService = new CarService();

    // without parts of JAVA 2, this is a quick and dirty-solution
    // ! make it static for now -> BETTER WOULD BE A DISPATCHER!
    private static RentalView rentalView = new RentalView();

    public void showRentals() {
        ArrayList<Person> peopleWithCar = personService.getPeopleWithCar();

        rentalView.showAllRentals(peopleWithCar);
    }

    public void showCarRental() {
        ArrayList<Car> freeCars = carService.getFreeCars();
        ArrayList<Person> personsWithoutCar = personService.getPeopleWithoutCar();

        rentalView.showCarRental(freeCars, personsWithoutCar);
    }

    public void rentCar(int personId, int carId) {
        try {
            Person person = personService.findPersonById(personId);
            carService.rentCar(person, carId);
            showRentals();  // simple show all the rentals...
        } catch (Throwable th) {
            // error - just show the dialog
            MainView.showErrorDialog(th.getMessage());
        }
    }

    /**
     * it's nearly "showRentals" but with another view
     */
    public void showCarWithdraw() {
        ArrayList<Person> peopleWithCar = personService.getPeopleWithCar();

        rentalView.showWithdrawCar(peopleWithCar);
    }

    public void withdrawCar(int personId) {
        try {
            Person person = personService.findPersonById(personId);
            carService.withdrawCar(person);
            showCarWithdraw();  // simple show/update the list of rented cars
        } catch (Throwable th) {
            // error - just show the dialog
            MainView.showErrorDialog(th.getMessage());
        }
    }
}
