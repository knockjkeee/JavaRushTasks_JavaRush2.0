package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        byte[] symbol = new byte[inputStream.available()];
        Map<Character, Integer> map = new TreeMap<>();

        while (inputStream.available() > 0) {
            inputStream.read(symbol);
        }

        Arrays.sort(symbol);
        map.put((char) symbol[0], 0);
        for (byte b : symbol) {
            if (!map.containsKey((char) b)) {
                map.put((char) b, 1);
            } else {
                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                    if (entry.getKey() == (char) b) {
                        entry.setValue(entry.getValue() + 1);
                    }
                }
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        inputStream.close();
    }
}


//        Встречаемость символов
//        Программа запускается с одним параметром — именем файла, который содержит английский текст.
//        Посчитать частоту встречания каждого символа.
//        Отсортировать результат по возрастанию кода ASCII (почитать в инете).
//
//        Пример:
//        ‘,’=44, ‘s’=115, ‘t’=116.
//
//        Вывести на консоль отсортированный результат:
//        [символ1] частота1
//        [символ2] частота2
//        Закрыть потоки.
//
//        Пример вывода:
//        , 19
//        - 7
//        f 361
//
//
//        Требования:
//        1. Считывать с консоли ничего не нужно.
//        2. Создай поток для чтения из файла, который приходит первым параметром в main.
//        3. В файле необходимо посчитать частоту встречания каждого символа и вывести результат.
//        4. Выведенный в консоль результат должен быть отсортирован по возрастанию кода ASCII.
//        5. Поток для чтения из файла должен быть закрыт.