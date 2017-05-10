package com.leycarno.geometry;

public class Position {

    private double x, y;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    private void move(double x, double y) {
        this.x += x;
        this.y += y;
    }

}
