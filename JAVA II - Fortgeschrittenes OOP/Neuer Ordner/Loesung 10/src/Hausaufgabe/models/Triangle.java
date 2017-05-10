package Hausaufgabe.models;


public class Triangle {

    private double a;
    private double b;
    private double c;
    private Position pos;

    public Triangle(Position pos, double a, double b, double c) {

        boolean checked = false;

        if ((a + b) > c && ((a + c) > b && (b + c) > a)) checked = true; else checked = false;

        if (!checked) {
            System.out.println("Zwei Seiten zusammen müssen länger sein als die dritte!");
            System.exit(0);
        } else {
            this.pos = pos;
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public double calculateArea() {
        return (float) Math.sqrt((this.a + this.b + this.c) * (this.a + this.b - this.c) * (this.b + this.c - this.a) * (this.c + this.a - this.b)) * 0.25;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", pos=" + pos +
                '}';
    }
}
