/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.javarush.task.task33.task3310.tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {


    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
        Date startGetIds = new Date();

        for (String s : strings) {
            ids.add(shortener.getId(s));
        }

        Date endGetIds = new Date();

        return (endGetIds.getTime() - startGetIds.getTime());
    }


    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings){
        Date startGetString = new Date();

        for (Long s : ids){
            strings.add(shortener.getString(s));
        }

        Date endGetString = new Date();

        return (endGetString.getTime() - startGetString.getTime());
    }


    @Test
    public void testHashMapStorage(){
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());

        Set<String> origStrings = new HashSet<>();

        for (int i = 0; i < 10000; i++) {
            origStrings.add(Helper.generateRandomString());
        }

        Set<Long> origIds1 = new HashSet<>();
        Set<Long> origIds2 = new HashSet<>();

        Long time1 = getTimeForGettingIds(shortener1, origStrings, origIds1);
        Long time2 = getTimeForGettingIds(shortener2, origStrings, origIds2);

        Assert.assertTrue(time1 > time2);


        Set<String> origStrings1 = new HashSet<>();
        Set<String> origStrings2 = new HashSet<>();
        Long time3 = getTimeForGettingStrings(shortener1, origIds1, origStrings1);
        Long time4 = getTimeForGettingStrings(shortener2, origIds2, origStrings2);

        Assert.assertEquals(time3, time4, 30);
    }
}
