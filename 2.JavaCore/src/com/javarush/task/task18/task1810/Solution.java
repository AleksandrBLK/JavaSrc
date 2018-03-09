package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import org.omg.CORBA.portable.*;

import java.io.*;


public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileSourth = reader.readLine();
        FileInputStream inputStream = new FileInputStream(fileSourth);


        while (inputStream.available() > 999) {
            inputStream.close();
            fileSourth = reader.readLine();
            inputStream = new FileInputStream(fileSourth);

        }


        reader.close();
        inputStream.close();
        throw new DownloadException();






    }

    public static class DownloadException extends Exception {


    }
}
