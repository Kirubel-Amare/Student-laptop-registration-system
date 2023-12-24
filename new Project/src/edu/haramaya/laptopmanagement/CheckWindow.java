package edu.haramaya.laptopmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckWindow extends RegistrationWindow{

    // checkWindow Buttons
    protected JButton enterButton;
    protected JButton formatButton;

    // constructor
    public CheckWindow(){
        enterButton= new JButton("Search");
        formatButton=new JButton("Format");
    }
    public static void openRegistrationCheckWindow() {

        // object creation
        RegistrationWindow registrationWindow = new CheckWindow();
        CheckWindow checkWindow = new CheckWindow();

        JFrame thirdWindow = new JFrame("laptop management system");
        thirdWindow.getContentPane().setBackground(new Color(0x2ecc71));
        thirdWindow.setSize(1000, 700);

        JLabel inputCheck = new JLabel("ENTER SERIAL NUMBER");
        inputCheck.setFont(new Font("SANS_SERIF", Font.PLAIN, 20));
        thirdWindow.getContentPane().setLayout(null);
        inputCheck.setForeground(new Color(0xffffff));
        inputCheck.setBounds(382, 230, 310, 30);
        thirdWindow.add(inputCheck);

        JTextField serialField = new JTextField();
        serialField.setBounds(403, 290, 200, 30);
        thirdWindow.add(serialField);

        checkWindow.enterButton.setBounds(380, 340, 100, 30);
        registrationWindow.exitButton.setBounds(520, 400, 100, 30);
        registrationWindow.exitButton.setFocusable(false);
        registrationWindow.backButton.setBounds(10, 15, 80, 30);
        registrationWindow.backButton.setFocusable(false);
        registrationWindow.deleteButton.setBounds(380, 400, 100, 30);
        checkWindow.formatButton.setBounds(520, 340, 100, 30);

        thirdWindow.add(checkWindow.enterButton);
        thirdWindow.add(registrationWindow.exitButton);
        thirdWindow.add(registrationWindow.backButton);
        thirdWindow.add(registrationWindow.deleteButton);
        thirdWindow.add(checkWindow.formatButton);


       JLabel deleted = new JLabel("SUCCESSFULLY DELETED !!");
        deleted.setBounds(390, 550, 400, 50);

        deleted.setFont(new Font("SANS_SERIF", Font.BOLD, 20));
        deleted.setForeground(new Color(0Xffffff));
        deleted.setVisible(false);
        thirdWindow.add(deleted);

        JLabel format = new JLabel("SUCCESSFULLY FORMAT !!");
        deleted.setBounds(390, 550, 400, 50);
        format.setFont(new Font("SANS_SERIF", Font.BOLD, 20));
        format.setForeground(new Color(0Xffffff));
        format.setVisible(false);
        thirdWindow.add(format);

        registrationWindow.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LaptopManagement.openRegistrationFirstWindow();
                thirdWindow.dispose();
            }
        });

        
        registrationWindow.exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        thirdWindow.setVisible(true);
    }
}