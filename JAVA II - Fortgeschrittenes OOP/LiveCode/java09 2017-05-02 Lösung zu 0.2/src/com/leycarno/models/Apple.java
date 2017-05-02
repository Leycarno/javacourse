package com.leycarno.models;

public class Apple extends Fruit {

    float weight = 10; // kg
    float weightPrice = 3; // €

    public Apple(String name) {
        super(name);
    }

    public Apple() {
        super("Apfel");
//        setName("Apfel");
        setUnitPrice(0.45f);
    }

    @Override
    public float getUnitPrice() {
        float result = super.getUnitPrice();
        return result * 2;
//        return getUnitPrice() * 2;
    }

    @Override
    public float getWeightPrice() {
        return weight * weightPrice;
    }

}
