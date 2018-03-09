package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        //напишите тут ваш код
        int[] mas = new int[20];

        for (int i = 0; i < 20; i++) {
            mas[i] = Integer.parseInt(reader.readLine());
        }
        int maximum = mas[0];
        int minimum = mas[0];
        for (int i = 0; i < 20; i++) {
            maximum = mas[i] > maximum ? mas[i] : maximum;
            minimum = mas[i] <= minimum ? mas[i] : minimum;
        }
        System.out.print(maximum + " " + minimum);


    }
}
