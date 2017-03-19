package com.leycarno.collections;

import com.leycarno.collections.programms.*;
import com.leycarno.collections.views.StaticView;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welches Programm starten?");
        System.out.println("1. Beispiele - Arrays");
        System.out.println("2. Beispiele - Collections");
        System.out.println("3. Beispiele - Enums");
        System.out.println("4. Auto tanken - MVC");
        System.out.println("Bitte die Zahl eingeben: ");

        int option = StaticView.nextIntInput("Bitte eine Zahl für das gewünschte Programm eingeben!");

        switch (option) {
            case 1:
                _1_Arrays arrays = new _1_Arrays();
                arrays.run();
                break;
            case 2:
                _2_Collections collections = new _2_Collections();
                collections.run();
                break;
            case 3:
                _3_Enums enums = new _3_Enums();
                enums.run();
                break;
            case 4:
                _4_RefuelCarMvc refuelCar = new _4_RefuelCarMvc();
                refuelCar.run();
                break;
            default:
                System.err.println("Unbekanntes Programm!");
        }

    }
}
