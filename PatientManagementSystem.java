import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Patient {
    private String name;
    private int age;
    private String gender;
    private String disease;

    public Patient(String name, int age, String gender, String disease) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.disease = disease;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Gender: " + gender + ", Disease: " + disease;
    }
}

public class PatientManagementSystem extends JFrame implements ActionListener {

    private JTextField txtName, txtAge;
    private JComboBox<String> comboGender, comboDisease;
    private JButton btnSubmit, btnClear;
    private JPanel formPanel;
    private JTextArea displayArea;

    private ArrayList<Patient> patients = new ArrayList<>();

    public PatientManagementSystem() {
        setTitle("Patient Management System");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Form Panel
        formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        formPanel.add(new JLabel("Patient Name:"));
        txtName = new JTextField();
        formPanel.add(txtName);

        formPanel.add(new JLabel("Age:"));
        txtAge = new JTextField();
        formPanel.add(txtAge);

        formPanel.add(new JLabel("Gender:"));
        String[] genders = {"Select Gender", "Male", "Female", "Other"};
        comboGender = new JComboBox<>(genders);
        formPanel.add(comboGender);

        formPanel.add(new JLabel("Disease:"));
        String[] diseases = {"Select Disease", "Flu", "Covid", "Diabetes", "Cancer"};
        comboDisease = new JComboBox<>(diseases);
        formPanel.add(comboDisease);

        btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(this);
        btnClear = new JButton("Clear");
        btnClear.addActionListener(e -> clearForm());
        formPanel.add(btnSubmit);
        formPanel.add(btnClear);

        add(formPanel, BorderLayout.NORTH);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(displayArea);
        scroll.setBorder(BorderFactory.createTitledBorder("Patient Records"));
        add(scroll, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PatientManagementSystem::new);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) {
            try {
                handleSubmit();
            } catch (NullPointerException eb) {
                JOptionPane.showMessageDialog(this, eb.getMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ea) {
                JOptionPane.showMessageDialog(this, ea.getMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ee) {
                JOptionPane.showMessageDialog(this, ee.getMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ez) {
                JOptionPane.showMessageDialog(this, ez.getMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void handleSubmit() {
        String name = txtName.getText().trim();
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name field cannot be empty.");
        }

        String ageText = txtAge.getText().trim();
        String gender = comboGender.getSelectedItem().toString();
        String disease = comboDisease.getSelectedItem().toString();

        int age;
        try {
            age = Integer.parseInt(ageText);
        } catch (NumberFormatException ee) {
            throw new NumberFormatException("Age cannot contain alphabets.");
        }
        if(age <= 0){
            throw new InvalidPatientDataException("Age cannot be less than or equal to zero");
        }

        if (gender.equals("Select Gender")) {
            throw new IllegalArgumentException("Please select a gender.");
        }

        if (disease.equals("Select Disease")) {
            throw new IllegalArgumentException("Please select a disease.");
        }

        Patient patient = new Patient(name, age, gender, disease);
        patients.add(patient);

        displayArea.append(patient.toString() + "\n");
        JOptionPane.showMessageDialog(this, "Patient added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        clearForm();
    }

    public void clearForm() {
        txtName.setText("");
        txtAge.setText("");
        comboGender.setSelectedIndex(0);
        comboDisease.setSelectedIndex(0);
    }
}