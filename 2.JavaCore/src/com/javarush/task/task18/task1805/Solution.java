package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());

        ArrayList<Integer> list = new ArrayList<Integer>();


        while (inputStream.available() > 0) {
            int d = inputStream.read();
            if (list.contains(d)) {

            } else {
                list.add(d);
            }
        }



        Collections.sort(list);

        for (int i : list){
            System.out.print(i + " ");
        }

        reader.close();
        inputStream.close();
    }
}
