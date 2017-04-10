package Test;

public class Main {
    public static void main(String[] args) {
        String s = "name.1.part3.txt";
        String temp = s.substring(s.length() - 4, s.length());

        System.out.println(temp);
    }
}
