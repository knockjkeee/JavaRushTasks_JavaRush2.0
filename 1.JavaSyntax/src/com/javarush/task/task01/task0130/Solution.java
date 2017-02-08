package com.javarush.task.task01.task0130;

/* 
Наш первый конвертер!
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(convertCelsiumToFahrenheit(40));
    }

    public static double convertCelsiumToFahrenheit(int celsium) {
        //напишите тут ваш код
        return (celsium * 1.8) + 32;
    }
}


//    Метод convertCelsiumToFahrenheit(int celsium) принимает значение в градусах Цельсия. Метод должен переводить температуру и возвращать значение в градусах Фаренгейта.
//        Температура по Цельсию TC и температура по Фаренгейту TF связаны следующим соотношением:
//        TC = (TF – 32) * 5/9
//
//        Пример:
//        В метод convertCelsiumToFahrenheit на вход подается значение 40.
//
//        Пример вывода:
//        104.0