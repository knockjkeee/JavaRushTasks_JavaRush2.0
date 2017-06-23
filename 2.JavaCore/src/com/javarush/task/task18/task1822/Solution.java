package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream inputStream = new FileInputStream(fileName);
        StringBuilder builderKey = new StringBuilder();
        StringBuilder builderValue = new StringBuilder();
//        byte[] tt = new byte[inputStream.available()];

        BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream));
        Map<Integer, String> map = new HashMap<>();

        while (rd.ready()) {
            char[] temp = rd.readLine().toCharArray();
            int count = 0;
            int countTemp = 0;
            for (char c : temp) {
                if (c == ' ') {
                    countTemp++;
                    break;
                } else {
                    count++;
                    builderKey.append(c);
                }
            }
            if (countTemp == 1) {
                for (int i = count + 1; i < temp.length; i++) {
                    builderValue.append(temp[i]);
                }
            }
            map.put(Integer.parseInt(String.valueOf(builderKey)), builderValue.toString());
            count = 0;
            countTemp = 0;
            builderKey.delete(0, builderKey.length() + 1);
            builderValue.delete(0, builderValue.length() + 1);
        }

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() == Integer.parseInt(args[0])){
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }

        inputStream.close();


//        while (inputStream.available() > 0) {
//            inputStream.read(tt);
//        }
//
//        for (byte b : tt) {
//            if ((char) b == ' ') {
//                break;
//            }
//            builder.append((char) b);
//        }
//        System.out.println(builder);


    }
}


//        Поиск данных внутри файла
//        Считать с консоли имя файла.
//        Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
//        Программа запускается с одним параметром: id (int).
//        Закрыть потоки.
//
//        В файле данные разделены пробелом и хранятся в следующей последовательности:
//        id productName price quantity
//        где id — int.
//        productName — название товара, может содержать пробелы, String.
//        price — цена, double.
//        quantity — количество, int.
//
//        Информация по каждому товару хранится в отдельной строке.
//
//
//        Требования:
//        1. Программа должна считать имя файла с консоли.
//        2. Создай для файла поток для чтения.
//        3. Программа должна найти в файле и вывести информацию о id, который передается первым параметром.
//        4. Поток для чтения из файла должен быть закрыт.