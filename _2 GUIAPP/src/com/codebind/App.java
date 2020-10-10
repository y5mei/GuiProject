package com.codebind;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    private JButton buttonmsg;
    private JPanel panelMain;

    public App() {
        buttonmsg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(null, "Hellow World");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("APP");       // 1st, set a frame
        frame.setContentPane(new App().panelMain);      // 2nd set a pane inside of the frame
        frame.setDefaultCloseOperation(JFrame.TEXT_CURSOR);
        frame.pack();

        ImageIcon img = new ImageIcon("40x50xiaozhu.png");
        frame.setIconImage(img.getImage());

        frame.setVisible(true);
    }

}
