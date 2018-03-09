package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = reader.readLine();
            if (str.equals("exit")) {
                break;
            } else {
                new ReadThread(str).start();
            }
        }

        reader.close();

    }

    public static class ReadThread extends Thread {
        String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            int max = 0;
            int max1 = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            try {
                FileInputStream inputStream = new FileInputStream(fileName);
                while (inputStream.available() > 0) {
                    int d = inputStream.read();
                    if (map.containsKey(d)) {
                        map.put(d, map.get(d) + 1);
                    } else {
                        map.put(d, 1);
                    }
                }

                for (Map.Entry entry : map.entrySet()) {
                    if ((int) entry.getValue() > max) {
                        max = (int) entry.getValue();
                    }
                }

                for (Map.Entry entry : map.entrySet()) {
                    if (entry.getValue().equals(max)) {
                        max1 = (int) entry.getKey();
                    }
                }
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            resultMap.put(fileName, max1);
        }
    }
}
