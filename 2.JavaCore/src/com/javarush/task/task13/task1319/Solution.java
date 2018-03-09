package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Запись в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String filePath = reader.readLine();

        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

        while (true) {
            String line = reader.readLine();
            writer.write(line);
            writer.newLine();
            if (line.equals("exit")){
                break;
            }
        }

        reader.close();
        writer.close();


    }
}
