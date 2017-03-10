package Test;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        StringBuilder bb = new StringBuilder();
        String temp = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\Test\\1.txt")));
            while ((temp = reader.readLine()) != null) {
                bb.append(temp);
                bb.append(" ");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        temp = String.valueOf(bb).trim();
        System.out.println(temp);

    }
}
