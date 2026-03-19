import java.awt.*;
import java.util.*;
import javax.swing.*;

public class EventHandling
{
    public static void main(String[] args){
        new myframe();
    }
}
class Task{
    String name;
    String priority;
    boolean completed=false;

    Task(String name,String priority){
        this.name=name;
        this.priority=priority;
    }
}
class myframe extends JFrame{
    JTextField taskField=new JTextField();
    JComboBox<String> taskBox;
    //JButton addTaskButton;
    JPanel centerTask=new JPanel();
    String currentFilter="ALL";
    ArrayList<Task> tasks = new ArrayList<>();
    myframe(){
        this.setTitle("My ToDo Manager");
        this.setSize(900,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        JPanel header=new JPanel();
        JLabel headerLabel=new JLabel("<html><h1>My ToDo Manager</h1></html>");
        header.add(headerLabel);
        header.setBackground(Color.CYAN);
        header.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(header, BorderLayout.NORTH);
        
        
        JPanel sidebar=new JPanel();
        sidebar.setLayout(new FlowLayout(FlowLayout.LEFT));
        sidebar.setPreferredSize(new Dimension(180,0));
        String [] buttons={"All tasks", "Completed","Pending","Important"};
        for( String button:buttons){
            JButton b=new JButton(button);
            sidebar.add(b);
            b.setPreferredSize(new Dimension(150,50));
            b.addActionListener(e -> {
            if(button.equals("All tasks")) {
                currentFilter = "ALL";
            }
            if(button.equals("Completed")){
                currentFilter = "COMPLETED";
            }
            if(button.equals("Pending")){
                currentFilter = "PENDING";
            } 
            if(button.equals("Important")) {
                currentFilter = "IMPORTANT";
            }    
            if(button.equals("Clear All")){
                currentFilter="REMOVE";
            }
            System.out.println("button was clicked");
            refreshTasks();
        });
        
        }
        
        JPanel sidebar2=new JPanel();
        sidebar2.setLayout(new FlowLayout(FlowLayout.LEFT));
        sidebar2.setPreferredSize(new Dimension(180,0));
        sidebar2.setBackground(Color.GRAY);
        JButton b1=new JButton("Done");
        b1.setBackground(Color.RED);
        b1.addActionListener(e->{
            currentFilter="DONE"; 
            refreshTasks();
        });
        b1.setPreferredSize(new Dimension(150,50));
        JButton b2=new JButton("Clear All");
        b2.setPreferredSize(new Dimension(150,50));
        b2.setBackground(Color.GREEN);
        b2.addActionListener(e->{
            currentFilter="REMOVE";
            refreshTasks();
        });
        sidebar2.add(b1);
        sidebar2.add(b2);
        // JButton ba=new JButton("new");
        // ba.addActionListener((actionEvent) -> {
        //     System.out.println("you clicked me");
        // });
        //sidebar.add(ba);
        add(sidebar,BorderLayout.WEST);
        
        JPanel footer=new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel footerLabel=new JLabel("<html><h3>Developed using Java Swing</h3></html>");
        footer.add(footerLabel);
        add(footer,BorderLayout.SOUTH);
        
        
        JPanel center=new JPanel(new BorderLayout());
        JPanel centerTop=new JPanel(new FlowLayout(FlowLayout.CENTER));
        centerTask=new JPanel();
        centerTask.setLayout(new BoxLayout(centerTask,BoxLayout.Y_AXIS));
        centerTask.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel taskLabel=new JLabel("Task: ");
        taskField=new JTextField();
        taskField.setPreferredSize(new Dimension(200,30));
        String[] taskLevel = {"High","Medium","Low"};
        taskBox = new JComboBox<>(taskLevel); 
        JButton addTaskButton=new JButton("Add Task");
        addTaskButton.addActionListener(e->addTask());
        addTaskButton.setBackground(Color.GREEN);
        centerTop.add(taskLabel);
        centerTop.add(taskField);
        centerTop.add(taskBox);
        centerTop.add(addTaskButton);
    
        
        center.add(centerTop,BorderLayout.NORTH);
        center.add(centerTask,BorderLayout.CENTER);
        add(center,BorderLayout.CENTER);
        add(sidebar2,BorderLayout.EAST);
        this.setVisible(true);
    }
    
    public void addTask(){
        String name=taskField.getText();
        String priority=(String) taskBox.getSelectedItem();
        if(name.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Enter a task!");
            return;
        }

        Task t = new Task(name,priority);
        tasks.add(t);
        refreshTasks();

        taskField.setText("");
    }
    
    void addingtask(Task t){
        
        JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JCheckBox check = new JCheckBox();
        check.setSelected(t.completed);
        JLabel label;
        if (currentFilter.equals("DONE") && t.completed){
            label = new JLabel("<html><strike>" + t.name + " (" + t.priority + ")</strike></html>");
        }else{
            label = new JLabel(t.name + " ("+t.priority+")");
        }
        JButton del = new JButton("Delete");
        del.setBackground(Color.RED);

        check.addActionListener(e -> {
            t.completed = check.isSelected();
        });

        del.addActionListener(e -> {
            tasks.remove(t);
            refreshTasks();
        });

        row.add(check);
        row.add(label);
        row.add(del);

        centerTask.add(row);
        
    }
    void refreshTasks(){

        centerTask.removeAll();
        
        if(currentFilter.equals("REMOVE")){
            int choice=JOptionPane.showConfirmDialog(null,"Are you sure?","",JOptionPane.YES_NO_OPTION);
            if (choice==JOptionPane.YES_OPTION){
                tasks.clear();
            }
            currentFilter="ALL";
        }
        
        for(Task t : tasks){
            if(currentFilter.equals("ALL")){
                addingtask(t);
            }
            else if(currentFilter.equals("COMPLETED") && t.completed){
                addingtask(t);
            }
            else if(currentFilter.equals("PENDING") && !t.completed){
                addingtask(t);
            }
            else if(currentFilter.equals("IMPORTANT") && t.priority.equals("High")){
                addingtask(t);
            }else if(currentFilter.equals("DONE")) {
                addingtask(t);
            }
        }
         centerTask.revalidate();  
         centerTask.repaint();    
    }
}