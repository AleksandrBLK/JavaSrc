package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        int count = 0;

        if (args.length > 0){
            FileInputStream in = new FileInputStream(args[0]);
            while (in.available() > 0){
                int data = in.read();
                if ((data > 64 && data < 91) || (data > 96 && data < 123)){
                    count++;
                }
            }

            System.out.println(count);

            in.close();
        }


    }
}
