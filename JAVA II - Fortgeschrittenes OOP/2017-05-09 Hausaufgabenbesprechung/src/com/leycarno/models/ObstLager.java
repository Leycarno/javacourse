package com.leycarno.models;

public class ObstLager {

    private Obst[] obst;

    public void ObstHinzufuegen(Obst obst) {
        // if (this.obst.length <= 0) // Fehler weil Objekt noch nicht existiert

        if (this.obst == null)
            this.obst = new Obst[1];
        else {
            Obst[] neuArray = new Obst[this.obst.length + 1];
            for (int i = 0; i < this.obst.length; i++) {
                neuArray[i] = this.obst[i];
            }
            this.obst = neuArray;
        }

        this.obst[this.obst.length - 1] = obst;
    }


    public void ausgeben() {
        if (this.obst == null) {
            System.out.println("Lager ist leer");
            return;
        }

        for (Obst x : this.obst)
            System.out.println(x);
    }

}
