/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.javarush.task.task15.task1530;

/**
 * Created by info on 29.05.2017.
 */
public class LatteMaker extends DrinkMaker {
    @Override
    void getRightCup() {
        System.out.println("Берем чашку для латте");
    }

    @Override
    void putIngredient() {
        System.out.println("Делаем кофе");
    }

    @Override
    void pour() {
        System.out.println("Заливаем молоком с пенкой");
    }
}
