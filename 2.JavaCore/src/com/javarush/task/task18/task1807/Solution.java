package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());

        byte shearchChar = ((byte) ',');
        int temp = 0;
        int resault = 0;
        while (inputStream.available() > 0) {
            temp = inputStream.read();
            if (temp == shearchChar) {
                resault++;
            }
        }
        reader.close();
        inputStream.close();

        System.out.println(resault);


    }
}






//    Подсчет запятых
//    С консоли считать имя файла.
//        Посчитать в файле количество символов ‘,‘, количество вывести на консоль.
//        Закрыть потоки.
//
//        Подсказка:
//        нужно сравнивать с ascii-кодом символа ‘,‘.
//
//
//        Требования:
//        1. Программа должна считывать имя файла с консоли.
//        2. Для чтения из файла используй поток FileInputStream.
//        3. В консоль должно выводится число запятых в считанном файле.
//        4. Поток чтения из файла должен быть закрыт.