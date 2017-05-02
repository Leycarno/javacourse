package com.leycarno.models;

public class Peach extends Fruit {

    public Peach() {
        setName("Pfirsich");
        setUnitPrice(0.35f);
    }

    @Override
    public float getWeightPrice() {
        return 0;
    }
}
