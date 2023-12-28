// Main Package
package converter;

import converter.currency.CurrencyConverter;
import converter.distance.DistanceConverter;
import converter.Time.TimeConverter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Converter extends JFrame {
    private JComboBox<String> conversionTypeComboBox;
    private JComboBox<String> specificConversionComboBox;
    private JTextField inputField;
    private JButton convertButton;

    public Converter() {
        setTitle("Converter");
        setSize(250, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Center the window on the screen
        setLocationRelativeTo(null);

        setLayout(new GridLayout(4, 1));

        String[] conversionTypes = {"Currency", "Distance", "Time"};
        conversionTypeComboBox = new JComboBox<>(conversionTypes);

        specificConversionComboBox = new JComboBox<>();

        inputField = new JTextField();
        convertButton = new JButton("Convert");

        conversionTypeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateSpecificConversionOptions();
            }
        });

        add(conversionTypeComboBox);
        add(specificConversionComboBox);
        add(inputField);
        add(convertButton);

        updateSpecificConversionOptions();

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convert();
            }
        });
    }

    private void updateSpecificConversionOptions() {
        String selectedConversionType = (String) conversionTypeComboBox.getSelectedItem();
        String[] specificConversionOptions;

        switch (selectedConversionType) {
            case "Currency":
                specificConversionOptions = new String[]{
                        "Dollar to BDT", "Euro to BDT", "Yen to BDT",
                        "BDT to Dollar", "BDT to Euro", "BDT to Yen"
                };
                break;
            case "Distance":
                specificConversionOptions = new String[]{"Meter to KM", "KM to Meter", "Miles to KM", "KM to Miles"};
                break;
            case "Time":
                specificConversionOptions = new String[]{"Hours to Minutes", "Hours to Seconds", "Minutes to Hours", "Seconds to Hours"};
                break;
            default:
                specificConversionOptions = new String[]{};
                break;
        }

        specificConversionComboBox.setModel(new DefaultComboBoxModel<>(specificConversionOptions));
    }

    private void convert() {
        String selectedConversion = (String) specificConversionComboBox.getSelectedItem();
        double inputValue = Double.parseDouble(inputField.getText());
        double result = 0;

        switch (selectedConversion) {
            case "Dollar to BDT":
                result = CurrencyConverter.convertDollarToBDT(inputValue);
                break;
            case "Euro to BDT":
                result = CurrencyConverter.convertEuroToBDT(inputValue);
                break;
            case "Yen to BDT":
                result = CurrencyConverter.convertYenToBDT(inputValue);
                break;
            case "BDT to Dollar":
                result = CurrencyConverter.convertBDTToDollar(inputValue);
                break;
            case "BDT to Euro":
                result = CurrencyConverter.convertBDTToEuro(inputValue);
                break;
            case "BDT to Yen":
                result = CurrencyConverter.convertBDTToYen(inputValue);
                break;
            case "Meter to KM":
                result = DistanceConverter.convertMeterToKM(inputValue);
                break;
            case "KM to Meter":
                result = DistanceConverter.convertKMToMeter(inputValue);
                break;
            case "Miles to KM":
                result = DistanceConverter.convertMilesToKM(inputValue);
                break;
            case "KM to Miles":
                result = DistanceConverter.convertKMToMiles(inputValue);
                break;
            case "Hours to Minutes":
                result = TimeConverter.convertHoursToMinutes(inputValue);
                break;
            case "Hours to Seconds":
                result = TimeConverter.convertHoursToSeconds(inputValue);
                break;
            case "Minutes to Hours":
                result = TimeConverter.convertMinutesToHours(inputValue);
                break;
            case "Seconds to Hours":
                result = TimeConverter.convertSecondsToHours(inputValue);
                break;
            default:
                break;
        }

        // Display result in a new window
        showResult(result);
    }

    private void showResult(double result) {
        JFrame resultFrame = new JFrame("Result");
        resultFrame.setSize(300, 100);
        resultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Center the result window on the screen
        resultFrame.setLocationRelativeTo(null);

        JLabel resultLabel = new JLabel("Result: " + result);
        resultFrame.add(resultLabel);

        resultFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Converter converterGUI = new Converter();
                // Center the window on the screen
                converterGUI.setLocationRelativeTo(null);
                converterGUI.setVisible(true);
            }
        });
    }
}