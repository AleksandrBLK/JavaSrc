package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file = reader.readLine();

        try (BufferedReader inStream = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            ArrayList<Integer> list = new ArrayList<Integer>();

            String a;

            while ((a = inStream.readLine()) != null) {
                if ((Integer.parseInt(a)) % 2 == 0) {
                    list.add(Integer.parseInt(String.valueOf(Integer.parseInt(a))));
                }
            }
            Collections.sort(list);

            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        reader.close();


    }
}
