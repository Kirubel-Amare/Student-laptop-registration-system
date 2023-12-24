package edu.haramaya.laptopmanagement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.*;
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

        laptopManagement. registerButton.addActionListener(e -> {
            String url = "jdbc:sqlite:student.db";
            String Pc_serial = Pc_serialField.getText();
            String firstname1 = firstnameField.getText();
            String lastname1 =lastnameField.getText();
            String student_id1 = student_idField.getText();
            String laptop1 =laptopField.getText();
            String department1 =departmentField.getText();
            String contact1 = contactField.getText();
            String age1 = ageField.getText();
            String gender1 = genderField.getText();

                        boolean valid_pc_serial = isValidSerialNumber(Pc_serial);
            if (!(valid_pc_serial)){
                Pc_serialField.setForeground(Color.RED);
                Pc_serialField.setText("");
                Pc_serialField.setText("invalid pc_serial");
                return;
            }

            boolean validFirstName = isVAlidName(firstname1);
            if (!(validFirstName)){
                firstnameField.setForeground(Color.RED);
                firstnameField.setText("");
                firstnameField.setText("invalid name");
                return;
            }

            boolean validLastName = isVAlidName(lastname1);
            if(!(validLastName)){
                lastnameField.setForeground(Color.RED);
                lastnameField.setText("");
                lastnameField.setText("invalid name");
                return;
            }

            boolean valid_id =  isvalidateId(student_id1);
            if (!(valid_id)){
                student_idField.setForeground(Color.RED);
                student_idField.setText("");
                student_idField.setText("ivalidid");
                return;
            }

            boolean valid_laptop = isValidLaptop(laptop1);
            if(!(valid_laptop)){
                laptopField.setText("");
                laptopField.setForeground(Color.RED);
                laptopField.setText("invalid laptop name");
                return;
            }

            boolean valid_department = isValidDepartment(department1);
            if (!(valid_department)){
                departmentField.setText("");
                departmentField.setForeground(Color.RED);
                departmentField.setText("incorrect department name");
                return;
            }

            boolean valid_contact = isvalidContactNumber(contact1);
            if (!(valid_contact)){
                contactField.setText("");
                contactField.setForeground(Color.RED);
                contactField.setText("incorrect phone number");
                return;
            }

            boolean validAge = isValidAge(age1);
            if (!(validAge)){
                ageField.setText("");
                ageField.setForeground(Color.RED);
                ageField.setText("incorrect age");
                return;
            }

            if (!(gender1.equals("F") || gender1.equals("M") ||gender1.equals("m") || gender1.equals("f") ) ){
                genderField.setText("invalid sex");
                return;
            }

            DefaultTableModel model1 = (DefaultTableModel) table.getModel();
            model1.addRow(new Object[]{Pc_serial, firstname1, lastname1, student_id1, laptop1, department1, contact1, age1, gender1});

            // Clear the input fields
            Pc_serialField.setText("");
            firstnameField.setText("");
            lastnameField.setText("");
            student_idField.setText("");
            laptopField.setText("");
            departmentField.setText("");
            contactField.setText("");
            ageField.setText("");
            genderField.setText("");

            String createTableSql = "CREATE TABLE IF NOT EXISTS student (" +
                    "Pc_serial String PRIMARY KEY," +
                    "first_name VARCHAR(50) NOT NULL," +
                    "last_name VARCHAR(50) NOT NULL," +
                    "student_id VARCHAR(10) UNIQUE NOT NULL," +
                    "Laptop VARCHAR(50) NOT NULL," +
                    "Department VARCHAR(50) NOT NULL," +
                    "Contact String NOT NULL," +
                    "age INTEGER NOT NULL," +
                    "Gender CHAR(1) NOT NULL" +
                    ");";

            try(
                    Connection conn = DriverManager.getConnection(url);
                    Statement stmt = conn.createStatement()){

                stmt.executeUpdate(createTableSql);
                String insertSql = "INSERT INTO student (Pc_serial, first_name, last_name, Department, Laptop, student_id, Contact, age, Gender) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(insertSql);
                pstmt.setString(1, Pc_serial);
                pstmt.setString(2, firstname1);
                pstmt.setString(3, lastname1);
                pstmt.setString(4, department1);
                pstmt.setString(5, laptop1);
                pstmt.setString(6, student_id1);
                pstmt.setString(7, contact1);
                pstmt.setString(8, age1);
                pstmt.setString(9, String.valueOf(gender1));

                pstmt.executeUpdate();

            } catch (SQLException ex) {
                System.err.format("An error occurred: %s", ex.getMessage());
                JOptionPane.showMessageDialog(null, "error occurred: Pc_serial try again!");

            }
            firstFrame.dispose();
        });

        registration.updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:sqlite:student.db";

                try (Connection conn = DriverManager.getConnection(url)){
 
                    String Pc_serial = Pc_serialField.getText();
                    if (Pc_serial.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please enter a serial number");
                        return;
                    }

                    Pc_serial = Pc_serialField.getText();
                    String firstName = firstnameField.getText();
                    String lastName = lastnameField.getText();
                    String studentId=student_idField.getText();
                    String laptop = laptopField.getText();
                    String department =departmentField.getText();
                    String contact = contactField.getText();
                    String age = ageField.getText();
                    String gender = genderField.getText();

                    String selectSql = "SELECT * FROM student WHERE Pc_serial=?";
                    PreparedStatement selectStatement = conn.prepareStatement(selectSql);
                    selectStatement.setString(1, Pc_serial);
                    ResultSet resultSet = selectStatement.executeQuery();

                    if (resultSet.next()) {

                        // If there is a matching record, retrieve the information
                        String lastFirstName = resultSet.getString("first_name");
                        String lastLastName = resultSet.getString("last_name");
                        String lastStudentId = resultSet.getString("student_id");
                        String lastLaptop = resultSet.getString("Laptop");
                        String lastDepartment = resultSet.getString("Department");
                        String lastContact = resultSet.getString("Contact");
                        String lastAge = resultSet.getString("age");
                        String lastGender = resultSet.getString("Gender");

                        // Update the GUI fields with the last information
                        firstnameField.setText(lastFirstName);
                        lastnameField.setText(lastLastName);
                        student_idField.setText(lastStudentId);
                        laptopField.setText(lastLaptop);
                        departmentField.setText(lastDepartment);
                        contactField.setText(lastContact);
                        ageField.setText(lastAge);
                        genderField.setText(lastGender);

                        String updateSql = "UPDATE student SET Pc_serial=?, first_name=?, last_name=?, student_id=?, Laptop=?, Department=?, Contact=?, age=?, Gender=? WHERE Pc_serial=?";
                        PreparedStatement preparedStatement = conn.prepareStatement(updateSql);
                        preparedStatement.setString(1, Pc_serial);
                        preparedStatement.setString(2, firstName);
                        preparedStatement.setString(3, lastName);
                        preparedStatement.setString(4, studentId);
                        preparedStatement.setString(5, laptop);
                        preparedStatement.setString(6, department);
                        preparedStatement.setString(7, contact);
                        preparedStatement.setString(8, age);
                        preparedStatement.setString(9, String.valueOf(gender));
                        preparedStatement.setString(10, Pc_serial);
                        preparedStatement.executeUpdate();

                    } else {
                        // If no matching record is found, display an error message
                        JOptionPane.showMessageDialog(null, "Record not found for serial number: " + Pc_serialField.getText());
                    }
                } catch (SQLException s) {
                    System.err.format("An error occurred: %s", s.getMessage());
                    JOptionPane.showMessageDialog(null, "Error occurred. Please try again!");
                }  
        
        });
    

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
    

