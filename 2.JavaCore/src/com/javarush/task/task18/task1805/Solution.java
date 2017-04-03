package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        List<Integer> list = new ArrayList<>();

        while (fileInputStream.available() > 0) {
            list.add(fileInputStream.read());
        }
        Collections.sort(list);
        Set<Integer> set = new TreeSet<>();

        for (Integer integer : list) {
            set.add(integer);
        }

        for (Integer integer : set) {
            System.out.print(integer + " ");
        }

        reader.close();
        fileInputStream.close();

    }
}
