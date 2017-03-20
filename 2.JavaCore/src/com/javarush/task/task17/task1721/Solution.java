package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    static {
        String filePathOne;
        String filePathTwo;
        String tempOne;
        String tempTwo;
        BufferedReader readerOneFile;
        BufferedReader readerTwoFile;
        BufferedReader readerFileName = new BufferedReader(new InputStreamReader(System.in));
        try {
            filePathOne = readerFileName.readLine();
            filePathTwo = readerFileName.readLine();
            readerOneFile = new BufferedReader(new InputStreamReader(new FileInputStream(filePathOne)));
            readerTwoFile = new BufferedReader(new InputStreamReader(new FileInputStream(filePathTwo)));
            while ((tempOne = readerOneFile.readLine()) != null) {
                allLines.add(tempOne);
            }
            while ((tempTwo = readerTwoFile.readLine()) != null) {
                forRemoveLines.add(tempTwo);
            }
            readerFileName.close();
            readerOneFile.close();
            readerTwoFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        System.out.println(allLines.size());
//        System.out.println(forRemoveLines.size());
        try {
            sol.joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }
//        System.out.println(allLines.size());
//        System.out.println(forRemoveLines.size());
    }


    public void joinData() throws CorruptedDataException {
        if (checkList()) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }


    public boolean checkList() {
        int count = 0;
        for (int i = 0; i < forRemoveLines.size(); i++) {
            for (String line : allLines) {
                if (line.equals(forRemoveLines.get(i))) {
                    count++;
                }
            }
        }
        if (count == forRemoveLines.size()) {
            return true;
        } else {
            return false;
        }
    }
}
