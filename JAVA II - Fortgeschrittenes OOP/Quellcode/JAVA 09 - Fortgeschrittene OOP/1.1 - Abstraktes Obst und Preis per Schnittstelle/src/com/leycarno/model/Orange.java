package com.leycarno.model;

public class Orange extends Fruit {

    private static final float UNIT_PRICE = 0.46f;

    public Orange() {
        this.setFruitType(FruitType.Orange);
    }

    @Override
    public float getUnitPrice() {
        return UNIT_PRICE;
    }
}
