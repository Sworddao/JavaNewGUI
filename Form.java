import java.awt.*;
import javax.swing.*;

public class Form extends JFrame{
    
    private String[] buttons = {"Add", "Edit", "Delete", "View"}; 
        
    public Form(){
        setTitle("Layout Demon");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        // Title panel at the top
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Welcome to Admin Dashboard!");
        titlePanel.add(titleLabel);
        
        // Sidebar panel on the left
        JPanel sidebarPanel = new JPanel();
        sidebarPanel.setLayout(new BoxLayout(sidebarPanel, BoxLayout.Y_AXIS));
        sidebarPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        
        sidebarPanel.add(Box.createVerticalGlue());
        
        for(String btn : buttons){
            JButton button = new JButton(btn);
            button.setMaximumSize(new Dimension(100, 40));
            sidebarPanel.add(button);
            sidebarPanel.add(Box.createVerticalStrut(10));
        }
        
        sidebarPanel.add(Box.createVerticalGlue());
        
        // Form panel in the center
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JPanel row1 = new JPanel();
        row1.setLayout(new BoxLayout(row1, BoxLayout.X_AXIS));
        
        JLabel nameLabel = new JLabel("Name: ");
        JTextField txtName = new JTextField();
        txtName.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30)); // makes it stretch horizontally
        
        row1.add(nameLabel);
        row1.add(Box.createRigidArea(new Dimension(10,0))); // space between label and textfield
        row1.add(txtName); 
        
        formPanel.add(row1);
        
        // Add panels to frame
        add(sidebarPanel, BorderLayout.WEST);
        add(titlePanel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER); // <-- this was missing
    }
    
    public static void main(String[] args){
        SwingUtilities.invokeLater(() ->{
            new Form().setVisible(true);
        });
    }
}