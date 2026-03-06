import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ButtonStateExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Submit State Example");
        frame.setSize(400,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        JTextField txtName = new JTextField();
        JTextField txtAge = new JTextField();
        JTextField txtPhone = new JTextField();
        JButton submit = new JButton("Submit");

        // Initially disable
        submit.setEnabled(false);

        // Document listener to watch for changes
        DocumentListener docListener = new DocumentListener() {
                void checkFields() {
                    boolean enabled = !txtName.getText().trim().isEmpty()
                        && !txtAge.getText().trim().isEmpty()
                        && !txtPhone.getText().trim().isEmpty();
                    submit.setEnabled(enabled);
                }

                @Override
                public void insertUpdate(DocumentEvent e) { checkFields(); }

                @Override
                public void removeUpdate(DocumentEvent e) { checkFields(); }

                @Override
                public void changedUpdate(DocumentEvent e) { checkFields(); }
            };

        txtName.getDocument().addDocumentListener(docListener);
        txtAge.getDocument().addDocumentListener(docListener);
        txtPhone.getDocument().addDocumentListener(docListener);

        frame.add(new JLabel("Name:"));
        frame.add(txtName);
        frame.add(new JLabel("Age:"));
        frame.add(txtAge);
        frame.add(new JLabel("Phone:"));
        frame.add(txtPhone);
        frame.add(submit);

        frame.setVisible(true);
    }
}