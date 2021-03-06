package com.javarush.task.task15.task1529;

/*
Осваивание статического блока
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
        try {
            reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //add your code here - добавьте код тут
    }

    public static Flyable result;

    public static void reset() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        if (s.equals("helicopter")) {
            result = new Helicopter();
        } else if (s.equals("plane")) {
            int temp = Integer.parseInt(reader.readLine());
            result = new Plane(temp);
        }
        reader.close();
        //add your code here - добавьте код тут
    }
}
//        3.2. Если параметр равен «helicopter«, то статическому объекту Flyable result присвоить объект класса Helicopter.
//        3.3. Если параметр равен «plane«, то считать второй параметр типа int(количество пассажиров), статическому объекту Flyable result присвоить
//          объект класса Plane.
//        4. В статическом блоке инициализировать Flyable result вызвав метод reset.
//        5. Закрыть поток ввода методом close().