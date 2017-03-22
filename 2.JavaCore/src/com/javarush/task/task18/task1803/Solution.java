package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = reader.readLine();
        FileInputStream inputStream = new FileInputStream(filePath);

        int temp;
        List<Integer> list = new ArrayList<>();

        while (inputStream.available() > 0) {
            temp = inputStream.read();
            list.add(temp);
        }

        int firstCase = 0;
        int count = 0;
        int resultCount = 0;
        int resultByte = 0;

        for (Integer integer : list) {
            firstCase = integer;
            for (Integer i : list) {
                if (i == firstCase) {
                    count++;
                }
            }

            if (resultCount < count) {
                resultCount = count;
                resultByte = firstCase;
            }
            count = 0;
        }


        for (Integer integer : list) {
            System.out.print(integer);
            System.out.print(" ");
        }
        System.out.println();
        System.out.println(resultCount);
        System.out.println(resultByte);
        System.out.println(firstCase);

        reader.close();
        inputStream.close();
    }
}
