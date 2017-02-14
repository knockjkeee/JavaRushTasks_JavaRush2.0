package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String temp;
        while (true) {
            temp = reader.readLine();
            try {
                if (temp.equals("exit")) {
                    break;
                } else if (temp.contains(".")) {
                    print(Double.parseDouble(temp));
                } else if (Integer.parseInt(temp) > 0 && Integer.parseInt(temp) < 128) {
                    print(Short.parseShort(temp));
                } else if (Integer.parseInt(temp) <= 0 || Integer.parseInt(temp) >= 128) {
                    print(Integer.parseInt(temp));
                }
            } catch (NumberFormatException e) {
                print(temp);
            }
        }
    }


    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
