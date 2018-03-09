/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.javarush.task.task14.task1417;

/**
 * Created by info on 27.05.2017.
 */
public class Ruble extends Money {

    public Ruble(double amount) {
        super(amount);
    }

    @Override
    public double getAmount() {
        return super.getAmount();
    }


    @Override
    public String getCurrencyName() {
        return "RUB";
    }
}
