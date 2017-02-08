package com.javarush.task.task01.task0140;

/*
Выводим квадрат числа
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int a;
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);

        a = scanner.nextInt();
        System.out.println(a * a);
    }
}




//        Напиши программу, которая считывает с клавиатуры целое число a и выводит квадрат этого числа (a * a).
//        Внимательно просмотри лекцию. Для считывания данных с клавиатуры используй метод nextInt() класса Scanner.