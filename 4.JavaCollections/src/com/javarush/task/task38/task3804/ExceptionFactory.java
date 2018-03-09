/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.javarush.task.task38.task3804;

public class ExceptionFactory {
    public static Throwable getException(Enum type) {
        if (type == null)
            return new IllegalArgumentException();

        String message = type.name().charAt(0) + type.name().substring(1).toLowerCase().replace("_", " ");

        if (type instanceof ExceptionApplicationMessage)
            return new Exception(message);

        if (type instanceof ExceptionDBMessage)
            return new RuntimeException(message);

        if (type instanceof ExceptionUserMessage)
            return new Error(message);

        return new IllegalArgumentException();
    }
}
