package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());




    }

    public static ByteArrayOutputStream getPassword() throws IOException {
        boolean result = false;
        StringBuilder sb = GeneratingPassword();

        while (!result){
            sb = GeneratingPassword();
            if (sb.toString().matches("(.*)[A-Z](.*)") && sb.toString().matches("(.*)[a-z](.*)") && sb.toString().matches("(.*)[0-9](.*)")){
                result = true;
            }
        }

        byte[] array = sb.toString().getBytes();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write(array);

        return outputStream;
    }

    private static StringBuilder GeneratingPassword() {
        String dict = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(8);
        for (int i = 0; i < 8; i++) {
            sb.append(dict.charAt(rnd.nextInt(dict.length())));
        }
        return sb;
    }


}