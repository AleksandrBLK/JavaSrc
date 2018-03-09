package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sourthFile = reader.readLine();

        reader.close();

        FileReader fileReader = new FileReader(sourthFile);

        int count = 0;
        String str = "";
        while(fileReader.ready()) {
            str+=String.valueOf((char)fileReader.read());
        }
        fileReader.close();
        String[] arr = str.split("\\W");
        for(String t: arr) {
            if(t.equals("world")) count++;
        }

        System.out.println(count);
    }
}
