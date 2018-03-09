package com.javarush.task.task15.task1527;

import com.sun.org.apache.xml.internal.utils.URI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str = reader.readLine();
        URI str1 = new URI(str);
        str = str1.getQueryString();

        reader.close();

        ArrayList<String> list = new ArrayList<>();

        for (String retval : str.split("=\\d+|=\\D+&|&|.\\d+|=\\D+")) {
            if (retval.trim().length() != 0) {
                list.add(retval);
            }

        }

        for (int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }

        if (str.contains("obj=")) {
            for (String retval1 : str.split("&\\D+|obj=")) {
                if (retval1.trim().length() != 0) {
                    try {
                        double d = Double.parseDouble(retval1);
                        alert(d);
                    } catch (Exception e) {
                        alert(retval1);
                    }
                }
            }
        }
    }


    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
