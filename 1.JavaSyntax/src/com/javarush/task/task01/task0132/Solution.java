package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        //напишите тут ваш код
        int temp = 0;
        while (number > 0) {
            temp = temp + (number % 10);
            number = number / 10;
        }
        return temp;

    }
}

//
//    Реализуй метод sumDigitsInNumber(int number). Метод на вход принимает целое трехзначное число.
// Нужно посчитать сумму цифр этого числа, и вернуть эту сумму.
//
//        Пример:
//        Метод sumDigitsInNumber вызывается с параметром 546.
//
//        Пример вывода:
//        15