package com.leycarno.controller;

import com.leycarno.model.Apple;
import com.leycarno.model.FruitType;
import com.leycarno.model.Orange;
import com.leycarno.model.Peach;

import java.util.HashMap;

public class FruitController {

    private Apple apple = new Apple();
    private Peach peach = new Peach();
    private Orange orange = new Orange();

    public void changeFruitAmount(FruitType fruitType, int addAmount) throws Exception {
        switch (fruitType) {
            case Apple:
                apple.setAmount(changeAmount(apple.getAmount(), addAmount));
                break;
            case Peach:
                peach.setAmount(changeAmount(peach.getAmount(), addAmount));
                break;
            case Orange:
                orange.setAmount(changeAmount(orange.getAmount(), addAmount));
                break;
            default:
                throw new Exception("FruitType " + fruitType + " kann nicht verarbeitet werden!");
        }
    }

    private int changeAmount(int amount, int addAmount) throws Exception {
        if (amount + addAmount < 0) {
            throw new Exception("Die Anzahl kann nicht unter 0 sinken!");
        }
        return amount + addAmount;
    }

    public HashMap<FruitType, Integer> getStorageAmounts() {
        HashMap<FruitType, Integer> amounts = new HashMap<>();

        amounts.put(FruitType.Apple, apple.getAmount());
        amounts.put(FruitType.Peach, peach.getAmount());
        amounts.put(FruitType.Orange, orange.getAmount());

        return amounts;
    }

    public HashMap<FruitType, Float> getStorageValues() {
        HashMap<FruitType, Float> values = new HashMap<>();

        values.put(FruitType.Apple, (int) (apple.getAmount() * Apple.UNIT_PRICE * 100) / 100f);
        values.put(FruitType.Peach, (int) (peach.getAmount() * Peach.UNIT_PRICE * 100) / 100f);
        values.put(FruitType.Orange, (int) (orange.getAmount() * Orange.UNIT_PRICE * 100) / 100f);

        return values;
    }

    public float getPriceSum() {
        float sumPrice = 0;
        for (float price : getStorageValues().values()) {
            sumPrice += price;
        }
        return (int) (sumPrice * 100) / 100f;
    }

}
