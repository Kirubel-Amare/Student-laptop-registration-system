package edu.haramaya.laptopmanagement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class RegistrationWindow extends LaptopManagement{

    // creating buttons
    protected JButton updateButton ;
    protected JButton deleteButton ;
    protected JButton backButton;
    protected ButtonGroup male_female_buttonGroup ;
    protected ButtonGroup window_mac_buttongroup;
    protected  JRadioButton male;
    protected JRadioButton female;
    protected  JRadioButton window;
    protected  JRadioButton mac;
    protected JPanel panel;
    protected JButton refresh ;


    // Registration class Constructor
    public RegistrationWindow(){
        registerButton = new JButton("Register");
        exitButton = new JButton("Exit");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        backButton = new JButton("Back");
        male_female_buttonGroup = new ButtonGroup();
        window_mac_buttongroup = new ButtonGroup();
        male = new JRadioButton("male");
        female = new JRadioButton("female");
        window = new JRadioButton("window");
        mac = new JRadioButton("mac");
        panel = new JPanel();
        refresh = new JButton("Refresh");
    }

    public static void openRegistrationWindow() {

        LaptopManagement laptopManagement = new RegistrationWindow();
        RegistrationWindow registration = new RegistrationWindow();

        JFrame secondFrame = new JFrame("laptop management system");
        secondFrame.getContentPane().setBackground(new Color(0x2ecc71));
        secondFrame.setSize(1000, 700);

        // Set the position and size of each button
        laptopManagement.registerButton.setBounds(10, 490, 130, 25);
        registration.updateButton.setBounds(150, 490, 130, 25);
        laptopManagement.exitButton.setBounds(150, 540, 130, 25);
        registration.backButton.setBounds(10, 7, 75, 21);
        registration.backButton.setFocusable(false);

        // Add the buttons to the frame
        secondFrame.add(laptopManagement.registerButton);
        secondFrame.add(registration.updateButton);
        secondFrame.add(registration.deleteButton);
        secondFrame.add(laptopManagement.exitButton);
        secondFrame.add(registration.backButton);

        JLabel title = new JLabel("Laptop Registration");
        JLabel serialNumber = new JLabel("PC SERIAL");
        JLabel firstname = new JLabel("FIRST NAME");
        JLabel lastname = new JLabel("LAST NAME");
        JLabel student_id = new JLabel("ID");
        JLabel laptop = new JLabel("LAPTOP NAME");
        JLabel department = new JLabel("DEPT.");
        JLabel contact = new JLabel("CONTACT");
        JLabel age = new JLabel("AGE");
        JLabel gender = new JLabel("GENDER");

        // Set the position and size of each label
        title.setBounds(75, 37, 200, 30);
        serialNumber.setBounds(30, 80, 60, 30);
        firstname.setBounds(30, 120, 70, 30);
        lastname.setBounds(30, 160, 80, 30);
        student_id.setBounds(30, 200, 60, 30);
        laptop.setBounds(30, 240, 60, 30);
        department.setBounds(30, 280, 60, 30);
        contact.setBounds(30, 320, 60, 30);
        age.setBounds(30, 360, 60, 30);
        gender.setBounds(30, 400, 60, 30);

        // Add the labels to the frame
        secondFrame.getContentPane().setLayout(null);
        secondFrame.add(title);
        secondFrame.add(serialNumber);
        secondFrame.add(firstname);
        secondFrame.add(lastname);
        secondFrame.add(student_id);
        secondFrame.add(laptop);
        secondFrame.add(department);
        secondFrame.add(contact);
        secondFrame.add(age);
        secondFrame.add(gender);

        JTextField Pc_serialField = new JTextField();
        JTextField firstnameField = new JTextField();
        JTextField lastnameField = new JTextField();
        JTextField student_idField = new JTextField();
        JTextField laptopField = new JTextField();
        JTextField departmentField = new JTextField();
        JTextField contactField = new JTextField();
        JTextField ageField = new JTextField();
        JTextField genderField = new JTextField();

        // Set the position and size of each text field
        Pc_serialField.setBounds(120, 80, 130, 30);
        firstnameField.setBounds(120, 120, 130, 30);
        lastnameField.setBounds(120, 160, 130, 30);
        student_idField.setBounds(120, 200, 130, 30);
        laptopField.setBounds(120, 240, 130, 30);
        departmentField.setBounds(120, 280, 130, 30);
        contactField.setBounds(120, 320, 130, 30);
        ageField.setBounds(120, 360, 130, 30);
        genderField.setBounds(120, 400, 130, 30);

        // Add the text fields to the frame
        secondFrame.add(Pc_serialField);
        secondFrame.add(firstnameField);
        secondFrame.add(lastnameField);
        secondFrame.add(student_idField);
        secondFrame.add(laptopField);
        secondFrame.add(departmentField);
        secondFrame.add(contactField);
        secondFrame.add(ageField);
        secondFrame.add(genderField);


        registration.panel.setLayout(new GridLayout());
        registration.panel.setBounds(300,20,600,600);
        secondFrame.add(registration.panel);


        registration.refresh.setBounds(10,540,130,25);
        secondFrame.add(registration.refresh);

        DefaultTableModel model=new DefaultTableModel();
        JTable table=new JTable(model);
        table.setBounds(400,50,600,800);
        table.getTableHeader().setReorderingAllowed(false);

        model.addColumn("PC SERIAL");
        model.addColumn("FIRST NAME");
        model.addColumn("LAST NAME");
        model.addColumn("ID NO");
        model.addColumn("LAPTOP");
        model.addColumn("DEPARTMENT");
        model.addColumn("CONTACT");
        model.addColumn("AGE");
        model.addColumn("Gender");

        // Enable Scrolling on table
        JScrollPane scrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        registration.panel.add(scrollPane);

        // Make the second window visible
        scrollPane.setVisible(true);
        secondFrame.setVisible(true);

        registration.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secondFrame.setVisible(false);
                LaptopManagement.openRegistrationFirstWindow();
            }
        });

        laptopManagement.exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        registration.refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pc_serialField.setText("");
                firstnameField.setText("");
                lastnameField.setText("");
                student_idField.setText("");
                laptopField.setText("");
                departmentField.setText("");
                contactField.setText("");
                ageField.setText("");
                genderField.setText("");

            }
        });
    }
}


