package com.leycarno.javacourse.java_08_awt.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Person {

    private int id;
    private String name;

    @JsonIgnore
    private Car car;

    private int carId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
        if (car == null) {
            this.carId = 0;
        } else {
            this.carId = car.getId();
        }
    }

    public int getCarId() {
        return carId;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", car=" + car +
                '}';
    }
}
