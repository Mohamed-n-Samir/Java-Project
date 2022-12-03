package GUI;

import java.awt.Color;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import CustomComponent.PasswordField;
import CustomComponent.RoundedJTextFieldTest;
import ProjectApplication.DbConnection;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ~Nash2T~
 */
public class AdminLogin extends javax.swing.JFrame {

    /**
     * Creates new form AdminLogin
     */
    public AdminLogin() {
        initComponents();
        getContentPane().setBackground(Color.white);                                                 // set new background color
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 15, 15)); // make rounded corners
        addWindowListener(new WindowAdapter() {                                                        // make auto focus on username field
            @Override
            public void windowOpened(WindowEvent e) {
                txtAdminUserName.requestFocus();
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        closeApplication = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        txtAdminUserName = new RoundedJTextFieldTest(50);
        pwdAdmin = new PasswordField(50);
        boxShowPwd = new javax.swing.JCheckBox();
        loginButton = new javax.swing.JButton();
        goBackButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(440, 585));
        setSize(new java.awt.Dimension(440, 585));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/admin (1).png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 117, 52, -1));

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel5.setPreferredSize(new java.awt.Dimension(100, 1));
        jPanel5.setRequestFocusEnabled(false);
        jPanel5.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 153, -1, -1));

        closeApplication.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close (1).png"))); // NOI18N
        closeApplication.setBorder(null);
        closeApplication.setBorderPainted(false);
        closeApplication.setContentAreaFilled(false);
        closeApplication.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        closeApplication.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeApplicationActionPerformed(evt);
            }
        });
        getContentPane().add(closeApplication, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 29, -1, -1));

        jLabel2.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(45, 68, 86));
        jLabel2.setText("Admin");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 193, 77, -1));

        jPanel10.setBackground(new java.awt.Color(0, 0, 0));
        jPanel10.setPreferredSize(new java.awt.Dimension(100, 1));
        jPanel10.setRequestFocusEnabled(false);
        jPanel10.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 154, -1, -1));

        txtAdminUserName.setBackground(new java.awt.Color(33, 191, 255));
        txtAdminUserName.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        txtAdminUserName.setForeground(new java.awt.Color(102, 102, 102));
        txtAdminUserName.setText("Enter Username");
        txtAdminUserName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtAdminUserNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAdminUserNameFocusLost(evt);
            }
        });
        getContentPane().add(txtAdminUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 350, 70));

        pwdAdmin.setBackground(new java.awt.Color(33, 191, 255));
        pwdAdmin.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        pwdAdmin.setForeground(new java.awt.Color(102, 102, 102));
        pwdAdmin.setText("Password");
        pwdAdmin.setEchoChar('\u0000');
        pwdAdmin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pwdAdminFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                pwdAdminFocusLost(evt);
            }
        });
        pwdAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwdAdminActionPerformed(evt);
            }
        });
        getContentPane().add(pwdAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 350, 70));

        boxShowPwd.setFont(new java.awt.Font("Lato", 1, 14)); // NOI18N
        boxShowPwd.setForeground(new java.awt.Color(45, 68, 86));
        boxShowPwd.setText("Show Password");
        boxShowPwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxShowPwdActionPerformed(evt);
            }
        });
        getContentPane().add(boxShowPwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, -1, -1));

        loginButton.setBackground(new java.awt.Color(12, 69, 92));
        loginButton.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/sign-in.png"))); // NOI18N
        loginButton.setText("Log-In");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        getContentPane().add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 500, 100, 50));

        goBackButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Group 16.png"))); // NOI18N
        goBackButton.setBorder(null);
        goBackButton.setBorderPainted(false);
        goBackButton.setContentAreaFilled(false);
        goBackButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        goBackButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        goBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackButtonActionPerformed(evt);
            }
        });
        getContentPane().add(goBackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 50, 40));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeApplicationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeApplicationActionPerformed
        // TODO add your handling code here:
        ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
        int a = JOptionPane.showOptionDialog(null, "Are you Sure to Exit The Program?", "Exit!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, image, null, 0);
        if (a == 0) {
            System.exit(0);
        }

    }//GEN-LAST:event_closeApplicationActionPerformed

    private void txtAdminUserNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAdminUserNameFocusGained
        // TODO add your handling code here:

        if (txtAdminUserName.getText().equals("Enter Username")) {
            txtAdminUserName.setText("");
            txtAdminUserName.setForeground(Color.white);
        }

    }//GEN-LAST:event_txtAdminUserNameFocusGained

    private void txtAdminUserNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAdminUserNameFocusLost
        // TODO add your handling code here:

        if (txtAdminUserName.getText().equals("")) {
            txtAdminUserName.setText("Enter Username");
            txtAdminUserName.setForeground(new Color(153, 153, 153));
        }

    }//GEN-LAST:event_txtAdminUserNameFocusLost

    private void pwdAdminFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pwdAdminFocusGained
        // TODO add your handling code here:

        if (pwdAdmin.getText().equals("Password")) {
            pwdAdmin.setText("");
            pwdAdmin.setForeground(Color.white);
            if (!boxShowPwd.isSelected()) {
                pwdAdmin.setEchoChar('\u2022');
            }
        }

    }//GEN-LAST:event_pwdAdminFocusGained

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:

        Connection connection = dbConnection.ConnectDB();

        try {
            PreparedStatement pst = connection.prepareStatement("Select username,password from Admin");
            ResultSet rs = pst.executeQuery();
            boolean found = false;

            while (rs.next()) {
                if (rs.getString(1).equals(txtAdminUserName.getText()) && rs.getString(2).equals(pwdAdmin.getText())) {
                    setVisible(false);
                    new AdminHome().setVisible(true);
                    found = true;
                }
            }

            if (!found) {
                ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
                JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Wrong Username OR Password,<br>Try Again!</p></html>", "Try Again!", JOptionPane.INFORMATION_MESSAGE, image);
            }

        } catch (SQLException ex) {
            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
            JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Couldn't Connect to the DB<br>Try Again!</p></html>", "Try Again!", JOptionPane.INFORMATION_MESSAGE, image);
            Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_loginButtonActionPerformed

    private void goBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackButtonActionPerformed
        // TODO add your handling code here:

        setVisible(false);
        new MainApplication().setVisible(true);

    }//GEN-LAST:event_goBackButtonActionPerformed

    private void pwdAdminFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pwdAdminFocusLost
        // TODO add your handling code here:

        if (pwdAdmin.getText().equals("")) {
            pwdAdmin.setEchoChar('\u0000');
            pwdAdmin.setText("Password");
            pwdAdmin.setForeground(new Color(153, 153, 153));
        }

    }//GEN-LAST:event_pwdAdminFocusLost

    private void boxShowPwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxShowPwdActionPerformed
        // TODO add your handling code here:
        if (!(pwdAdmin.getText().equals("Password"))) {
            if (boxShowPwd.isSelected()) {
                pwdAdmin.setEchoChar((char) 0);
            } else {
                pwdAdmin.setEchoChar('\u2022');
            }
        }
    }//GEN-LAST:event_boxShowPwdActionPerformed

    private void pwdAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwdAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwdAdminActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminLogin().setVisible(true);
            }
        });
    }
        String url = "jdbc:sqlserver://PANDETA:1433;"
                + "database=Project;"
                + "trustServerCertificate=true;"
                + "integratedSecurity=true;";
        DbConnection dbConnection = new DbConnection(url);

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox boxShowPwd;
    private javax.swing.JButton closeApplication;
    private javax.swing.JButton goBackButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField pwdAdmin;
    private javax.swing.JTextField txtAdminUserName;
    // End of variables declaration//GEN-END:variables
}
