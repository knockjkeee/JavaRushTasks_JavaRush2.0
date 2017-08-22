package com.javarush.task.task17.task1710;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут

//        String param = args[0];
        String param = "-u Миронов ж 15/04/1990";
//        String param = "-d 1";
//        String param = "-i 0";
        SimpleDateFormat formatDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        StringBuilder id = new StringBuilder();
        StringBuilder name = new StringBuilder();
        StringBuilder sex = new StringBuilder();
        StringBuilder dateBirthday = new StringBuilder();


        if (param.contains("-c")) {
            int count = 0;

            for (int i = 0; i < param.length(); i++) {
                if (count == 1 && !param.substring(i, i + 1).equals(" ")) {
                    name.append(param.substring(i, i + 1));
                }
                if (count == 2 && !param.substring(i, i + 1).equals(" ")) {
                    sex.append(param.substring(i, i + 1));
                }
                if (count == 3) {
                    dateBirthday.append(param.substring(i));
                    break;
                }
                if (param.substring(i, i + 1).equals(" ")) {
                    count++;
                }
            }

            int day = Integer.parseInt(dateBirthday.toString().substring(0, 2));
            int month = Integer.parseInt(dateBirthday.toString().substring(3, 5)) - 1;
            int year = Integer.parseInt(dateBirthday.toString().substring(6)) - 1900;

            if (sex.toString().equals("м") || sex.toString().equals("М")) {
                allPeople.add(Person.createMale(name.toString(), new Date(year, month, day)));
            } else {
                allPeople.add(Person.createFemale(name.toString(), new Date(year, month, day)));
            }

            for (int i = 0; i < allPeople.size(); i++) {
                if (allPeople.get(i).getName().equals(name.toString())) {
                    System.out.println(i);
                }
            }

        }
        if (param.contains("-u")) {
            int count = 0;

            for (int i = 0; i < param.length(); i++) {
                if (count == 1 && !param.substring(i, i + 1).equals(" ")) {
                    id.append(param.substring(i, i + 1));
                }
                if (count == 2 && !param.substring(i, i + 1).equals(" ")) {
                    name.append(param.substring(i, i + 1));
                }
                if (count == 3 && !param.substring(i, i + 1).equals(" ")) {
                    sex.append(param.substring(i, i + 1));
                }
                if (count == 4 && !param.substring(i, i + 1).equals(" ")) {
                    dateBirthday.append(param.substring(i));
                    break;
                }
                if (param.substring(i, i + 1).equals(" ")) {
                    count++;
                }
            }

            int day = Integer.parseInt(dateBirthday.toString().substring(0, 2));
            int month = Integer.parseInt(dateBirthday.toString().substring(3, 5)) - 1;
            int year = Integer.parseInt(dateBirthday.toString().substring(6)) - 1900;

            for (int i = 0; i < allPeople.size(); i++) {
                if (i == Integer.parseInt(id.toString())) {
                    if (sex.toString().equals("м") || sex.toString().equals("М")) {
                        allPeople.set(i, Person.createMale(name.toString(), new Date(year, month, day)));
                    } else {
                        allPeople.set(i, Person.createFemale(name.toString(), new Date(year, month, day)));
                    }
                }
            }

        }
        if (param.contains("-d")) {
            int count = 0;
            for (int i = 0; i < param.length(); i++) {
                if (count == 1 && !param.substring(i).equals(" ")) {
                    id.append(param.substring(i));
                    break;
                }
                if (param.substring(i, i + 1).equals(" ")) {
                    count++;
                }
            }
            for (int i = 0; i < allPeople.size(); i++) {
                if (i == Integer.parseInt(id.toString())) {
                    allPeople.remove(i);
                }
            }
        }
        if (param.contains("-i")) {
            int count = 0;
            for (int i = 0; i < param.length(); i++) {
                if (count == 1 && !param.substring(i).equals(" ")) {
                    id.append(param.substring(i));
                    break;
                }
                if (param.substring(i, i + 1).equals(" ")) {
                    count++;
                }
            }

            for (int i = 0; i < allPeople.size(); i++) {
                if (i == Integer.parseInt(id.toString())) {
                    if (allPeople.get(i).getSex() == Sex.FEMALE) {
                        System.out.println(allPeople.get(i).getName() + " " + "ж" + " " + formatDate.format(allPeople.get(i).getBirthDay()));
                    } else if (allPeople.get(i).getSex() == Sex.MALE) {
                        System.out.println(allPeople.get(i).getName() + " " + "м" + " " + formatDate.format(allPeople.get(i).getBirthDay()));
                    }
                }
            }
        }


        for (Person person : allPeople) {
            if (person.getSex() == Sex.FEMALE) {
                System.out.println(person.getName() + " " + "ж" + " " + formatDate.format(person.getBirthDay()));
            } else if (person.getSex() == Sex.MALE) {
                System.out.println(person.getName() + " " + "м" + " " + formatDate.format(person.getBirthDay()));
            }
        }
    }
}
