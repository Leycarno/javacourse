package com.leycarno.models;

public abstract class Fruit implements Priceable {

    private float unitPrice;
    private String name;
    private int amount;

    public Fruit() {

    }

    public Fruit(String name) {
        this.name = name;
    }

    public abstract float getWeightPrice();

    public float getUnitPrice() {
        return unitPrice;
    }

    protected void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
