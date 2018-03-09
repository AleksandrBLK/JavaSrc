package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileSourth = reader.readLine();

        reader.close();

        if (args.length > 0){
           BufferedReader bufferedReader = new BufferedReader(new FileReader(fileSourth));
            ArrayList<String> list = new ArrayList<>();

           while (bufferedReader.ready()){
               String data = bufferedReader.readLine();
               for (String str : data.split("\\s", 2)){
                   list.add(str);
               }
           }

           bufferedReader.close();

            for (int i = 0; i < list.size(); i++){
                if (list.get(i).equals(args[0])){
                    System.out.println(list.get(i) + " " + list.get(i + 1));
                }
            }


        }
    }
}
