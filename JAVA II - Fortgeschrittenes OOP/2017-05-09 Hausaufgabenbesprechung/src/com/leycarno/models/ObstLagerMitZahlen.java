package com.leycarno.models;

import java.util.HashMap;
import java.util.Map;

public class ObstLagerMitZahlen {

    private HashMap<Obst, Integer> obst = new HashMap<>();

    public void ObstHinzufügen(Obst obst, Integer anzahl) {
        if (this.obst.containsKey(obst))
            anzahl += this.obst.get(obst);
        this.obst.put(obst, anzahl);
    }

    public void ausgeben() {
        if (this.obst.size() <= 0) {
            System.out.println("Lager ist leer");
            return;
        }

        // die beiden folgenden Ausdrücke sind das selbe

        for (Obst x : this.obst.keySet())
            System.out.println(x + " " + this.obst.get(x));

        for (Map.Entry x : this.obst.entrySet())
            System.out.println(x.getKey() + " " + x.getValue());

    }

}
