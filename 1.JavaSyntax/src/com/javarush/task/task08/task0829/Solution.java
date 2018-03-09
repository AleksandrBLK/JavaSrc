package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> family = new HashMap<String, String>();

        while (true) {
            String city = reader.readLine();
            if (city.isEmpty()) break;
            String secondName = reader.readLine();


            family.put(city, secondName);

        }

        String city1 = reader.readLine();

        for (Map.Entry<String, String> pair : family.entrySet()){
            String value = pair.getKey();
            if (value.equals(city1)){
                System.out.println(pair.getValue());
            }
        }


    }
}
