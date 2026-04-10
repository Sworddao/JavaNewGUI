import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class VehicleForm extends JFrame implements ActionListener 
{
    private JRadioButton carBtn, bikeBtn;
    private JPanel formPanel, topPanel, bottomPanel, btnPanel;

    private JTextField nameField, speedField, seatsField, fuelField, gearField;
    private JTextField distanceField, tankField;

    private JCheckBox carrierBox;

    private JButton submitBtn, showInfoBtn, operateBtn, displayAllBtn, checkTypeBtn, clearBtn;

    private JTextArea displayArea;

    private String selectedType = "";
    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    public VehicleForm() 
    {
        setTitle("Vehicle Casting Demo");
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // TOP PANEL
        topPanel = new JPanel(new FlowLayout());

        carBtn = new JRadioButton("Car");
        bikeBtn = new JRadioButton("Bike");

        ButtonGroup bg = new ButtonGroup();
        bg.add(carBtn);
        bg.add(bikeBtn);

        topPanel.add(new JLabel("Select Vehicle Type:"));
        topPanel.add(carBtn);
        topPanel.add(bikeBtn);

        add(topPanel, BorderLayout.NORTH);

        carBtn.addActionListener(e -> showForm("Car"));
        bikeBtn.addActionListener(e -> showForm("Bike"));

        formPanel = new JPanel();
        formPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        add(formPanel, BorderLayout.CENTER);

        bottomPanel = new JPanel(new BorderLayout());
        btnPanel = new JPanel(new FlowLayout());

        submitBtn = new JButton("Submit Vehicle");
        showInfoBtn = new JButton("Show Basic Info");
        operateBtn = new JButton("Run Operation");
        displayAllBtn = new JButton("Display All");
        checkTypeBtn = new JButton("Check Type");
        clearBtn = new JButton("Clear Form");

        btnPanel.add(submitBtn);
        btnPanel.add(showInfoBtn);
        btnPanel.add(operateBtn);
        btnPanel.add(displayAllBtn);
        btnPanel.add(checkTypeBtn);
        btnPanel.add(clearBtn);

        displayArea = new JTextArea(10, 70);
        displayArea.setEditable(false);

        bottomPanel.add(btnPanel, BorderLayout.NORTH);
        bottomPanel.add(new JScrollPane(displayArea), BorderLayout.CENTER);

        add(bottomPanel, BorderLayout.SOUTH);

        submitBtn.addActionListener(this);
        clearBtn.addActionListener(e -> clearForm());
        showInfoBtn.addActionListener(e -> showBasicInfo());
        operateBtn.addActionListener(e -> runVehicleOperation());
        displayAllBtn.addActionListener(e -> displayAllVehicles());
        checkTypeBtn.addActionListener(e -> checkVehicleType());
    }

    // -------- FORM SWITCH --------
    private void showForm(String type) 
    {
        selectedType = type;

        formPanel.removeAll();
        formPanel.setLayout(new GridLayout(0, 2, 10, 10));

        nameField = new JTextField(15);
        speedField = new JTextField(10);

        formPanel.add(new JLabel(type + " Name:"));
        formPanel.add(nameField);

        formPanel.add(new JLabel("Speed (km/h):"));
        formPanel.add(speedField);

        if(type.equals("Car")) 
        {
            seatsField = new JTextField(10);
            fuelField = new JTextField(10);
            tankField = new JTextField(10);

            formPanel.add(new JLabel("Seats:"));
            formPanel.add(seatsField);

            formPanel.add(new JLabel("Fuel Efficiency:"));
            formPanel.add(fuelField);

            formPanel.add(new JLabel("Tank Capacity:"));
            formPanel.add(tankField);
        }
        else 
        {
            gearField = new JTextField(10);
            carrierBox = new JCheckBox("Has Carrier");
            distanceField = new JTextField(10);

            formPanel.add(new JLabel("Gear Count:"));
            formPanel.add(gearField);

            formPanel.add(new JLabel(""));
            formPanel.add(carrierBox);

            formPanel.add(new JLabel("Distance:"));
            formPanel.add(distanceField);
        }

        formPanel.revalidate();
        formPanel.repaint();
    }
    
    private void clearForm() 
    {
        if(nameField != null) nameField.setText("");
        if(speedField != null) speedField.setText("");
        if(seatsField != null) seatsField.setText("");
        if(fuelField != null) fuelField.setText("");
        if(tankField != null) tankField.setText("");
        if(gearField != null) gearField.setText("");
        if(distanceField != null) distanceField.setText("");
        if(carrierBox != null) carrierBox.setSelected(false);
    }

    private int getIndexFromDialog() 
    {
        int index = -1;

        try 
        {
            String input = JOptionPane.showInputDialog(this, "Enter Vehicle Index:");

            if(input == null) return -1;

            index = Integer.parseInt(input.trim());

            if(index < 0 || index >= vehicles.size()) 
            {
                JOptionPane.showMessageDialog(this, "Index out of range!");
                return -1;
            }
        } 
        catch(Exception ex) 
        {
            JOptionPane.showMessageDialog(this, "Enter only numbers!");
        }

        return index;
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
            
        // PART 1: Upcasting here
        try 
        {
            String name = nameField.getText().trim();
            int speed = Integer.parseInt(speedField.getText().trim());
            Vehicle v;
            if(selectedType.equals("Car")) 
            {
                // int seats, double fuel, double tank
                int seats=Integer.parseInt(seatsField.getText().trim());
                double fuel=Double.parseDouble(fuelField.getText().trim());
                double tank=Double.parseDouble(tankField.getText().trim());
                
                v=new Car(name,speed,seats,fuel,tank);
                vehicles.add(v);
                displayArea.append(v.getInfo()+"\n");
            }
            else if(selectedType.equals("Bike")) 
            {
                // boolean carrier, int gear, double distance
                
                boolean carrier=carrierBox.isSelected();
                int gear=Integer.parseInt(gearField.getText().trim());
                double distance=Double.parseDouble(distanceField.getText().trim());
                
                v=new Bike(name,speed,carrier,gear,distance);
                vehicles.add(v);
                displayArea.append(v.getInfo()+"\n");
    
            }
            JOptionPane.showMessageDialog(this,"added succesfully");
            clearForm();
        } 
        catch(Exception ex) 
        {
            JOptionPane.showMessageDialog(this, "Invalid input!", "Error Message", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showBasicInfo() 
    {
       // Part 2: show basic info
       int index = getIndexFromDialog();
       if(index!=-1){
           Vehicle v= vehicles.get(index);
           displayArea.append(v.getInfo()+"\n");
       }
    }

    private void runVehicleOperation() 
    {
       // Part 3: run bike or vehicle operations on the basis of index
       int index = getIndexFromDialog();
       if(index!=-1){
           Vehicle v= vehicles.get(index);
           if(v instanceof Bike){
               Bike vh=(Bike)v;
               JOptionPane.showMessageDialog(this,vh.calculateTravelTime());
           }else if(v instanceof Car){
               Car vh=(Car)v;
               JOptionPane.showMessageDialog(this,vh.calculateRange());
           }
       }
    }

    private void displayAllVehicles() 
    {
       // Part 4: display all vehicles here
        if(vehicles.isEmpty()){
            JOptionPane.showMessageDialog(this,"no object created yet");
        }else{
            for(int i=0;i<vehicles.size();i++){
                displayArea.append(vehicles.get(i).getInfo()+"\n");
            }
        }
    }


    private void checkVehicleType() 
    {
        // Part 5: check the type of vehicle at the user given index
       int index = getIndexFromDialog();
       if(index!=-1){
           Vehicle v= vehicles.get(index);
           if(v instanceof Bike){
               JOptionPane.showMessageDialog(this,"Bike");
           }else if(v instanceof Car){
               JOptionPane.showMessageDialog(this,"Car");
           }
       }
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> new VehicleForm().setVisible(true));
    }
}