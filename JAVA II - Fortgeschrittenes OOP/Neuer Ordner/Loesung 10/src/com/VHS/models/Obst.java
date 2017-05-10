package com.VHS.models;

/**
 * Created by elenanakostenko on 09.05.17.
 */
public abstract class Obst {
    protected String name;
    protected String farbe;


    public String getName() {
        return this.name;
    }

    public String getFarbe() {
        return this.farbe;
    }

    @Override
    public String toString() {
        return this.name + " " + this.farbe;
    }
}
