package integer.division;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntegerDivision extends JFrame {

    private JTextField num1Field, num2Field;
    private JFrame resultFrame;
    private JTextField resultField;

    public IntegerDivision() {
        // Set up the main frame
        setTitle("Integre Division");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(270, 140);

        // Center the main frame on the screen
        setLocationRelativeTo(null);

        // Create components for the main frame
        JLabel num1Label = new JLabel("Num1:");
        num1Field = new JTextField(10);

        JLabel num2Label = new JLabel("Num2:");
        num2Field = new JTextField(10);

        JButton divideButton = new JButton("Divide");

        // Set layout for the main frame
        setLayout(new GroupLayout(getContentPane()));

        GroupLayout layout = (GroupLayout) getContentPane().getLayout();
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(num1Label)
                        .addComponent(num2Label))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(num1Field)
                        .addComponent(num2Field)
                        .addComponent(divideButton))
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(num1Label)
                        .addComponent(num1Field))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(num2Label)
                        .addComponent(num2Field))
                .addComponent(divideButton)
        );

        // Add action listener to the divide button
        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int num1 = Integer.parseInt(num1Field.getText());
                    int num2 = Integer.parseInt(num2Field.getText());

                    if (num2 == 0) {
                        throw new ArithmeticException("Cannot divide by zero");
                    }

                    int result = num1 / num2;

                    // Display the result in a new window
                    displayResult(result);
                } catch (NumberFormatException ex) {
                    showErrorMessage("Please enter valid integers for Num1 and Num2");
                } catch (ArithmeticException ex) {
                    showErrorMessage("Cannot divide by zero");
                }
            }
        });
    }

    private void displayResult(int result) {
        // Set up the result frame
        resultFrame = new JFrame("Result");
        resultFrame.setSize(200, 100);
        resultFrame.setLayout(new FlowLayout());
        resultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Center the result frame on the screen
        resultFrame.setLocationRelativeTo(null);

        // Create components for the result frame
        resultField = new JTextField(String.valueOf(result), 10);
        resultField.setEditable(false);

        resultFrame.add(new JLabel("Result: "));
        resultFrame.add(resultField);

        // Make the result frame visible
        resultFrame.setVisible(true);
    }

    private void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new IntegerDivision().setVisible(true);
            }
        });
    }
}
