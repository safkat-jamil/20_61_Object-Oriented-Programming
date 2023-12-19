package fine.the.prime.number.between.pkg1.to.n;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FineThePrimeNumberBetween1ToN {

    private JFrame frame;
    private JTextField inputField;
    private JTextArea outputArea;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                FineThePrimeNumberBetween1ToN window = new FineThePrimeNumberBetween1ToN();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public FineThePrimeNumberBetween1ToN() {
        frame = new JFrame();
        frame.setTitle("Prime Numbers Finder");
        frame.setBounds(100, 100, 400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, "Center");
        panel.setLayout(null);

        JLabel lblEnterN = new JLabel("Enter n:");
        lblEnterN.setBounds(10, 15, 60, 20);
        panel.add(lblEnterN);

        inputField = new JTextField();
        inputField.setBounds(80, 12, 100, 25);
        panel.add(inputField);

        JButton btnFindPrimes = new JButton("Find Primes");
        btnFindPrimes.setBounds(190, 12, 120, 25);
        panel.add(btnFindPrimes);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBounds(10, 50, 360, 200);
        panel.add(scrollPane);

        btnFindPrimes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                findAndDisplayPrimes();
            }
        });
    }

    private void findAndDisplayPrimes() {
        outputArea.setText(""); // Clear previous output

        try {
            int n = Integer.parseInt(inputField.getText());
            outputArea.append("Prime numbers between 1 and " + n + " are:\n");
            for (int i = 2; i <= n; i++) {
                if (isPrime(i)) {
                    outputArea.append(i + " ");
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid number for 'n'.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}