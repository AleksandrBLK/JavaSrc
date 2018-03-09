package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        int count = 0;
        int count1 = 0;



        if (args.length > 0){
            FileInputStream in = new FileInputStream(args[0]);
            while (in.available() > 0){
                int data = in.read();
                count++;
                if (data == 32){
                    count1++;
                }
            }

            in.close();
            double result = (double) count1/count * 100 ;


            System.out.println(String.format("%.2f",result));
        }

    }
}
