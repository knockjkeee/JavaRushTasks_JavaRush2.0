package com.javarush.task.task17.task1711;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        SimpleDateFormat formatDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        String id;
        String name;
        String sex;
        String dateBirthday;

        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i = i + 3) {
                        name = args[i];
                        sex = args[i + 1];
                        dateBirthday = args[i + 2];
                        if (sex.equals("м") || sex.equals("М")) {
                            allPeople.add(Person.createMale(name, new Date(Integer.parseInt(dateBirthday.substring(6)) - 1900,
                                    Integer.parseInt(dateBirthday.substring(3, 5)) - 1,
                                    Integer.parseInt(dateBirthday.substring(0, 2)))));
                        } else {
                            allPeople.add(Person.createFemale(name, new Date(Integer.parseInt(dateBirthday.substring(6)) - 1900,
                                    Integer.parseInt(dateBirthday.substring(3, 5)) - 1,
                                    Integer.parseInt(dateBirthday.substring(0, 2)))));
                        }

                        for (int j = 0; j < allPeople.size(); j++) {
                            if (allPeople.get(j).getName().equals(name)) {
                                System.out.println(j);
                            }
                        }
                    }
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i = i + 4) {
                        id = args[i];
                        name = args[i + 1];
                        sex = args[i + 2];
                        dateBirthday = args[i + 3];
                        for (int j = 0; j < allPeople.size(); j++) {
                            if (j == Integer.parseInt(id)) {
                                if (sex.equals("м") || sex.equals("М")) {
                                    allPeople.set(j, Person.createMale(name, new Date(Integer.parseInt(dateBirthday.substring(6)) - 1900,
                                            Integer.parseInt(dateBirthday.substring(3, 5)) - 1,
                                            Integer.parseInt(dateBirthday.substring(0, 2)))));
                                } else {
                                    allPeople.set(j, Person.createFemale(name, new Date(Integer.parseInt(dateBirthday.substring(6)) - 1900,
                                            Integer.parseInt(dateBirthday.substring(3, 5)) - 1,
                                            Integer.parseInt(dateBirthday.substring(0, 2)))));
                                }
                            }
                        }
                    }
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        id = args[i];
                        for (int j = 0; j < allPeople.size(); j++) {
                            if (j == Integer.parseInt(id)) {
                                Person person = allPeople.get(j);
                                person.setName(null);
                                person.setBirthDay(null);
                                person.setSex(null);
                            }
                        }
                    }
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        id = args[i];
                        for (int j = 0; j < allPeople.size(); j++) {
                            if (j == Integer.parseInt(id)) {
                                if (allPeople.get(j).getSex() == Sex.FEMALE) {
                                    System.out.println(allPeople.get(j).getName() + " " + "ж" + " " + formatDate.format(allPeople.get(j).getBirthDay()));
                                } else if (allPeople.get(j).getSex() == Sex.MALE) {
                                    System.out.println(allPeople.get(j).getName() + " " + "м" + " " + formatDate.format(allPeople.get(j).getBirthDay()));
                                }
                            }
                        }
                    }
                }
                break;
        }
//        for (Person person : allPeople) {
//            System.out.println(person.getName() + " " + person.getSex() + " " + formatDate.format(person.getBirthDay()));
//        }
    }
}

