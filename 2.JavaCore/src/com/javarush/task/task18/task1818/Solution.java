package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        //TODO task ready
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFilePath = reader.readLine();
        String twoFilePath = reader.readLine();
        String threeFilePath = reader.readLine();
        FileOutputStream outputStreamFileFirst = new FileOutputStream(firstFilePath);
        FileInputStream inputStreamFileTwo = new FileInputStream(twoFilePath);
        FileInputStream inputStreamFileThree = new FileInputStream(threeFilePath);

        while (inputStreamFileTwo.available() > 0) {
            int temp = inputStreamFileTwo.read();
            outputStreamFileFirst.write(temp);
        }

        while (inputStreamFileThree.available() > 0) {
            int temp = inputStreamFileThree.read();
            outputStreamFileFirst.write(temp);

        }

        reader.close();
        outputStreamFileFirst.close();
        inputStreamFileTwo.close();
        inputStreamFileThree.close();

    }
}


//        Два в одном
//        Считать с консоли 3 имени файла.
//        Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла.
//        Закрыть потоки.
//
//
//        Требования:
//        1. Программа должна три раза считать имена файлов с консоли.
//        2. Для первого файла создай поток для записи. Для двух других - потоки для чтения.
//        3. Содержимое второго файла нужно переписать в первый файл.
//        4. Содержимое третьего файла нужно дописать в первый файл (в который уже записан второй файл).
//        5. Созданные для файлов потоки должны быть закрыты.