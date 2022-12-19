package CustomComponent;

import java.awt.Graphics;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ReadField extends JTextField {

    public ReadField(int size) {
        super(size);
        setBorder(new EmptyBorder(0, 15, 0, 0));
        setOpaque(false);

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


}
