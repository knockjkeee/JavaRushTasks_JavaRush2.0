package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        BufferedReader input = new BufferedReader(new FileReader(file1));
        BufferedWriter out = new BufferedWriter(new FileWriter(file2));


        while (input.ready()) {
            String temp = input.readLine().replace(".", "!");
            out.write(temp);
            out.flush();
        }

        reader.close();
        input.close();
        out.close();
    }
}


//Требования:
//        1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
//        2. BufferedReader для считывания данных с консоли должен быть закрыт.
//        3. Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором FileReader).
//        4. Поток чтения из файла (BufferedReader) должен быть закрыт.
//        5. Программа должна записывать во второй файл содержимое первого файла, где заменены все точки "." на знак "!" (Для записи в файл используй BufferedWriter с конструктором FileWriter).
//        6. Поток записи в файл (BufferedWriter) должен быть закрыт.