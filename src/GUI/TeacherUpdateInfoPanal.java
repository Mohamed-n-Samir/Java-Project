package GUI;

import CustomComponent.PasswordField;
import CustomComponent.RoundedJTextFieldTest;
import static GUI.TeacherHome.LoggedIn;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import ProjectApplication.*;
import UsersClasses.Teacher;

public class TeacherUpdateInfoPanal extends javax.swing.JFrame {

    DbConnection dbConnection = new DbConnection();

    public TeacherUpdateInfoPanal() {
        initComponents();
        getContentPane().setBackground(Color.white);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 15, 15));
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                getSubjects();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        closeApplication = new javax.swing.JButton();
        UpdateName = new RoundedJTextFieldTest(50);
        UpdatepwdTeacher = new PasswordField(50);
        boxShowPwd = new javax.swing.JCheckBox();
        UpdateTeacherButton = new javax.swing.JButton();
        UpdatepwdTeacherRewrite = new PasswordField(50);
        UpdateEmail = new RoundedJTextFieldTest(50);
        UpdateSubject1 = new javax.swing.JComboBox<>();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        UpdateSubject2 = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        UpdateSubject3 = new javax.swing.JComboBox<>();
        goBackButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 750));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(600, 750));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel5.setPreferredSize(new java.awt.Dimension(100, 1));
        jPanel5.setRequestFocusEnabled(false);
        jPanel5.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, -1, -1));

        jPanel10.setBackground(new java.awt.Color(0, 0, 0));
        jPanel10.setPreferredSize(new java.awt.Dimension(100, 1));
        jPanel10.setRequestFocusEnabled(false);
        jPanel10.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/teacher (2).png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(45, 68, 86));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Teacher");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 290, -1));

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
        getContentPane().add(closeApplication, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, -1, -1));

        UpdateName.setBackground(new java.awt.Color(45, 68, 86));
        UpdateName.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        UpdateName.setForeground(new java.awt.Color(102, 102, 102));
        UpdateName.setText("Change Name");
        UpdateName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                UpdateNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                UpdateNameFocusLost(evt);
            }
        });
        UpdateName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateNameActionPerformed(evt);
            }
        });
        getContentPane().add(UpdateName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 470, 70));

        UpdatepwdTeacher.setBackground(new java.awt.Color(45, 68, 86));
        UpdatepwdTeacher.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        UpdatepwdTeacher.setForeground(new java.awt.Color(102, 102, 102));
        UpdatepwdTeacher.setText("Rewrite Password");
        UpdatepwdTeacher.setEchoChar('\u0000');
        UpdatepwdTeacher.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                UpdatepwdTeacherFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                UpdatepwdTeacherFocusLost(evt);
            }
        });
        UpdatepwdTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdatepwdTeacherActionPerformed(evt);
            }
        });
        getContentPane().add(UpdatepwdTeacher, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 470, 70));

        boxShowPwd.setFont(new java.awt.Font("Lato", 1, 14)); // NOI18N
        boxShowPwd.setForeground(new java.awt.Color(45, 68, 86));
        boxShowPwd.setText("Show Password");
        boxShowPwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxShowPwdActionPerformed(evt);
            }
        });
        getContentPane().add(boxShowPwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 410, -1, -1));

        UpdateTeacherButton.setBackground(new java.awt.Color(12, 69, 92));
        UpdateTeacherButton.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        UpdateTeacherButton.setForeground(new java.awt.Color(255, 255, 255));
        UpdateTeacherButton.setText("Update");
        UpdateTeacherButton.setIconTextGap(15);
        UpdateTeacherButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateTeacherButtonActionPerformed(evt);
            }
        });
        getContentPane().add(UpdateTeacherButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 640, 150, 60));

        UpdatepwdTeacherRewrite.setBackground(new java.awt.Color(45, 68, 86));
        UpdatepwdTeacherRewrite.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        UpdatepwdTeacherRewrite.setForeground(new java.awt.Color(102, 102, 102));
        UpdatepwdTeacherRewrite.setText("New Password");
        UpdatepwdTeacherRewrite.setEchoChar('\u0000');
        UpdatepwdTeacherRewrite.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                UpdatepwdTeacherRewriteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                UpdatepwdTeacherRewriteFocusLost(evt);
            }
        });
        UpdatepwdTeacherRewrite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdatepwdTeacherRewriteActionPerformed(evt);
            }
        });
        getContentPane().add(UpdatepwdTeacherRewrite, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 470, 70));

        UpdateEmail.setBackground(new java.awt.Color(45, 68, 86));
        UpdateEmail.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        UpdateEmail.setForeground(new java.awt.Color(102, 102, 102));
        UpdateEmail.setText("Change Email");
        UpdateEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                UpdateEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                UpdateEmailFocusLost(evt);
            }
        });
        UpdateEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateEmailActionPerformed(evt);
            }
        });
        getContentPane().add(UpdateEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, 470, 70));

        UpdateSubject1.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        UpdateSubject1.setForeground(new java.awt.Color(45, 68, 86));
        UpdateSubject1.setBorder(null);
        UpdateSubject1.setLightWeightPopupEnabled(false);
        getContentPane().add(UpdateSubject1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 560, 150, 60));

        jLabel35.setFont(new java.awt.Font("Lato", 3, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(51, 51, 51));
        jLabel35.setText("Subject1:");
        getContentPane().add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 530, -1, -1));

        jLabel36.setFont(new java.awt.Font("Lato", 3, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(51, 51, 51));
        jLabel36.setText("Subject2:");
        getContentPane().add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 530, -1, -1));

        UpdateSubject2.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        UpdateSubject2.setForeground(new java.awt.Color(45, 68, 86));
        UpdateSubject2.setBorder(null);
        UpdateSubject2.setLightWeightPopupEnabled(false);
        getContentPane().add(UpdateSubject2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 560, 150, 60));

        jLabel37.setFont(new java.awt.Font("Lato", 3, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(51, 51, 51));
        jLabel37.setText("Subject3:");
        getContentPane().add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 530, -1, -1));

        UpdateSubject3.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        UpdateSubject3.setForeground(new java.awt.Color(45, 68, 86));
        UpdateSubject3.setBorder(null);
        UpdateSubject3.setLightWeightPopupEnabled(false);
        getContentPane().add(UpdateSubject3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 560, 150, 60));

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
        getContentPane().add(goBackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 40, 40));

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

    private void UpdateNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UpdateNameFocusGained
        // TODO add your handling code here:

        if (UpdateName.getText().equals("Change Name")) {
            UpdateName.setText("");
            UpdateName.setForeground(Color.white);
        }
    }//GEN-LAST:event_UpdateNameFocusGained

    private void UpdateNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UpdateNameFocusLost
        // TODO add your handling code here:

        if (UpdateName.getText().equals("")) {
            UpdateName.setText("Change Name");
            UpdateName.setForeground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_UpdateNameFocusLost

    private void UpdatepwdTeacherFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UpdatepwdTeacherFocusGained
        // TODO add your handling code here:

        if (UpdatepwdTeacher.getText().equals("Rewrite Password")) {
            UpdatepwdTeacher.setText("");
            UpdatepwdTeacher.setForeground(Color.white);
            if (!boxShowPwd.isSelected()) {
                UpdatepwdTeacher.setEchoChar('\u2022');
            }
        }
    }//GEN-LAST:event_UpdatepwdTeacherFocusGained

    private void UpdatepwdTeacherFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UpdatepwdTeacherFocusLost
        // TODO add your handling code here:

        if (UpdatepwdTeacher.getText().equals("")) {
            UpdatepwdTeacher.setEchoChar('\u0000');
            UpdatepwdTeacher.setText("Rewrite Password");
            UpdatepwdTeacher.setForeground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_UpdatepwdTeacherFocusLost

    private void UpdatepwdTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdatepwdTeacherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdatepwdTeacherActionPerformed

    private void boxShowPwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxShowPwdActionPerformed
        // TODO add your handling code here:
        if (!(UpdatepwdTeacher.getText().equals("Rewrite Password"))) {
            if (boxShowPwd.isSelected()) {
                UpdatepwdTeacher.setEchoChar((char) 0);
            } else {
                UpdatepwdTeacher.setEchoChar('\u2022');
            }
        }
        if (!(UpdatepwdTeacherRewrite.getText().equals("New Password"))) {
            if (boxShowPwd.isSelected()) {
                UpdatepwdTeacherRewrite.setEchoChar((char) 0);
            } else {
                UpdatepwdTeacherRewrite.setEchoChar('\u2022');
            }
        }
    }//GEN-LAST:event_boxShowPwdActionPerformed

    private void UpdateTeacherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateTeacherButtonActionPerformed
        // TODO add your handling code here:

        String newName = UpdateName.getText().trim().equals("Change Name") ? "" : UpdateName.getText().trim();
        newName = UpdateName.getText().trim().length() < 3 || !UpdateName.getText().trim().matches("[a-zA-Z]*|[a-zA-Z]*\\s[a-zA-Z]*") ? "wrong input" : newName;

        String newEmail = UpdateEmail.getText().trim().matches("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*"
                + "@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$") || UpdateEmail.getText().trim().equals("Change Email") ? UpdateEmail.getText().trim() : "wrong email";

        String newPassword = !UpdatepwdTeacher.getText().trim().equals("Rewrite Password") ? UpdatepwdTeacher.getText().trim() : "";
        newPassword = UpdatepwdTeacher.getText().trim().length() > 5 ? newPassword : "wrong Password";

        String newPasswordRewrite = !UpdatepwdTeacherRewrite.getText().trim().equals("New Password") ? UpdatepwdTeacherRewrite.getText().trim() : "";
        newPasswordRewrite = UpdatepwdTeacherRewrite.getText().trim().length() > 5 ? newPasswordRewrite : "wrong Password";

        String sub1 = UpdateSubject1.getSelectedItem().toString().equals("Default".trim()) ? Teacher.getSubject1() == null ? "NONE" : Teacher.getSubject1() : UpdateSubject1.getSelectedItem().toString();
        String sub2 = UpdateSubject2.getSelectedItem().toString().equals("Default".trim()) ? Teacher.getSubject2() == null ? "NONE" : Teacher.getSubject2() : UpdateSubject2.getSelectedItem().toString();
        String sub3 = UpdateSubject3.getSelectedItem().toString().equals("Default".trim()) ? Teacher.getSubject3() == null ? "NONE" : Teacher.getSubject3() : UpdateSubject3.getSelectedItem().toString();

        System.out.println(sub1);
        System.out.println(sub2);
        System.out.println(sub3);

        boolean cheak = true;

        if (newName.equals("")) {
            newName = Teacher.getName();

        }
        if (newName.equals("wrong input")) {
            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
            JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Change the Name Field make sure that<br>the name is more than 3 character with no numbers<br>if you need to leave the name as it is leave it empty!</p></html>", "Error!", JOptionPane.INFORMATION_MESSAGE, image);
            cheak = false;

        }
        if (newPassword.equals("wrong Password")) {
            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
            JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Change the password Field make sure that<br>the password is at least 6 characters <br>if you need to leave the name as it is leave it empty!</p></html>", "Error!", JOptionPane.INFORMATION_MESSAGE, image);
            cheak = false;

        }
        if (!newPassword.equals(newPasswordRewrite)) {
            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
            JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Change the password Field make sure that<br>the 2 password field is exactly the same!<br>if you need to leave the name as it is leave it empty!</p></html>", "Error!", JOptionPane.INFORMATION_MESSAGE, image);
            cheak = false;

        }
        if (newEmail.equals("wrong email")) {
            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
            JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Change the Email Field make sure that<br>the Email you write is in correct form!<br>if you need to leave the name as it is leave it empty!</p></html>", "Error!", JOptionPane.INFORMATION_MESSAGE, image);
            cheak = false;
        }

        if (sub1.equals(sub2) && sub2.equals(sub3)) {
            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
            JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Change the Subject Fields make sure that<br>the 3 subjects are diffrent or not equal none<br> if you need to leave the subject as it is leave it as Default!</p></html>", "Error!", JOptionPane.INFORMATION_MESSAGE, image);
            cheak = false;
        }
        if (cheak) {
            System.out.println("aaaaaa");

            try {
                boolean emailCheck = true;
                Connection connection = dbConnection.ConnectDB();
                PreparedStatement pst;
                pst = connection.prepareStatement("Select email from Teacher");

                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    if (newEmail.toLowerCase().equals(rs.getString(1))) {
                        emailCheck = false;
                        ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
                        JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">This Email is already been taken!<br>if you need to leave the Email as it is leave it empty!</p></html>", "Error!", JOptionPane.INFORMATION_MESSAGE, image);
                    }

//                System.out.println(Arrays.toString(rows));
                }

                if (emailCheck) {
                    if (newEmail.equals("Change Email")) {
                        newEmail = Teacher.getEmail();
                    }
                    pst = connection.prepareStatement("update Teacher set email = ?, name = ?, password = ?, subject1 = ?, subject2 = ?, subject3 = ? where ID = ?");
                    pst.setString(1, newEmail.toLowerCase());
                    Teacher.setEmail(newEmail.toLowerCase());
                    pst.setString(2, newName);
                    Teacher.setName(newName);
                    if (newPassword.equals("")) {
                        pst.setString(3,Teacher.getPassword());
                    } else {
                        pst.setString(3, newPassword);
                        Teacher.setPassword(newPassword);
                    }

                    if (sub1.equals("NONE")) {
                        pst.setNull(4, Types.NVARCHAR);
                        Teacher.setSub1(sub1);
                    } else {
                        pst.setString(4, sub1.trim());
                        Teacher.setSub1(sub1);
                    }

                    if (sub2.equals("NONE")) {
                        pst.setNull(5, Types.NVARCHAR);
                        Teacher.setSub2(sub2);
                    } else {
                        pst.setString(5, sub2.trim());
                        Teacher.setSub2(sub2);
                    }

                    if (sub3.equals("NONE")) {
                        pst.setNull(6, Types.NVARCHAR);
                        Teacher.setSub3(sub3);
                    } else {
                        pst.setString(6, sub3.trim());
                        Teacher.setSub3(sub3);
                    }

                    pst.setInt(7, Teacher.getID());
                    int k = pst.executeUpdate();
                    if (k == 1) {
                        ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (2).png"));
                        JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">en taken!<br>Update Done Successfully!</p></html>", "Done!", JOptionPane.INFORMATION_MESSAGE, image);

                    }
                }

            } catch (SQLException ex) {
                Logger.getLogger(TeacherHome.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }//GEN-LAST:event_UpdateTeacherButtonActionPerformed

    private void UpdateNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateNameActionPerformed

    private void UpdatepwdTeacherRewriteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UpdatepwdTeacherRewriteFocusGained
        // TODO add your handling code here:
        if (UpdatepwdTeacherRewrite.getText().equals("New Password")) {
            UpdatepwdTeacherRewrite.setText("");
            UpdatepwdTeacherRewrite.setForeground(Color.white);
            if (!boxShowPwd.isSelected()) {
                UpdatepwdTeacherRewrite.setEchoChar('\u2022');
            }
        }

    }//GEN-LAST:event_UpdatepwdTeacherRewriteFocusGained

    private void UpdatepwdTeacherRewriteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UpdatepwdTeacherRewriteFocusLost
        // TODO add your handling code here:

        if (UpdatepwdTeacherRewrite.getText().equals("")) {
            UpdatepwdTeacherRewrite.setEchoChar('\u0000');
            UpdatepwdTeacherRewrite.setText("New Password");
            UpdatepwdTeacherRewrite.setForeground(new Color(102, 102, 102));
        }
