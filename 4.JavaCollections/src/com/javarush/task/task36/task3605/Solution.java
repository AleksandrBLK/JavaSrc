package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        if (args[0] != null) {
            FileReader reader = new FileReader(args[0]);
            Set<Character> set = new TreeSet<>();

            while (reader.ready()) {
                char data = Character.toLowerCase((char) reader.read());
                if (Character.isLetter(data)) {
                    set.add(data);
                }
            }

            reader.close();

            Iterator<Character> iter = set.iterator();
            int count = 0;

            while (iter.hasNext()) {
                System.out.print(iter.next().toString());
                count++;
                if (count >= 5) {
                    break;
                }
            }

        }
    }
}
