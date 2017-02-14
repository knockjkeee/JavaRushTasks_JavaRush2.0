package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики 1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(1.0, "One");
        labels.put(1.1, "One1");
        labels.put(1.2, "One2");
        labels.put(1.3, "One3");
        labels.put(1.4, "One4");
    }


    public static void main(String[] args) {
        System.out.println(labels);
    }
}


//    В статическом блоке инициализировать labels 5 различными парами ключ-значение.