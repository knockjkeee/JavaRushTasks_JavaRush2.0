package com.javarush.task.task09.task0918;

/* 
Все свои, даже исключения
*/

import java.io.FileNotFoundException;

public class Solution {
    public static void main(String[] args) {
    }
    
    static class MyException extends NullPointerException{
    }

    static class MyException2 extends ArithmeticException{
    }

    static class MyException3 extends FileNotFoundException{
    }

    static class MyException4 extends ClassNotFoundException{
    }
}



//        Все свои, даже исключения
//        Есть четыре класса MyException, MyException2, MyException3, MyException4.
//        Унаследуй классы так, чтобы у тебя появилось любые два checked исключения и любые два unchecked исключения.
//
//        Подсказка:
//        Изучи внимательно классы Exception1, Exception2, Exception3 из второй задачи этого блока.