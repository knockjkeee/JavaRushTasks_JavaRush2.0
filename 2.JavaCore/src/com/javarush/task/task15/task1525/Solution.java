package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static {
        try {
            InputStream in = new FileInputStream(Statics.FILE_NAME);
            int count = in.available();
            char temp;
                while (count != -1) {
                    temp = (char) count;
                    System.out.print(temp);
//                    lines.add(String.valueOf(temp));
                    count = in.read();
                }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        System.out.println(lines);
    }
}



//        1. Инициализируй переменную Statics.FILE_NAME полным путем к файлу с данными, который содержит несколько строк.
//        2. В статическом блоке считай из файла с именем Statics.FILE_NAME все строки и добавь их по-отдельности в List lines.