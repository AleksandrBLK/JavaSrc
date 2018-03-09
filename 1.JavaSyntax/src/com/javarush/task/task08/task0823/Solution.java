package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Locale;


/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //напишите тут ваш код

        StringBuffer sb = new StringBuffer(s);
        char y = s.toUpperCase().charAt(0);
        sb.replace(0, 1, String.valueOf(y));


        for (int i = 0; i < s.length(); i++) {
            if (Character.isWhitespace(s.charAt(i))) {
                char x = s.toUpperCase().charAt(i + 1);
                sb.replace(i + 1, i + 2, String.valueOf(x));

            }


        }

        System.out.println(sb);
    }
}
