package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = new int[20];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(reader.readLine());
        }

        int[] numbers1 = new int[10];
        int[] numbers2 = new int[10];

        for (int i = 0; i < numbers1.length; i ++){
            numbers1 [i] = numbers [i];
        }

        for (int i = 0; i < numbers2.length; i++ ){
            numbers2 [i] = numbers [i + 10];
            System.out.println(numbers2[i]);
        }
    }
}
