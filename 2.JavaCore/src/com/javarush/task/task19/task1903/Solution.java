package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
    }

    public static class IncomeDataAdapter implements Contact, Customer {
        private IncomeData data;

        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            String temp = data.getCountryCode();
            for (Map.Entry<String, String> entry : countries.entrySet()) {
                if (entry.getKey().equals(temp)) {
                    return entry.getValue();
                } else {
                    return null;
                }
            }
            return null;
        }

        @Override
        public String getName() {
            String result = data.getContactLastName() + ", " + data.getContactFirstName();
            return result;
        }

        @Override
        public String getPhoneNumber() {
            DecimalFormat pp = new DecimalFormat("0000000000");
            String result = pp.format(data.getPhoneNumber());
            MessageFormat mm = new MessageFormat("({0}){1}-{2}-{3}");
            String[] arr = {result.substring(0, 3), result.substring(3, 6), result.substring(6, 8), result.substring(8)};
            return "+" + data.getCountryPhoneCode() + mm.format(arr);
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
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