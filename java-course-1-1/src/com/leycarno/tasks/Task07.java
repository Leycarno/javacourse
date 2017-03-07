package com.leycarno.tasks;

import java.util.Scanner;

public class Task07 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int time, hours, result;

        System.out.print("What time is it? ");
        time = scanner.nextInt();
        System.out.print("How many hours are gone? ");
        hours = scanner.nextInt();

        result = (time + hours) % 24;

        System.out.print("In " + hours + " hours is it " + result + " o'clock");

    }

}
