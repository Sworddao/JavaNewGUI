import javax.swing.*;
import java.awt.*;

public class StudentDashboardUI extends JFrame{

    String[] buttons = {"Add Student", "View Student", "Update Student", "Delete Student"};
    String[] genderOptions = {"Male", "Female"};
    String[] skills = {"Java", "Python", "C++"};
    String[] courses = {"B.Tech", "M.Tech", "B.Sc", "M.Sc"};
    String[] hobbies = {"Reading", "Gaming", "Sports", "Music", "Travel"};

    public StudentDashboardUI(){

        setTitle("Admin Dashboard");
        setSize(900,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // HEADER
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        headerPanel.setBackground(Color.LIGHT_GRAY);

        JLabel title = new JLabel("<html><h1>Student Admin Panel</h1></html>");
        headerPanel.add(title);

        add(headerPanel, BorderLayout.NORTH);

        // FOOTER
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        footerPanel.setBackground(Color.LIGHT_GRAY);

        JLabel footer = new JLabel("© 2025 Student Management System");
        footerPanel.add(footer);

        add(footerPanel, BorderLayout.SOUTH);

        // SIDEBAR
        JPanel sideBar = new JPanel();
        sideBar.setBackground(new Color(220,220,220));
        sideBar.setPreferredSize(new Dimension(180,0));
        sideBar.setLayout(new BoxLayout(sideBar, BoxLayout.Y_AXIS));

        sideBar.add(Box.createVerticalStrut(20));

        for(String b : buttons){
            JButton btn = new JButton(b);
            btn.setMaximumSize(new Dimension(150,30));
            sideBar.add(btn);
            sideBar.add(Box.createVerticalStrut(15));
        }

        add(sideBar, BorderLayout.WEST);

        // FORM PANEL
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));

        // ROW 1 - NAME
        JPanel row1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(20);
        row1.add(nameLabel);
        row1.add(nameField);

        // ROW 2 - AGE
        JPanel row2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel ageLabel = new JLabel("Age:");
        JTextField ageField = new JTextField(20);
        row2.add(ageLabel);
        row2.add(ageField);

        // ROW 3 - GENDER
        JPanel row3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel genderLabel = new JLabel("Gender:");
        row3.add(genderLabel);

        ButtonGroup genderGroup = new ButtonGroup();
        for(String g : genderOptions){
            JRadioButton btn = new JRadioButton(g);
            genderGroup.add(btn);
            row3.add(btn);
        }

        // ROW 4 - SKILLS
        JPanel row4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel skillLabel = new JLabel("Skills:");
        row4.add(skillLabel);

        for(String s : skills){
            JCheckBox box = new JCheckBox(s);
            row4.add(box);
        }

        // ROW 5 - COURSE
        JPanel row5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel courseLabel = new JLabel("Course:");
        JComboBox<String> courseBox = new JComboBox<>(courses);

        row5.add(courseLabel);
        row5.add(courseBox);

        // ROW 6 - HOBBIES
        JPanel row6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel hobbyLabel = new JLabel("Hobbies:");
        JComboBox<String> hobbyBox = new JComboBox<>(hobbies);

        row6.add(hobbyLabel);
        row6.add(hobbyBox);

        // ROW 7 - REGISTER BUTTON
        JPanel row7 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton registerBtn = new JButton("Register");
        row7.add(registerBtn);

        // ADD ROWS
        formPanel.add(row1);
        formPanel.add(row2);
        formPanel.add(row3);
        formPanel.add(row4);
        formPanel.add(row5);
        formPanel.add(row6);
        formPanel.add(row7);

        add(formPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
                    new StudentDashboardUI().setVisible(true);
            });
    }
}