package GUI;

import CustomComponent.PasswordField;
import CustomComponent.RoundedJTextFieldTest;
import ProjectApplication.DbConnection;
import UsersClasses.Student;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentLogin extends javax.swing.JFrame {

    public StudentLogin() {
        initComponents();
        getContentPane().setBackground(Color.white);                                                 // set new background color
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 15, 15)); // make rounded corners
        addWindowListener(new WindowAdapter() {                                                        // make auto focus on username field
            @Override
            public void windowOpened(WindowEvent e) {
                StudnetEmail.requestFocus();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        closeApplication = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        StudnetEmail = new RoundedJTextFieldTest(50);
        pwdStudent = new PasswordField(50);
        boxShowPwd = new javax.swing.JCheckBox();
        loginButton = new javax.swing.JButton();
        goBackButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/student (1)_1.png"))); // NOI18N

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));
        jPanel7.setPreferredSize(new java.awt.Dimension(100, 1));
        jPanel7.setRequestFocusEnabled(false);
        jPanel7.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

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

        jLabel2.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(45, 68, 86));
        jLabel2.setText("Student");

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

        StudnetEmail.setBackground(new java.awt.Color(45, 68, 86));
        StudnetEmail.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        StudnetEmail.setForeground(new java.awt.Color(102, 102, 102));
        StudnetEmail.setText("Enter Username");
        StudnetEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                StudnetEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                StudnetEmailFocusLost(evt);
            }
        });

        pwdStudent.setBackground(new java.awt.Color(45, 68, 86));
        pwdStudent.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        pwdStudent.setForeground(new java.awt.Color(102, 102, 102));
        pwdStudent.setText("Password");
        pwdStudent.setEchoChar('\u0000');
        pwdStudent.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pwdStudentFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                pwdStudentFocusLost(evt);
            }
        });
        pwdStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwdStudentActionPerformed(evt);
            }
        });

        boxShowPwd.setFont(new java.awt.Font("Lato", 1, 14)); // NOI18N
        boxShowPwd.setForeground(new java.awt.Color(45, 68, 86));
        boxShowPwd.setText("Show Password");
        boxShowPwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxShowPwdActionPerformed(evt);
            }
        });

        loginButton.setBackground(new java.awt.Color(12, 69, 92));
        loginButton.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/sign-in.png"))); // NOI18N
        loginButton.setText("Log-In");
        loginButton.setIconTextGap(15);
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

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

        jLabel3.setFont(new java.awt.Font("Lato", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(79, 119, 150));
        jLabel3.setText("Dont have Account?");

        jLabel5.setFont(new java.awt.Font("Lato", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 255));
        jLabel5.setText("Sign-In");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(goBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(328, 328, 328)
                        .addComponent(closeApplication))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(StudnetEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(boxShowPwd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(loginButton)
                                .addComponent(pwdStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(163, 163, 163))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(goBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(closeApplication)))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addGap(57, 57, 57)
                .addComponent(StudnetEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(pwdStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxShowPwd)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

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

    private void StudnetEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_StudnetEmailFocusGained
        // TODO add your handling code here:

        if (StudnetEmail.getText().equals("Enter Username")) {
            StudnetEmail.setText("");
            StudnetEmail.setForeground(Color.white);
        }
    }//GEN-LAST:event_StudnetEmailFocusGained

    private void StudnetEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_StudnetEmailFocusLost
        // TODO add your handling code here:

        if (StudnetEmail.getText().equals("")) {
            StudnetEmail.setText("Enter Username");
            StudnetEmail.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_StudnetEmailFocusLost

    private void pwdStudentFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pwdStudentFocusGained
        // TODO add your handling code here:

        if (pwdStudent.getText().equals("Password")) {
            pwdStudent.setText("");
            pwdStudent.setForeground(Color.white);
            if (!boxShowPwd.isSelected()) {
                pwdStudent.setEchoChar('\u2022');
            }
        }
    }//GEN-LAST:event_pwdStudentFocusGained

    private void pwdStudentFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pwdStudentFocusLost
        // TODO add your handling code here:

        if (pwdStudent.getText().equals("")) {
            pwdStudent.setEchoChar('\u0000');
            pwdStudent.setText("Password");
            pwdStudent.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_pwdStudentFocusLost

    private void pwdStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwdStudentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwdStudentActionPerformed

    private void boxShowPwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxShowPwdActionPerformed
        // TODO add your handling code here:
        if (!(pwdStudent.getText().equals("Password"))) {
            if (boxShowPwd.isSelected()) {
                pwdStudent.setEchoChar((char) 0);
            } else {
                pwdStudent.setEchoChar('\u2022');
            }
        }
    }//GEN-LAST:event_boxShowPwdActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:
//        String url = "jdbc:sqlserver://PANDETA:1433;"
//                + "database=Project;"
//                + "trustServerCertificate=true;"
//                + "integratedSecurity=true;";
        DbConnection dbConnection = new DbConnection();
        Connection connection = dbConnection.ConnectDB();

        try {
            PreparedStatement pst = connection.prepareStatement("Select * from Students");
            ResultSet rs = pst.executeQuery();
            boolean found = false;

            while (rs.next()) {
                if (rs.getString("email").toLowerCase().equals(StudnetEmail.getText().trim().toLowerCase()) && rs.getString("password").equals(pwdStudent.getText().trim().toLowerCase())) {
                    found = true;
                    Student student;
                    student = new Student(rs.getInt("ID"), rs.getString("name"), rs.getString("email"), rs.getString("phone"), rs.getInt("age"), rs.getString("subject1"), rs.getString("subject2"), rs.getString("subject3"),rs.getString("Password"));
                    setVisible(false);
                    new StudentHome().setVisible(true);
                }
            }

            if (!found) {
                ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
                JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Wrong Email OR Password,<br>Try Again!</p></html>", "Try Again!", JOptionPane.INFORMATION_MESSAGE, image);
            }


        } catch (SQLException ex) {
            Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_loginButtonActionPerformed

    private void goBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackButtonActionPerformed
        // TODO add your handling code here:

        setVisible(false);
        new MainApplication().setVisible(true);
    }//GEN-LAST:event_goBackButtonActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:

        setVisible(false);
        new StudentSignUp().setVisible(true);

    }//GEN-LAST:event_jLabel5MouseClicked

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
            java.util.logging.Logger.getLogger(StudentLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField StudnetEmail;
    private javax.swing.JCheckBox boxShowPwd;
    private javax.swing.JButton closeApplication;
    private javax.swing.JButton goBackButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField pwdStudent;
    // End of variables declaration//GEN-END:variables
}
