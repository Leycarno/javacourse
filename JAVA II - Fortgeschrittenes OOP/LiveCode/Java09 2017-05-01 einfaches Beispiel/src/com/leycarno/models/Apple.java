package com.leycarno.models;

public class Apple {

    public final static float UNIT_PRICE = 0.56f;

    private FruitType fruitType = FruitType.APPLE;
    private int amount;

    public FruitType getFruitType() {
        return fruitType;
    }

    public String getName() {
        return fruitType.de;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
