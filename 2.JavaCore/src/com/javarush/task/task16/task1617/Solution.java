package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int countSeconds = 4;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        //add your code here - добавь код тут
        Thread.sleep(3500);
        clock.interrupt();
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        //add your code here - добавь код тут

        public void run() {

            try {
                while (!currentThread().isInterrupted()) {
                    System.out.print(countSeconds + " ");
                    Thread.sleep(1000);

                    if (countSeconds == 1){
                        System.out.print("Марш!");
                        break;
                    }

                    countSeconds--;

                }
            } catch (InterruptedException e) {
                System.out.print("Прервано!");
            }
        }

    }
}

