package com.javarush.task.task19.task1906;

/* 
Четные байты
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str = reader.readLine();
        String outputFile = reader.readLine();

        reader.close();

        FileReader fileReader = new FileReader(str);
        FileWriter fileWriter = new FileWriter(outputFile);
        int count = 0;

        while (fileReader.ready()){
            count++;
            int data = fileReader.read();
            if (count % 2 == 0){
                fileWriter.write(data);

            }
        }

        fileReader.close();
        fileWriter.close();

    }
}