//[102,102,102]
    }//GEN-LAST:event_UpdatepwdTeacherRewriteFocusLost

    private void UpdatepwdTeacherRewriteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdatepwdTeacherRewriteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdatepwdTeacherRewriteActionPerformed

    private void UpdateEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UpdateEmailFocusGained
        // TODO add your handling code here:

        if (UpdateEmail.getText().equals("Change Email")) {
            UpdateEmail.setText("");
            UpdateEmail.setForeground(Color.white);
        }

    }//GEN-LAST:event_UpdateEmailFocusGained

    private void UpdateEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UpdateEmailFocusLost
        // TODO add your handling code here:

        if (UpdateEmail.getText().equals("")) {
            UpdateEmail.setText("Change Email");
            UpdateEmail.setForeground(new Color(102, 102, 102));
        }

    }//GEN-LAST:event_UpdateEmailFocusLost

    private void UpdateEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateEmailActionPerformed

    private void goBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackButtonActionPerformed
        // TODO add your handling code here:

        setVisible(false);
        new TeacherHome().setVisible(true);
    }//GEN-LAST:event_goBackButtonActionPerformed

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
            java.util.logging.Logger.getLogger(TeacherUpdateInfoPanal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeacherUpdateInfoPanal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeacherUpdateInfoPanal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeacherUpdateInfoPanal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TeacherUpdateInfoPanal().setVisible(true);
            }
        });
    }

    private void getSubjects() {
        if (LoggedIn()) {
            try {
                Connection connection = dbConnection.ConnectDB();
                PreparedStatement pst;
                pst = connection.prepareStatement("Select * from Subject ");

                ResultSet rs = pst.executeQuery();

                Object[] rows = new Object[]{"Default", "NONE"};

                int counter = 2;
                while (rs.next()) {
                    Object[] temp = new Object[rows.length + 1];
                    System.arraycopy(rows, 0, temp, 0, rows.length);
                    rows = temp;
                    rows[counter] = rs.getString(1);
                    counter++;
//                System.out.println(Arrays.toString(rows));
                }
                UpdateSubject1.setModel(new javax.swing.DefaultComboBoxModel(rows));
                UpdateSubject2.setModel(new javax.swing.DefaultComboBoxModel(rows));
                UpdateSubject3.setModel(new javax.swing.DefaultComboBoxModel(rows));

            } catch (SQLException ex) {
                Logger.getLogger(TeacherHome.class.getName()).log(Level.SEVERE, null, ex);

            }

        } else {
            String[] options = {"Login", "Exit"};
            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
            int a = JOptionPane.showOptionDialog(null, "To Update your Profile you must Login as Teacher first?", "Login or Exit!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, image, options, 0);
            if (a == 0 || a == -1) {
                setVisible(false);
                new TeacherLogin().setVisible(true);
            } else if (a == 1) {
                System.exit(0);

            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField UpdateEmail;
    private javax.swing.JTextField UpdateName;
    private javax.swing.JComboBox<String> UpdateSubject1;
    private javax.swing.JComboBox<String> UpdateSubject2;
    private javax.swing.JComboBox<String> UpdateSubject3;
    private javax.swing.JButton UpdateTeacherButton;
    private javax.swing.JPasswordField UpdatepwdTeacher;
    private javax.swing.JPasswordField UpdatepwdTeacherRewrite;
    private javax.swing.JCheckBox boxShowPwd;
    private javax.swing.JButton closeApplication;
    private javax.swing.JButton goBackButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
