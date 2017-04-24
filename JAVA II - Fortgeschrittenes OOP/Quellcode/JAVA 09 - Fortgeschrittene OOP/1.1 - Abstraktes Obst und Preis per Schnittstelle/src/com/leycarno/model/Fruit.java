package com.leycarno.model;

public abstract class Fruit implements FruitPrice {

    private FruitType fruitType = FruitType.Apple;
    private int amount;

    protected void setFruitType(FruitType fruitType) {
        this.fruitType = fruitType;
    }

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
