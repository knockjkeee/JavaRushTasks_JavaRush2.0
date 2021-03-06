package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {
    String name;
    int age;

    public Solution() {
    }

    protected Solution(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Solution(int age) {
        this.age = age;
    }

    Solution(String name) {
        this.name = name;
    }

    public static void main(String[] args) {

    }
}


//        Перегрузка конструкторов
//        1. В классе Solution создай 4 конструктора конструктора с разными модификаторами доступа.
//        2. В отдельном файле создай класс SubSolution и сделай его потомком класса Solution.
//        3. Внутри класса SubSolution создай конструкторы командой Alt+Insert -> Constructors.
//        4. Исправь модификаторы доступа конструкторов в SubSolution так, чтобы получилось
//        3 конструктора с различными модификаторами доступа(все кроме private).