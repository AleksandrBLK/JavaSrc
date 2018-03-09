package com.javarush.task.task18.task1827;

/* 
Прайсы
*/


import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {

        if (args[0].equals("-c")) {
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
            String fileSourth = reader2.readLine();
            reader2.close();
            BufferedReader reader = new BufferedReader(new FileReader(fileSourth));
            ArrayList<String> list = new ArrayList<>();
            int maxId = 0;

            while (reader.ready()) {
                list.add(reader.readLine());
            }

            reader.close();


            for (String id : list) {
                if (maxId < Integer.parseInt(id.substring(0, 8).trim())) {
                    maxId = Integer.parseInt(id.substring(0, 8).trim());
                }
            }

            maxId++;
            String maxEnd = String.valueOf(maxId);
            String productName = args[1];
            String price = args[2];
            String quantity = args[3];


            if (maxEnd.length() < 8){
                int endCount = maxEnd.length();
                for (int i = 0; i < 8 - endCount; i++){
                    maxEnd = maxEnd.concat(" ");
                }
            }

            if (productName.length() < 30){
                int endCount = productName.length();
                for (int i = 0; i < 30 - endCount; i++){
                    productName = productName.concat(" ");
                }
            }

            if (productName.length() > 30){
                productName.substring(0, 30).trim();
            }

            if (price.length() < 8){
                int endCount = price.length();
                for (int i = 0 ; i < 8 - endCount; i++){
                    price = price.concat(" ");
                }
            }

            if (quantity.length() < 4){
                int endCount = quantity.length();
                for (int i = 0; i < 4 - endCount; i++){
                    quantity = quantity.concat(" ");
                }
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileSourth));

            for (String line : list){
                writer.write(line + "\n");
            }

            writer.write(maxEnd);
            writer.write(productName);
            writer.write(price);
            writer.write(quantity + "\n");

            writer.close();


        }
    }
}
