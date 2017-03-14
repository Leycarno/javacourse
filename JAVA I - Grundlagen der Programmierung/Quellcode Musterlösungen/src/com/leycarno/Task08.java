package com.leycarno;

public class Task08 {

    // it's obvious: int seconds = 30 * 24 * 60 * 60; BUT:

    private final static int SECONDS_PER_MINUTE = 60;
    private final static int MINUTE_PER_HOUR = 60;
    private final static int HOURS_PER_DAY = 24;
    private final static int DAYS_IN_JANUARY = 31;

    public static void main(String[] args) {

        int seconds = DAYS_IN_JANUARY * HOURS_PER_DAY * MINUTE_PER_HOUR * SECONDS_PER_MINUTE;

        System.out.print("There are " + seconds + " seconds in january");
    }
}
