package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int sum = 0;
        int temp = 0;
        while (true) {
            temp = scanner.nextInt();
            if (temp == -1) {
                break;
            }
            sum = sum + temp;
            count++;
        }
        System.out.println(((double) sum) / ((double) count));
    }
}
//
//          Среднее арифметическое
//          Вводить с клавиатуры числа и вычислить среднее арифметическое.
//        Если пользователь ввел -1, вывести на экран среднее арифметическое всех чисел и завершить программу.
//        -1 не должно учитываться.
//
//        Пример для чисел 1 2 2 4 5 -1:
//        2.8
//
//        Пример для чисел 4 3 2 1 -1:
//        2.5