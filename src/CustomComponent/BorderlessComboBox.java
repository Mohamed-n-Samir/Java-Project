package CustomComponent;

import javax.swing.*;

import javax.swing.plaf.basic.BasicComboBoxUI;


public class BorderlessComboBox {
    
   public BorderlessComboBox() {
      JTextField textField = new JTextField(15);
      textField.setBorder(null);

      Object[] items = {"First Item", "Second Item", "Third Item"};
      JComboBox comboBox = new JComboBox(items);
      comboBox.setUI(new BasicComboBoxUI() {

         @Override
         protected JButton createArrowButton() {
            JButton button = super.createArrowButton();
            button.setVisible(false);
            return button;
         }
      });
      JPanel panel = new JPanel();
      panel.add(textField);
      panel.add(comboBox);

//      JPanel panel = new JPanel();
//      panel.add(textField);
//      panel.add(comboBox);
//
//      JFrame frame = new JFrame("Borderless");
//      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//      frame.setSize(200, 200);
//      frame.setContentPane(panel);
//      frame.setLocationRelativeTo(null);
//      frame.setVisible(true);
   }
}

//   public static void main(String[] args) {
//      UIManager.put("ComboBox.background",
//              new ColorUIResource(Color.WHITE));
//      UIManager.put("ComboBox.selectionBackground",
//              new ColorUIResource(Color.WHITE));
//      SwingUtilities.invokeLater(new Runnable() {
//
//         @Override
//         public void run() {
//            new BorderlessComboBox().makeUI();
//         }
//      });
//   }
//}