package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        //add your code here
        StringBuilder builder = new StringBuilder();
        BigInteger result = BigInteger.valueOf(1);
        builder.append("1");
        String temp;

        if (n < 0) {
            return "0";   /*4! = factorial(4) = 1*2*3*4 = 24*/
        } else if (n == 0 || n == 1) {
            return "1";
        } else {
            if (n <= 150) {
                for (int i = 2; i < n + 1; i++) {
                    builder.append("*" + i);
                    result = result.multiply(BigInteger.valueOf(i));
                }
                return result.toString();
            } else {
                return "";
            }
        }
    }
}


//        Факториал
//        Написать метод, который вычисляет факториал — произведение всех чисел от 1 до введенного числа включая его.
//
//        Пример: 4! = factorial(4) = 1*2*3*4 = 24
//
//        1. Ввести с консоли число меньше либо равно 150.
//        2. Реализовать функцию factorial.
//        3. Если введенное число меньше 0, то вывести 0.
//        0! = 1