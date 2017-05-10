package Hausaufgabe;

import Hausaufgabe.models.Circle;
import Hausaufgabe.models.Position;
import Hausaufgabe.models.Square;
import Hausaufgabe.models.Triangle;

public class Main {


    public static void main(String[] args) {

        Position pos = new Position(1,10);
        Square square = new Square(pos,5);
        Circle circle= new Circle(pos, 10);
        Triangle triangle = new Triangle(pos, 4,2,3);

        System.out.println(pos);
        System.out.println(square);
        System.out.println(circle);
        System.out.println(triangle);


        pos.move(1,-11);
        System.out.println(pos);

        System.out.printf("\n%.2f", square.calculateArea());
        System.out.printf("\n%.2f", circle.calculateArea());
        System.out.printf("\n%.2f", triangle.calculateArea());
    }
}
