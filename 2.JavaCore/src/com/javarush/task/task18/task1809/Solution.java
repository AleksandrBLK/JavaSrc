package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1Sourth = reader.readLine();
        String file2Sourth = reader.readLine();

        reader.close();

        FileInputStream inputStream = new FileInputStream(file1Sourth);
        ArrayList<Integer> list = new ArrayList<>();

        while (inputStream.available() > 0) {
            int data = inputStream.read();
            list.add(data);
        }

        inputStream.close();

        Collections.reverse(list);

        FileOutputStream outputStream = new FileOutputStream(file2Sourth);


        for (int i : list) {
            outputStream.write(i);
        }

        outputStream.close();

    }
}
