package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str = reader.readLine();
        String str1 = reader.readLine();

        reader.close();

        FileInputStream in = new FileInputStream(str);



        byte[] bt = new byte[in.available()];
        in.read(bt);
        in.close();


        FileOutputStream in1 = new FileOutputStream(str);
        FileInputStream in2 = new FileInputStream(str1);

        byte[] bt1 = new byte[in2.available()];
        in2.read(bt1);

        in1.write(bt1);
        in1.write(bt);

        in1.close();
        in2.close();

    }
}
