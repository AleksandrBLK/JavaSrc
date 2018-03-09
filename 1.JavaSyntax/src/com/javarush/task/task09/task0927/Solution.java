package com.javarush.task.task09.task0927;

import java.util.*;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //напишите тут ваш код
        HashMap<String, Cat> map = new HashMap<>();

        map.put("Мурзик", new Cat("Мурзик"));
        map.put("Васька", new Cat("Васька"));
        map.put("Рижык", new Cat("Рижык"));
        map.put("Котэ", new Cat("Котэ"));
        map.put("Грымзик", new Cat("Грымзик"));
        map.put("Снежок", new Cat("Снежок"));
        map.put("Барсик", new Cat("Барсик"));
        map.put("Матроскин", new Cat("Матроскин"));
        map.put("Дымка", new Cat("Дымка"));
        map.put("Цезарь", new Cat("Цезарь"));


        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //напишите тут ваш код
        HashSet<Cat> list = new HashSet<>();
        list.addAll(map.values());

        return list;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
