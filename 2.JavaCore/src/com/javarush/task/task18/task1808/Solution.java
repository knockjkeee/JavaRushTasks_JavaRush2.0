package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String first = reader.readLine();
        String two = reader.readLine();
        String three = reader.readLine();

        FileInputStream inputStream = new FileInputStream(first);
        FileOutputStream outputStreamTwo = new FileOutputStream(two);
        FileOutputStream outputStreamThree = new FileOutputStream(three);

        int chechSymbol = inputStream.available();
        byte[] temp = new byte[inputStream.available()];

        while (inputStream.available() > 0) {
            inputStream.read(temp);
            for (int i = 0; i < temp.length; i++) {
                if (chechSymbol % 2 == 0) {
                    if (i <= (chechSymbol / 2) - 1) {
                        outputStreamTwo.write(temp[i]);
                    } else {
                        outputStreamThree.write(temp[i]);
                    }
                } else {
                    if (i <= (chechSymbol - 1) / 2) {
                        outputStreamTwo.write(temp[i]);
                    } else {
                        outputStreamThree.write(temp[i]);
                    }
                }
            }

        }
        System.out.println(chechSymbol);
        reader.close();
        inputStream.close();
        outputStreamTwo.close();
        outputStreamThree.close();
    }
}


//        Разделение файла
//        Считать с консоли три имени файла: файл1, файл2, файл3.
//        Разделить файл1 по следующему критерию:
//        Первую половину байт записать в файл2, вторую половину байт записать в файл3.
//        Если в файл1 количество байт нечетное, то файл2 должен содержать большую часть.
//        Закрыть потоки.
//
//
//        Требования:
//        1. Программа должна три раза считать имена файлов с консоли.
//        2. Для чтения из файла используй поток FileInputStream, для записи в файлы - FileOutputStream
//        3. Первую половину байт из первого файла нужно записать во второй файл.
//        4. Вторую половину байт из первого файла нужно записать в третий файл.
//        5. Потоки FileInputStream и FileOutputStream должны быть закрыты.