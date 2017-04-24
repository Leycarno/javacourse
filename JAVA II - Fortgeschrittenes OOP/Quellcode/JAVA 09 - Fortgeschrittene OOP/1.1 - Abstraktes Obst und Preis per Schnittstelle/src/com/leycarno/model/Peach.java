package com.leycarno.model;

public class Peach extends Fruit {

    private static final float UNIT_PRICE = 0.74f;

    public Peach() {
        this.setFruitType(FruitType.Peach);
    }

    @Override
    public float getUnitPrice() {
        return UNIT_PRICE;
    }
}
