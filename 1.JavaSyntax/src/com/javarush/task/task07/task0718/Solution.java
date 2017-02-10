package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(reader.readLine());
        }

        int start = list.get(0).length();
        int finish = 0;
        int index = 0;
        for (int i = 1; i < list.size(); i++) {
            if (start > list.get(i).length()) {
                index = i;
                break;
            }
            start = list.get(i).length();
        }

        if (index == finish) {
        } else {
            System.out.println(index);

        }
    }
}


//        1. Введи с клавиатуры 10 слов в список строк.
//        2. Определить, является ли список упорядоченным по возрастанию длины строки.
//        3. В случае отрицательного ответа вывести на экран номер первого элемента, нарушающего такую упорядоченность.