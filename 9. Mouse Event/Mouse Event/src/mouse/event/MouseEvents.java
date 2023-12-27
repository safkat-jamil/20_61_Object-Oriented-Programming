package mouse.event;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MouseEvents extends JFrame {

    private JLabel eventLabel;

    public MouseEvents() {
        super("Mouse Event");

        eventLabel = new JLabel("Event Name");
        eventLabel.setHorizontalAlignment(JLabel.CENTER);
        add(eventLabel);

        addMouseListener(new MyMouseAdapter());

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class MyMouseAdapter extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            displayEventName("Mouse Clicked");
        }

        @Override
        public void mousePressed(MouseEvent e) {
            displayEventName("Mouse Pressed");
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            displayEventName("Mouse Released");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            displayEventName("Mouse Entered");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            displayEventName("Mouse Exited");
        }
    }

    private void displayEventName(String eventName) {
        eventLabel.setText(eventName);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MouseEvents());
    }
}
