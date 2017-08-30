package Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main3 {

    public static void main(String[] args) {
        String temp = "a s d f 123 33 1";
        Pattern pattern = Pattern.compile("\\b[0-9]+\\b");
        Matcher matcher = pattern.matcher(temp);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
//        System.out.println(matcher.matches());

//        String[] split = temp.split("\\b[0-9]\\b");
//
//        for (String s : split) {
//            System.out.println(s);
//        }
    }

}
