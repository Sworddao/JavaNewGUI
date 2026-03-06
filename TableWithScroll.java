import javax.swing.*;

public class TableWithScroll {

    public static void main(String[] args) {

        String[] columns = {"ID", "Name", "Course", "Gender", "Skill"};

        Object[][] data = new Object[50][5]; // 50 rows example
        for (int i = 0; i < 50; i++) {
            data[i][0] = 100 + i;
            data[i][1] = "Student " + (i + 1);
            data[i][2] = "BSc";
            data[i][3] = "Male";
            data[i][4] = "Java";
        }

        JTable table = new JTable(data, columns) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false; // Non-editable
                }
            };

        table.setRowHeight(25);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Wrap JTable in JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);

        JFrame frame = new JFrame("Student Table with Scroll");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(scrollPane); // add scroll pane, not table directly
        frame.setVisible(true);
    }
}