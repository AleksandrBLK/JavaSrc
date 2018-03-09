/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever {
    private LRUCache cash;
    private OriginalRetriever originalRetriever;

    public CachingProxyRetriever(Storage storage) {
        originalRetriever = new OriginalRetriever(storage);
        cash = new LRUCache(10);
    }

    @Override
    public Object retrieve(long id) {
        Object result = cash.find(id);
        if (result != null) {
            return result;
        } else {
            Object result1 = originalRetriever.retrieve(id);
            cash.set(id, result1);
            return result1;
        }
    }
}
