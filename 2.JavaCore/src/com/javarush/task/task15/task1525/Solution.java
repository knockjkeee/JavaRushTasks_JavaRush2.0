package com.javarush.task.task15.task1525;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static {
        try {
            String data;
            BufferedReader in;
            in = new BufferedReader(new InputStreamReader(new FileInputStream(Statics.FILE_NAME), "UTF-8"));
            int temp = -1;
            while ((data = in.readLine()) != null) {
                lines.add(data);
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