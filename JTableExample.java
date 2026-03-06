import javax.swing.*;

public class JTableExample {

    public static void main(String[] args) {

        String[] columnNames = {"ID", "Name", "Course", "Gender", "Skill"};

        Object[][] rowData = {
            {101, "Alice", "BSc", "Female", "Java"},
            {102, "Bob", "BBA", "Male", "Python"},
            {103, "Charlie", "BIT", "Other", "C++"}
        };

        JTable table = new JTable(rowData, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table.setRowHeight(25);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(table);

        JFrame frame = new JFrame("Student Records");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(scrollPane);
        frame.setVisible(true);
    }
}