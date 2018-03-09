package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));


    }

    public static String factorial(int n) {
        //add your code here
        BigDecimal result = BigDecimal.ONE;

        if (n <= 150 && n >= 0) {
            for (int i = 2; i <= n; i++) {
                result = result.multiply(BigDecimal.valueOf(i));
            }
        } else if (n < 0) {
            return "0";
        }

        return result.toString();
    }
}