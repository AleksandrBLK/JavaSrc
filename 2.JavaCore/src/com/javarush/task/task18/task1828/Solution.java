package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
        String fileSourth = reader2.readLine();
        reader2.close();

        ArrayList<String> list = new ArrayList<>();


        if (args[0].equals("-d")) {
            BufferedReader reader = new BufferedReader(new FileReader(fileSourth));
            while (reader.ready()) {
                list.add(reader.readLine());
            }

            reader.close();
            for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
                if (Integer.parseInt(args[1]) == Integer.parseInt(iterator.next().substring(0, 8).trim())) {
                    iterator.remove();
                }
            }

        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileSourth));

        for (String line : list) {
            writer.write(line + "\n");
        }

        writer.close();


        if (args[0].equals("-u")) {
            String id = args[1];
            String productName = args[2];
            String price = args[3];
            String quantity = args[4];


            if (id.length() < 8) {
                int endCount = id.length();
                for (int i = 0; i < 8 - endCount; i++) {
                    id = id.concat(" ");
                }
            }

            if (productName.length() < 30) {
                int endCount = productName.length();
                for (int i = 0; i < 30 - endCount; i++) {
                    productName = productName.concat(" ");
                }
            }

            if (productName.length() > 30) {
                productName.substring(0, 30).trim();
            }

            if (price.length() < 8) {
                int endCount = price.length();
                for (int i = 0; i < 8 - endCount; i++) {
                    price = price.concat(" ");
                }
            }

            if (quantity.length() < 4) {
                int endCount = quantity.length();
                for (int i = 0; i < 4 - endCount; i++) {
                    quantity = quantity.concat(" ");
                }
            }

            String updateResult = id.concat(productName).concat(price).concat(quantity);

            BufferedReader reader1 = new BufferedReader(new FileReader(fileSourth));

            while (reader1.ready()) {
                list.add(reader1.readLine());
            }

            reader1.close();

            for (int i = 0; i < list.size(); i++) {
                if (Integer.parseInt(args[1]) == Integer.parseInt(list.get(i).substring(0, 8).trim())) {
                    list.remove(i);
                    list.add(i, updateResult);
                }
            }


            BufferedWriter writer1 = new BufferedWriter(new FileWriter(fileSourth));

            for (String line : list) {
                writer1.write(line + "\n");
            }

            writer1.close();


        }
    }
}

