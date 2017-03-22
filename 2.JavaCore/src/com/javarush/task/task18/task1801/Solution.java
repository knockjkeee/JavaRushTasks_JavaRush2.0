package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader readerFilePath = new BufferedReader(new InputStreamReader(System.in));
        String filePath = readerFilePath.readLine();
        FileInputStream reader = new FileInputStream(filePath);

        int temp;
        int result = 0;

        while (reader.available() > 0) {
            temp = reader.read();
            if (result < temp) {
                result = temp;
            }
        }

        System.out.println(result);
        readerFilePath.close();
        reader.close();

    }
}
