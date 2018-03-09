package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileSourth = reader.readLine();
        reader.close();

        InputStream inputStream = new FileInputStream(fileSourth);

        load(inputStream);

        inputStream.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties myProperties = new Properties();

        if (properties.size() > 0) {
            for (Map.Entry<String, String> map : properties.entrySet()) {
                myProperties.setProperty(map.getKey(), map.getValue());
            }
            myProperties.store(outputStream, null);
        }


        outputStream.close();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties myProperties = new Properties();
        myProperties.load(inputStream);
        properties.clear();
        for (Map.Entry e : myProperties.entrySet()) {
            properties.put(e.getKey().toString(), e.getValue().toString());
        }
        inputStream.close();
    }

    public static void main(String[] args) throws Exception {
    }
}
