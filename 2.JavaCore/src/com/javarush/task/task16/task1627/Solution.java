package com.javarush.task.task16.task1627;


import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        OnlineGame onlineGame = new OnlineGame();
        onlineGame.start();
    }

    public static class OnlineGame extends Thread {
        public static volatile boolean isWinnerFound = false;

        public static List<String> steps = new ArrayList<String>();

        static {
            steps.add("Начало игры");
            steps.add("Сбор ресурсов");
            steps.add("Рост экономики");
            steps.add("Убийство врагов");
        }

        protected Gamer gamer1 = new Gamer("Ivanov", 3);
        protected Gamer gamer2 = new Gamer("Petrov", 1);
        protected Gamer gamer3 = new Gamer("Sidorov", 5);

        public void run() {
            gamer1.start();
            gamer2.start();
            gamer3.start();

            while (!isWinnerFound) {
            }
            gamer1.interrupt();
            gamer2.interrupt();
            gamer3.interrupt();
        }
    }

    public static class Gamer extends Thread {
        private int rating;

        public Gamer(String name, int rating) {
            super(name);
            this.rating = rating;
        }

        @Override
        public void run() {
            try {
                for (String step : OnlineGame.steps) {
                    System.out.println(getName() + ":" + step);
                    Thread.sleep(1000 / rating);
                }
//                OnlineGame.isWinnerFound = true;
//                System.out.println(getName() + ":победитель!");
                if (!OnlineGame.isWinnerFound) {
                    OnlineGame.isWinnerFound = true;
                    System.out.println(getName() + ":победитель!");
                }
            } catch (InterruptedException e) {
                System.out.println(getName() + ":проиграл");
                return;
            }


//            for (int i = 0; i < OnlineGame.steps.size(); i++) {
//                System.out.println(Thread.currentThread().getName() + ":" + OnlineGame.steps.get(i));
//                try {
//                    Thread.sleep(1000 / rating);
//                } catch (InterruptedException e) {
//                    System.out.println(Thread.currentThread().getName() + ":проиграл");
//                    break;
//                }
//            }
//            if (!OnlineGame.isWinnerFound) {
//                OnlineGame.isWinnerFound = true;
//                System.out.println(Thread.currentThread().getName() + ":победитель!");
//            }
//            int count = 0;
//            while (!isInterrupted()) {
//                try {
//                    for (String step : OnlineGame.steps) {
//                        if (!OnlineGame.isWinnerFound) {
//                            Thread.sleep(1000 / rating);
//                            System.out.println(Thread.currentThread().getName() + ":" + step);
//                            count++;
//                        }
//                    }
//                    if (count == OnlineGame.steps.size()) {
//                        System.out.println(Thread.currentThread().getName() + ":победитель!");
//                    } else if (count < OnlineGame.steps.size()) {
//                        System.out.println(Thread.currentThread().getName() + ":проиграл");
//                    }
//                    OnlineGame.isWinnerFound = true;
//                    return;
//                } catch (InterruptedException e) {
//                }
//            }
        }
    }
}
