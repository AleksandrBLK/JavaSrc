package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем Singleton pattern
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут
    static {
        try {
            readKeyFromConsoleAndInitPlanet();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readKeyFromConsoleAndInitPlanet() throws IOException {
        // implement step #5 here - реализуйте задание №5 тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = reader.readLine();
            if (str.equals(Planet.EARTH)) {
                thePlanet = Earth.getInstance();
                break;
            } else if (str.equals(Planet.MOON)) {
                thePlanet = Moon.getInstance();
                break;
            } else if (str.equals(Planet.SUN)) {
                thePlanet = Sun.getInstance();
                break;
            } else {
                thePlanet = null;
                break;
            }
        }
    }
}
