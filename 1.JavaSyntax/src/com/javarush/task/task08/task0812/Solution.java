package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> list = new ArrayList<>();

        int repeatDigit = 1;
        int count = 1;

        for (int i = 0; i < 10; i++) {
            list.add(Integer.parseInt(reader.readLine()));

            if (i > 0 && list.get(i) == list.get(i - 1)) {
                repeatDigit++;
            } else {
                repeatDigit = 1;
            }

            if (count < repeatDigit) {
                count = repeatDigit;
            }
        }

        System.out.println(count);

    }
}