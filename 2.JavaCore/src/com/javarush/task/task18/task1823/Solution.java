package com.javarush.task.task18.task1823;

import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {

    }

    public static class ReadThread extends Thread {
        public ReadThread(String fileName) {
            //implement constructor body
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}


//         Нити и байты
//        Читайте с консоли имена файлов, пока не будет введено слово «exit«.
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