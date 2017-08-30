package Test.debug;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImageViewerFrame extends JFrame{

    private JLabel jLabel;
    private static Logger logger = Logger.getLogger("JavaRushHomeWork.project.JavaRushTasks.JavaRushTasks.2.JavaCore.src.Test.debug");
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGT = 400;


    public ImageViewerFrame() {
        logger.entering("ImageViewerFrame", "<init>");
        setTitle("LoggingImageViewer");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGT);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu jMenu = new JMenu("File");
        menuBar.add(jMenu);
        JMenuItem openItem = new JMenuItem("Open");
        jMenu.add(openItem);
        openItem.addActionListener(new FileOpenListener());
        JMenuItem exitItem = new JMenuItem("Exit");
        jMenu.add(exitItem);
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logger.fine("Exiting.");
                System.exit(0);
            }
        });

        jLabel = new JLabel();
        add(jLabel);
        logger.exiting("ImageViewerFrame", "<init>");

    }

    private class FileOpenListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            logger.entering("ImageViewerFrame.FileOpenListener", "actionPerormed", e);
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));
            fileChooser.setFileFilter(new FileFilter() {
                @Override
                public boolean accept(File f) {
                    return f.getName().toLowerCase().endsWith(".gif") || f.isDirectory();
                }
                @Override
                public String getDescription() {
                    return "GIF Image";
                }
            });

            int r = fileChooser.showOpenDialog(ImageViewerFrame.this);
            if (r == fileChooser.APPROVE_OPTION) {
                String name = fileChooser.getSelectedFile().getPath();
                logger.log(Level.FINE, "Reading file {0}", name);
                jLabel.setIcon(new ImageIcon(name));
            } else {
                logger.fine("File open dialog canceled.");
                logger.exiting("ImageViewerFrame.FileOpenListener", "actionPerformed");
            }
        }
    }
}
