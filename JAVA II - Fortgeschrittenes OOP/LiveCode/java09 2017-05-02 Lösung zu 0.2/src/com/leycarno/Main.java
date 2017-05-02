package com.leycarno;

import com.leycarno.models.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Apple apple = new Apple();
        Apple apple2 = new Apple("Apfel");
        Peach peach = new Peach();
        showPrice(apple);
        showPrice(peach);

        apple.getUnitPrice();

        ArrayList<Fruit> list = new ArrayList<>();
        list.add(new Apple());
        list.add(new Peach());
        list.add(new Orange());

         // Anzeige von Float und Double ohne Fehler
        rundungsKorrigierung();
    }

//    public static void showPrice(Fruit fruit) {
//        System.out.println(fruit.getUnitPrice());
//    }

    public static void showPrice(Priceable p) {
        System.out.println(p.getUnitPrice());
    }










    private static void rundungsKorrigierung() {
        float f = 0.0987654321f;
        float falschGerundet = 23.490001f;
        double mehrNachkommastellen = 23.49000000000001f;

        System.out.println("Zahl: " + f);
        // %n = das selbe wir \n also nächste Zeile
        System.out.printf("Zahl: %f%n", f); // voreingestellt 6 Nachkommstellen
        System.out.printf("Zahl: %.2f%n", f); // Beschrönken auf 2 Nachkommastellen

        System.out.println("Zahl: " + falschGerundet);
        System.out.printf("Zahl: %.2f%n", falschGerundet);
        System.out.println("Zahl: " + mehrNachkommastellen);
        System.out.printf("Zahl: %.2f%n", mehrNachkommastellen);
    }

}
