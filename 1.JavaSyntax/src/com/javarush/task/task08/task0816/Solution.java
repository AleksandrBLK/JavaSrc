package com.javarush.task.task08.task0816;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Bilyk", new Date("AUGUST 7 1987"));
        map.put("Ostapenko", new Date("JUNE 8 1995"));
        map.put("Korol", new Date("JULY 2 1985"));
        map.put("Karol", new Date("SEPTEMBER 5 1989"));
        map.put("Hrebtova", new Date("NOVEMBER 1 2005"));
        map.put("Ovcharuk", new Date("OCTOBER 4 2007"));
        map.put("Kirilenko", new Date("JANUARY 9 1956"));
        map.put("Poroshenko", new Date("JUNE 4 1980"));
        map.put("Grigorovich", new Date("JUNE 3 1980"));

        return map;

        //напишите тут ваш код
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код

        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry<String, Date> pair = iterator.next();
            int value = pair.getValue().getMonth();

            if (value > 4 && value < 8){
                iterator.remove();
            }
        }



    }

    public static void main(String[] args) {

    }
}
