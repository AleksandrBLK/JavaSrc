package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код

        HashMap<String, String> map = new HashMap<>();

        map.put("Билык", "Александр");
        map.put("Рыжков", "Василий");
        map.put("Коцюбинский", "Виталий");
        map.put("Шевченко", "Тарас");
        map.put("Порошенко", "Петр");
        map.put("Черновол", "Александр");
        map.put("Филипонов", "Тарас");
        map.put("Колокольчик", "Колюння");
        map.put("Пупкиин", "Василий");
        map.put("Необыкновеный", "Александр");

        return map;


    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код

        int count = 0;

        for (HashMap.Entry pair : map.entrySet()){
            if (pair.getValue().equals(name)){
                count++;
            }
        }

        return count;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        //напишите тут ваш код
        int count1 = 0;

        for (HashMap.Entry pair : map.entrySet()){
            if (pair.getKey().equals(lastName)){
                count1++;
            }
        }

        return count1;

    }

    public static void main(String[] args) {

    }
}
