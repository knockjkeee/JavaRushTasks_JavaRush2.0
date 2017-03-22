package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;/*
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader readerPath = new BufferedReader(new InputStreamReader(System.in));
        String filePath = readerPath.readLine();
        FileInputStream inputStream = new FileInputStream(filePath);

        int temp;
        int result = Integer.MAX_VALUE;

        while (inputStream.available() > 0) {
            temp = inputStream.read();
            if (result > temp) {
                result = temp;
            }
        }
        System.out.println(result);
        inputStream.close();
        readerPath.close();
    }
}
