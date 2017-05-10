package com.VHS.models;

/**
 * Created by elenanakostenko on 09.05.17.
 */
public class Obstlager {

    private Obst[] obst;

    public void ObstHinzufuegen(Obst obst) {
        if (this.obst == null) {
            this.obst = new Obst[1];
        } else {
            Obst[] neuArray = new Obst[this.obst.length + 1];
            for (int i = 0; i < this.obst.length; i++) {
                neuArray[i] = this.obst[i];
            }

        }
        this.obst[this.obst.length - 1] = obst;
    }

    public void ausgeben() {
        if (this.obst == null){
            System.out.println("lager ist leer");
            return;
        }

        for (Obst x: this.obst)
        {System.out.println(x);

        }
    }
}
