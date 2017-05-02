package com.leycarno.controllers;

import com.leycarno.models.Apple;
import com.leycarno.models.FruitType;
import com.leycarno.models.Orange;
import com.leycarno.models.Peach;

import java.util.HashMap;

public class FruitController {

    static Apple apple = new Apple();
    static Peach peach = new Peach();
    static Orange orange = new Orange();

    /**
     * So würden wir die "Message" einer Exception irgendwann verwenden
     */
    private void demo() {
        try {
            changeAmount(FruitType.APPLE, 10);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public HashMap<FruitType, Float> getPrices() {
        HashMap<FruitType, Float> result = new HashMap<>();
        result.put(FruitType.APPLE, Apple.UNIT_PRICE);
        result.put(FruitType.PEACH, Peach.UNIT_PRICE);
        result.put(FruitType.ORANGE, Orange.UNIT_PRICE);
        return result;
    }

    public HashMap<FruitType, Integer> getAmounts() {
        HashMap<FruitType, Integer> result = new HashMap<>();
        result.put(FruitType.APPLE, apple.getAmount());
        result.put(FruitType.PEACH, peach.getAmount());
        result.put(FruitType.ORANGE, orange.getAmount());
        return result;
    }

    public HashMap<FruitType, Float> getStorage() {
        HashMap<FruitType, Float> result = new HashMap<>();
        result.put(FruitType.APPLE, apple.getAmount() * Apple.UNIT_PRICE);
        result.put(FruitType.PEACH, peach.getAmount() * Peach.UNIT_PRICE);
        result.put(FruitType.ORANGE, orange.getAmount() * Orange.UNIT_PRICE);
        return result;
    }

    public float getStorageSum() {
        float result = 0;
        for (float f : getStorage().values()) {
            result += f;
        }
        return result;
    }

    public void changeAmount(FruitType type, int changeAmount) throws Exception {
        switch (type) {
            case APPLE:
                apple.setAmount(getAddAmount(apple.getAmount(), changeAmount) + apple.getAmount());
                break;
            case PEACH:
                peach.setAmount(getAddAmount(peach.getAmount(), changeAmount) + peach.getAmount());
                break;
            case ORANGE:
                orange.setAmount(getAddAmount(orange.getAmount(), changeAmount) + orange.getAmount());
                break;
        }
    }

    public static int getAddAmount(int amount, int change) throws Exception {
        if (amount + change < 0) {
            throw new Exception("Die Anzahl kann nicht <0 sein");
            //System.out.println("Die Anzahl kann nicht <0 sein");
            //return 0; // oder wieder rekursiv
        }
        return change;
    }



}
