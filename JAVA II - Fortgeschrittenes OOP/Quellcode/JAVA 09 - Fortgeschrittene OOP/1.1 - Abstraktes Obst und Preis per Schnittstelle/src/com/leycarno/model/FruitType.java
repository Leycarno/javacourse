package com.leycarno.model;

public enum FruitType {

    Apple("Apfel"),
    Peach("Pfirsich"),
    Orange("Orange");

    private final String name;

    FruitType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
