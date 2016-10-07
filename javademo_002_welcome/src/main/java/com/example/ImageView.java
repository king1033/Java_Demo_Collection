package com.example;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * @Author:king1033
 * @Desc:Java实现简单的图像文件查看器（viewer），加载并显示一个图像
 * @Time:2016/10/7
 */
public class ImageView {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new ImageViewerFrame();
                frame.setTitle("ImageViewer");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);

            }
        });

    }

    /**
     * A frame with a label to show an image
     */
    static class ImageViewerFrame extends JFrame{
        private JLabel label;
        private JFileChooser chooser;
        public static final int DEFAULT_WIDTH = 300;
        public static final int DEFAULT_HEIGHT = 400;

        public ImageViewerFrame(){
            setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

            //use a label to display the images
            label = new JLabel();
            add(label);

            //set up the file chooser
            chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File("."));

            //set up menu bar
            JMenuBar menuBar = new JMenuBar();
            setJMenuBar(menuBar);

            JMenu menu = new JMenu("File");
            menuBar.add(menu);

            JMenuItem openItem = new JMenuItem("Open");
            menu.add(openItem);
            openItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //show file chooser dialog
                    int result = chooser.showOpenDialog(null);

                    //if file seleceted ,set it as icon of the label
                    if(result == JFileChooser.APPROVE_OPTION){
                        String name = chooser.getSelectedFile().getPath();
                        label.setIcon(new ImageIcon(name));
                    }
                }
            });

            JMenuItem exitItem = new JMenuItem("Exit");
            menu.add(exitItem);
            exitItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
        }
    }
}
