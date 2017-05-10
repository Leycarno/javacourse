package com.leycarno.geometry;

public class Square {

    private Position position;
    private double x;

    public Square(Position position, double x) {
        this.position = position;
        this.x = x;
    }

    public double calculateArea() {
        return this.x * this.x;
    }

}
