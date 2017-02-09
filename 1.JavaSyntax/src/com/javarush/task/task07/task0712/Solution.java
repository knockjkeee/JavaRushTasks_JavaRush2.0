package com.javarush.task.task07.task0712;

/*
Самые-самые
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            list.add(reader.readLine());
        }

        int min = list.get(0).length();
        int max = list.get(0).length();
        int countMin = 0;
        int countMax = 0;

        for (int i = 0; i < list.size(); i++) {
            if (min > list.get(i).length() && min != list.get(i).length()) {
                min = list.get(i).length();
                countMin = i;
            } else if (max < list.get(i).length() && max != list.get(i).length()) {
                max = list.get(i).length();
                countMax = i;
            }
        }

        if (countMin < countMax) {
            System.out.println(list.get(countMin));
        } else {
            System.out.println(list.get(countMax));
        }
        //напишите тут ваш код
    }
}


//        1. Создай список строк.
//        2. Добавь в него 10 строчек с клавиатуры.
//        3. Узнай, какая строка в списке встретится раньше: самая короткая или самая длинная.
//        Если таких строк несколько, то должны быть учтены самые первые из них.
//        4. Выведи на экран строку из п.3.