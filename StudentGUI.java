import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class StudentGUI extends JFrame {

    JTextField txtID, txtName, txtSkill;
    JComboBox<String> courseBox;

    JRadioButton male, female, other;
    ButtonGroup genderGroup;

    JButton btnAdd, btnReset, btnSearch, btnDelete;

    JTable table;
    DefaultTableModel model;

    public StudentGUI() {

        setTitle("Student Registration System");
        setSize(700,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // -------- FORM PANEL --------
        JPanel formPanel = new JPanel(new GridLayout(5,2,10,10));

        txtID = new JTextField();
        txtName = new JTextField();
        txtSkill = new JTextField();

        courseBox = new JComboBox<>();
        courseBox.addItem("BSc");
        courseBox.addItem("BBA");
        courseBox.addItem("BIT");

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        other = new JRadioButton("Other");

        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);

        JPanel genderPanel = new JPanel();
        genderPanel.add(male);
        genderPanel.add(female);
        genderPanel.add(other);

        formPanel.add(new JLabel("Student ID"));
        formPanel.add(txtID);

        formPanel.add(new JLabel("Student Name"));
        formPanel.add(txtName);

        formPanel.add(new JLabel("Course"));
        formPanel.add(courseBox);

        formPanel.add(new JLabel("Gender"));
        formPanel.add(genderPanel);

        formPanel.add(new JLabel("Skills"));
        formPanel.add(txtSkill);

        add(formPanel, BorderLayout.NORTH);

        // -------- BUTTON PANEL --------
        JPanel buttonPanel = new JPanel();

        btnAdd = new JButton("Submit / Add");
        btnReset = new JButton("Reset");
        btnSearch = new JButton("Search");
        btnDelete = new JButton("Delete");

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnReset);
        buttonPanel.add(btnSearch);
        buttonPanel.add(btnDelete);

        add(buttonPanel, BorderLayout.CENTER);

        // -------- TABLE --------
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Course");
        model.addColumn("Gender");
        model.addColumn("Skill");

        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentGUI();
    }
}