package com.leycarno.javacourse.java_07_json_files.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leycarno.javacourse.java_07_json_files.models.Car;
import com.leycarno.javacourse.java_07_json_files.models.Person;
import com.leycarno.javacourse.java_07_json_files.models.Repository;

import java.io.File;

public class RepositoryService {

    public static void store(String fileName) {
        // get all the current people and cars
        Repository repository = new Repository();
        repository.setCars(CarService.getAllCars());
        repository.setPeople(PersonService.getAllPeople());

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

    public static void load(String fileName) {
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
                    person.setCar(CarService.findCar(person.getCarId()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        // put all the people and cars from the file to the services
        PersonService.putData(repository.getPeople());
        CarService.putData(repository.getCars());

    }

}
