package com.leycarno.models;

public class Peach {

    public final static float UNIT_PRICE = 0.34f;

    private FruitType fruitType = FruitType.PEACH;
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
