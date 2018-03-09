package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length > 0){
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));

            while (reader.ready()){
                String str = reader.readLine();

                String[] str1 = str.split(" ");

                String pattern = "[0-9]";

                Pattern r = Pattern.compile(pattern);

                for (String str2 : str1){
                    Matcher m = r.matcher(str2);
                    if (m.find()){
                        writer.write(str2 + " ");
                    }
                }
            }

            reader.close();
            writer.close();
        }
    }
}
