package com.javarush.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> words = new ArrayList<String>();
        words.add("мама");
        words.add("мыла");
        words.add("раму");

        for (int i = 1; i < words.size() + 1; i = i + 2) {
            words.add(i, "именно");
        }

        for (int i = 0; i < words.size(); i++) {
            System.out.println(words.get(i));
        }
    }
}
