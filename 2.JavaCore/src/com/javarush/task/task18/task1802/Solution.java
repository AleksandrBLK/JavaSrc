package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        reader.close();

        ArrayList<Integer> list = new ArrayList<>();
        int min = 0;

        while (inputStream.available() > 0){
            int data = inputStream.read();
            list.add(data);
            
        }
        
        for (int i = 0; i < list.size(); i++){
            if (list.get(0) > list.get(i)){
                min = list.get(i);
            }
        }

        System.out.println(min);

        inputStream.close();

    }
}
