package keywords;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Define an interface
interface Animal {
    void makeSound();
}

// Implement the interface using the extends keyword
class Dog implements Animal {
    @Override
    public void makeSound() {
        JOptionPane.showMessageDialog(null, "Woof! Woof!");
    }
}

class Cat implements Animal {
    @Override
    public void makeSound() {
        JOptionPane.showMessageDialog(null, "Meow! Meow!");
    }
}

class Other implements Animal {
    @Override
    public void makeSound() {
        JOptionPane.showMessageDialog(null, "Unknown!");
    }
}

// Main GUI class
public class Interface extends JFrame {

    public Interface() {
        super("Animal Sounds");

        // Create buttons for each animal
        JButton dogButton = new JButton("Dog");
        JButton catButton = new JButton("Cat");
        JButton otherButton = new JButton("Other");    

        // Add action listeners to the buttons
        dogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dog myDog = new Dog();
                myDog.makeSound();
            }
        });

        catButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cat myCat = new Cat();
                myCat.makeSound();
            }
        });

        otherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Other myOther = new Other();
                myOther.makeSound();
            }
        });

        
        // Create a panel and add buttons to it
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.add(dogButton);
        panel.add(catButton);
        panel.add(otherButton);

        // Set up the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    public static void main(String[] args) {
        // Create the GUI frame
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Interface();
            }
        });
    }
}
