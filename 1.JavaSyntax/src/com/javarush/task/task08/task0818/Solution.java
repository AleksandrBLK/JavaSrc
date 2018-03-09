package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<>();

        map.put("Bilyk", 700);
        map.put("Pavlov", 100);
        map.put("Vasilyev", 1200);
        map.put("Babaeva", 200);
        map.put("Pupkin", 400);
        map.put("Lyubimova", 700);
        map.put("Vitalyev", 150);
        map.put("Borisov", 350);
        map.put("Bolyk", 700);
        map.put("Balyk", 850);

        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        HashMap<String, Integer> copyMap = new HashMap<String, Integer>(map);

        for (Map.Entry<String, Integer> pair : copyMap.entrySet()) {
            if (pair.getValue() < 500) {
                map.remove(pair.getKey());
            }

        }

    }


    public static void main(String[] args) {

    }
}