package Test.debug;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingImageViewer {

    public static void main(String[] args) {
        if (System.getProperty("java.class.logging.config.class") == null &&
                System.getProperty("java.class.logging.config.file") == null) {
            Logger.getLogger("JavaRushHomeWork.project.JavaRushTasks.JavaRushTasks.2.JavaCore.src.Test.debug").setLevel(Level.ALL);
            final int LOG_ROTATION_COUNT = 10;
            try {
                Handler handler = new FileHandler("%h/LoggingImageViewer.log", 0, LOG_ROTATION_COUNT);
                Logger.getLogger("JavaRushHomeWork.project.JavaRushTasks.JavaRushTasks.2.JavaCore.src.Test.debug").addHandler(handler);
            } catch (IOException e) {
                Logger.getLogger("JavaRushHomeWork.project.JavaRushTasks.JavaRushTasks.2.JavaCore.src.Test.debug").log(Level.SEVERE, "Can`t create log file handler", e);
            }
        }

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Handler handler = new WindowHandler();
                handler.setLevel(Level.ALL);
                Logger.getLogger("JavaRushHomeWork.project.JavaRushTasks.JavaRushTasks.2.JavaCore.src.Test.debug").addHandler(handler);
                JFrame jFrame = new ImageViewerFrame();
                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Logger.getLogger("JavaRushHomeWork.project.JavaRushTasks.JavaRushTasks.2.JavaCore.src.Test.debug").fine("Showing frame");
                jFrame.setVisible(true);
            }
        });


    }
}
