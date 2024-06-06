import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class HRISGUI extends JFrame {
    private JFrame frame;
    private JButton addEmployeeButton;
    private JButton showEmployeeButton;
    private List<Employee> employees;

    public HRISGUI() {
        employees = new ArrayList<>();
        frame = new JFrame("HRIS - Human Resource Information System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        addEmployeeButton = new JButton("Add Employee");
        showEmployeeButton = new JButton("Show Employees");

        addEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddEmployeeGUI(employees);
            }
        });

        showEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowEmployeeGUI(employees);
            }
        });

        frame.add(addEmployeeButton);
        frame.add(showEmployeeButton);

        frame.pack();
        frame.setSize(400, 100);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HRISGUI();
            }
        });
    }
}

class AddEmployeeGUI extends JFrame {
    private List<Employee> employees;
    private JTextField nameField;
    private JTextField dateOfBirthField;
    private JComboBox<String> positionComboBox;
    private JComboBox<String> departmentComboBox;

    public AddEmployeeGUI(List<Employee> employees) {
        this.employees = employees;
        JFrame frame = new JFrame("Add Employee");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(15);

        JLabel dateOfBirthLabel = new JLabel("Date of Birth (DDMMYYYY):");
        dateOfBirthField = new JTextField(15);

        JLabel departmentLabel = new JLabel("Department:");
        String[] departments = {"Product", "HR"};
        departmentComboBox = new JComboBox<>(departments);

        JLabel positionLabel = new JLabel("Position:");
        String[] positions = {"Manager", "Developer", "HR Staff"};
        positionComboBox = new JComboBox<>(positions);

        JButton addEmployeeButton = new JButton("Add Employee");

        addEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEmployee();
            }
        });

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(dateOfBirthLabel);
        inputPanel.add(dateOfBirthField);
        inputPanel.add(departmentLabel);
        inputPanel.add(departmentComboBox);
        inputPanel.add(positionLabel);
        inputPanel.add(positionComboBox);
        inputPanel.add(new JLabel());
        inputPanel.add(addEmployeeButton);

        mainPanel.add(inputPanel, BorderLayout.NORTH);

        frame.add(mainPanel);
        frame.pack();
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void addEmployee() {
        String name = nameField.getText();
        String dateOfBirth = dateOfBirthField.getText();
        String department = departmentComboBox.getSelectedItem().toString();
        String position = positionComboBox.getSelectedItem().toString();

        Employee employee = null;
        switch (position) {
            case "Manager":
                employee = new Manager(name, department, dateOfBirth);
                break;
            case "Developer":
                employee = new Developer(name, department, dateOfBirth);
                break;
            case "HR Staff":
                employee = new HRStaff(name, department, dateOfBirth);
                break;
        }

        if (employee != null) {
            employees.add(employee);
            JOptionPane.showMessageDialog(null, "Employee added: " + employee);
        } else {
            JOptionPane.showMessageDialog(null, "Failed to add employee.");
        }
    }
}

class ShowEmployeeGUI extends JFrame {
    private List<Employee> employees;
    private JTable dataTable;
    private DefaultTableModel tableModel;

    public ShowEmployeeGUI(List<Employee> employees) {
        this.employees = employees;
        JFrame frame = new JFrame("Show Employees");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Department");
        tableModel.addColumn("Date of Birth");
        tableModel.addColumn("Position");
        tableModel.addColumn("Salary");

        dataTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(dataTable);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        displayEmployees();

        frame.add(mainPanel);
        frame.pack();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void displayEmployees() {
        for (Employee employee : employees) {
            Object[] rowData = {employee.id, employee.name, employee.department, employee.dateOfBirth, employee.getClass().getSimpleName(), employee.salary};
            tableModel.addRow(rowData);
        }
    }
}
