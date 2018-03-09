/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(int capacity) {
        map = new HashMap<>(capacity);
    }

    public AmigoSet(Collection<? extends E> collection) {
        map = new HashMap<>(Math.max((int) (collection.size() / .75f) + 1, 16));
        addAll(collection);
    }

    @Override
    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }


    @Override
    public Iterator<E> iterator() {
        Set<E> keySet = map.keySet();
        return keySet.iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public boolean remove(Object o) {
        map.remove(o);
        return super.remove(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Object clone() {
        AmigoSet copy;
        try {
            copy = (AmigoSet) super.clone();
            copy.map = (HashMap) map.clone();
        } catch (Exception e) {
            throw new InternalError(e);
        }

        return copy;
    }

    private void writeObject(ObjectOutputStream oos) throws Exception {
        oos.defaultWriteObject();

        oos.writeInt(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
        oos.writeFloat(HashMapReflectionHelper.callHiddenMethod(map,"loadFactor"));
        oos.writeInt(map.size());

        for (E e : map.keySet()) oos.writeObject(e);



    }
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();

        int capacity = ois.readInt();
        float loadFactor = ois.readFloat();
        int size = ois.readInt();

        map = new HashMap<>(capacity,loadFactor);

        for (int i = 0; i < size; i++)
        {
            E e = (E) ois.readObject();
            map.put(e,PRESENT);
        }

    }
}
