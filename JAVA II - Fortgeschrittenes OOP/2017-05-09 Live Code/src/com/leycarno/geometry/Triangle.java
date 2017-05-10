package com.leycarno.geometry;

public class Triangle {

    private Position position;
    private double a, b, c;

    public Triangle(Position position, double a, double b, double c) {
        this.position = position;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double calculateArea() throws Exception {
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new Exception("Das ist kein Dreieck!");
        }
        return Math.sqrt((a + b + c) * (a + b - c) * (b + c - a) * (c + a - b)) / 4;

    }

}
