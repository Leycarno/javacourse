package com.leycarno.model;

public class Peach {

    public static final float UNIT_PRICE = 0.74f;

    private FruitType fruitType = FruitType.Peach;
    private int amount;

    public FruitType getFruitType() {
        return fruitType;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
