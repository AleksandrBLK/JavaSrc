package com.javarush.task.task07.task0712;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < 10; i++) {
            String word = reader.readLine();
            list.add(word);
        }

        String minWord = list.get(0);
        String maxWord = list.get(0);
        int min = 0;
        int max = 0;

        for (int i = 0; i < list.size(); i++) {
            if (minWord.length() < list.get(i).length()) {
                minWord = list.get(i);
                min = i;
            }

        }

        for (int i = 0; i < list.size(); i++) {
            if (maxWord.length() > list.get(i).length()) {
                maxWord = list.get(i);
                max = i;
            }
        }


        if (min < max){
            System.out.println(list.get(min));
        } if (max < min){
            System.out.println(list.get(max));
        }

    }
}
