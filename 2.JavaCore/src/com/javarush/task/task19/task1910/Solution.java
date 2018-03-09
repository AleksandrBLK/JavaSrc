package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sourceFile = reader.readLine();
        String outputFile = reader.readLine();

        reader.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceFile));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile));
        String data = "";


        while (bufferedReader.ready()){
           data+= String.valueOf((char) bufferedReader.read());
        }

        bufferedReader.close();

        String[] arr = data.split("[^a-zA-Z]");


        for (String i : arr){
            bufferedWriter.write(i);
        }

        bufferedWriter.close();



    }
}
