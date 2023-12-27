package shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

abstract class Shape {
    protected int dimension1;
    protected int dimension2;

    public Shape(int dimension1, int dimension2) {
        this.dimension1 = dimension1;
        this.dimension2 = dimension2;
    }

    public abstract void printArea();
}

class Rectangle extends Shape {
    public Rectangle(int length, int width) {
        super(length, width);
    }

    @Override
    public void printArea() {
        int area = dimension1 * dimension2;
        JOptionPane.showMessageDialog(null, "Area of Rectangle: " + area);
    }
}

class Triangle extends Shape {
    public Triangle(int base, int height) {
        super(base, height);
    }

    @Override
    public void printArea() {
        int area = (int) (0.5 * dimension1 * dimension2);
        JOptionPane.showMessageDialog(null, "Area of Triangle: " + area);
    }
}

class Circle extends Shape {
    public Circle(int radius) {
        super(radius, 0); // Assuming dimension1 is the radius and dimension2 is not used
    }

    @Override
    public void printArea() {
        int area = (int) (Math.PI * dimension1 * dimension1);
        JOptionPane.showMessageDialog(null, "Area of Circle: " + area);
    }
}

public class ThreeTypeShape {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Shape");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            String[] shapeOptions = {"Select", "Rectangle", "Triangle", "Circle"};
            JComboBox<String> shapeComboBox = new JComboBox<>(shapeOptions);
            JTextField dimension1Field = new JTextField(10);
            JTextField dimension2Field = new JTextField(10);
            JLabel label1 = new JLabel("Dimension 1:");
            JLabel label2 = new JLabel("Dimension 2:");
            JButton calculateButton = new JButton("Calculate");
            calculateButton.setEnabled(false); // Disable initially

            JPanel panel = new JPanel(new GridLayout(5, 1));
            panel.add(new JLabel("Select Shape:"));
            panel.add(shapeComboBox);
            panel.add(label1);
            panel.add(dimension1Field);
            panel.add(label2);
            panel.add(dimension2Field);

            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            buttonPanel.add(calculateButton);

            frame.add(panel, BorderLayout.CENTER);
            frame.add(buttonPanel, BorderLayout.SOUTH);

            calculateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String selectedShape = (String) shapeComboBox.getSelectedItem();
                    int dimension1 = Integer.parseInt(dimension1Field.getText());
                    int dimension2 = Integer.parseInt(dimension2Field.getText());

                    if (!selectedShape.equals("Select")) {
                        Shape shape = createShape(selectedShape, dimension1, dimension2);
                        if (shape != null) {
                            shape.printArea();
                        }
                    }
                }
            });

            shapeComboBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String selectedShape = (String) shapeComboBox.getSelectedItem();
                    label1.setText(getLabelName(selectedShape, 1));
                    label2.setText(getLabelName(selectedShape, 2));
                    dimension2Field.setVisible(!selectedShape.equals("Circle"));
                    calculateButton.setEnabled(!selectedShape.equals("Select"));
                }
            });

            frame.setSize(220, 180);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    private static Shape createShape(String shapeType, int dimension1, int dimension2) {
        switch (shapeType) {
            case "Rectangle":
                return new Rectangle(dimension1, dimension2);
            case "Triangle":
                return new Triangle(dimension1, dimension2);
            case "Circle":
                return new Circle(dimension1);
            default:
                return null;
        }
    }

    private static String getLabelName(String shapeType, int dimensionNumber) {
        switch (shapeType) {
            case "Rectangle":
                return (dimensionNumber == 1) ? "Length:" : "Width:";
            case "Triangle":
                return (dimensionNumber == 1) ? "Base:" : "Height:";
            case "Circle":
                return (dimensionNumber == 1) ? "Radius:" : "";
            default:
                return "";
        }
    }
}
