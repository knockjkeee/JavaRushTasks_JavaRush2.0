package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //add your code here - добавьте код тут
    static {
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();

    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String tempFilename;
        private String resultContent;
        List<String> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        @Override
        public void run() {
            String temp;
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(tempFilename)));
                while ((temp = reader.readLine()) != null) {
                    list.add(temp);
                }
                reader.close();
                interrupt();
            } catch (FileNotFoundException e) {
            } catch (IOException e) {
            }
        }

        @Override
        public void setFileName(String fullFileName) {
            tempFilename = fullFileName;
        }

        @Override
        public String getFileContent() {
            for (int i = 0; i < list.size(); i++) {
                builder.append(list.get(i));
                if (i != list.size() - 1) {
                    builder.append(" ");
                }
            }
            resultContent = String.valueOf(builder);
            return resultContent;
        }
    }
    //add your code here - добавьте код тут

}
