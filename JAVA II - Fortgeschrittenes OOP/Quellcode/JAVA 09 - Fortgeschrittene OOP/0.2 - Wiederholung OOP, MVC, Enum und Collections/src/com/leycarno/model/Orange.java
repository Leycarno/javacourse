package com.leycarno.model;

public class Orange {

    public static final float UNIT_PRICE = 0.46f;

    private FruitType fruitType = FruitType.Orange;
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
