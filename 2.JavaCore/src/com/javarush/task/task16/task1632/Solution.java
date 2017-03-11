package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new thread1());
        threads.add(new thread2());
        threads.add(new thread3());
        threads.add(new thread4());
        threads.add(new thread5());
    }

    public static void main(String[] args) {
        for (Thread thread : threads) {
            thread.start();
        }
    }


    public static class thread1 extends Thread {
        @Override
        public void run() {
            while (true) {
            }
        }
    }

    public static class thread2 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class thread3 extends Thread {
        @Override
        public void run() {
            while (!isInterrupted()) {
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class thread4 extends Thread implements Message {
        @Override
        public void run() {
            while (!isInterrupted()) {
            }
        }

        @Override
        public void showWarning() {
            this.interrupt();
            try {
                this.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static class thread5 extends Thread {

        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String temp = null;
            int resultSum = 0;

            while (!isInterrupted()) {
                try {
                    resultSum = resultSum + Integer.parseInt(temp = reader.readLine());
                } catch (Exception e) {
                    if (temp.equals("N")) {
                        System.out.println(resultSum);
//                        interrupt();
//                        return;
                    } else {

                    }
                }
            }
        }
    }
}