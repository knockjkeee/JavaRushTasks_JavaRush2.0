package com.javarush.task.task02.task0205;

/* 
Прибавка к зарплате
*/
public class Solution {
    public static void main(String[] args) {
        salary(700);
    }

    public static void salary(int a) {
        int temp = a + 100;
        System.out.printf("Твоя зарплата составляет: %d долларов в месяц.", temp);
    }
}


//    Реализуй метод public static void salary(int a).
//        Метод должен увеличить переданное число на 100 и вывести на экран надпись: «Твоя зарплата составляет: a долларов в месяц.»
//        Где a — это переданное число, которое увеличили на 100.
//
//        Пример вывода на экран для а = 700:
//        Твоя зарплата составляет: 800 долларов в месяц.