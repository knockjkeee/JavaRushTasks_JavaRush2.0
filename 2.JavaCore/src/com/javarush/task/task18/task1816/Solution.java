package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        char[] symbolUp = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[] symbolDown = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int count = 0;

        while (inputStream.available() > 0) {
            int temp = inputStream.read();
            for (char c : symbolUp) {
                if (temp == ((byte) c)) {
                    count++;
                }
            }
            for (char c : symbolDown) {
                if (temp == ((byte) c)) {
                    count++;
                }
            }
        }
        inputStream.close();
        System.out.println(count);
    }
}


//        В метод main первым параметром приходит имя файла.
//        Посчитать количество букв английского алфавита, которое есть в этом файле.
//        Вывести на экран число (количество букв).
//        Закрыть потоки.
//
//
//        Требования:
//        1. Считывать с консоли ничего не нужно.
//        2. Создай поток чтения из файла, который приходит первым параметром в main.
//        3. В файле необходимо посчитать буквы английского алфавита и вывести это число в консоль.
//        4. Нужно учитывать заглавные и строчные буквы.
//        5. Поток чтения из файла должен быть закрыт.