package Shapes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * A simple toggle switch component for Java Swing.
 */
public class ToggleSwitch extends JComponent {
    private boolean selected = false;
    private final int width = 50;
    private final int height = 25;

    public ToggleSwitch() {
        setPreferredSize(new Dimension(width, height));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selected = !selected;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Background
        if (selected) {
            g2.setColor(new Color(0x728c89)); // teal for ON
        } else {
            g2.setColor(Color.LIGHT_GRAY); // gray for OFF
        }
        g2.fillRoundRect(0, 0, width, height, height, height);

        // Knob
        int padding = 2;
        int knobDiameter = height - 2 * padding;
        int knobX = selected ? width - knobDiameter - padding : padding;
        g2.setColor(Color.WHITE);
        g2.fillOval(knobX, padding, knobDiameter, knobDiameter);

        g2.dispose();
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        repaint();
    }

    // Demo frame
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Toggle Switch Demo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new FlowLayout());

            ToggleSwitch toggle = new ToggleSwitch();
            frame.add(toggle);

            JLabel status = new JLabel("OFF");
            frame.add(status);

            toggle.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    status.setText(toggle.isSelected() ? "ON" : "OFF");
                }
            });

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
