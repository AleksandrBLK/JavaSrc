package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/


import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileSourth = reader.readLine();
        String fileOutput = reader.readLine();

        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileSourth));

        String str = "";
        while (fileReader.ready()) {
            str += String.valueOf((char) fileReader.read());
        }
        fileReader.close();

        String[] arr = str.split(" ");

        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileOutput));

        for (String i : arr) {
            if (isNumber(i)) {
                fileWriter.write(i.concat(" "));
            }

        }

        fileWriter.close();


    }

    private static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
