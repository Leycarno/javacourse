package com.leycarno;

public class Task09 {

    public static void main(String[] args) {

        for (int x = 1; x <= 10; x++) {
            String xStr = x == 10 ? "" + x : " " + x;

            for (int y = 1; y <= 10; y++) {
                String yStr = y == 10 ? "" + y : " " + y;

                int result = x*y;
                String resultStr;
                if (result == 100) {
                    resultStr = "" + result;
                } else if (result >= 10) {
                    resultStr = " " + result;
                } else { // result < 10
                    resultStr = "  " + result;
                }

                System.out.println(xStr + " * " + yStr + " = " + resultStr);
            }
            System.out.println();
        }

    }

}
