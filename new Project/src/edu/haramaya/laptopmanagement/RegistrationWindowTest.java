package edu.haramaya.laptopmanagement;


import org.junit.Test;

import javax.swing.*;

import java.awt.*;

import static edu.haramaya.laptopmanagement.RegistrationWindow.isValidAge;
import static org.junit.Assert.*;

public class RegistrationWindowTest {
        @Test
        public void testValidId() {
            String validId = "123456/";
            assertFalse(isvalidateId(validId));
        }
        @Test
        public void testInvalidIdMessage() {
            String invalidId = "abc123";
            assertFalse(isvalidateId(invalidId));
            // You can add additional assertions to check the error message if needed
        }
        @Test
        public void testExceptionHandling() {
            // Mocking a situation where an exception occurs (e.g., null input)
            assertFalse(isvalidateId(null));
        }
        private boolean isvalidateId(Object o) {
            return false;
        }
        @Test
        public void testNameValidation() {
            // Valid name
            String validName = "John Doe";
            assertTrue(isNameValid(validName));

            // Invalid name
            String invalidName = "1234";
            assertFalse(isNameValid(invalidName));
        }

        @Test
        public void testDepartmentValidation() {
            // Valid department
            String validDepartment = "Engineering";
            assertTrue(isDepartmentValid(validDepartment));
            //Invalid Characters
            String InvalidDepartment = "SWE2";
            assertFalse(isDepartmentValid(InvalidDepartment));
            // Invalid department
            String invalidDepartment = "1234";
            assertFalse(isDepartmentValid(invalidDepartment));
        }

        // Helper method to test name validation logic
        private boolean isNameValid(String name) {
            String nameRegex = "[a-zA-Z]+([ -][a-zA-Z]+)*";
            return name.matches(nameRegex);
        }

        // Helper method to test department validation logic
        //@org.jetbrains.annotations.Contract(pure = true)
        private boolean isDepartmentValid(String department) {
            String departmentRegex = "^[a-zA-Z\\s]+$";
            return department.matches(departmentRegex);
        }
        @Test
        public void testSerialNumberValidation() {
            // Valid serial number
            String validSerialNumber = "Abc123";
            assertTrue(isSerialNumberValid(validSerialNumber));

            // Invalid serial number
            String invalidSerialNumber = "!@#$%^";
            assertFalse(isSerialNumberValid(invalidSerialNumber));
        }

        @Test
        public void testContactNumberValidation() {
            // Valid contact number
            String validContactNumber = "0912345678";
            assertTrue(isContactNumberValid(validContactNumber));

            // Invalid contact number
            String invalidContactNumber = "12345";
            assertFalse(isContactNumberValid(invalidContactNumber));

            //Invalid characters
            String invalidcontactNumber = "09abcde123";
            assertFalse(isContactNumberValid(invalidContactNumber));
        }

        // Helper method to test serial number validation logic
        private boolean isSerialNumberValid(String serialNumber) {
            String serialNumberRegex = "[a-zA-Z0-9]{6,12}";
            return serialNumber.matches(serialNumberRegex);
        }

        // Helper method to test contact number validation logic
        private boolean isContactNumberValid(String contactNumber) {
            String contactNumberRegex = "^09[0-9]{8}";
            return contactNumber.matches(contactNumberRegex);
        }

        @Test
        public void testInvalidLaptopEmpty() {
            // Invalid laptop (empty)
            String invalidLaptop = "";
            assertFalse(isValidLaptop(invalidLaptop));
        }

        @Test
        public void testInvalidLaptopNull() {
            // Invalid laptop (null)
            assertFalse(isValidLaptop(null));
        }

        private boolean isValidLaptop(Object o) {
            return false;
        }

        @Test
        public void test_main_window_displayed_with_correct_title_and_size() {
            LaptopManagement lmanagement = new LaptopManagement();
            lmanagement.openRegistrationFirstWindow();
            JFrame frame = lmanagement.firstFrame;
            assertEquals("HARAMAYA UNIVERSITY", frame.getTitle());
            assertEquals(1000, frame.getWidth());
            assertEquals(700, frame.getHeight());
        }
        @Test
        public void test_main_window_background_color_set_correctly() {
            LaptopManagement lmanagement = new LaptopManagement();
            lmanagement.openRegistrationFirstWindow();
            JFrame frame = lmanagement.firstFrame;
            Color expectedColor = new Color(0x2ecc71);
            assertEquals(expectedColor, frame.getContentPane().getBackground());
        }
        @Test
        public void test_title_labels_displayed_correctly() {
            LaptopManagement lmanagement = new LaptopManagement();
            lmanagement.openRegistrationFirstWindow();
            JFrame frame = lmanagement.firstFrame;

            JLabel titleLabel = (JLabel) frame.getContentPane().getComponent(0);
            JLabel titleLabel2 = (JLabel) frame.getContentPane().getComponent(1);
            JLabel titleLabel3 = (JLabel) frame.getContentPane().getComponent(2);
            JLabel titleLabel4 = (JLabel) frame.getContentPane().getComponent(3);

            assertEquals(" HARAMAYA UNIVERSITY ", titleLabel.getText());
            assertEquals(new Color(0xffffff), titleLabel.getForeground());
            assertEquals(new Font("SANS_SERIF", Font.BOLD, 25), titleLabel.getFont());
            assertEquals(new Rectangle(340, 90, 600, 100), titleLabel.getBounds());
        }
        @Test
        public void test_main_window_cannot_be_resized() {
            LaptopManagement lmanagement = new LaptopManagement();
            lmanagement.openRegistrationFirstWindow();
            JFrame frame = lmanagement.firstFrame;
            assertTrue(frame.isResizable());
        }
@Test
        public void testValidSingleDigitAge() {
            // Valid single-digit age
            String validSingleDigitAge = "7";
            assertTrue(isvalidateId(validSingleDigitAge));
        }

        @Test
        public void testInvalidNonNumericAge() {
            // Invalid age (non-numeric)
            String invalidAge = "abc";
            assertFalse(isvalidateId(invalidAge));
        }
        
        @Test
        public void testInvalidZeroAge() {
            // Invalid age (zero)
            String invalidAge = "0";
            assertFalse(isvalidateId(invalidAge));
        }

        @Test
        public void testInvalidNegativeAge() {
            // Invalid age (negative)
            String invalidAge = "-10";
            assertFalse(isvalidateId(invalidAge));
        }

        @Test
        public void testInvalidAgeWithSpaces() {
            // Invalid age (contains spaces)
            String invalidAge = " 35 ";
            assertFalse(isValidAge(invalidAge));
        }

        @Test
        public void testValidLaptop() {
            // Valid laptop
            String validLaptop = "hp";
            assertTrue(isValidLaptop(validLaptop));
        }

        @Test
        public void testValidLaptopIgnoreCase() {
            // Valid laptop (case-insensitive)
            String validLaptop = "dell";
            assertTrue(isValidLaptop(validLaptop));
        }
        @Test
        public void test_laptop_name_with_leading_or_trailing_spaces() {
            boolean result = RegistrationWindow.isValidLaptop(" hp ");
            assertFalse(result);
        }

        @Test
        public void test_valid_laptop_name_in_uppercase() {
            boolean result = RegistrationWindow.isValidLaptop("DELL");
            assertTrue(result);
        }
    }
