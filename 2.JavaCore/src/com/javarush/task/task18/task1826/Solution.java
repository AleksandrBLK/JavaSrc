package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Key;

public class Solution {
    public static void main(String[] args) throws IOException {

        if (args[0].equals("-e")){
            FileInputStream fileInputStream = new FileInputStream(args[1]);
            FileOutputStream fileOutputStream = new FileOutputStream(args[2]);

            while (fileInputStream.available() > 0){
                fileOutputStream.write(fileInputStream.read() + 1);
            }

            fileInputStream.close();
            fileOutputStream.close();

        } if (args[0].equals("-d")){
            FileInputStream fileInputStream = new FileInputStream(args[1]);
            FileOutputStream fileOutputStream = new FileOutputStream(args[2]);

            while (fileInputStream.available() > 0){
                fileOutputStream.write(fileInputStream.read() - 1);
            }

            fileInputStream.close();
            fileOutputStream.close();
        }

    }

}
