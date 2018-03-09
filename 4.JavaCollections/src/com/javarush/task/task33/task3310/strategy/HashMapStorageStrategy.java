/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.javarush.task.task33.task3310.strategy;

import java.util.HashMap;
import java.util.Map;

public class HashMapStorageStrategy implements StorageStrategy {
    private HashMap<Long, String> data = new HashMap<>();

    @Override
    public boolean containsKey(Long key) {
        return data.containsKey(key);
    }

    @Override
    public boolean containsValue(String value) {
        return data.containsValue(value);
    }

    @Override
    public void put(Long key, String value) {
        data.put(key, value);
    }

    @Override
    public Long getKey(String value) {
        for (Map.Entry entry: data.entrySet()){
            if (value.equals(entry.getValue())){
                return (Long) entry.getKey();
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        return data.get(key);
    }
}
