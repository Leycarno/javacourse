package Hausaufgabe.models;


import Hausaufgabe.Main;

public class Circle  {

    private double Radius;
    private Position pos;

    public Circle(Position pos, double radius) {
        this.pos = pos;
        this.Radius = radius;
    }

    public double calculateArea() {
        return (float) Math.PI * this.Radius * this.Radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "Radius=" + Radius +
                ", pos=" + pos +
                '}';
    }
}
