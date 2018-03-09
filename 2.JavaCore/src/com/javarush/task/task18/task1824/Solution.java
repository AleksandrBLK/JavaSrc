package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = " ";

        while (true) {
            try {
                str = reader.readLine();
                FileInputStream fileInputStream = new FileInputStream(str);
                fileInputStream.close();
            } catch (FileNotFoundException e) {
                System.out.println(str);
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }

    }
}
