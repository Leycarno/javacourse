package Hausaufgabe.models;

/**
 * Created by elenanakostenko on 09.05.17.
 */
public class Position {
    private double x;
    private double y;

    public void move (double x, double y) {
        this.x = this.x + x;
        this.y = this.y + y;
    }

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
