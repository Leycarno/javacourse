package com.leycarno.javacourse.java_07_json_files.services;

import com.leycarno.javacourse.java_07_json_files.models.Car;
import com.leycarno.javacourse.java_07_json_files.models.Person;

import java.util.ArrayList;

public class CarService {

    // static members to reuse the same list with several service-objects!
    private static int nextId = 1000;
    private static ArrayList<Car> cars = new ArrayList<>();

    /**
     * 1. try to find the car by his id         (Exception if not found)
     * 2. give the car to the person            (Exception if the car is leased)
     *
     * @param idOfTheCar
     * @throws Exception
     */
    public void rentCar(Person person, int idOfTheCar) throws Exception {
        if (person == null) throw new Exception("Das ist keine Person!");
        if (person.getCar() != null) throw new Exception("Diese Person hat schon ein Auto");
        Car car = findCar(idOfTheCar);
        if (car.isLeased()) throw new Exception("Dieses Auto ist schon vermietet!");

        car.setLeased(true);
        person.setCar(car);
    }

    /**
     * unlink the car from the person
     *
     * @param person
     * @throws Exception
     */
    public void giveBackCar(Person person) throws Exception {
        Car car = person.getCar();
        if (car.isLeased()) throw new Exception("Dieses Person hat doch gar kein Auto!");

        car.setLeased(false);
        person.setCar(null);
    }

    /**
     * @return all the cars
     */
    public static ArrayList<Car> getAllCars() {
        return cars;
    }

    /**
     * @return all the free car
     */
    public static ArrayList<Car> getFreeCars() {
        ArrayList<Car> freeCars = new ArrayList<>();
        for (Car p : cars) {
            if (!p.isLeased()) freeCars.add(p);
        }
        return freeCars;
    }

    /**
     * @return all the leased car
     */
    public static ArrayList<Car> getLeasedCars() {
        ArrayList<Car> leasedCars = new ArrayList<>();
        for (Car p : cars) {
            if (p.isLeased()) leasedCars.add(p);
        }
        return leasedCars;
    }

    /**
     * creates a car with a type-name of max. 3 and min. 64 characters
     * @param type
     * @return
     * @throws Exception
     */
    public Car createCar(String type) throws Exception {
        if (type.length() < 3 || type.length() > 64) {
            throw new Exception("Der Autotyp muss mindestens 3 und kann maximal nur 64 Zeichen lang sein");
        }
        Car car = new Car();
        car.setId(nextId++); // set and increment
        car.setType(type);
        cars.add(car);
        return car;
    }

    /**
     * try to find the car by his unique id
     * @param id
     * @return
     * @throws Exception
     */
    public static Car findCar(int id) throws Exception {
        Car result = null;
        for (Car car : cars) {
            if (car.getId() == id) {
                result = car;
                break;
            }
        }
        if (result == null) {
            throw new Exception("Das Auto konnte nicht gefunden werden!");
        }
        return result;
    }

    /**
     * replace all the cars in memory
     * @param carsData
     */
    public static void putData(ArrayList<Car> carsData) {
        cars = carsData;
        nextId += cars.size();
    }
}
