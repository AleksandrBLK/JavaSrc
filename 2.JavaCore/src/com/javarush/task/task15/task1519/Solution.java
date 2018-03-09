package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = reader.readLine();

            if (str.equals("exit")) {
                break;
            } else if (str.contains(".") && isDouble(str)) {
                double d = Double.parseDouble(str);
                print(d);
            } else if (isShortInteger(str)) {
                int sh = Integer.parseInt(str);
                if (sh >= 128 || sh <= 0) {
                    print((Integer) sh);
                }
                else if (sh < 128 && sh > 0) {
                    print((short) sh);
                }
            } else {
                print(str);
            }
        }


    }

    public static boolean isDouble(String string) {
        try {
            Double.parseDouble(string);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean isShortInteger(String string) {
        try {
            Integer.parseInt(string);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
