package com.leycarno.geometry;

public class Circle {

    private Position position;
    private double radius;

    public Circle(Position position, double radius) {
        this.position = position;
        this.radius = radius;
    }

    public Circle(double x, double y, double radius) {
        this.position = new Position(x, y);
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * this.radius * this.radius;
    }

}
