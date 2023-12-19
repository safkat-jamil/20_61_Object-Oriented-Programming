package quadratic.equation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuadraticEquation extends JFrame {

    private JTextField aField, bField, cField;

    public QuadraticEquation() {
        super("Quadratic Equation Solver");

        // Set layout manager
        setLayout(new GridLayout(4, 2, 5, 5));

        // Create components
        JLabel aLabel = new JLabel("Enter a:");
        aField = new JTextField();
        JLabel bLabel = new JLabel("Enter b:");
        bField = new JTextField();
        JLabel cLabel = new JLabel("Enter c:");
        cField = new JTextField();

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateAndDisplay();
            }
        });

        // Add components to the frame
        add(aLabel);
        add(aField);
        add(bLabel);
        add(bField);
        add(cLabel);
        add(cField);
        add(new JLabel()); // Empty label for spacing
        add(calculateButton);

        // Set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    private void calculateAndDisplay() {
        try {
            // Get values from text fields
            double a = Double.parseDouble(aField.getText());
            double b = Double.parseDouble(bField.getText());
            double c = Double.parseDouble(cField.getText());

            // Calculate the discriminant
            double discriminant = b * b - 4 * a * c;

            // Check if the discriminant is non-negative
            if (discriminant >= 0) {
                // Calculate the real solutions using the quadratic formula
                double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);

                // Display result in a new window
                displayResult(root1, root2);
            } else {
                // If the discriminant is negative, no real solutions exist
                JOptionPane.showMessageDialog(this, "No real solutions. The discriminant is negative.",
                        "Result", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter numeric values for a, b, and c.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displayResult(double root1, double root2) {
        JFrame resultFrame = new JFrame("Result");
        resultFrame.setLayout(new GridLayout(3, 1));

        JLabel label1 = new JLabel("Real Solutions:");
        JLabel label2 = new JLabel("Root 1: " + root1);
        JLabel label3 = new JLabel("Root 2: " + root2);

        resultFrame.add(label1);
        resultFrame.add(label2);
        resultFrame.add(label3);

        resultFrame.setSize(300, 150);
        resultFrame.setLocationRelativeTo(this); // Center the result frame relative to the main frame
        resultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        resultFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new QuadraticEquation();
            }
        });
    }
}