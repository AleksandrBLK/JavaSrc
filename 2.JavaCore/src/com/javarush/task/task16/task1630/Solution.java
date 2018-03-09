package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws InterruptedException, IOException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException, IOException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent() throws IOException;

        void join() throws InterruptedException;

        void start();
    }


    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String FileName;
        String b = "";

        @Override
        public void setFileName(String fullFileName) {
            FileName = fullFileName;
        }

        @Override
        public String getFileContent() throws IOException {
            return b;
        }

        @Override
        public void run() {
            try (BufferedReader inStream = new BufferedReader(new InputStreamReader(new FileInputStream(FileName)))) {
                String a;
                while ((a = inStream.readLine()) != null) {
                    b = b.concat(a).concat(" ");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }


    //add your code here - добавьте код тут
}
