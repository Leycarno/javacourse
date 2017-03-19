package com.leycarno.collections.programms;

import com.leycarno.collections.enums.Day;
import com.leycarno.collections.enums.I18nDay;
import com.leycarno.collections.enums.Planet;
import com.leycarno.collections.views.StaticView;

public class _3_Enums {

    public void run() {
        this.simpleEnumDemo();
        this.extendedEnumDemo();
        this.planetEnumDemo();
    }

    /** ************************************************************
     * simple use of enums
     */
    private void simpleEnumDemo() {

        Day day = Day.MONDAY;

        switch(day) {
            case MONDAY:
                System.out.println(day + " - Los geht’s!");
                break;
            case SATURDAY: case SUNDAY:
                System.out.println(day + " - Leg dich wieder hin…");
                break;
        }

    }

    /** ************************************************************
     * simple use of extended enums
     */
    private void extendedEnumDemo() {

        I18nDay day = I18nDay.SATURDAY;

        switch(day) {
            case MONDAY:
                System.out.println(day.de() + " - Los geht’s!");
                break;
            case SATURDAY: case SUNDAY:
                System.out.println(day.de() + " - Leg dich wieder hin…");
                break;
        }

    }

    /** ************************************************************
     *  Demo for the "Planet" - enum
     *  Origin: https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
     */
    private void planetEnumDemo() {

        System.out.println("Bitte geben Sie ein Gewicht (in kg) ein: ");
        double earthWeight = StaticView.nextIntInput("Bitte eine Ganzzahl angeben!");
        double mass = earthWeight/Planet.EARTH.surfaceGravity();

        for (Planet p : Planet.values())
            System.out.printf("Das gegebene Gewicht ist auf dem Planeten %s: %f%n",
                    p, p.surfaceWeight(mass));

    }
}
