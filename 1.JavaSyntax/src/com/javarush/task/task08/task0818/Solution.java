package com.javarush.task.task08.task0818;

/*
Только для богачей
*/

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> result = new HashMap<>();
        result.put("Rostov", 100);
        result.put("Rostov1", 200);
        result.put("Rostov2", 400);
        result.put("Rostov3", 500);
        result.put("Rostov4", 600);
        result.put("Rostov5", 700);
        result.put("Rostov6", 500);
        result.put("Rostov7", 800);
        result.put("Rostov8", 900);
        result.put("Rostov9", 300);
        return result;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            int a = it.next().getValue();
            if (a < 500) {
                it.remove();
            }
        }
    }

    public static void main(String[] args) {

    }
}

//        Создать словарь (Map<String, Integer>) и занести в него десять записей по принципу: «фамилия» — «зарплата».
//        Удалить из словаря всех людей, у которых зарплата ниже 500.
