package fruit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Base class
class Fruit0 {
    protected String name;
    protected String taste;
    protected String size;

    // Constructor
    public Fruit0(String name, String taste, String size) {
        this.name = name;
        this.taste = taste;
        this.size = size;
    }

    // Method to describe eating the fruit
    public void eat() {
        JOptionPane.showMessageDialog(null, "Eating " + name + ". It tastes " + taste + ".");
    }
}

// Subclass Apple
class Apple extends Fruit0 {
    // Constructor
    public Apple(String size) {
        super("Apple", "sweet", size);
    }

    // Override eat method to represent apple taste
    @Override
    public void eat() {
        JOptionPane.showMessageDialog(null, "Crunching on an apple. It tastes sweet and a bit tangy.");
    }
}

// Subclass Orange
class Orange extends Fruit0 {
    // Constructor
    public Orange(String size) {
        super("Orange", "citrusy", size);
    }

    // Override eat method to represent orange taste
    @Override
    public void eat() {
        JOptionPane.showMessageDialog(null, "Peeling and enjoying an orange. It tastes citrusy and refreshing.");
    }
}

// Main GUI class
public class Fruit extends JFrame {

    private JComboBox<String> fruitComboBox;
    private JButton eatButton;

    public Fruit() {
        setTitle("Fruit Eating App");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create and populate the combo box
        String[] fruits = {"Apple", "Orange", "Unknown Fruit"};
        fruitComboBox = new JComboBox<>(fruits);
        add(fruitComboBox);

        // Create the Eat button
        eatButton = new JButton("Eat");
        add(eatButton);

        // Add action listener to the Eat button
        eatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eatSelectedFruit();
            }
        });
    }

    // Method to eat the selected fruit based on the combo box selection
    private void eatSelectedFruit() {
        String selectedFruit = (String) fruitComboBox.getSelectedItem();

        Fruit0 fruit;
        switch (selectedFruit) {
            case "Apple":
                fruit = new Apple("medium");
                break;
            case "Orange":
                fruit = new Orange("large");
                break;
            default:
                fruit = new Fruit0("Unknown Fruit", "unknown", "medium");
        }

        fruit.eat();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Fruit().setVisible(true);
            }
        });
    }
}