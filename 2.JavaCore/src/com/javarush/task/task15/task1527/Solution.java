package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        char[] data = url.toCharArray();
        boolean check = false;
        String result;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder objBuilder = new StringBuilder();
        Map<String, Object> map = new LinkedHashMap<>();

        for (int i = 0; i < data.length; i++) {
            if (data[i] == '?') {
                check = true;
            }
            if (data[i] != '?' && check == true) {
                stringBuilder.append(data[i]);
            }
        }

        result = stringBuilder.toString();
        data = result.toCharArray();
        check = false;
        stringBuilder.setLength(0);

        for (int i = 0; i < data.length; i++) {
            if (data[i] != '=' && check == false && data[i] != '&') {
                stringBuilder.append(data[i]);
            }
            if (data[i] == '=' && check == false) {
                check = true;
            }
            if (data[i] != '=' && check == true && data[i] != '&') {
                objBuilder.append(data[i]);
            }
            if (data[i] == '&' && check == false) {
                objBuilder.append("noObject");
                check = true;
            }
            if (data[i] == '&' || i == data.length - 1) {
                map.put(stringBuilder.toString(), objBuilder.toString());
                stringBuilder.setLength(0);
                objBuilder.setLength(0);
                check = false;
            }
        }

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.print(entry.getKey() + " ");
        }
        System.out.println();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getKey().equals("obj")) {
                String value = entry.getValue().toString();
                try {
                    if (value.contains(".")) {
                        alert(Double.parseDouble(value));
                    } else if (Integer.parseInt(value) <= 0 || Integer.parseInt(value) > 0) {
                        alert(Double.parseDouble(value));
                    }
                } catch (NumberFormatException e) {
                    alert(value);
                }
            }
        }

    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
