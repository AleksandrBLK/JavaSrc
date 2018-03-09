package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код

        HashMap<String, String> map = new HashMap<String, String>();

        map.put("Билык", "Александр");
        map.put("Рыжков", "Василий");
        map.put("Коцюбинский", "Виталий");
        map.put("Билык", "Тарас");
        map.put("Билык", "Петр");
        map.put("Черновол", "Александр");
        map.put("Филипонов", "Тарас");
        map.put("Колокольчик", "Колюння");
        map.put("Пупкиин", "Василий");
        map.put("Необыкновеный", "Александр");

        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
