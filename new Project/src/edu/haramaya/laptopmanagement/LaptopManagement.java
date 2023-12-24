package edu.haramaya.laptopmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaptopManagement {
    // Buttons
    protected JButton registerButton;
    protected JButton exitButton ;
    protected JButton checkButton ;
    public static JFrame firstFrame;

    // Laptop Management Constructor
    public LaptopManagement(){
        firstFrame=new JFrame("HARAMAYA UNIVERSITY");
        registerButton = new JButton("Register");
        exitButton = new JButton("Exit");
        checkButton = new JButton("Check");
    }

    public static void main(String[] args) {
        new Loading();


    }
    public static void openRegistrationFirstWindow() {

        // object creation for LaptopManagement
        LaptopManagement lmanagement = new LaptopManagement();

        firstFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
        firstFrame.setSize(1000, 700);
        firstFrame.getContentPane().setBackground(new Color(0x2ecc71));

        JLabel titleLabel = new JLabel(" HARAMAYA UNIVERSITY ");
        titleLabel.setForeground(new Color(0xffffff));
        JLabel titleLabel2 = new JLabel(" STUDENT PC CONTROL SYSTEM");
        titleLabel2.setForeground(new Color(0xffffff));
        JLabel titleLabel3 = new JLabel("Let's put the safety and security ");
        titleLabel3.setForeground(new Color(0xffffff));
        JLabel titleLabel4 = new JLabel("of the haramaya student first !!!");
        titleLabel4.setForeground(new Color(0xffffff));

        titleLabel.setFont(new Font("SANS_SERIF", Font.BOLD, 25));
        titleLabel2.setFont(new Font("SANS_SERIF", Font.PLAIN, 21));
        titleLabel3.setFont(new Font("amaze", Font.BOLD, 15));
        titleLabel4.setFont(new Font("amaze", Font.BOLD, 15));

        // Set the position and size of each button
        titleLabel.setBounds(340, 90, 600, 100);
        titleLabel2.setBounds(330, 170, 500, 50);
        titleLabel3.setBounds(390, 530, 500, 50);
        titleLabel4.setBounds(390, 550, 500, 50);

        lmanagement.registerButton.setBounds(340,315,150,30);
        lmanagement.registerButton.setFocusable(false);
        lmanagement.checkButton.setBounds(520, 315, 150, 30);
        lmanagement.checkButton.setFocusable(false);
        lmanagement.exitButton.setBounds(430, 380, 150, 30);
        lmanagement.exitButton.setFocusable(false);

        // Add the buttons to the frame
        firstFrame.getContentPane().setLayout(null);
        firstFrame.add(titleLabel);
        firstFrame.add(titleLabel2);
        firstFrame.add(titleLabel3);
        firstFrame.add(titleLabel4);

        firstFrame.add(lmanagement.registerButton);
        firstFrame.add(lmanagement.checkButton);
        firstFrame.add(lmanagement.exitButton);

        lmanagement.registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RegistrationWindow.openRegistrationWindow();
                firstFrame.setVisible(false);
                firstFrame.dispose();
            }
        });

        lmanagement.checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CheckWindow.openRegistrationCheckWindow();
                firstFrame.setVisible(false);
                firstFrame.dispose();
            }
        });

        lmanagement.exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        firstFrame.setVisible(true);
    }
}


