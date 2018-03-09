/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.javarush.task.task33.task3310.strategy;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

public class Entry implements Serializable {
    Long key;
    String value;
    Entry next;
    int hash;

    public Entry(int hash, Long key, String value, Entry next) {
        this.key = key;
        this.value = value;
        this.next = next;
        this.hash = hash;
    }

    public Long getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return (key == null ? 0 : key.hashCode()) ^ (value == null ? 0 : value.hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Entry))
            return false;

        Long k1 = getKey();
        Long k2 = ((Entry) o).getKey();
        String v1 = getValue();
        String v2 = ((Entry) o).getValue();
        if (k1 == k2 || (k1 != null && k1.equals(k2))) {
            if (v1 == v2 || (v1 != null && v1.equals(v2))) {
                return true;
            }
        }

        return false;
    }

    public String toString() {
        return key + "=" + value;
    }
}
