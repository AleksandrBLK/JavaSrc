package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String str = reader.readLine();
            String str1 = reader.readLine();

            reader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
            while ((str = reader.readLine()) != null) {
                allLines.add(str);
            }

            reader = new BufferedReader(new InputStreamReader(new FileInputStream(str1)));
            while ((str1 = reader.readLine()) != null) {
                forRemoveLines.add(str1);
            }

            reader.close();

            Solution e = new Solution();

            e.joinData();

        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }


    }

    public void joinData() throws CorruptedDataException {

        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }


    }
}
