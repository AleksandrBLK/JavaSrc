package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    public static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) throws InterruptedException {

        Horse horse = new Horse("Маруся", 3, 0);
        Horse horse1 = new Horse("Павлуша", 3, 0);
        Horse horse2 = new Horse("Котозавр", 3, 0);

        List<Horse> horses = new ArrayList<Horse>();
        horses.add(horse1);
        horses.add(horse2);
        horses.add(horse);
        game = new Hippodrome(horses);
        game.run();
        game.printWinner();

    }

    public void run() throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        double max = 0;
        int resultIndex = 0;
        for (int i = 0; i < horses.size(); i++) {
            if (horses.get(i).getDistance() > max){
                max = horses.get(i).getDistance();
                resultIndex = i;
            }
        }

        return horses.get(resultIndex);
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }


}
