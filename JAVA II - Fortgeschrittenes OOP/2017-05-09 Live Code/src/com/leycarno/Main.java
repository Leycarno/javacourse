package com.leycarno;

import com.leycarno.geometry.Circle;
import com.leycarno.geometry.Position;
import com.leycarno.geometry.Square;
import com.leycarno.geometry.Triangle;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Fläche eines Kreises mit radius 10: ");


        System.out.println(new Circle(new Position(0, 0), 10).calculateArea());

        Scanner scanner = new Scanner(System.in);
        double radius = scanner.nextInt();

        Position p = new Position(0, 0);
        Circle c = new Circle(p, radius);
        double area = c.calculateArea();
        System.out.println(area);



        System.out.println("Fläche eines Quadrats mit Seitenlänge 10: ");
        System.out.println(new Square(new Position(0, 0), 10).calculateArea());

        System.out.println("Fläche eines Dreiecks mit Seitenlängen 2, 3 und 4: ");
        try {
            System.out.println(new Triangle(new Position(0, 0), 2, 3, 4).calculateArea());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Ungültiges Dreiecks mit Seitenlängen 20, 3 und 4: ");
        try {
            System.out.println(new Triangle(new Position(0, 0), 20, 3, 4).calculateArea());
        } catch (Exception e) {
            System.out.println("----- " + e.getMessage() + " -----");
        }
    }
}
