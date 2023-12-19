package illustrate.overloading;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class IllustrateOverloading extends JFrame {

    public IllustrateOverloading() {
        setTitle("Method Overloading");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton addButton = new JButton("Add Two Integers");
        addButton.addActionListener(e -> {
            int num1 = getUserInput("Enter the first integer:");
            int num2 = getUserInput("Enter the second integer:");
            showResult(add(num1, num2));
        });

        JButton addThreeButton = new JButton("Add Three Integers");
        addThreeButton.addActionListener(e -> {
            int num1 = getUserInput("Enter the first integer:");
            int num2 = getUserInput("Enter the second integer:");
            int num3 = getUserInput("Enter the third integer:");
            showResult(add(num1, num2, num3));
        });

        JButton concatenateButton = new JButton("Concatenate Strings");
        concatenateButton.addActionListener(e -> {
            String str1 = JOptionPane.showInputDialog("Enter the first string:");
            String str2 = JOptionPane.showInputDialog("Enter the second string:");
            showResult(concatenate(str1, str2));
        });

        setLayout(new java.awt.FlowLayout());
        add(addButton);
        add(addThreeButton);
        add(concatenateButton);
    }

    // Method to add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Method to add three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Method to concatenate two strings
    public String concatenate(String str1, String str2) {
        return str1 + str2;
    }

    private int getUserInput(String message) {
        String input = JOptionPane.showInputDialog(message);
        return Integer.parseInt(input);
    }

    private void showResult(Object result) {
        JOptionPane.showMessageDialog(this, "Result: " + result, "Method Overloading Example", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            IllustrateOverloading gui = new IllustrateOverloading();
            gui.setVisible(true);
        });
    }
}