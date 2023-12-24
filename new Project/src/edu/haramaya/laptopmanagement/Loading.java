package edu.haramaya.laptopmanagement;

import java.awt.*;
import javax.swing.*;
public class Loading {
    JFrame frame = new JFrame();
    JProgressBar bar = new JProgressBar(0,100);
    JLabel titleLabel = new JLabel(" HARAMAYA UNIVERSITY ");
    JLabel titleLabel2 = new JLabel(" STUDENT PC CONTROL SYSTEM");

    Loading(){


        titleLabel.setForeground(new Color(0xffffff));
        titleLabel2.setForeground(new Color(0xffffff));
        titleLabel.setFont(new Font("SANS_SERIF", Font.BOLD, 25));
        titleLabel2.setFont(new Font("SANS_SERIF", Font.PLAIN, 21));

        titleLabel.setBounds(340, 90, 600, 100);
        titleLabel2.setBounds(330, 170, 500, 50);

        frame.add(titleLabel);
        frame.add(titleLabel2);

        bar.setValue(0);
        bar.setBounds(150, 400, 700, 50);
        bar.setStringPainted(true);
        bar.setFont(new Font("SANS_SERIF", Font.BOLD, 25));
        bar.setBackground(Color.black);
        bar.setForeground(new Color(0x27ae60));
        frame.add(bar);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Starting a system");
        frame.getContentPane().setBackground(new Color (0x2ecc71));
        frame.setOpacity(1);
        frame.setSize(1000, 700);
        frame.setLayout(null);
        frame.setVisible(true);

        fill();
    }
    public void fill() {

        int counter = 0;
        int after = 0;

        while(counter<=100){

            bar.setValue(counter);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter += 1;
        }
        bar.setString("The System is ready");

        while(after <= 30){

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            after += 1;
        }
        new LoginPage();
        frame.dispose();
    }
}
