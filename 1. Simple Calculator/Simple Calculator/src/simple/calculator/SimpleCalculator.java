package simple.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator {
    private JFrame frame;
    private JTextField textField;
    private JButton[] numberButtons = new JButton[10];
    private JButton[] functionButtons = new JButton[8];
    private JButton addButton, subButton, mulButton, divButton, eqButton, clrButton, dotButton, perButton, backspaceButton, signButton;
    private JPanel panel;

    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    public SimpleCalculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(10, 10, 360, 80);
        textField.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT); // Set text alignment to right

        panel = new JPanel();
        panel.setBounds(10, 100, 360, 400);
        panel.setLayout(new GridLayout(5, 4, 5, 5));

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        eqButton = new JButton("=");
        clrButton = new JButton("CE");
        dotButton = new JButton(".");
        perButton = new JButton("%");
        backspaceButton = new JButton("C");
        signButton = new JButton("+/-");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = eqButton;
        functionButtons[5] = clrButton;
        functionButtons[6] = backspaceButton;
        functionButtons[7] = signButton;

        for (int i = 0; i < 8; i++) {
            functionButtons[i].setFont(new Font("Times New Roman", Font.PLAIN, 18));
            functionButtons[i].setFocusPainted(false);
            functionButtons[i].addActionListener(new OperatorAction());
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Times New Roman", Font.PLAIN, 18));
            numberButtons[i].setFocusPainted(false);
            numberButtons[i].addActionListener(new NumberAction());
        }

        clrButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        clrButton.setFocusPainted(false);
        clrButton.addActionListener(new ClearAction());

        dotButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        dotButton.setFocusPainted(false);
        dotButton.addActionListener(new DotAction());

        perButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        perButton.setFocusPainted(false);
        perButton.addActionListener(new OperatorAction());

        backspaceButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        backspaceButton.setFocusPainted(false);
        backspaceButton.addActionListener(new BackspaceAction());

        signButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        signButton.setFocusPainted(false);
        signButton.addActionListener(new SignAction());

        panel.add(clrButton);
        panel.add(backspaceButton);
        panel.add(signButton);
        panel.add(perButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(divButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(mulButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(subButton);
        panel.add(numberButtons[0]);
        panel.add(dotButton);
        panel.add(eqButton);
        panel.add(addButton);
        
        frame.add(textField);
        frame.add(panel);
        frame.setVisible(true);
    }

    private class SignAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String currentText = textField.getText();
            if (!currentText.isEmpty()) {
                double currentValue = Double.parseDouble(currentText);
                currentValue = -currentValue;
                textField.setText(String.valueOf(currentValue));
            }
        }
    }

    private class NumberAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            textField.setText(textField.getText() + button.getText());
        }
    }

    private class OperatorAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String buttonText = button.getText();

            if (!buttonText.equals("=")) {
                if (!textField.getText().isEmpty()) {
                    num1 = Double.parseDouble(textField.getText());
                    operator = buttonText.charAt(0);
                    textField.setText("");
                }
            } else {
                if (!textField.getText().isEmpty()) {
                    num2 = Double.parseDouble(textField.getText());
                    switch (operator) {
                        case '+':
                            result = num1 + num2;
                            break;
                        case '-':
                            result = num1 - num2;
                            break;
                        case '*':
                            result = num1 * num2;
                            break;
                        case '/':
                            if (num2 != 0) {
                                result = num1 / num2;
                            } else {
                                JOptionPane.showMessageDialog(null, "Error: Division by zero is not allowed.");
                                return;
                            }
                            break;
                        case '%':
                            result = num1 % num2;
                            break;
                    }
                    textField.setText(String.valueOf(result));
                }
            }
        }
    }

    private class ClearAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            textField.setText("");
            num1 = 0;
            num2 = 0;
            result = 0;
        }
    }

    private class DotAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (!textField.getText().contains(".")) {
                textField.setText(textField.getText() + ".");
            }
        }
    }

    private class BackspaceAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String currentText = textField.getText();
            if (!currentText.isEmpty()) {
                textField.setText(currentText.substring(0, currentText.length() - 1));
            }
        }
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}