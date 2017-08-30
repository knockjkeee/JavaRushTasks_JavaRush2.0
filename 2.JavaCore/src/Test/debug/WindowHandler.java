package Test.debug;

import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

public class WindowHandler extends StreamHandler{
    JFrame frame;

    @Override
    public void publish(LogRecord record) {
        if (!frame.isVisible()) {
            return;
        }
        super.publish(record);
        flush();
    }

    public WindowHandler() {
        frame = new JFrame();
        final JTextArea output = new JTextArea();
        output.setEnabled(false);
        output.setSize(200, 200);
        frame.add(new JScrollPane(output));
        frame.setVisible(true);

        setOutputStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {

            }

            @Override
            public void write(byte[] b, int off, int len) throws IOException {
                output.append(new String(b, off, len));
            }
        });


    }
}
