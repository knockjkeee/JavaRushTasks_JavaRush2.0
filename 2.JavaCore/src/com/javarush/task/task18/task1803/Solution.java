package com.javarush.task.task18.task1803;

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
        boolean isCheck;
        while (inputStream.available() > 0) {
            isCheck = false;
            temp = inputStream.read();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getKey() == temp) {
                    entry.setValue(entry.getValue() + 1);
                    isCheck = true;
                }
            }
            if (!isCheck) {
                map.put(temp, 1);
            }
        }

        int maxValue = 0;
//        int resultKey = 0;
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                list.clear();
                list.add(entry.getKey());
            } else if (entry.getValue() == maxValue) {
                list.add(entry.getKey());
            }
        }
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }
//
//        System.out.println("*******");
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        reader.close();
        inputStream.close();
    }
}

//        int firstCase = 0;
//        int count = 0;
//        int resultCount = 0;
//        int resultByte = 0;

//        int temp;
//        List<Integer> list = new ArrayList<>();
//        List<Integer> result = new ArrayList<>();
//
//        while (inputStream.available() > 0) {
//            temp = inputStream.read();
//            list.add(temp);
//            for (Integer integer : list) {
//                firstCase = integer;
//                for (Integer i : list) {
//                    if (i == firstCase) {
//                        count++;
//                    }
//                }
//
//                if (resultCount < count) {
//                    resultCount = count;
//                    resultByte = firstCase;
//                }
//                count = 0;
//            }
//        }
//        reader.close();
//        inputStream.close();
//
//        for (Integer integer : list) {
//            if (integer == resultByte) {
//                result.add(integer);
//            }
//        }
//
////        for (Integer integer : list) {
////            System.out.print(integer);
////            System.out.print(" ");
////        }
//
//
//
//        for (Integer integer : result) {
//            System.out.print(integer);
//            System.out.print(" ");
//        }
////        System.out.println();
////        System.out.println(resultCount);
////        System.out.println(resultByte);
////        System.out.println(firstCase);
//
////        reader.close();
////        inputStream.close();
//    }

