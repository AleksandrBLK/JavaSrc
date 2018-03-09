package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {

        if (args.length > 0) {
            FileInputStream fileInputStream = new FileInputStream(args[0]);
            Map<Integer, Integer> map = new TreeMap<>();

            while (fileInputStream.available() > 0) {
                int d = fileInputStream.read();
                if (map.containsKey(d)) {
                    map.put(d, map.get(d) + 1);
                } else {
                    map.put(d, 1);
                }
            }

            fileInputStream.close();



            for (Map.Entry map1 : map.entrySet()) {
                int i = (int) map1.getKey();
                System.out.println((char) i + " " + map1.getValue());
            }

        }





    }

}

