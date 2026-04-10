import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.*;

public class EmployeeManagementSystem extends JFrame {

    // UI Components
    private JLabel headerLabel;
    private JTextField empIdField, nameField, salaryField;
    private JRadioButton fullTime, partTime, contract;
    private JCheckBox healthInsurance, dentalInsurance, retirementPlan;
    private JComboBox<String> departmentBox;
    private JTextArea displayArea;
    private JLabel charCountLabel, mousePositionLabel;
    private JLabel statusLabel;
    private ArrayList<Employee> employees=new ArrayList<>();
    private int count;
    public EmployeeManagementSystem() {
      setTitle("Employee Management System");
      setLayout(new BorderLayout());
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(1200, 700);

      // ===== Header =====
      JPanel header = new JPanel(new FlowLayout(FlowLayout.LEFT));
      headerLabel = new JLabel("<html><h1>Employee Management System</h1></html>");
      header.add(headerLabel);
      header.setBackground(new Color(70, 130, 200));
      header.addMouseListener(new MouseAdapter(){
          @Override
           public void mouseEntered(MouseEvent e){
                header.setBackground(Color.ORANGE);
            }
          @Override
          public void mouseExited(MouseEvent e){
                header.setBackground(new Color(70, 130, 200));
            }
      });
      headerLabel.setForeground(Color.WHITE);
      add(header, BorderLayout.NORTH);
      

      // TODO 1: Add MouseListener to header for hover effects
      // When mouse enters: change header text to "Employee Records View" and background color to an orange color
      // When mouse exits: revert to original text and color

      // ===== Sidebar =====
      JPanel sidebar = new JPanel();
      sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
      sidebar.setPreferredSize(new Dimension(200, 0));
      sidebar.setBackground(new Color(240, 240, 240));
      sidebar.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

      JButton addBtn = new JButton("Add Employee");
      addBtn.addMouseListener(new MouseAdapter(){
          @Override
          public void mouseEntered(MouseEvent e){
              addBtn.setBackground(Color.GREEN);
              addBtn.setForeground(Color.WHITE);
          }
          @Override
          public void mouseExited(MouseEvent e){
              addBtn.setBackground(new Color(240, 240, 240));
              addBtn.setForeground(Color.BLACK);
          }
      });
      JButton viewBtn = new JButton("View Employees");
      viewBtn.addMouseListener(new MouseAdapter(){
          @Override
          public void mouseEntered(MouseEvent e){
              viewBtn.setBackground(Color.GREEN);
              viewBtn.setForeground(Color.WHITE);
          }
          @Override
          public void mouseExited(MouseEvent e){
              viewBtn.setBackground(new Color(240, 240, 240));
              viewBtn.setForeground(Color.BLACK);
          }
      });
      JButton updateBtn = new JButton("Update Employee");
       updateBtn.addMouseListener(new MouseAdapter(){
          @Override
          public void mouseEntered(MouseEvent e){
              updateBtn.setBackground(Color.GREEN);
              updateBtn.setForeground(Color.WHITE);
          }
          @Override
          public void mouseExited(MouseEvent e){
              updateBtn.setBackground(new Color(240, 240, 240));
              updateBtn.setForeground(Color.BLACK);
          }
      });
      JButton deleteBtn = new JButton("Delete Employee");
      deleteBtn.addMouseListener(new MouseAdapter(){
          @Override
          public void mouseEntered(MouseEvent e){
              deleteBtn.setBackground(Color.GREEN);
              deleteBtn.setForeground(Color.WHITE);
          }
          @Override
          public void mouseExited(MouseEvent e){
              deleteBtn.setBackground(new Color(240, 240, 240));
              deleteBtn.setForeground(Color.BLACK);
          }
      });
      JButton searchBtn = new JButton("Search Employee");
      searchBtn.addMouseListener(new MouseAdapter(){
          @Override
          public void mouseEntered(MouseEvent e){
              searchBtn.setBackground(Color.GREEN);
              searchBtn.setForeground(Color.WHITE);
          }
          @Override
          public void mouseExited(MouseEvent e){
              searchBtn.setBackground(new Color(240, 240, 240));
              searchBtn.setForeground(Color.BLACK);
          }
      });
      sidebar.add(Box.createRigidArea(new Dimension(0, 10)));
      sidebar.add(addBtn);
      sidebar.add(Box.createRigidArea(new Dimension(0, 10)));
      sidebar.add(viewBtn);
      sidebar.add(Box.createRigidArea(new Dimension(0, 10)));
      sidebar.add(updateBtn);
      sidebar.add(Box.createRigidArea(new Dimension(0, 10)));
      sidebar.add(deleteBtn);
      sidebar.add(Box.createRigidArea(new Dimension(0, 10)));
      sidebar.add(searchBtn);
      sidebar.add(Box.createVerticalGlue());

      add(sidebar, BorderLayout.WEST);

      // ===== Form Panel =====
      JPanel form = new JPanel();
      form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
      form.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
      form.setBackground(Color.WHITE);

      // TODO 2: Add MouseMotionListener to form panel
      
      // When mouse moves, update mousePositionLabel with coordinates
      
      form.addMouseMotionListener(new MouseAdapter(){
            @Override
            public void mouseMoved(MouseEvent e){
                mousePositionLabel.setText("Mouse Position: ("+e.getX()+") ("+e.getY()+")");
            }
            
            @Override
            public void mouseDragged(MouseEvent e){
                mousePositionLabel.setText("Mouse Dragged at: "+e.getX()+","+e.getY());
            } 
      });
      // Name Field
      nameField = new JTextField(20);
      nameField.setText("Enter full name");
      JPanel namePanel = createFieldPanel("Full Name:", nameField);
      form.add(namePanel);
      form.add(Box.createRigidArea(new Dimension(0, 10)));
      // TODO 3: Add FocusListener to name field
      // When focused gained, if text is "Enter full name", clear it and set text color to black
      nameField.addKeyListener(new KeyAdapter(){
          @Override
          public void keyReleased(KeyEvent e){
              
              int n=nameField.getText().length();
              if(n<10){
                  charCountLabel.setForeground(Color.GREEN);
                  charCountLabel.setText("<html><h3>Characters: "+nameField.getText().length()+"</h3></html");
              }else if(n>10&& n<15){
                  charCountLabel.setForeground(Color.YELLOW);
                  charCountLabel.setText("<html><h3>Characters: "+nameField.getText().length()+"</h3></html");
              }else{
                  charCountLabel.setForeground(Color.RED);
                  charCountLabel.setText("<html><h3>Characters: "+nameField.getText().length()+"</h3></html");
              }
          }
      });
      nameField.addFocusListener(new FocusAdapter(){
          @Override
          public void focusGained(FocusEvent e){
            if(nameField.getText().equalsIgnoreCase("Enter full name")){
              nameField.setText("");
            }
            nameField.setForeground(Color.BLACK);
          }
          @Override 
          public void focusLost(FocusEvent e){
              if(nameField.getText().equalsIgnoreCase("")){
              nameField.setText("Enter full name");
              nameField.setForeground(Color.GRAY);  
            }
          }
      });
      // When focus lost, if text is empty, set it to "Enter full name" and text color to gray

      // Salary Field
      salaryField = new JTextField(20);
      JPanel salaryPanel = createFieldPanel("Salary", salaryField);
      form.add(salaryPanel);
      form.add(Box.createRigidArea(new Dimension(0, 10)));
      salaryField.addKeyListener(new KeyAdapter(){
          @Override
          public void keyTyped(KeyEvent e){
              char c = e.getKeyChar();
              if(!(Character.isDigit(c) && c == '.')){
                  e.consume(); //block the words & other keys except digits and dot
              }
          }
      });
      // Employment Type
      JPanel employmentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      employmentPanel.add(new JLabel("Employment Type:"));
      fullTime = new JRadioButton("Full-Time");
      partTime = new JRadioButton("Part-Time");
      contract = new JRadioButton("Contract");
      ButtonGroup empGroup = new ButtonGroup();
      empGroup.add(fullTime);
      empGroup.add(partTime);
      empGroup.add(contract);
      employmentPanel.add(fullTime);
      employmentPanel.add(partTime);
      employmentPanel.add(contract);
      form.add(employmentPanel);
      form.add(Box.createRigidArea(new Dimension(0, 10)));

      // Benefits
      JPanel benefitsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      benefitsPanel.add(new JLabel("Benefits:"));
      healthInsurance = new JCheckBox("Health Insurance");
      dentalInsurance = new JCheckBox("Dental Insurance");
      retirementPlan = new JCheckBox("Retirement Plan");
      benefitsPanel.add(healthInsurance);
      benefitsPanel.add(dentalInsurance);
      benefitsPanel.add(retirementPlan);
      form.add(benefitsPanel);
      form.add(Box.createRigidArea(new Dimension(0, 10)));

      // Department
      JPanel deptPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      deptPanel.add(new JLabel("Department:"));
      String[] departments = {"IT", "HR", "Finance", "Marketing", "Operations"};
      departmentBox = new JComboBox<>(departments);
      deptPanel.add(departmentBox);
      form.add(deptPanel);
      form.add(Box.createRigidArea(new Dimension(0, 10)));

      // Action Buttons
      JButton registerBtn = new JButton("Register Employee");
      registerBtn.addActionListener(e->add());
      JButton clearFormBtn = new JButton("Clear Form");
      clearFormBtn.addActionListener(e->clearform());
      JButton clearAllBtn = new JButton("Clear All Records");
      clearAllBtn.addActionListener(e->clearAll());

      JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
      btnPanel.add(registerBtn);
      btnPanel.add(clearFormBtn);
      btnPanel.add(clearAllBtn);
      form.add(btnPanel);

      add(form, BorderLayout.CENTER);
    

      // ===== Display Area =====
      JPanel rightPanel = new JPanel(new BorderLayout());
      rightPanel.setPreferredSize(new Dimension(400, 0));

      displayArea = new JTextArea(20, 30);
      displayArea.setEditable(false);
      displayArea.setWrapStyleWord(true);
      displayArea.setLineWrap(true);
      
      displayArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
      displayArea.setBackground(new Color(252, 252, 252));
      rightPanel.add(new JScrollPane(displayArea), BorderLayout.CENTER);
      add(rightPanel, BorderLayout.EAST);

      // ===== Footer =====
      JPanel footer = new JPanel(new GridLayout(1, 2));
      footer.setBackground(new Color(60, 60, 60));
      footer.setPreferredSize(new Dimension(0, 60));

      charCountLabel = new JLabel("<html><h3>Characters: 0</h3></html>");
      mousePositionLabel = new JLabel("<html><h3>Mouse Position: (0, 0)</h3></html>");
      statusLabel = new JLabel("<html><h3>Status: Ready</h3></html>");

      charCountLabel.setForeground(Color.WHITE);
      mousePositionLabel.setForeground(Color.WHITE);
      statusLabel.setForeground(Color.WHITE);

      JPanel leftFooter = new JPanel(new FlowLayout(FlowLayout.LEFT));
      leftFooter.setBackground(new Color(60, 60, 60));
      leftFooter.add(charCountLabel);
      leftFooter.add(mousePositionLabel);

      JPanel rightFooter = new JPanel(new FlowLayout(FlowLayout.RIGHT));
      rightFooter.setBackground(new Color(60, 60, 60));
      rightFooter.add(statusLabel);

      footer.add(leftFooter);
      footer.add(rightFooter);
      add(footer, BorderLayout.SOUTH);
    
      setVisible(true);
    }

