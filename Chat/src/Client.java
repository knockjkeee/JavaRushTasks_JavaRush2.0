import net.Net;

import javax.swing.*;

public class Client extends JFrame {
    private JPanel contentpanel;
    private String name;
    private String address;
    private int port;
    private JTextField txtMessage;
    private JTextArea history;
    private boolean connected = false;
    private Net net;

    public Client(String title, String name, String address, int port) {
        this.name = name;
        this.address = address;
        this.port = port;

        connected = net.openConnection(address);
        if (!connected) {
            System.out.println("Connection falied...");
            console("Connection falied..");
        }

        createWindow();

        String connectionPacket = "/c/" + name;
        net.send(connectionPacket.getBytes());
        console("You are trying to connect to: " + address + ", port: " + port + ", user name: " + name);


    }

    /**
    * Create new method  gor {@link Thread}
     * @since  1.0
     * @author asd
     *
    */

    private void createWindow() {
    }

    public void console(String message) {
        history.setCaretPosition(history.getDocument().getLength());
        history.append(message + "\n\r");
    }


}

