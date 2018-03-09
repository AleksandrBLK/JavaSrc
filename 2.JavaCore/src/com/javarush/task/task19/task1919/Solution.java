package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {

        if (args[0].length() > 0) {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));

            String str = "";

            while (reader.ready()) {
                str += reader.readLine() + " ";
            }

            reader.close();

            String[] arr = str.split(" ");


            Map<String, Double> map = new TreeMap<>();

            for (int i = 0; i < arr.length; i += 2) {
                if (map.containsKey(arr[i])) {
                    Double d = map.get(arr[i]) + Double.parseDouble(arr[i + 1]);
                    map.remove(arr[i]);
                    map.put(arr[i], d);
                } else {
                    map.put(arr[i], Double.parseDouble(arr[i + 1]));
                }

            }

            for (Map.Entry map1 : map.entrySet()) {
                System.out.println(map1.getKey() + " " + map1.getValue());
            }


        }
    }
}
