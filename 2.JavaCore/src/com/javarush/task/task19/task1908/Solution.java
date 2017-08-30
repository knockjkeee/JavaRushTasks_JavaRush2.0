package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        Pattern p = Pattern.compile("\\b[0-9]+\\b");
        BufferedReader inputStream = new BufferedReader(new FileReader(file1));
        BufferedWriter outputStream = new BufferedWriter(new FileWriter(file2));
        StringBuilder builder = new StringBuilder();

        while (inputStream.ready()) {
            String temp = inputStream.readLine();
            Matcher m = p.matcher(temp);
            while (m.find()) {
                builder.append(m.group() + " ");
            }
            builder.deleteCharAt(builder.length() - 1);
            outputStream.write(builder.toString());
            outputStream.flush();
        }
        reader.close();
        inputStream.close();
        outputStream.close();
    }
}
