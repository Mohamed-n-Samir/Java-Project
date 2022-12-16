package GUI;

import CustomComponent.PasswordField;
import CustomComponent.RoundedJTextFieldTest;
import ProjectApplication.DbConnection;
import UsersClasses.Admin;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminAddStudent extends javax.swing.JFrame {

    DbConnection dbConnection = new DbConnection();

    public AdminAddStudent() {
        initComponents();
        getContentPane().setBackground(Color.white);                                               // set new background color
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 15, 15)); // make rounded corners

        addWindowListener(new WindowAdapter() {                                                        // make auto focus on username field
            @Override
            public void windowOpened(WindowEvent e) {

                getSubjects();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        studentAge = new RoundedJTextFieldTest(50);
        studentSubject1 = new javax.swing.JComboBox<>();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        studentSubject2 = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        studentSubject3 = new javax.swing.JComboBox<>();
        goBackButton = new javax.swing.JButton();
        studentPhoneNumber = new RoundedJTextFieldTest(50);
        jPanel5 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        closeApplication = new javax.swing.JButton();
        studentName = new RoundedJTextFieldTest(50);
        studentPassword = new PasswordField(50);
        boxShowPwd = new javax.swing.JCheckBox();
        studentEmail = new RoundedJTextFieldTest(50);
        studentSignIn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        studentAge.setBackground(new java.awt.Color(45, 68, 86));
        studentAge.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        studentAge.setForeground(new java.awt.Color(102, 102, 102));
        studentAge.setText("Age");
        studentAge.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                studentAgeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                studentAgeFocusLost(evt);
            }
        });
        studentAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentAgeActionPerformed(evt);
            }
        });

        studentSubject1.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        studentSubject1.setForeground(new java.awt.Color(45, 68, 86));
        studentSubject1.setBorder(null);
        studentSubject1.setLightWeightPopupEnabled(false);

        jLabel35.setFont(new java.awt.Font("Lato", 3, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(51, 51, 51));
        jLabel35.setText("Subject1:");

        jLabel36.setFont(new java.awt.Font("Lato", 3, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(51, 51, 51));
        jLabel36.setText("Subject2:");

        studentSubject2.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        studentSubject2.setForeground(new java.awt.Color(45, 68, 86));
        studentSubject2.setBorder(null);
        studentSubject2.setLightWeightPopupEnabled(false);

        jLabel37.setFont(new java.awt.Font("Lato", 3, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(51, 51, 51));
        jLabel37.setText("Subject3:");

        studentSubject3.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        studentSubject3.setForeground(new java.awt.Color(45, 68, 86));
        studentSubject3.setBorder(null);
        studentSubject3.setLightWeightPopupEnabled(false);

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

        studentPhoneNumber.setBackground(new java.awt.Color(45, 68, 86));
        studentPhoneNumber.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        studentPhoneNumber.setForeground(new java.awt.Color(102, 102, 102));
        studentPhoneNumber.setText("Phone Number");
        studentPhoneNumber.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                studentPhoneNumberFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                studentPhoneNumberFocusLost(evt);
            }
        });
        studentPhoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentPhoneNumberActionPerformed(evt);
            }
        });

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

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/admin (1).png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(45, 68, 86));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Add Student");

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

        studentName.setBackground(new java.awt.Color(45, 68, 86));
        studentName.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        studentName.setForeground(new java.awt.Color(102, 102, 102));
        studentName.setText("Name");
        studentName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                studentNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                studentNameFocusLost(evt);
            }
        });
        studentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentNameActionPerformed(evt);
            }
        });

        studentPassword.setBackground(new java.awt.Color(45, 68, 86));
        studentPassword.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        studentPassword.setForeground(new java.awt.Color(102, 102, 102));
        studentPassword.setText("Password");
        studentPassword.setEchoChar('\u0000');
        studentPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                studentPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                studentPasswordFocusLost(evt);
            }
        });
        studentPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentPasswordActionPerformed(evt);
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

        studentEmail.setBackground(new java.awt.Color(45, 68, 86));
        studentEmail.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        studentEmail.setForeground(new java.awt.Color(102, 102, 102));
        studentEmail.setText("Email");
        studentEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                studentEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                studentEmailFocusLost(evt);
            }
        });
        studentEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentEmailActionPerformed(evt);
            }
        });

        studentSignIn.setBackground(new java.awt.Color(12, 69, 92));
        studentSignIn.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        studentSignIn.setForeground(new java.awt.Color(255, 255, 255));
        studentSignIn.setText("Sign-In");
        studentSignIn.setIconTextGap(15);
        studentSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentSignInActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("You can't Change The subject after Sign-In With the Admin.");

        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("Alert!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(goBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(500, 500, 500)
                        .addComponent(closeApplication))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(studentName, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(studentPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(studentAge, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(jLabel35)
                                        .addGap(90, 90, 90)
                                        .addComponent(jLabel36)
                                        .addGap(90, 90, 90)
                                        .addComponent(jLabel37))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(studentSubject1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(studentSubject2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(studentSubject3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel1)))
                                .addComponent(studentSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(studentEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(studentPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(boxShowPwd))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel4)
                                .addGap(6, 6, 6)
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(goBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(closeApplication)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(6, 6, 6)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentName, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(studentEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(studentPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(boxShowPwd, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentAge, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(studentPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36)
                    .addComponent(jLabel37))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(studentSubject1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentSubject2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentSubject3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(studentSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void studentAgeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentAgeFocusGained
        // TODO add your handling code here:

        if (studentAge.getText().equals("Age")) {
            studentAge.setText("");
            studentAge.setForeground(Color.white);
        }
    }//GEN-LAST:event_studentAgeFocusGained

    private void studentAgeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentAgeFocusLost
        // TODO add your handling code here:

        if (studentAge.getText().equals("")) {
            studentAge.setText("Age");
            studentAge.setForeground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_studentAgeFocusLost

    private void studentAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentAgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentAgeActionPerformed

    private void goBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackButtonActionPerformed
        // TODO add your handling code here:

        setVisible(false);
        new AdminHome().setVisible(true);

    }//GEN-LAST:event_goBackButtonActionPerformed

    private void studentPhoneNumberFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentPhoneNumberFocusGained
        // TODO add your handling code here:

        if (studentPhoneNumber.getText().equals("Phone Number")) {
            studentPhoneNumber.setText("");
            studentPhoneNumber.setForeground(Color.white);
        }
    }//GEN-LAST:event_studentPhoneNumberFocusGained

    private void studentPhoneNumberFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentPhoneNumberFocusLost
        // TODO add your handling code here:

        if (studentPhoneNumber.getText().equals("")) {
            studentPhoneNumber.setText("Phone Number");
            studentPhoneNumber.setForeground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_studentPhoneNumberFocusLost

    private void studentPhoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentPhoneNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentPhoneNumberActionPerformed

    private void closeApplicationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeApplicationActionPerformed
        // TODO add your handling code here:
        ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
        int a = JOptionPane.showOptionDialog(null, "Are you Sure to Exit The Program?", "Exit!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, image, null, 0);
        if (a == 0) {
            System.exit(0);

        }
    }//GEN-LAST:event_closeApplicationActionPerformed

    private void studentNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentNameFocusGained
        // TODO add your handling code here:

        if (studentName.getText().equals("Name")) {
            studentName.setText("");
            studentName.setForeground(Color.white);
        }
    }//GEN-LAST:event_studentNameFocusGained

    private void studentNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentNameFocusLost
        // TODO add your handling code here:

        if (studentName.getText().equals("")) {
            studentName.setText("Name");
            studentName.setForeground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_studentNameFocusLost

    private void studentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentNameActionPerformed

    private void studentPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentPasswordFocusGained
        // TODO add your handling code here:

        if (studentPassword.getText().equals("Password")) {
            studentPassword.setText("");
            studentPassword.setForeground(Color.white);
            if (!boxShowPwd.isSelected()) {
                studentPassword.setEchoChar('\u2022');
            }
        }
    }//GEN-LAST:event_studentPasswordFocusGained

    private void studentPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentPasswordFocusLost
        // TODO add your handling code here:

        if (studentPassword.getText().equals("")) {
            studentPassword.setEchoChar('\u0000');
            studentPassword.setText("Password");
            studentPassword.setForeground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_studentPasswordFocusLost

    private void studentPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentPasswordActionPerformed

    private void boxShowPwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxShowPwdActionPerformed
        // TODO add your handling code here:
        if (!(studentPassword.getText().equals("Password"))) {
            if (boxShowPwd.isSelected()) {
                studentPassword.setEchoChar((char) 0);
            } else {
                studentPassword.setEchoChar('\u2022');
            }

        }
    }//GEN-LAST:event_boxShowPwdActionPerformed

    private void studentEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentEmailFocusGained
        // TODO add your handling code here:

        if (studentEmail.getText().equals("Email")) {
            studentEmail.setText("");
            studentEmail.setForeground(Color.white);
        }
    }//GEN-LAST:event_studentEmailFocusGained

    private void studentEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentEmailFocusLost
        // TODO add your handling code here:

        if (studentEmail.getText().equals("")) {
            studentEmail.setText("Email");
            studentEmail.setForeground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_studentEmailFocusLost

    private void studentEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentEmailActionPerformed

    private void studentSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentSignInActionPerformed
        // TODO add your handling code here:

        String sdName = studentName.getText().trim().equals("Name") ? "wrong input" : studentName.getText().trim();
        sdName = studentName.getText().trim().length() < 3 || !studentName.getText().trim().matches("[a-zA-Z]*|[a-zA-Z]*\\s[a-zA-Z]*") ? "wrong input" : sdName;

        String sdEmail = studentEmail.getText().trim().matches("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*"
                + "@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$") ? studentEmail.getText().trim() : "wrong email";

        String sdPassword = !studentPassword.getText().trim().equals("Password") ? studentPassword.getText().trim() : "wrong Password";
        sdPassword = studentPassword.getText().trim().length() > 5 ? sdPassword : "wrong Password";

        String sdPhone = studentPhoneNumber.getText().trim().matches("^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$") ? studentPhoneNumber.getText().trim() : "wrong input";

        String sub1 = studentSubject1.getSelectedItem().toString();
        String sub2 = studentSubject2.getSelectedItem().toString();
        String sub3 = studentSubject3.getSelectedItem().toString();

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

        if (sdPhone.equals("wrong input")) {
            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
            JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Change the phone Field make sure that<br>you enterd a correct phone format as<br>123-456-7890\n"
                    + "(123) 456-7890\n"
                    + "123 456 7890\n"
                    + "123.456.7890\n"
                    + "+91 (123) 456-7890</p></html>", "Error!", JOptionPane.INFORMATION_MESSAGE, image);
            cheak = false;
        }
        int sdAge = -1;
        try {
            sdAge = (Integer.parseInt(studentAge.getText()) >= 17 && Integer.parseInt(studentAge.getText()) <= 24) ? Integer.parseInt(studentAge.getText()) : -1;
        } catch (NumberFormatException ex) {
            cheak = false;
            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
            JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Wrong input please Enter Correct integar Number<br> More than 16 and less than 24!</p></html>", "Try Again!", JOptionPane.INFORMATION_MESSAGE, image);
        }

        if (sdAge == -1) {
            cheak = false;
            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
            JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Wrong input please Enter Correct integar Number<br> More than 16 and less than 24!</p></html>", "Try Again!", JOptionPane.INFORMATION_MESSAGE, image);
        }

        if (cheak) {

            try {
                boolean emailCheck = true;
                Connection connection = dbConnection.ConnectDB();
                PreparedStatement pst;
                pst = connection.prepareStatement("Select email,phone from Students");

                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    if (sdEmail.toLowerCase().equals(rs.getString(1)) || sdPhone.equals(rs.getString(2))) {
                        emailCheck = false;
                        ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
                        JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">This Email or Phone Number is already been taken!<br></p></html>", "Error!", JOptionPane.INFORMATION_MESSAGE, image);
                    }

                    //                System.out.println(Arrays.toString(rows));
                }

                if (emailCheck) {

                    pst = connection.prepareStatement("insert into Students(name,email,password,subject1,subject2,subject3,phone,age) values(?,?,?,?,?,?,?,?)");
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

                    pst.setString(7, sdPhone);
                    pst.setInt(8, sdAge);

                    int k = pst.executeUpdate();
                    if (k == 1) {
                        ImageIcon image = new ImageIcon(getClass().getResource("/Images/admin (1).png"));
                        String[] options = {"Add another", "Return"};

                        int a = JOptionPane.showOptionDialog(null, "Student add Successfully!?", "Done!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, image, options, 0);
                        if (a == 0) {

                        } else if (a == 1) {
                            setVisible(false);
                            new AdminHome().setVisible(true);

                        }
                    }
                }

            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(AdminAddStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

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
            java.util.logging.Logger.getLogger(AdminAddStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminAddStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminAddStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminAddStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if (isLoggedIn()) {

                    new AdminAddStudent().setVisible(true);
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

    private void getSubjects() {

        try {
            Connection connection = dbConnection.ConnectDB();
            PreparedStatement pst;
            pst = connection.prepareStatement("Select * from Subject ");

            ResultSet rs = pst.executeQuery();

            Object[] rows = new Object[]{"NONE"};

            int counter = 1;       // make sure that the counter is equal to the Strings in side the rows[];
            while (rs.next()) {
                Object[] temp = new Object[rows.length + 1];
                System.arraycopy(rows, 0, temp, 0, rows.length);
                rows = temp;
                rows[counter] = rs.getString(1);
                counter++;
//                System.out.println(Arrays.toString(rows));
            }
            studentSubject1.setModel(new javax.swing.DefaultComboBoxModel(rows));
            studentSubject2.setModel(new javax.swing.DefaultComboBoxModel(rows));
            studentSubject3.setModel(new javax.swing.DefaultComboBoxModel(rows));

        } catch (SQLException ex) {
            Logger.getLogger(AdminAddStudent.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox boxShowPwd;
    private javax.swing.JButton closeApplication;
    public javax.swing.JButton goBackButton;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    public javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField studentAge;
    private javax.swing.JTextField studentEmail;
    private javax.swing.JTextField studentName;
    private javax.swing.JPasswordField studentPassword;
    private javax.swing.JTextField studentPhoneNumber;
    private javax.swing.JButton studentSignIn;
    private javax.swing.JComboBox<String> studentSubject1;
    private javax.swing.JComboBox<String> studentSubject2;
    private javax.swing.JComboBox<String> studentSubject3;
    // End of variables declaration//GEN-END:variables
}
