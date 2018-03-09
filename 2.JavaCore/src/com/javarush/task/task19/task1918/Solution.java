package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String fileSourth = reader.readLine();

            reader.close();

            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileSourth));

            Pattern p = Pattern.compile("<" + args[0]);
            Pattern p1 = Pattern.compile("</" + args[0] + ">");
            ArrayList<Integer> startIndex = new ArrayList<>();
            ArrayList<Integer> endIndex = new ArrayList<>();
            String str = "";


            while (bufferedReader.ready()) {
                String str1 = bufferedReader.readLine();
                str += str1;
            }
            bufferedReader.close();

            Matcher m = p.matcher(str);
            Matcher m1 = p1.matcher(str);

            while (m.find()) {
                startIndex.add(m.start());
            }

            while (m1.find()) {
                endIndex.add(m1.end());
            }



            for (int i = 0; i < startIndex.size(); i++) {
                String str1 = str.substring(startIndex.get(i), endIndex.get(i));
                int count = 0;
                int count1 = 0;
                Matcher m2 = p.matcher(str1);
                while (m2.find()) {
                    count++;
                }
                Matcher m3 = p1.matcher(str1);
                while (m3.find()) {
                    count1++;
                }
                if (count > 1) {
                    str1 = str.substring(startIndex.get(i), endIndex.get(i + 1));
                }
                if (count1 > 1) {
                    str1 = str.substring(startIndex.get(i), endIndex.get(i - 1));
                }

                System.out.println(str1);
            }


        }
    }
}
