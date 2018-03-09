package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;

/* 
Самая длинная строка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        int max = 0;

        for (int i = 0; i < 5; i++) {
            String word = reader.readLine();
            list.add(word);
        }


        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() > max) {
                max = list.get(i).length();
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == max) {
                System.out.println(list.get(i));
            }
        }


    }
}
