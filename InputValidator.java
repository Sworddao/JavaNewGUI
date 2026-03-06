import javax.swing.*;
import java.util.regex.*;

public class InputValidator {

    public static boolean validate(String name, String ageStr, String phone) {
        // --- 1. Presence Check ---
        if (name == null || name.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Name cannot be empty.");
            return false;
        }

        if (ageStr == null || ageStr.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Age cannot be empty.");
            return false;
        }

        if (phone == null || phone.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Phone number cannot be empty.");
            return false;
        }

        // --- 2. Type Check ---
        int age;
        try {
            age = Integer.parseInt(ageStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Age must be a number.");
            return false;
        }

        // --- 3. Range Check ---
        if (age < 16 || age > 100) {
            JOptionPane.showMessageDialog(null, "Age must be between 16 and 100.");
            return false;
        }

        // --- 4. Phone Format Check ---
        // Regex: exactly 10 digits
        Pattern pattern = Pattern.compile("\\d{10}");
        Matcher matcher = pattern.matcher(phone);
        if (!matcher.matches()) {
            JOptionPane.showMessageDialog(null, "Phone must be 10 digits (numbers only).");
            return false;
        }

        // All validations passed
        return true;
    }

    public static void main(String[] args) {
        // Example test
        String name = " ";
        String age = "abc";
        String phone = "98A76";

        boolean valid = validate(name, age, phone);

        if (valid) {
            System.out.println("All inputs are valid!");
        } else {
            System.out.println("Validation failed.");
        }
    }
}