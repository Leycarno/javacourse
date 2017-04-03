package com.leycarno.javacourse.java_08_awt.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leycarno.javacourse.java_08_awt.models.Person;
import com.leycarno.javacourse.java_08_awt.models.Repository;

import java.io.File;

public class RepositoryService {

    private CarService carService = new CarService();
    private PersonService personService = new PersonService();

    public void store(String fileName) {
        // get all the current people and cars
        Repository repository = new Repository();
        repository.setCars(carService.getAllCars());
        repository.setPeople(personService.getAllPeople());

        // and save them into the file
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Example 1: Convert object to JSON string and pretty print
            String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(repository);
            System.out.println(jsonInString);

            // Example 2: Convert object to JSON string and save into a file directly
            mapper.writeValue(new File(fileName), repository);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void load(String fileName) {
        ObjectMapper mapper = new ObjectMapper();
        Repository repository = null;
        try {

            // Convert JSON string from file to Object
            repository = mapper.readValue(new File(fileName), Repository.class);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // put the correct car and person by ids
        for (Person person : repository.getPeople()) {
            if (person.getCarId() > 0) {
                try {
                    person.setCar(carService.findCar(person.getCarId()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        // put all the people and cars from the file to the services
        personService.putData(repository.getPeople());
        carService.putData(repository.getCars());

    }

}
