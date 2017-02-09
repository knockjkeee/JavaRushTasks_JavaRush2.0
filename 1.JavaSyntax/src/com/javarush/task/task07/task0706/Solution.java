package com.javarush.task.task07.task0706;

/*
Улицы и дома
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        int [] array = new int[15];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int even = 0;
        int odd = 0;

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                even = even + array[i];
            }
            if (i % 2 == 0) {
                even = even + array[i];
            } else {
                odd = odd + array[i];
            }
        }

        if (odd > even) {System.out.println("В домах с нечетными номерами проживает больше жителей.");}
        else {System.out.println("В домах с четными номерами проживает больше жителей.");}

        //напишите тут ваш код
    }
}



//        1. Создать массив на 15 целых чисел.
//        2. Ввести в него значения с клавиатуры.
//        3. Пускай индекс элемента массива является номером дома, а значение — число жителей, проживающих в доме.
//        Дома с нечетными номерами расположены на одной стороне улицы, с четными — на другой. Выяснить, на какой стороне улицы проживает больше жителей.
//        4. Вывеси на экран сообщение: «В домах с нечетными номерами проживает больше жителей.» или «В домах с четными номерами проживает больше жителей.»
//
//        Примечание:
//        дом с порядковым номером 0 считать четным.