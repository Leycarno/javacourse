package com.leycarno.models;

public class Orange extends Fruit {

    public Orange() {
        setName("Orange");
        setUnitPrice(0.75f);
    }

    @Override
    public float getWeightPrice() {
        return 0;
    }
}
