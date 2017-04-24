package com.leycarno.model;

public class Apple {

    public static final float UNIT_PRICE = 0.56f;

    private FruitType fruitType = FruitType.Apple;
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
