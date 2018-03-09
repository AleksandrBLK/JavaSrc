package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {

        if (args.length > 0) {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));

            ArrayList<String> list = new ArrayList<>();

            while (reader.ready()) {
                String[] str = reader.readLine().split(" ");

                for (int i = 0; i < str.length; i++) {
                    if (str[i].length() > 6) {
                        str[i] += ",";
                        list.add(str[i]);
                    }
                }
            }

            reader.close();

            String str = list.get(list.size() - 1).substring(0, list.get(list.size() - 1).length() - 1);
            list.set(list.size() - 1, str);


            for (String str1 : list) {
                writer.write(str1);
            }
            writer.close();
        }

    }
}
