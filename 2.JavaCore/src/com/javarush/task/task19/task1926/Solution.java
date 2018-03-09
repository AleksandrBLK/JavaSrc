package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileSourth = reader.readLine();

        reader.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileSourth));

        while (bufferedReader.ready()){
            StringBuffer str = new StringBuffer(bufferedReader.readLine());
            str.reverse();
            System.out.println(str);
        }

        bufferedReader.close();
    }
}
