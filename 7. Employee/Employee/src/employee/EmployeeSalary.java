package employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Employee {
    String emp_name, emp_id, address, mail_id, mobile_no;
}

class Programmer extends Employee {
    int basicPay;

    Programmer(int basicPay) {
        this.basicPay = basicPay;
    }
}

class AssistantProfessor extends Employee {
    int basicPay;

    AssistantProfessor(int basicPay) {
        this.basicPay = basicPay;
    }
}

class AssociateProfessor extends Employee {
    int basicPay;

    AssociateProfessor(int basicPay) {
        this.basicPay = basicPay;
    }
}

class Professor extends Employee {
    int basicPay;

    Professor(int basicPay) {
        this.basicPay = basicPay;
    }
}

class PayrollResultWindow extends JFrame {
    private JTextArea resultArea;

    public PayrollResultWindow(String result, int totalEntries) {
        setTitle("Payroll Result");
        setSize(400, 400);

        // Center the frame on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int frameWidth = getWidth();
        int frameHeight = getHeight();
        setLocation((screenWidth - frameWidth) / 2, (screenHeight - frameHeight) / 2);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        resultArea = new JTextArea(result);
        resultArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(resultArea);
        add(scrollPane, BorderLayout.CENTER);

        // Add total entries section
        JLabel totalLabel = new JLabel("Total Entries: " + totalEntries);
        totalLabel.setHorizontalAlignment(JLabel.CENTER);
        add(totalLabel, BorderLayout.SOUTH);
    }
}

public class EmployeeSalary extends JFrame {
    private JTextField empNameField, empIdField, addressField, mailIdField, mobileNoField, basicPayField;
    private JComboBox<String> employeeTypeComboBox;
    private JTextArea resultArea;
    private ArrayList<String> history;

    public EmployeeSalary() {
        setTitle("Payroll System");
        setSize(380, 255);

        // Center the frame on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int frameWidth = getWidth();
        int frameHeight = getHeight();
        setLocation((screenWidth - frameWidth) / 2, (screenHeight - frameHeight) / 2);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        history = new ArrayList<>();

        employeeTypeComboBox = new JComboBox<>(new String[]{"Programmer", "Assistant Professor", "Associate Professor", "Professor"});
        add(createComboBoxPanel("Employee Type:", employeeTypeComboBox));

        empNameField = createTextField();
        empIdField = createTextField();
        addressField = createTextField();
        mailIdField = createTextField();
        mobileNoField = createTextField();
        basicPayField = createTextField();

        JButton calculateButton = new JButton("Calculate Salary");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateSalary();
            }
        });

        JButton showHistoryButton = new JButton("Show History");
        showHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showHistory();
            }
        });

        resultArea = new JTextArea();
        resultArea.setEditable(false);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2, 5, 5));
        inputPanel.add(new JLabel("Employee Name:"));
        inputPanel.add(empNameField);
        inputPanel.add(new JLabel("Employee ID:"));
        inputPanel.add(empIdField);
        inputPanel.add(new JLabel("Address:"));
        inputPanel.add(addressField);
        inputPanel.add(new JLabel("Mail ID:"));
        inputPanel.add(mailIdField);
        inputPanel.add(new JLabel("Mobile No:"));
        inputPanel.add(mobileNoField);
        inputPanel.add(new JLabel("Basic Pay:"));
        inputPanel.add(basicPayField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(calculateButton);
        buttonPanel.add(showHistoryButton);

        add(inputPanel);
        add(buttonPanel);
        add(resultArea);
    }

    private JTextField createTextField() {
        JTextField jTextField = new JTextField(20);
        jTextField.setAlignmentX(Component.LEFT_ALIGNMENT);
        return jTextField;
    }

    private JPanel createComboBoxPanel(String label, JComboBox<String> comboBox) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.add(new JLabel(label));
        panel.add(comboBox);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        return panel;
    }

    private void calculateSalary() {
        try {
            String empType = (String) employeeTypeComboBox.getSelectedItem();
            String empName = empNameField.getText();
            String empId = empIdField.getText();
            String address = addressField.getText();
            String mailId = mailIdField.getText();
            String mobileNo = mobileNoField.getText();
            int basicPay = Integer.parseInt(basicPayField.getText());

            history.add("Employee Type: " + empType + ", Employee Name: " + empName + ", Employee ID: " + empId +
                    ", Address: " + address + ", Mail ID: " + mailId + ", Mobile No: " + mobileNo + ", Basic Pay: " + basicPay);

            Employee employee = null;

            switch (empType) {
                case "Programmer":
                    employee = new Programmer(basicPay);
                    break;
                case "Assistant Professor":
                    employee = new AssistantProfessor(basicPay);
                    break;
                case "Associate Professor":
                    employee = new AssociateProfessor(basicPay);
                    break;
                case "Professor":
                    employee = new Professor(basicPay);
                    break;
            }

            // Display the pay slip
            double da = (0.97 * basicPay);
            double hra = (0.10 * basicPay);
            double pf = (0.12 * basicPay);
            double staffClubFund = (0.001 * basicPay);

            double grossSalary = basicPay + da + hra;
            double netSalary = grossSalary - pf - staffClubFund;

            String result = "Pay Slip\n" +
                    "Employee Type: " + empType + "\n" +
                    "Employee Name: " + empName + "\n" +
                    "Employee ID: " + empId + "\n" +
                    "Address: " + address + "\n" +
                    "Mail ID: " + mailId + "\n" +
                    "Mobile No: " + mobileNo + "\n" +
                    "Basic Pay: ৳" + basicPay + "\n" +
                    "Dearness Allowance (DA): ৳" + da + "\n" +
                    "House Rent Allowance (HRA): ৳" + hra + "\n" +
                    "Provident Fund (PF): ৳" + pf + "\n" +
                    "Staff Club Fund: ৳" + staffClubFund + "\n" +
                    "Gross Salary: ৳" + grossSalary + "\n" +
                    "Net Salary: ৳" + netSalary + "\n";

            resultArea.setText(result);

            // Show result in a new window
            int totalEntries = history.size();
            new PayrollResultWindow(result, totalEntries).setVisible(true);

        } catch (NumberFormatException e) {
            resultArea.setText("Error: Please enter valid numeric values for Basic Pay.");
        }
    }

    private void showHistory() {
        StringBuilder historyText = new StringBuilder("Input History:\n");

        for (String entry : history) {
            historyText.append(entry).append("\n");
        }

        JTextArea historyArea = new JTextArea(historyText.toString());
        historyArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(historyArea);

        JFrame historyFrame = new JFrame("Input History");
        historyFrame.setSize(400, 400);
        historyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        historyFrame.add(scrollPane);
        historyFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EmployeeSalary().setVisible(true);
            }
        });
    }
}
