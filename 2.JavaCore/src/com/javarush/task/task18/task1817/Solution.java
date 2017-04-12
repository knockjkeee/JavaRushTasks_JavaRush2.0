package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution {
    public static void main(String[] args) throws IOException {
        String temp = args[0];
        FileInputStream inputStream = new FileInputStream(temp);

        int allSymbol = inputStream.available();
        int countSpaceSymbol = 0;
        int spaceSymbol = (byte) ' ';
        while (inputStream.available() > 0) {
            if (inputStream.read() == spaceSymbol) {
                countSpaceSymbol++;
            }
        }
        inputStream.close();
        double result = new BigDecimal((double) countSpaceSymbol / allSymbol * 100).setScale(2, RoundingMode.HALF_UP).doubleValue();
        System.out.println(result);
    }
}


//    FileInputStream fileInputStream = new FileInputStream(args[0]);
//    int count = 0;
//    int spaceCount = 0;
//    double result;
//        while (fileInputStream.available() > 0) {
//                int data = fileInputStream.read();
//                count++;
//                if (data == 32) {
//                spaceCount++;
//                }
//                }
//                result = (double) spaceCount/count * 100;
//                System.out.println(String.format("%.2f",result));
//                fileInputStream.close();
//                }