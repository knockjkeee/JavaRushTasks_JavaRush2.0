package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(Integer.parseInt(reader.readLine()));
        }
        int index = list.get(0);
        int search = 1;
        int result = 0;

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == index) {
                search++;
            } else if (list.get(i) != index) {
                search = 1;
            }
            index = list.get(i);
            if (search > result) {
                result = search;
            }
        }
        System.out.println(result);
        //напишите тут ваш код
    }
}


//        Cамая длинная последовательность
//        1. Создай список чисел.
//        2. Добавь в список 10 чисел с клавиатуры.
//        3. Вывести на экран длину самой длинной последовательности повторяющихся чисел в списке.
//
//        Пример для списка 2, 4, 4, 4, 8, 8, 9, 12, 12, 14:
//        3
//
//        Искомое значение равно 3, т.к. самая длинная последовательность повторяющихся чисел состоит из трех четверок.