/**
     * The function "validateId_input" checks if the input idno is valid by matching it against a
     * regular expression pattern.
     *
     * @param idno The idno parameter is a string representing an identification number.
     * @return The method is returning a boolean value, which indicates whether the idno input is valid
     * or not.
     */
    private static boolean isvalidateId(String idno){
        boolean isValidId = true;
        try {
            String id_matches = "[0-9/T]{6,8}";

            if(!idno.matches(id_matches)){
                JOptionPane.showMessageDialog(null, "Please enter a idno (six digit and backslash only).", "Invalid id_No", JOptionPane.ERROR_MESSAGE);
                isValidId = false;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return isValidId;
    }

    /**
     * The function isVAlidName checks if a given input name is valid, meaning it only contains letters
     * and spaces.
     *
     * @param inputname The input name that needs to be validated.
     * @return The method is returning a boolean value, which indicates whether the input name is valid
     * or not.
     */
    private static boolean isVAlidName(String inputname){
        boolean isValidName = true;
        try {

            String name_matches = "[a-zA-Z]+([ -][a-zA-Z]+)*";

            if (!inputname.matches(name_matches)) {
                JOptionPane.showMessageDialog(null, "Please enter a  correct name (letter s and spaces only).", "Invalid name", JOptionPane.ERROR_MESSAGE);
                isValidName = false;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return isValidName;
    }

    /**
     * The function checks if a given department name is valid, which means it only contains letters
     * and spaces.
     *
     * @param department The parameter "department" is a string that represents the name of a
     * department.
     * @return The method is returning a boolean value, which indicates whether the department name is
     * valid or not.
     */
    private static  boolean isValidDepartment(String department){
        boolean isvalidDep = true;

        try {
            String departmen_matches  = "^[a-zA-Z\\s]+$";

            if (!department.matches(departmen_matches)) {
                JOptionPane.showMessageDialog(null, "Please enter a  correct department name (letters and spaces only).", "Invalid department name", JOptionPane.ERROR_MESSAGE);
                isvalidDep = false;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return isvalidDep;
    }

    /**
     * The function checks if a given serial number is valid by matching it against a regular
     * expression pattern.
     *
     * @param serialNumber The serial number of a PC.
     * @return The method is returning a boolean value, which indicates whether the given serial number
     * is valid or not.
     */
    private static boolean isValidSerialNumber(String serialNumber) {
        boolean isValidSerial = true;
        try {
            String pcSerialNumber_matches = "[a-zA-Z0-9]{6,12}";

            if (!serialNumber.matches(pcSerialNumber_matches)) {
                JOptionPane.showMessageDialog(null, "Please enter a  correct your pc serail Number (letters and number only).", "Invalid pc serial number", JOptionPane.ERROR_MESSAGE);
                isValidSerial = false;
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return isValidSerial;
    }

    /**
     * The function checks if a given laptop name is valid by comparing with correct laptop  name
     * @return The method is returning a boolean value, which indicates whether the given laptop Name
     * is valid or not.
     */
    private  static  boolean isValidLaptop(String laptop){
        boolean vali_laptp = false;
        String [] laptops = {"hp","Dell","Toshiba","apple","chromebook"};
        for (String pc :laptops){
            if (pc.equalsIgnoreCase(laptop)){
                return  true;
            }
        }
        return  vali_laptp;
    }

    /**
     * The function isvalidContactNumber checks if a given contact number is valid by matching it
     * against a regular expression pattern.
     *
     * @param contactNumber The contact number that needs to be validated.
     * @return The method is returning a boolean value, which indicates whether the contact number is
     * valid or not.
     */
    private static boolean  isvalidContactNumber(String contactNumber){
        boolean isValidContact = true;

        try {
            String contact_matches = "^09[0-9]{8}";

            if (!contactNumber.matches(contact_matches)) {
                JOptionPane.showMessageDialog(null, "Please enter a  correct your contact Number (start with 09 and can't exceed 10 digit).", "Invalid contact Number", JOptionPane.ERROR_MESSAGE);
                isValidContact = false;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return isValidContact;
    }
    /**
     * The function is validAge checks if a given  age is valid by matching it
     * against a regular expression pattern.
     // @param validAge The contact number that needs to be validated.
     * @return The method is returning a boolean value, which indicates whether the age is
     * valid or not.
     */
    private  static  boolean isValidAge(String age){
        boolean validAge = true;
        String valid_age_matches = "[1-9]{1,2}";

        if(!(age.matches(valid_age_matches))){
            JOptionPane.showMessageDialog(null, "Please enter a  correct age.", "Invalid Age", JOptionPane.ERROR_MESSAGE);
            validAge = false;
        }
        return  validAge;

    }
}
}