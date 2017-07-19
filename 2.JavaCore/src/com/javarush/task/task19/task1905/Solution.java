package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }


    public static void main(String[] args) {

    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            String temp = customer.getCountryName();
            for (Map.Entry<String, String> entry : countries.entrySet()) {
                if (entry.getValue().equals(temp)) {
                    return entry.getKey();
                }
            }
            return null;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String[] arr = contact.getName().split(" ");
            return arr[1];
        }

        @Override
        public String getContactLastName() {
            String[] arr = contact.getName().split(" ");
            return arr[0].substring(0, arr[0].length() - 1);
        }

        @Override
        public String getDialString() {
            String[] split = contact.getPhoneNumber().split("");
            StringBuilder builder = new StringBuilder();
            for (String s : split) {
                int temp = 0;
                try {
                    temp = Integer.parseInt(s);
                    builder.append(temp);
                } catch (NumberFormatException e) {
                }
            }
            return "callto://+" + builder.toString();
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}