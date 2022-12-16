package CustomComponent;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
//import java.util.HashMap;
//import java.util.Map;
import javax.swing.BorderFactory;
//import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class TableTextCenter extends JTable {

    private final TableDarkHeader header;
    private final TableDarkCell cell;

    public TableTextCenter() {
        header = new TableDarkHeader();
        cell = new TableDarkCell();
        getTableHeader().setDefaultRenderer(header);
        getTableHeader().setPreferredSize(new Dimension(0, 35));
        setDefaultRenderer(Object.class, cell);
        setRowHeight(25);
    }

    public void fixTable(JScrollPane scroll) {
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
        scroll.getViewport().setBackground(new Color(59, 90, 113));
        scroll.setBorder(BorderFactory.createLineBorder(new Color(60, 60, 60), 2));
    }

    private class TableDarkHeader extends DefaultTableCellRenderer {

//        private Map<Integer, Integer> alignment = new HashMap<>();
//
//        public void setAlignment(int column, int align) {
//            alignment.put(column, align);
//        }
        @Override
        public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
            Component com = super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
            com.setBackground(new Color(45, 68, 86));
            com.setForeground(new Color(255, 255, 255));
            com.setFont(com.getFont().deriveFont(Font.BOLD, 12));
            setHorizontalAlignment(SwingConstants.CENTER);

            return com;
        }
    }

    private class TableDarkCell extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int row, int column) {
            Component com = super.getTableCellRendererComponent(jtable, o, bln, bln1, row, column);
            if (isCellSelected(row, column)) {
//                if (row % 2 == 0) {
                com.setBackground(new Color(70, 202, 255));     //255, 44, 107
                com.setForeground(new Color(255, 255, 255));

//                } else {
//                    com.setBackground(new Color(29, 86, 127));
//                }
            } else {
                com.setForeground(new Color(200, 200, 200));
                if (row % 2 == 0) {
                    com.setBackground(new Color(50, 50, 50));
                } else {
                    com.setBackground(new Color(91, 110, 128));   //91,110,128
                }
            }
            setBorder(new EmptyBorder(0, 5, 0, 5));
            setHorizontalAlignment(SwingConstants.CENTER);
            return com;
        }

    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    
}
