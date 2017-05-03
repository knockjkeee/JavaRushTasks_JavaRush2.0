package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        //todo task ready
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String One = reader.readLine();
        String Two = reader.readLine();
        FileInputStream inputStreamOne = new FileInputStream(One);
        FileInputStream inputStreamTwo = new FileInputStream(Two);

        byte[] countOne = new byte[inputStreamOne.available()];
        int countarrOne = 0;
        while (inputStreamOne.available() > 0) {
            countOne[countarrOne] = (byte) inputStreamOne.read();
            countarrOne++;
        }

        int countarrTwo = 0;
        byte[] countTwo = new byte[inputStreamTwo.available()];
        while (inputStreamTwo.available() > 0) {
            countTwo[countarrTwo] = (byte) inputStreamTwo.read();
            countarrTwo++;
        }

        byte[] result = new byte[countOne.length + countTwo.length];
        for (int i = 0; i < countTwo.length; i++) {
            result[i] = countTwo[i];
        }
        int temp = 0;
        for (int i = countTwo.length; i < countOne.length + countTwo.length; i++) {
            result[i] = countOne[temp];
            temp++;
        }

        FileOutputStream outputStreamOne = new FileOutputStream(One);
        outputStreamOne.write(result);
        reader.close();
        inputStreamOne.close();
        inputStreamTwo.close();
        outputStreamOne.close();
    }
}


//
//        Объединение файлов
//        Считать с консоли 2 имени файла.
//        В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов.
//        Закрыть потоки.
//
//
//        Требования:
//        1. Программа должна два раза считать имена файлов с консоли.
//        2. Для первого файла создай поток для чтения и считай его содержимое.
//        3. Затем, для первого файла создай поток для записи. Для второго - для чтения.
//        4. Содержимое первого и второго файла нужно объединить в первом файле.
//        5. Сначала должно идти содержимое второго файла, затем содержимое первого.
//        6. Созданные для файлов потоки должны быть закрыты.