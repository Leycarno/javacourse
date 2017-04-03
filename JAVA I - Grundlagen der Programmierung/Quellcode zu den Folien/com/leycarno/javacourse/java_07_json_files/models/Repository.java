package com.leycarno.javacourse.java_07_json_files.models;

import java.util.ArrayList;

public class Repository {

    private ArrayList<Car> cars = new ArrayList<>();
    private ArrayList<Person> people = new ArrayList<>();

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }
}
