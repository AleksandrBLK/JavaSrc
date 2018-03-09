package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(args[0], "rw");

        raf.seek(Long.parseLong(args[1]));

        int textLength = args[2].length();

        byte[] buffer = new byte[textLength];

        raf.read(buffer, 0, textLength);

        String readText = convertByteToString(buffer);

        raf.seek(raf.length());

        if (readText.equals(args[2])) {
            raf.write("true".getBytes());
        } else {
            raf.write("false".getBytes());
        }

        raf.close();


    }

    public static String convertByteToString(byte readBytes[]) {
        return new String(readBytes);
    }
}
