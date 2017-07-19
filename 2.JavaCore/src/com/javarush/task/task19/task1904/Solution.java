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
//        try {
//            PersonScannerAdapter rr = new PersonScannerAdapter(new Scanner(Paths.get("d:\\test\\1.txt")));
//            Person pp = rr.read();
//            System.out.println(pp.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public static class PersonScannerAdapter implements PersonScanner {

        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
//            Person person = null;
//            Date birsday;
//            while (fileScanner.hasNext()) {
//                String[] temp = fileScanner.nextLine().split(" ");
//                List<String> name = new ArrayList<>();
//                List<Integer> date = new ArrayList<>();
//                for (String s : temp) {
//                    try {
//                        date.add(Integer.parseInt(s));
//                    } catch (NumberFormatException e) {
//                        name.add(s);
//                    }
//                }
//                birsday = new Date();
//                birsday.setDate(date.get(0));
//                birsday.setMonth(date.get(1) - 1);
//                birsday.setYear(date.get(2) - 1900);
//                person = new Person(name.get(1), name.get(2), name.get(0), birsday);
//            }
//            return person;

            fileScanner = new Scanner(new File("matrix.txt"));
            String line = fileScanner.nextLine();
            String[] string = line.split(" ");
            Date date = new Date(Integer.parseInt(string[3]),Integer.parseInt(string[4]),Integer.parseInt(string[5]));

            return new Person(string[0],string [1], string[2],date);



        }

        @Override
        public void close() {
            fileScanner.close();
        }
    }
}








