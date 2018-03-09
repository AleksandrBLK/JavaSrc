package com.javarush.task.task19.task1909;

/* 
Замена знаков
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

        while (bufferedReader.ready()){
            int data = bufferedReader.read();
            if (data == 46){
                data = 33;
            }
            bufferedWriter.write(data);
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
