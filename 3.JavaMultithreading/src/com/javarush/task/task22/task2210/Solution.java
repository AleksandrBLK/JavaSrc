package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {

    }

    public static String[] getTokens(String query, String delimiter) {

        StringTokenizer str = new StringTokenizer(query, delimiter);


        ArrayList<String> list = new ArrayList<>();

        while (str.hasMoreTokens()) {
            String token = str.nextToken();
            list.add(token);
        }

        return list.toArray(new String[0]);
    }
}
