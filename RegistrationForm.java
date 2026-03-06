import javax.swing.*;
import java.awt.*;

public class RegistrationForm extends JFrame {

    public RegistrationForm() {
        setTitle("Student Registration Form");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2, 10, 10));

        // --- Text Fields ---
        JTextField txtName = new JTextField();
        JTextField txtAge = new JTextField();
        JTextField txtPhone = new JTextField();

        // --- Department ComboBox (12 options) ---
        JComboBox<String> departmentBox = new JComboBox<>();
        for (int i = 1; i <= 12; i++) {
            departmentBox.addItem("Department " + i);
        }

        // --- Gender Radio Buttons ---
        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        JRadioButton other = new JRadioButton("Other");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);
        JPanel genderPanel = new JPanel();
        genderPanel.add(male);
        genderPanel.add(female);
        genderPanel.add(other);

        // --- Hobbies Checkboxes ---
        JCheckBox hobby1 = new JCheckBox("Reading");
        JCheckBox hobby2 = new JCheckBox("Gaming");
        JCheckBox hobby3 = new JCheckBox("Sports");
        JCheckBox hobby4 = new JCheckBox("Music");
        JPanel hobbiesPanel = new JPanel();
        hobbiesPanel.add(hobby1);
        hobbiesPanel.add(hobby2);
        hobbiesPanel.add(hobby3);
        hobbiesPanel.add(hobby4);

        // --- Add Components to Frame ---
        add(new JLabel("Student Name:"));
        add(txtName);

        add(new JLabel("Age:"));
        add(txtAge);

        add(new JLabel("Phone Number:"));
        add(txtPhone);

        add(new JLabel("Department:"));
        add(departmentBox);

        add(new JLabel("Gender:"));
        add(genderPanel);

        add(new JLabel("Hobbies:"));
        add(hobbiesPanel);

        JButton submit = new JButton("Submit");
        add(submit);

        setVisible(true);
    }

    public static void main(String[] args) {
        new RegistrationForm();
    }
}