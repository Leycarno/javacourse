package com.leycarno.controller;

import com.leycarno.model.*;

import java.util.Collection;
import java.util.HashMap;

public class FruitController {

    // Das einzige was noch fehlt, ist eine dynamische Erwieterung dieser Collection
    private HashMap<FruitType, Fruit> fruits = new HashMap<FruitType, Fruit>() {
        {
            put(FruitType.Apple, new Apple());
            put(FruitType.Peach, new Peach());
            put(FruitType.Orange, new Orange());
        }
    };

    public void changeFruitAmount(FruitType fruitType, int addAmount) throws Exception {
        Fruit fruit = fruits.get(fruitType);
        if (fruit == null)
            throw new Exception("FruitType " + fruitType + " kann nicht verarbeitet werden!");
        fruit.setAmount(changeAmount(fruit.getAmount(), addAmount));
    }

    private int changeAmount(int amount, int addAmount) throws Exception {
        if (amount + addAmount < 0) {
            throw new Exception("Die Anzahl kann nicht unter 0 sinken!");
        }
        return amount + addAmount;
    }

    /**
     * es macht keinen Sinn mehr, die values alleine auszugeben, daher Zugriff auf die Obst-Collection
     * @return
     */
    public HashMap<FruitType, Fruit> getFruits() {
        return fruits;
    }

    public HashMap<FruitType, Float> getStorageValues() {
        HashMap<FruitType, Float> values = new HashMap<>();

        for (Fruit fruit : fruits.values()) {
            values.put(fruit.getFruitType(), (int) (fruit.getAmount() * fruit.getUnitPrice() * 100) / 100f);
        }

        return values;
    }

    /**
     * Ein einfaches Beispiel um per Interface die Berechung vom Obst unabhängig zu nutzen
     *
     * @param priceables
     * @return
     */
    public static float getPriceSum(Collection<UnitPriceable> priceables) {
        float sumPrice = 0;
        for (UnitPriceable pa : priceables) {
            sumPrice += pa.getAmount() * pa.getUnitPrice();
        }
        return (int) (sumPrice * 100) / 100f;
    }

}
