package com.leycarno.model;

public abstract class Fruit implements UnitPriceable {

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

    @Override
    public int getAmount() {
        return amount;
    }

}
