package Socket.Protokol_HTTP_HTML;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{

//        try (Socket socket = new Socket()) {
//            socket.connect(new InetSocketAddress("india.colorado.edu", 13), 2000);
//            InputStream inputStream = socket.getInputStream();
//            Scanner sc = new Scanner(inputStream);
//
//            while (sc.hasNextLine()) {
//                String str = sc.nextLine();
//                System.out.println(str);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        URLConnection  connection = new URL("http://www.google.com/").openConnection();
////        InputStream inputStream = connection.getInputStream();
//        Scanner sc = new Scanner(connection.getInputStream());
//
//        while (sc.hasNextLine()) {
//            System.out.println(sc.nextLine());
//        }
        URLConnection connection = new URL("http://www.google.com/").openConnection();
        Scanner scanner = new Scanner(connection.getInputStream());
        scanner.useDelimiter("\\Z");
        System.out.println(scanner.next());

    }
}
