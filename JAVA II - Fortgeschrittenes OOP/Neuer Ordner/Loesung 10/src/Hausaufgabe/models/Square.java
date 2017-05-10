package Hausaufgabe.models;


public class Square {

    private double side;
    private Position pos;

    public Square(Position pos, double side) {
        this.pos = pos;
        this.side = side;
    }

    public double calculateArea() {
        return (float) this.side * this.side;
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                ", pos=" + pos +
                '}';
    }
}
