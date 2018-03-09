package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file = reader.readLine();
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        reader.close();


        FileOutputStream in = new FileOutputStream(file);
        FileInputStream in1 = new FileInputStream(file1);
        FileInputStream in2 = new FileInputStream(file2);

        byte[] bt1 = new byte[in1.available()];
        byte[] bt2 = new byte[in2.available()];

        in1.read(bt1);
        in.write(bt1);
        in2.read(bt2);
        in.write(bt2);


        in.close();
        in1.close();
        in2.close();

    }
}
