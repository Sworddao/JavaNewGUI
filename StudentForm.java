import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class StudentForm extends JFrame implements ActionListener
{
    private String[] btnList = {"Add", "Edit", "Delete", "View"};

    private JPanel titlePanel, sidebarPanel, formPanel, resultPanel;
    private JPanel row1, row2, row3, row4, row5;

    private JLabel label, nameLbl, courseLabel, genderLabel, hobbiesLabel;

    private JTextField txtField;
    private JComboBox<String> courseBox;

    private ButtonGroup genderGrp;
    private JRadioButton male, female, others;

    private JCheckBox readBox, travelBox, sportsBox;

    private JButton submitBtn, clearFormBtn, clearDisplayBtn;

    private JTextArea displayArea;
    
    private ArrayList<StudentMain> students = new ArrayList<>();

    public StudentForm()
    {
        setTitle("Student Registration");
        setSize(600,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // TITLE
        titlePanel = new JPanel();
        label = new JLabel("Student Registration Details");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setForeground(Color.RED);
        titlePanel.add(label);
        add(titlePanel, BorderLayout.NORTH);

        // SIDEBAR
        sidebarPanel = new JPanel();
        sidebarPanel.setLayout(new BoxLayout(sidebarPanel, BoxLayout.Y_AXIS));

        for(String btn : btnList)
        {
            JButton button = new JButton(btn);
            button.setMaximumSize(new Dimension(100,40));
            sidebarPanel.add(button);
            sidebarPanel.add(Box.createVerticalStrut(10));
        }

        add(sidebarPanel, BorderLayout.WEST);

        // FORM
        formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));

        // ROW 1
        row1 = new JPanel();
        nameLbl = new JLabel("Name:");
        txtField = new JTextField(15);
        row1.add(nameLbl);
        row1.add(txtField);

        // ROW 2
        row2 = new JPanel();
        courseLabel = new JLabel("Course:");
        String[] courses={"Computing","AI","Multimedia","Networking"};
        courseBox = new JComboBox<>(courses);
        row2.add(courseLabel);
        row2.add(courseBox);

        // ROW 3
        row3 = new JPanel();
        genderLabel = new JLabel("Gender:");

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        others = new JRadioButton("Others");

        genderGrp = new ButtonGroup();
        genderGrp.add(male);
        genderGrp.add(female);
        genderGrp.add(others);

        row3.add(genderLabel);
        row3.add(male);
        row3.add(female);
        row3.add(others);

        // ROW 4
        row4 = new JPanel();
        hobbiesLabel = new JLabel("Hobbies:");

        readBox = new JCheckBox("Reading");
        travelBox = new JCheckBox("Travelling");
        sportsBox = new JCheckBox("Sports");

        row4.add(hobbiesLabel);
        row4.add(readBox);
        row4.add(travelBox);
        row4.add(sportsBox);

        // ROW 5
        row5 = new JPanel();

        submitBtn = new JButton("Submit");
        clearFormBtn = new JButton("Clear Form");
        clearDisplayBtn = new JButton("Clear Display");

        submitBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                clearForm();
            }
        });
        clearFormBtn.addActionListener(this);
        
        clearDisplayBtn.addActionListener(this);

        row5.add(submitBtn);
        row5.add(clearFormBtn);
        row5.add(clearDisplayBtn);

        formPanel.add(row1);
        formPanel.add(row2);
        formPanel.add(row3);
        formPanel.add(row4);
        formPanel.add(row5);

        add(formPanel, BorderLayout.CENTER);

        // RESULT
        resultPanel = new JPanel(new BorderLayout());
        resultPanel.setBorder(BorderFactory.createTitledBorder("Student Details"));

        displayArea = new JTextArea(6,40);
        displayArea.setEditable(false);

        resultPanel.add(new JScrollPane(displayArea));
        add(resultPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() ->
        {
            new StudentForm().setVisible(true);
        });
    }

    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == submitBtn){
            handleSubmit();
        }
        else if(e.getSource() == clearFormBtn){
            clearForm();
        }
        else if(e.getSource() == clearDisplayBtn){
            displayArea.setText("");
        }
    }

    public void handleSubmit(){

        String name = txtField.getText().trim();
        String course = courseBox.getSelectedItem().toString();

        String gender = "";
        if(male.isSelected()) gender = "Male";
        else if(female.isSelected()) gender = "Female";
        else if(others.isSelected()) gender = "Others";
        else gender = "Not Selected";

        // FIX: new list every time
        ArrayList<String> hobbiesList = new ArrayList<>();

        if(readBox.isSelected()) hobbiesList.add("Reading");
        if(travelBox.isSelected()) hobbiesList.add("Travelling");
        if(sportsBox.isSelected()) hobbiesList.add("Sports");

        StudentMain std = new StudentMain(name, gender, course, hobbiesList);
        students.add(std);

        displayArea.append(std.toString() + "\n\n");
        submitBtn.setEnabled(false);
    }

    public void clearForm(){
        txtField.setText("");
        genderGrp.clearSelection();
        readBox.setSelected(false);
        travelBox.setSelected(false);
        sportsBox.setSelected(false);
        courseBox.setSelectedIndex(0);
        submitBtn.setEnabled(true);
    }
    
}