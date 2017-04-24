package com.leycarno.model;

public class Apple extends Fruit {

    private static final float UNIT_PRICE = 0.56f;

    public Apple() {
        this.setFruitType(FruitType.Apple);
    }

    @Override
    public float getUnitPrice() {
        return UNIT_PRICE;
    }
}
