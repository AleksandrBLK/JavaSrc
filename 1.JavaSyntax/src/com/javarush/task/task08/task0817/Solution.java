package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();

        map.put("Билык", "Александр");
        map.put("Рыжков", "Василий");
        map.put("Коцюбинский", "Виталий");
        map.put("Шевченко", "Тарас");
        map.put("Порошенка", "Петр");
        map.put("Черновол", "Александр");
        map.put("Филипонов", "Тарас");
        map.put("Колокольчик", "Колюння");
        map.put("Пупкиин", "Василий");
        map.put("Необыкновеный", "Александр");


        return map;

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        //напишите тут ваш код
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            int count = 0;

            for (Map.Entry<String, String> pair2 : copy.entrySet()) {
                if (pair.getValue().equals(pair2.getValue())) {
                    count++;
                    if (count > 1) {
                        removeItemFromMapByValue(map, pair.getValue());
                    }
                }
            }


        }


    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {


    }
}
