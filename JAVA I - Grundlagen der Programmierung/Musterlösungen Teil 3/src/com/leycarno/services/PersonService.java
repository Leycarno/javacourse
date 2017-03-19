package com.leycarno.services;

import com.leycarno.models.Person;

import java.util.ArrayList;

public class PersonService {

    private static int nextId = 1000;
    private static ArrayList<Person> people = new ArrayList<>();

    /**
     * @return all the people
     */
    public static ArrayList<Person> getAllPeople() {
        return people;
    }

    /**
     * @return all the people with a car
     */
    public static ArrayList<Person> getPeopleWithCar() {
        ArrayList<Person> peopleWithCar = new ArrayList<>();
        for (Person p : people) {
            if (p.getCar() != null) peopleWithCar.add(p);
        }
        return peopleWithCar;
    }

    /**
     * @return all the people without a car
     */
    public static ArrayList<Person> getPeopleWithoutCar() {

        ArrayList<Person> peopleWithCar = new ArrayList<>();
        for (Person p : people) {
            if (p.getCar() == null) peopleWithCar.add(p);
        }
        return peopleWithCar;
    }

    /**
     * creates a person with a name of max. 3 and min. 64 characters
     * @param name
     * @return
     * @throws Exception
     */
    public Person createPerson(String name) throws Exception {
        if (name.length() < 3 || name.length() > 64) {
            throw new Exception("Bitte minimal 3 und maximal 64 Buchstaben verwenden.");
        }
        Person p = new Person();
        p.setId(nextId++); // set and increment
        p.setName(name);
        people.add(p);
        return p;
    }

    /**
     * try to find the person by his unique id
     * @param id
     * @return
     * @throws Exception
     */
    public Person findPersonById(int id) throws Exception {
        Person result = null;
        for (Person p : people) {
            if (p.getId() == id) {
                result = p;
                break;
            }
        }
        if (result == null) {
            throw new Exception("Die Person wurde nicht gefunden.");
        }
        return result;
    }

    /**
     * try to find a person by his name
     * @param name
     * @return
     * @throws Exception
     */
    public Person findPersonByName(String name) throws Exception {
        Person result = null;
        boolean found = false;
        for (Person p : people) {
            if (p.getName().equals(name)) {
                if (found) { // this case you could also use for a search by a part of a name...
                    throw new Exception("Es wurde mehrere Personen mit diesem Namen gefunden.");
                }
                result = p;
                found = true;
            }
        }
        if (result == null) {
            throw new Exception("Die Person wurde nicht gefunden.");
        }
        return result;
    }
}
