package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String temp = reader.readLine();
        while (!temp.equals("exit")) {
            ReadThread read = new ReadThread(temp);
            read.start();
            temp = reader.readLine();
        }

        for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

    }

    public static class ReadThread extends Thread {
        public String getFileName() {
            return fileName;
        }

        String fileName;

        public ReadThread(String fileName) throws IOException {
            //implement constructor body
            this.fileName = fileName;
        }

        @Override
        public void run() {
            try {
                FileInputStream stream = new FileInputStream(fileName);
                byte[] temp = new byte[stream.available()];

                while (stream.available() > 0) {
                    stream.read(temp);
                }
                byte result = 0;
                int countStart = 0;
                int countFinish = 0;

                for (int i = 0; i < temp.length; i++) {
                    for (int j = 0; j < temp.length; j++) {
                        if (i != j) {
                            if (temp[i] == temp[j]) {
                                countStart++;
                            }
                        }
                    }
                    if (countFinish < countStart) {
                        countFinish = countStart;
                        result = temp[i];
                        countStart = 0;
                    } else {
                        countStart = 0;
                    }
                }
                resultMap.put(getFileName(), Integer.valueOf(result));
                stream.close();
//                interrupt();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // implement file reading here - реализуйте чтение из файла тут
    }
}


//         Нити и байты
//        Читайте с консоли имена файлов, пока не будет введено слово «exit«.$
//        Передайте имя файла в нить ReadThread.
//        Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
//        где параметр String — это имя файла, параметр Integer — это искомый байт.
//        Закрыть потоки.
//
//
//        Требования:
//        1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "exit".
//        2. Для каждого файла создай нить ReadThread и запусти ее.
//        3. После запуска каждая нить ReadThread должна создать свой поток для чтения из файла.
//        4. Затем, нити должны найти максимально встречающийся байт в своем файле и добавить его в словарь resultMap.
//        5. Поток для чтения из файла в каждой нити должен быть закрыт.