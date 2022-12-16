package GUI;

import CustomComponent.PasswordField;
import CustomComponent.RoundedJTextFieldTest;
import ProjectApplication.DbConnection;
import UsersClasses.Admin;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.sql.*;

public class AdminAddTeacher extends javax.swing.JFrame {

    DbConnection dbConnection = new DbConnection();

    public AdminAddTeacher() {
        initComponents();
        getContentPane().setBackground(Color.white);                                               // set new background color
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 15, 15)); // make rounded corners

        addWindowListener(new WindowAdapter() {                                                        // make auto focus on username field
            @Override
            public void windowOpened(WindowEvent e) {

            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        teacherSubject1 = new javax.swing.JComboBox<>();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        teacherSubject2 = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        teacherSubject3 = new javax.swing.JComboBox<>();
        goBackButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        closeApplication = new javax.swing.JButton();
        teacherName = new RoundedJTextFieldTest(50);
        teacherPassword = new PasswordField(50);
        boxShowPwd = new javax.swing.JCheckBox();
        teacherEmail = new RoundedJTextFieldTest(50);
        studentSignIn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        teacherSubject1.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        teacherSubject1.setForeground(new java.awt.Color(45, 68, 86));
        teacherSubject1.setBorder(null);
        teacherSubject1.setLightWeightPopupEnabled(false);
        getContentPane().add(teacherSubject1, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 458, 150, 60));

        jLabel35.setFont(new java.awt.Font("Lato", 3, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(51, 51, 51));
        jLabel35.setText("Subject1:");
        getContentPane().add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 428, -1, -1));

        jLabel36.setFont(new java.awt.Font("Lato", 3, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(51, 51, 51));
        jLabel36.setText("Subject2:");
        getContentPane().add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 428, -1, -1));

        teacherSubject2.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        teacherSubject2.setForeground(new java.awt.Color(45, 68, 86));
        teacherSubject2.setBorder(null);
        teacherSubject2.setLightWeightPopupEnabled(false);
        getContentPane().add(teacherSubject2, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 458, 150, 60));

        jLabel37.setFont(new java.awt.Font("Lato", 3, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(51, 51, 51));
        jLabel37.setText("Subject3:");
        getContentPane().add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(429, 428, -1, -1));

        teacherSubject3.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        teacherSubject3.setForeground(new java.awt.Color(45, 68, 86));
        teacherSubject3.setBorder(null);
        teacherSubject3.setLightWeightPopupEnabled(false);
        getContentPane().add(teacherSubject3, new org.netbeans.lib.awtextra.AbsoluteConstraints(389, 458, 150, 60));

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
        getContentPane().add(goBackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 6, 40, 40));

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
            .addGap(0, 1, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 80, -1, -1));

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

        getContentPane().add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 80, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/admin (1).png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(45, 68, 86));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Add Teacher");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 110, 280, -1));

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
        getContentPane().add(closeApplication, new org.netbeans.lib.awtextra.AbsoluteConstraints(559, 16, -1, -1));

        teacherName.setBackground(new java.awt.Color(45, 68, 86));
        teacherName.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        teacherName.setForeground(new java.awt.Color(102, 102, 102));
        teacherName.setText("Name");
        teacherName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                teacherNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                teacherNameFocusLost(evt);
            }
        });
        teacherName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherNameActionPerformed(evt);
            }
        });
        getContentPane().add(teacherName, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 152, 470, 70));

        teacherPassword.setBackground(new java.awt.Color(45, 68, 86));
        teacherPassword.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        teacherPassword.setForeground(new java.awt.Color(102, 102, 102));
        teacherPassword.setText("Password");
        teacherPassword.setEchoChar('\u0000');
        teacherPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                teacherPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                teacherPasswordFocusLost(evt);
            }
        });
        teacherPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(teacherPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 312, 470, 70));

        boxShowPwd.setFont(new java.awt.Font("Lato", 1, 14)); // NOI18N
        boxShowPwd.setForeground(new java.awt.Color(45, 68, 86));
        boxShowPwd.setText("Show Password");
        boxShowPwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxShowPwdActionPerformed(evt);
            }
        });
        getContentPane().add(boxShowPwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 389, -1, 27));

        teacherEmail.setBackground(new java.awt.Color(45, 68, 86));
        teacherEmail.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        teacherEmail.setForeground(new java.awt.Color(102, 102, 102));
        teacherEmail.setText("Email");
        teacherEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                teacherEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                teacherEmailFocusLost(evt);
            }
        });
        teacherEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherEmailActionPerformed(evt);
            }
        });
        getContentPane().add(teacherEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 230, 470, 70));

        studentSignIn.setBackground(new java.awt.Color(12, 69, 92));
        studentSignIn.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        studentSignIn.setForeground(new java.awt.Color(255, 255, 255));
        studentSignIn.setText("Add Teacher");
        studentSignIn.setIconTextGap(15);
        studentSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentSignInActionPerformed(evt);
            }
        });
        getContentPane().add(studentSignIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(389, 558, 150, 60));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void goBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackButtonActionPerformed
        // TODO add your handling code here:

        setVisible(false);
        new AdminHome().setVisible(true);

    }//GEN-LAST:event_goBackButtonActionPerformed

    private void closeApplicationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeApplicationActionPerformed
        // TODO add your handling code here:
        ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
        int a = JOptionPane.showOptionDialog(null, "Are you Sure to Exit The Program?", "Exit!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, image, null, 0);
        if (a == 0) {
            System.exit(0);

        }
    }//GEN-LAST:event_closeApplicationActionPerformed

    private void teacherNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_teacherNameFocusGained
        // TODO add your handling code here:

        if (teacherName.getText().equals("Name")) {
            teacherName.setText("");
            teacherName.setForeground(Color.white);
        }
    }//GEN-LAST:event_teacherNameFocusGained

    private void teacherNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_teacherNameFocusLost
        // TODO add your handling code here:

        if (teacherName.getText().equals("")) {
            teacherName.setText("Name");
            teacherName.setForeground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_teacherNameFocusLost

    private void teacherNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacherNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_teacherNameActionPerformed

    private void teacherPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_teacherPasswordFocusGained
        // TODO add your handling code here:

        if (teacherPassword.getText().equals("Password")) {
            teacherPassword.setText("");
            teacherPassword.setForeground(Color.white);
            if (!boxShowPwd.isSelected()) {
                teacherPassword.setEchoChar('\u2022');
            }
        }
    }//GEN-LAST:event_teacherPasswordFocusGained

    private void teacherPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_teacherPasswordFocusLost
        // TODO add your handling code here:

        if (teacherPassword.getText().equals("")) {
            teacherPassword.setEchoChar('\u0000');
            teacherPassword.setText("Password");
            teacherPassword.setForeground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_teacherPasswordFocusLost

    private void teacherPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacherPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_teacherPasswordActionPerformed

    private void boxShowPwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxShowPwdActionPerformed
        // TODO add your handling code here:
        if (!(teacherPassword.getText().equals("Password"))) {
            if (boxShowPwd.isSelected()) {
                teacherPassword.setEchoChar((char) 0);
            } else {
                teacherPassword.setEchoChar('\u2022');
            }

        }
    }//GEN-LAST:event_boxShowPwdActionPerformed

    private void teacherEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_teacherEmailFocusGained
        // TODO add your handling code here:

        if (teacherEmail.getText().equals("Email")) {
            teacherEmail.setText("");
            teacherEmail.setForeground(Color.white);
        }
    }//GEN-LAST:event_teacherEmailFocusGained

    private void teacherEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_teacherEmailFocusLost
        // TODO add your handling code here:

        if (teacherEmail.getText().equals("")) {
            teacherEmail.setText("Email");
            teacherEmail.setForeground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_teacherEmailFocusLost

    private void teacherEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacherEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_teacherEmailActionPerformed

    private void studentSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentSignInActionPerformed
        // TODO add your handling code here:

        String sdName = teacherName.getText().trim().equals("Name") ? "wrong input" : teacherName.getText().trim();
        sdName = teacherName.getText().trim().length() < 3 || !teacherName.getText().trim().matches("[a-zA-Z]*|[a-zA-Z]*\\s[a-zA-Z]*") ? "wrong input" : sdName;

        String sdEmail = teacherEmail.getText().trim().matches("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*"
                + "@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$") ? teacherEmail.getText().trim() : "wrong email";

        String sdPassword = !teacherPassword.getText().trim().equals("Password") ? teacherPassword.getText().trim() : "wrong Password";
        sdPassword = teacherPassword.getText().trim().length() > 5 ? sdPassword : "wrong Password";

        String sub1 = teacherSubject1.getSelectedItem().toString();
        String sub2 = teacherSubject2.getSelectedItem().toString();
        String sub3 = teacherSubject3.getSelectedItem().toString();

        boolean cheak = true;

        if (sdName.equals("wrong input")) {
            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
            JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Change the Name Field make sure that<br>the name is 3 character or more with no numbers.</p></html>", "Error!", JOptionPane.INFORMATION_MESSAGE, image);
            cheak = false;

        }
        if (sdPassword.equals("wrong Password")) {
            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
            JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Change the password Field make sure that<br>the password is at least 6 characters <br>if you need to leave the name as it is leave it empty!</p></html>", "Error!", JOptionPane.INFORMATION_MESSAGE, image);
            cheak = false;

        }

        if (sdEmail.equals("wrong email")) {
            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
            JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Change the Email Field make sure that<br>the Email you write is in correct form!</p></html>", "Error!", JOptionPane.INFORMATION_MESSAGE, image);
            cheak = false;
        }

        if (sub1.equals(sub2) || sub2.equals(sub3)) {
            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
            JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Change the Subject Fields make sure that<br>the 3 subjects are diffrent or at least there is only one none.<br></p></html>", "Error!", JOptionPane.INFORMATION_MESSAGE, image);
            cheak = false;
        }

        if (cheak) {

            try {
                boolean emailCheck = true;
                Connection connection = dbConnection.ConnectDB();
                PreparedStatement pst;
                pst = connection.prepareStatement("Select email from Teacher");

                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    if (sdEmail.toLowerCase().equals(rs.getString(1))) {
                        emailCheck = false;
                        ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
                        JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">This Email or Phone Number is already been taken!<br></p></html>", "Error!", JOptionPane.INFORMATION_MESSAGE, image);
                    }

                    //                System.out.println(Arrays.toString(rows));
                }

                if (emailCheck) {

                    pst = connection.prepareStatement("insert into Teacher(name,email,password,subject1,subject2,subject3) values(?,?,?,?,?,?)");
                    pst.setString(1, sdName);
                    pst.setString(2, sdEmail.toLowerCase());
                    pst.setString(3, sdPassword);

                    if (sub1.equals("NONE")) {
                        pst.setNull(4, Types.NVARCHAR);
                    } else {
                        pst.setString(4, sub1.trim());
                    }

                    if (sub2.equals("NONE")) {
                        pst.setNull(5, Types.NVARCHAR);
                    } else {
                        pst.setString(5, sub2.trim());
                    }

                    if (sub3.equals("NONE")) {
                        pst.setNull(6, Types.NVARCHAR);
                    } else {
                        pst.setString(6, sub3.trim());
                    }

                    int k = pst.executeUpdate();
                    if (k == 1) {
                        ImageIcon image = new ImageIcon(getClass().getResource("/Images/admin (1).png"));
                        String[] options = {"Add another", "Return"};

                        int a = JOptionPane.showOptionDialog(null, "teacher added Successfully!", "Done!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, image, options, 0);
                        if (a == 0) {

                        } else if (a == 1) {
                            setVisible(false);
                            new AdminHome().setVisible(true);

                        }
                    }
                }

            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(AdminAddTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

            }
        }
    }//GEN-LAST:event_studentSignInActionPerformed

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
            java.util.logging.Logger.getLogger(AdminAddTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminAddTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminAddTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminAddTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if (isLoggedIn()) {
                    new AdminAddTeacher().setVisible(true);
                } else {
                    new AdminLogin().setVisible(true);

                }
            }
        });
    }

    private static boolean isLoggedIn() {
        if (Admin.getUserName() != null) {
            return true;
        } else {
            return false;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox boxShowPwd;
    private javax.swing.JButton closeApplication;
    public javax.swing.JButton goBackButton;
    public javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    public javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton studentSignIn;
    private javax.swing.JTextField teacherEmail;
    private javax.swing.JTextField teacherName;
    private javax.swing.JPasswordField teacherPassword;
    private javax.swing.JComboBox<String> teacherSubject1;
    private javax.swing.JComboBox<String> teacherSubject2;
    private javax.swing.JComboBox<String> teacherSubject3;
    // End of variables declaration//GEN-END:variables
}
