import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class MyTodoManager extends JFrame{

    public MyTodoManager(){

        setTitle("My ToDo Manager");
        setSize(900,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel header = new JPanel();
        header.setBackground(new Color(170,190,220));

        JLabel title = new JLabel("My ToDo Manager");
        title.setFont(new Font("Arial",Font.BOLD,28));

        header.add(title);
        add(header,BorderLayout.NORTH);

        JPanel sidebar = new JPanel(new FlowLayout(FlowLayout.LEFT,10,20));
        sidebar.setPreferredSize(new Dimension(120,0));

        Dimension btnSize = new Dimension(100,30);

        JButton allBtn = new JButton("All Tasks");
        JButton completedBtn = new JButton("Completed");
        JButton pendingBtn = new JButton("Pending");
        JButton importantBtn = new JButton("Important");

        allBtn.setPreferredSize(btnSize);
        completedBtn.setPreferredSize(btnSize);
        pendingBtn.setPreferredSize(btnSize);
        importantBtn.setPreferredSize(btnSize);

        sidebar.add(allBtn);
        sidebar.add(completedBtn);
        sidebar.add(pendingBtn);
        sidebar.add(importantBtn);

        add(sidebar,BorderLayout.WEST);

        JPanel center = new JPanel(new BorderLayout());
        
        JPanel inputPanel = new JPanel();

        JLabel taskLabel = new JLabel("Task:");
        JTextField taskField = new JTextField(20);

        String priorities[] = {"High","Medium","Low"};
        JComboBox<String> priorityBox = new JComboBox<>(priorities);

        JButton addBtn = new JButton("Add Task");
        addBtn.setBackground(Color.GREEN);

        inputPanel.add(taskLabel);
        inputPanel.add(taskField);
        inputPanel.add(priorityBox);
        inputPanel.add(addBtn);

        center.add(inputPanel,BorderLayout.NORTH);
        
        JPanel taskPanel = new JPanel();
        taskPanel.setLayout(new BoxLayout(taskPanel,BoxLayout.Y_AXIS));

        taskPanel.setBorder(new LineBorder(Color.GRAY));

        JPanel task1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JCheckBox t1 = new JCheckBox("Finish Java Assignment");
        JButton del1 = new JButton("Delete");
        del1.setBackground(new Color(240,150,150));

        task1.add(t1);
        task1.add(del1);
        
        JPanel task2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JCheckBox t2 = new JCheckBox("Prepare Networking Notes");
        JButton del2 = new JButton("Delete");
        del2.setBackground(new Color(240,150,150));

        task2.add(t2);
        task2.add(del2);

        taskPanel.add(Box.createVerticalStrut(20));
        taskPanel.add(task1);
        taskPanel.add(Box.createVerticalStrut(120));
        taskPanel.add(task2);

        center.add(taskPanel,BorderLayout.CENTER);

        add(center,BorderLayout.CENTER);

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