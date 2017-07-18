package com.javarush.task.task19.task1904;

/*
И еще один адаптер
*/

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try {
            PersonScannerAdapter rr = new PersonScannerAdapter(new Scanner(new File("d:\\\\test/1.txt")));
            Person pp = rr.read();
            System.out.println(pp.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class PersonScannerAdapter implements PersonScanner {

        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
//            List<String> list = new ArrayList<>();
//            fileScanner = new Scanner(new File("d://test/1.txt"));
            Person test = null;
            while (fileScanner.hasNext()) {
                String temp = fileScanner.nextLine();
                test = new Person(temp, temp, temp, new Date());
            }
            return test;
        }

        @Override
        public void close() {
            fileScanner.close();
        }
    }

    }

