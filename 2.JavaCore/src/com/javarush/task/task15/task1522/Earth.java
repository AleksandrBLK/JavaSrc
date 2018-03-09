/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.javarush.task.task15.task1522;

/**
 * Created by info on 28.05.2017.
 */
public class Earth implements Planet {
    private static Earth instance;

    private Earth() {
    }

    public static Earth getInstance() {
        if (instance == null){
            instance = new Earth();
        }
        return instance;
    }
}
