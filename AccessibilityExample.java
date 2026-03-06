import javax.swing.*;

public class AccessibilityExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Accessibility Example");
        frame.setSize(400,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btnSave = new JButton("Save");
        btnSave.setMnemonic('S'); // ALT+S triggers button
        btnSave.setToolTipText("Click or press ALT+S to save the record");

        frame.setLayout(new java.awt.FlowLayout());
        frame.add(btnSave);

        // Make Enter key trigger the Save button
        frame.getRootPane().setDefaultButton(btnSave);

        frame.setVisible(true);
    }
}