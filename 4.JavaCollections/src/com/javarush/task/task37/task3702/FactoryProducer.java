/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.javarush.task.task37.task3702;

import com.javarush.task.task37.task3702.female.FemaleFactory;
import com.javarush.task.task37.task3702.male.MaleFactory;

public class FactoryProducer {
    public static enum HumanFactoryType {
        MALE, FEMALE
    }

    public static AbstractFactory getFactory(HumanFactoryType humanFactoryType) {
        if (humanFactoryType == HumanFactoryType.FEMALE) {
            return new FemaleFactory();
        }
        if (humanFactoryType == HumanFactoryType.MALE) {
            return new MaleFactory();
        }
        return null;
    }
}
