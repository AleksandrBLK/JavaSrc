/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {

        testStrategy(new OurHashMapStorageStrategy(), 10000);

    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> set = new HashSet<>();

        for (String s : strings) {
            set.add(shortener.getId(s));
        }

        return set;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> set = new HashSet<>();

        for (Long s : keys) {
            set.add(shortener.getString(s));
        }

        return set;
    }

    public static void testStrategy(OurHashMapStorageStrategy strategy, long elementsNumber) {
        System.out.println(strategy.getClass().getSimpleName());

        Set<String> test = new HashSet<>();

        for (int i = 0; i < elementsNumber; i++) {
            test.add(Helper.generateRandomString());
        }

        Shortener shortener = new Shortener(strategy);

        Date startGetIds = new Date();
        Set<Long> testSet = getIds(shortener, test);
        Date endGetIds = new Date();
        System.out.println("Время выполнения метода getIds (мс): " + (endGetIds.getTime() - startGetIds.getTime()));

        Date startGetStrings = new Date();
        Set<String> result = getStrings(shortener, testSet);
        Date endGetStrings = new Date();
        System.out.println("Время выполнения метода getStrings(мс): " + (endGetStrings.getTime() - startGetStrings.getTime()));

        if (result.size() == test.size()) {
            System.out.println("Тест пройден.");
        } else {
            System.out.println("Тест не пройден.");
        }
    }
}
