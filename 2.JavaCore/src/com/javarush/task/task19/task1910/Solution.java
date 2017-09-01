package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = bufferedReader.readLine();
        String file2 = bufferedReader.readLine();

        BufferedReader in = new BufferedReader(new FileReader(file1));
        BufferedWriter out = new BufferedWriter(new FileWriter(file2));

        Pattern pattern = Pattern.compile("[\\w]");
        StringBuilder sb = new StringBuilder();

        while (in.ready()) {
            sb.append(in.readLine());
        }

//        sb.deleteCharAt(0);
        Matcher m = pattern.matcher(sb);
        while (m.find()) {
            out.write(m.group());
            out.flush();
        }

        bufferedReader.close();
        in.close();
        out.close();

    }
}

//Требования:
//        1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
//        2. BufferedReader для считывания данных с консоли должен быть закрыт.
//        3. Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором FileReader).
//        4. Поток чтения из файла (BufferedReader) должен быть закрыт.
//        5. Программа должна записывать во второй файл содержимое первого файла, где удалены все знаки пунктуации, включая символы новой строки (Для записи в файл используй BufferedWriter с конструктором FileWriter).
//        6. Поток записи в файл (BufferedWriter) должен быть закрыт.