package com.javarush.task.task16.task1623;

/* 
Рекурсивное создание нитей
*/

import java.lang.invoke.MethodType;

public class Solution {
    static int count = 15;
    static volatile int countCreatedThreads;

    public static void main(String[] args) {

        new GenerateThread();
    }

    public static class GenerateThread extends Thread {

        public GenerateThread() {
            super(String.valueOf(++countCreatedThreads));
            start();
        }

        public String toString() {
            return getName() + " created";
        }

        @Override
        public void run() {
            if (countCreatedThreads < Solution.count) {
                GenerateThread generateThread = new GenerateThread();
                System.out.println(generateThread);
            }
        }
    }
}
