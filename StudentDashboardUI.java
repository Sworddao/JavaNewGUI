import javax.swing.*;
import java.awt.*;

public class StudentDashboardUI extends JFrame{
    
    public StudentDashboardUI(){
        setTitle("Admin Dashboard");
        setSize(900,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        headerPanel.setBackground(Color.LIGHT_GRAY);
        
        ImageIcon logo = new ImageIcon("logo.png");
        JLabel iconLabel = new JLabel(logo);
        
        JLabel titleLabel = new JLabel("<html><h1>Student Admin Panel</h1></html>");
        
        headerPanel.add(iconLabel);
        headerPanel.add(titleLabel);
        
        add(headerPanel, BorderLayout.NORTH);
        
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        footerPanel.setBackground(Color.LIGHT_GRAY);
        
        JLabel footerLabel = new JLabel("© 2025 Student Management System");
        
        footerPanel.add(footerLabel);
        
        add(footerPanel, BorderLayout.SOUTH);
        
        JPanel sidebar = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 20));
        sidebar.setPreferredSize(new Dimension(180,0));
        sidebar.setBackground(new Color(220, 220, 220));
        
        Dimension btnSize = new Dimension(150,30);
        
        JButton addBtn = new JButton("Add Student");
        JButton viewBtn = new JButton("View Student");
        JButton updateBtn = new JButton("Update Student");
        JButton deleteBtn = new JButton("Delete Student");
        
        addBtn.setPreferredSize(btnSize);
        viewBtn.setPreferredSize(btnSize);
        updateBtn.setPreferredSize(btnSize);
        deleteBtn.setPreferredSize(btnSize);
        
        sidebar.add(addBtn);
        sidebar.add(viewBtn);
        sidebar.add(updateBtn);
        sidebar.add(deleteBtn);
        
        add(sidebar, BorderLayout.WEST);
        
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(20);
        
        JLabel ageLabel = new JLabel("Age:");
        JTextField ageField = new JTextField(20);
        
        JLabel genderLabel = new JLabel("Gender:");
        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderPanel.add(male);
        genderPanel.add(female);
        
        JLabel skillLabel = new JLabel("Skills");
        JCheckBox java = new JCheckBox("Java");
        JCheckBox python = new JCheckBox("Python");
        JCheckBox cpp = new JCheckBox("C++");
        
        JPanel skillPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        skillPanel.add(java);
        skillPanel.add(python);
        skillPanel.add(cpp);
        
        JLabel courseLabel = new JLabel("Course");
        
        String courses[] = {"B.Tech", "M.Tech", "B.Sc", "M.Sc"};
        JComboBox<String> courseBox = new JComboBox<>(courses);
        
        JButton registerBtn = new JButton("Register");
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(registerBtn);
        
        formPanel.add(nameLabel);
        formPanel.add(nameField);
        
        formPanel.add(ageLabel);
        formPanel.add(ageField);
        
        formPanel.add(genderLabel);
        formPanel.add(genderPanel);
        
        formPanel.add(skillLabel);
        formPanel.add(skillPanel);
        
        formPanel.add(courseLabel);
        formPanel.add(courseBox);
        
        formPanel.add(buttonPanel);
        
        add(formPanel, BorderLayout.CENTER);
    }
    
    public static void main(String[] args){
        StudentDashboardUI app = new StudentDashboardUI();
        app.setVisible(true);
    }
}