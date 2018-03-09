/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.StorageStrategy;

public class Shortener {
    private Long lastId = new Long(0);
    private StorageStrategy storageStrategy;

    public Shortener(StorageStrategy storageStrategy) {
        this.storageStrategy = storageStrategy;
    }

    synchronized public Long getId(String string) {
        if (storageStrategy.containsValue(string)) {
            return storageStrategy.getKey(string);
        }
        if (!storageStrategy.containsValue(string)) {
            lastId++;
            storageStrategy.put(lastId, string);
        }
        return lastId;
    }

    synchronized public String getString(Long id) {

        return storageStrategy.getValue(id);
    }

}
