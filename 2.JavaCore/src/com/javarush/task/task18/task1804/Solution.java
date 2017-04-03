package com.javarush.task.task18.task1804;

/*
Самые редкие байты
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = reader.readLine();
        FileInputStream inputStream = new FileInputStream(filePath);
        Map<Integer, Integer> map = new HashMap<>();
        int temp;

        while (inputStream.available() > 0) {
            temp = inputStream.read();
            if (map.containsKey(temp)) {
                for (Map.Entry<Integer, Integer> interMap : map.entrySet()) {
                    if (interMap.getKey() == temp) {
                        interMap.setValue(interMap.getValue() + 1);
                    }
                }
            }else {
                map.put(temp, 1);
            }
        }

        int maxValue = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
            }
        }
        int mixValue = maxValue;

        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() < mixValue) {
                mixValue = entry.getValue();
                list.clear();
                list.add(entry.getKey());
            } else if (entry.getValue() == mixValue) {
                list.add(entry.getKey());
            }
        }

        for (Integer print : list) {
            System.out.print(print + " ");
        }
        reader.close();
        inputStream.close();


    }
}
