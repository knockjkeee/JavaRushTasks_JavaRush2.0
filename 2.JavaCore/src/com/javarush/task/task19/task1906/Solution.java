package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 = reader.readLine();
        String str2 = reader.readLine();
        FileReader fileReader = new FileReader(str1);
        FileWriter fileWriter = new FileWriter(str2);
        List<Integer> list = new ArrayList<>();

        int count = 1;
        while (fileReader.ready()) {
            int value = fileReader.read();
            if (count % 2 == 0) {
                fileWriter.write(value);
            }
            count++;
        }

//        for (int i = 0; i < list.size(); i++) {
//            if (i != 0) {
//                if (i % 2 == 0) {
//                    System.out.print(list.get(i));
//                    fileWriter.write(list.get(i));
//                }
//            }
//        }

        fileReader.close();
        fileWriter.close();
        reader.close();
    }
}