    private JPanel createFieldPanel(String label, JTextField field) {
      JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      JLabel jlabel = new JLabel(label);
      jlabel.setPreferredSize(new Dimension(120, 25));
      panel.add(jlabel);
      field.setPreferredSize(new Dimension(300, 30));
      panel.add(field);
      panel.setBackground(Color.WHITE);
      return panel;
    }

    // Register Employee Method
   
    public void add(){
            
        String name=nameField.getText();
        double salary=Double.parseDouble(salaryField.getText());
        String type="";
        ArrayList<String> benefits=new ArrayList<>();
        if (fullTime.isSelected()) 
        {
            type = fullTime.getText();
        }

        else if (partTime.isSelected())
        {
            type=partTime.getText();
        } 
        else if (contract.isSelected()) 
        {
            type=contract.getText();
        }
        if(healthInsurance.isSelected()){
            benefits.add(healthInsurance.getText());
        }
        if(dentalInsurance.isSelected()){
            benefits.add(dentalInsurance.getText());
        }
        if(retirementPlan.isSelected()){
            benefits.add(retirementPlan.getText());
        }
        String dep=departmentBox.getSelectedItem().toString();
        //String empId, String name, double salary, String employmentType, ArrayList<String> benefits, String department
        Employee emp=new Employee(name,salary,type,benefits,dep);
        employees.add(emp);
        displayArea.append(emp.toString()+"\n");
    }
    public void clearform(){
        nameField.setText("");
        salaryField.setText("");
        departmentBox.setSelectedItem(0);
        partTime.setSelected(false);
        fullTime.setSelected(false);
        contract.setSelected(false);
        healthInsurance.setSelected(false);
        dentalInsurance.setSelected(false);
        retirementPlan.setSelected(false);
    }
    public void clearAll(){
        displayArea.setText("");
    }
    public static void main(String[] args) {
      SwingUtilities.invokeLater(() -> new EmployeeManagementSystem());
    }
}