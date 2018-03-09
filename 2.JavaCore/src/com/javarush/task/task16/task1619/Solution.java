package com.javarush.task.task16.task1619;

/* 
А без interrupt слабо?
*/

import static java.lang.Thread.currentThread;

public class Solution {
    static boolean end = true;
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new TestThread());
        t.start();
        ourInterruptMethod();
        Thread.sleep(3000);

    }

    public static void ourInterruptMethod() {
        end = false;

    }

    public static class TestThread implements Runnable {



        public void run() {
            while (end) {
                try {
                        System.out.println("he-he");
                        Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
