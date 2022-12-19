package CustomComponent;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class RoundedJTextFieldTest extends JTextField {

    private boolean mouseOver = false;

    public RoundedJTextFieldTest(int size) {
        super(size);
        setBorder(new EmptyBorder(0, 15, 0, 0));
        setOpaque(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                mouseOver = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent me) {
                mouseOver = false;
                repaint();
            }

        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
    }

    @Override
    public void paint(Graphics grphcs) {
        super.paint(grphcs);
        Graphics2D g2 = (Graphics2D) grphcs;
        int width = getWidth();
        int height = getHeight();
        if (mouseOver) {
            g2.setColor(Color.BLACK);
        } else {
            g2.setColor(new Color(150, 150, 150));
        }
        g2.fillRect(10, height - 15, width - 20, 1);
    }
}
