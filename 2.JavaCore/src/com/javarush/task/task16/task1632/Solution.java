package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);


    static {
        Thread t1 = new thread1();
        threads.add(t1);
        Thread t2 = new thread2();
        threads.add(t2);
        Thread t3 = new thread3();
        threads.add(t3);
        Thread t4 = new thread4();
        threads.add(t4);
        Thread t5 = new thread5();
        threads.add(t5);
    }

    public static void main(String[] args) {
    }

    public static class thread5 extends Thread {

        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            int sum = 0;

            while (true) {
                try {
                    String str = reader.readLine();
                    if (str.equals("N")) {
                        break;
                    } else {
                        int a = Integer.parseInt(str);
                        sum = sum + a;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(sum);

            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static class thread4 extends Thread implements Message {
        @Override
        public void showWarning() {
            if (isAlive ()){
                this.interrupt();
            }

        }
    }


    public static class thread3 extends Thread {

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static class thread2 extends Thread {

        @Override
        public void run() {
            System.out.println("InterruptedException");
        }
    }

    public static class thread1 extends Thread {
        @Override
        public void run() {
            while (true) {
            }
        }
    }
}
