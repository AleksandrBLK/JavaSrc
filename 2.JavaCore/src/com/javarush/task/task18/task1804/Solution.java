package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());


        HashMap<Integer, Integer> map = new HashMap<>();


        while (inputStream.available() > 0) {
            int d = inputStream.read();
            if (map.containsKey(d)) {
                map.put(d, map.get(d) + 1);
            } else {
                map.put(d, 1);
            }
        }

        int min = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (Map.Entry entry : map.entrySet()) {
            list.add((int) entry.getValue());
        }



        for (int i = 0; i < list.size(); i++){
            if (list.get(0) > list.get(i)){
                min = list.get(i);
            }
        }

        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue().equals(min)) {
                System.out.print(entry.getKey() + " ");
            }
        }

        reader.close();
        inputStream.close();
    }
}
