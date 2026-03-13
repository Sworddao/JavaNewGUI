import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class MyTodoManager extends JFrame{

    String[] sidebarButtons = {"All Tasks","Completed","Pending","Important"};
    String[] priorities = {"High","Medium","Low"};
    String[] defaultTasks = {"Finish Java Assignment","Prepare Networking Notes"};

    public MyTodoManager(){

        setTitle("My ToDo Manager");
        setSize(900,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // HEADER
        JPanel header = new JPanel();
        header.setBackground(new Color(170,190,220));

        JLabel title = new JLabel("My ToDo Manager");
        title.setFont(new Font("Arial",Font.BOLD,28));

        header.add(title);
        add(header,BorderLayout.NORTH);

        // SIDEBAR
        JPanel sidebar = new JPanel(new FlowLayout(FlowLayout.LEFT,10,20));
        sidebar.setPreferredSize(new Dimension(120,0));

        Dimension btnSize = new Dimension(100,30);

        for(String b : sidebarButtons){
            JButton btn = new JButton(b);
            btn.setPreferredSize(btnSize);
            sidebar.add(btn);
        }

        add(sidebar,BorderLayout.WEST);

        // CENTER PANEL
        JPanel center = new JPanel(new BorderLayout());

        // INPUT PANEL
        JPanel inputPanel = new JPanel();

        JLabel taskLabel = new JLabel("Task:");
        JTextField taskField = new JTextField(20);

        JComboBox<String> priorityBox = new JComboBox<>(priorities);

        JButton addBtn = new JButton("Add Task");
        addBtn.setBackground(Color.GREEN);

        inputPanel.add(taskLabel);
        inputPanel.add(taskField);
        inputPanel.add(priorityBox);
        inputPanel.add(addBtn);

        center.add(inputPanel,BorderLayout.NORTH);

        // TASK PANEL
        JPanel taskPanel = new JPanel();
        taskPanel.setLayout(new BoxLayout(taskPanel,BoxLayout.Y_AXIS));
        taskPanel.setBorder(new LineBorder(Color.GRAY));

        taskPanel.add(Box.createVerticalStrut(20));

        for(String task : defaultTasks){

            JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT));

            JCheckBox taskCheck = new JCheckBox(task);

            JButton deleteBtn = new JButton("Delete");
            deleteBtn.setBackground(new Color(240,150,150));

            row.add(taskCheck);
            row.add(deleteBtn);

            taskPanel.add(row);
            taskPanel.add(Box.createVerticalStrut(120));
        }

        center.add(taskPanel,BorderLayout.CENTER);

        add(center,BorderLayout.CENTER);

        // FOOTER
        JPanel footer = new JPanel();
        JLabel footerLabel = new JLabel("Developed using Java Swing");

        footer.add(footerLabel);
        add(footer,BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args){
        new MyTodoManager();
    }
}