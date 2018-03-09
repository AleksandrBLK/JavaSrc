package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> startList = new ArrayList<Integer>();
        ArrayList<Integer> threeList = new ArrayList<Integer>();
        ArrayList<Integer> twoList = new ArrayList<Integer>();
        ArrayList<Integer> anotherList = new ArrayList<Integer>();

        for (int i = 0; i < 20; i++) {
            int number = Integer.parseInt(reader.readLine());
            startList.add(number);
            if (startList.get(i) % 3 == 0 && startList.get(i) % 2 == 0) {
                threeList.add(startList.get(i));
                twoList.add(startList.get(i));
            } else if (startList.get(i) % 3 == 0) {
                threeList.add(startList.get(i));
            } else if (startList.get(i) % 2 == 0) {
                twoList.add(startList.get(i));
            } else {
                anotherList.add(startList.get(i));
            }
        }

        printList(threeList);
        printList(twoList);
        printList(anotherList);

    }


    public static void printList(List<Integer> list) {
        //напишите тут ваш код
        for (int i : list) System.out.println(i);
    }
}

