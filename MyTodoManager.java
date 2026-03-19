import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MyTodoManager extends JFrame{

    String[] sidebarButtons = {"All Tasks","Completed","Pending","Important"};
    String[] priorities = {"High","Medium","Low"};
    String[] defaultTasks = {"Finish Java Assignment","Prepare Networking Notes"};

    // STORE REFERENCES
    java.util.List<JPanel> taskRows = new ArrayList<>();
    java.util.List<JCheckBox> checkBoxes = new ArrayList<>();
    java.util.List<String> taskPriorities = new ArrayList<>();

    JPanel taskPanel;

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

            // FILTER LOGIC
            btn.addActionListener(e -> {

                for(int i = 0; i < taskRows.size(); i++){
                    JPanel row = taskRows.get(i);
                    JCheckBox cb = checkBoxes.get(i);
                    String priority = taskPriorities.get(i);

                    boolean show = false;

                    if(b.equals("All Tasks")){
                        show = true;
                    }
                    else if(b.equals("Completed")){
                        show = cb.isSelected();
                    }
                    else if(b.equals("Pending")){
                        show = !cb.isSelected();
                    }
                    else if(b.equals("Important")){
                        show = priority.equals("High");
                    }

                    row.setVisible(show);
                }

                taskPanel.revalidate();
                taskPanel.repaint();
            });

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
        taskPanel = new JPanel();
        taskPanel.setLayout(new BoxLayout(taskPanel,BoxLayout.Y_AXIS));
        taskPanel.setBorder(new LineBorder(Color.GRAY));

        taskPanel.add(Box.createVerticalStrut(20));

        // DEFAULT TASKS
        for(String task : defaultTasks){
            addTaskRow(task, "Medium");
        }

        center.add(taskPanel,BorderLayout.CENTER);
        add(center,BorderLayout.CENTER);

        // ADD TASK BUTTON LOGIC
        addBtn.addActionListener(e -> {
            String taskText = taskField.getText().trim();
            String priority = (String) priorityBox.getSelectedItem();

            if(taskText.isEmpty()){
                JOptionPane.showMessageDialog(this,"Task cannot be empty!");
                return;
            }

            addTaskRow(taskText, priority);
            taskField.setText("");
        });

        // FOOTER
        JPanel footer = new JPanel();
        JLabel footerLabel = new JLabel("Developed using Java Swing");

        footer.add(footerLabel);
        add(footer,BorderLayout.SOUTH);

        setVisible(true);
    }

    // METHOD TO ADD TASK
    private void addTaskRow(String task, String priority){

        JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JCheckBox taskCheck = new JCheckBox(task);

        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setBackground(new Color(240,150,150));

        // DELETE LOGIC
        deleteBtn.addActionListener(e -> {
            taskPanel.remove(row);
            taskRows.remove(row);
            checkBoxes.remove(taskCheck);
            taskPriorities.remove(priority);

            taskPanel.revalidate();
            taskPanel.repaint();
        });

        row.add(taskCheck);
        row.add(deleteBtn);

        taskPanel.add(row);
        taskPanel.add(Box.createVerticalStrut(20));

        // STORE
        taskRows.add(row);
        checkBoxes.add(taskCheck);
        taskPriorities.add(priority);

        taskPanel.revalidate();
        taskPanel.repaint();
    }

    public static void main(String[] args){
        new MyTodoManager();
    }
}