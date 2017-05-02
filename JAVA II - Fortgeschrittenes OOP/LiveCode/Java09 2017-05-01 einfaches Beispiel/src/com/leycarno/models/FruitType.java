package com.leycarno.models;

public enum FruitType {

    APPLE("Apfel"),
    PEACH("Pfirsich"),
    ORANGE("Orange");

    public final String de;

    FruitType(String de) {
        // späteste Stelle, um "final" Attribute zu setzen
        this.de = de;
    }


//
//    public String getDe() {
//        return de;
//    }

}
