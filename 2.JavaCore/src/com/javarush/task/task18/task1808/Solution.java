package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sourthFile = reader.readLine();
        String sourthFile1 = reader.readLine();
        String sourthFile2 = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(sourthFile);
        FileOutputStream outputStream = new FileOutputStream(sourthFile1);
        FileOutputStream outputStream1 = new FileOutputStream(sourthFile2);

        if (inputStream.available() > 0) {
            byte[] buffer = new byte[(inputStream.available() + 1) / 2];
            byte[] buffer1 = new byte[inputStream.available() / 2];
            int count = inputStream.read(buffer);
            int count2 = inputStream.read(buffer1);
            outputStream.write(buffer, 0, count);
            outputStream1.write(buffer1);
        }

        inputStream.close();
        outputStream.close();
        outputStream1.close();


    }
}
