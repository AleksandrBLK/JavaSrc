package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));

        String str1 = reader1.readLine();

        reader1.close();

        BufferedReader reader = new BufferedReader(new FileReader(str1));

        while (reader.ready()) {
            String str = reader.readLine();

            String [] str2 = str.split(" ");
            int count = 0;

            for (int i = 0; i < str2.length; i++){
                for (int j = 0; j < words.size(); j++){
                    if (str2[i].trim().equals(words.get(j))){
                        count++;
                    }
                }
            }

            if (count == 2){
                System.out.println(str);
            }
        }

        reader.close();
    }


}
