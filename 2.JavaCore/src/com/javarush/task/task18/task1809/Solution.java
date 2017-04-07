package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pathOne = reader.readLine();
        String pathTwo = reader.readLine();
        FileInputStream inputStream = new FileInputStream(pathOne);
        FileOutputStream outputStream = new FileOutputStream(pathTwo);

        while (inputStream.available() > 0) {
            byte[] temp = new byte[inputStream.available()];
            inputStream.read(temp);
            for (int i = temp.length -1; i >= 0; i--) {
                outputStream.write(temp[i]);
            }
        }
        reader.close();
        inputStream.close();
        outputStream.close();
    }
}


//        Считать с консоли 2 имени файла: файл1, файл2.
//        Записать в файл2 все байты из файл1, но в обратном порядке.
//        Закрыть потоки.
//
//
//        Требования:
//        1. Программа должна два раза считать имена файлов с консоли.
//        2. Для чтения из файла используй поток FileInputStream, для записи в файл - FileOutputStream
//        3. Во второй файл нужно записать все байты из первого в обратном порядке.
//        4. Потоки FileInputStream и FileOutputStream должны быть закрыты.