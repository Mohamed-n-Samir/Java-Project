package GUI;

import ProjectApplication.DbConnection;
import UsersClasses.Student;
import UsersClasses.StudentTest;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.Component;
import java.sql.Connection;
import java.sql.SQLException;

public class ShowCorrectedTest extends javax.swing.JFrame {

    DbConnection dbConnection = new DbConnection();

    public ShowCorrectedTest() {
        initComponents();
        getContentPane().setBackground(Color.white);                                                 // set new background color
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 15, 15)); // make rounded corners
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                jLabel2.setText("Test: " + StudentTest.getTestName());
                markOutOf.setText("Your Mark: " + StudentTest.getStudentMark() + "/" + StudentTest.getTestMark());
                jScrollPane1.setFocusable(false);
                r1.setEnabled(false);
                r2.setEnabled(false);
                r3.setEnabled(false);
                r4.setEnabled(false);
                setCorrectPhotoNoVisible();
                try {
                    Connection connection = dbConnection.getConnection();
                    pst1 = connection.prepareStatement("select TOP " + StudentTest.getTestMark() + " *\n"
                            + "from StudentsTestQuestions\n"
                            + "INNER JOIN Questions\n"
                            + "on StudentsTestQuestions.testQuestionsID = Questions.ID\n"
                            + "where Questions.testID = " + StudentTest.getTestID() + " and studentID = " + Student.getID()
                            + "order by StudentsTestQuestions.testQuestionsID asc");
                    rs1 = pst1.executeQuery();
                    getQuestions();

                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(ShowCorrectedTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }

            }
        });
        
    }

    PreparedStatement pst1;
    ResultSet rs1;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        closeApplication = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        markOutOf = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        nextQuestionBotton = new javax.swing.JButton();
        ans4Correct = new javax.swing.JLabel();
        ans1Correct = new javax.swing.JLabel();
        ans2Correct = new javax.swing.JLabel();
        ans3Correct = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        r1 = new javax.swing.JRadioButton();
        r3 = new javax.swing.JRadioButton();
        r4 = new javax.swing.JRadioButton();
        r2 = new javax.swing.JRadioButton();
        Question = new javax.swing.JLabel();
        QuestionNumber = new javax.swing.JLabel();
        submitQuestionBotton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        answerTextArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        answerTextArea1 = new javax.swing.JTextArea();
        goBackButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        getContentPane().add(closeApplication, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(45, 68, 86));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Test: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, 450, -1));

        markOutOf.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        markOutOf.setText("12/12");
        getContentPane().add(markOutOf, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 190, 200, -1));

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

        getContentPane().add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 70, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/checklist (3).png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 30, -1, -1));

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

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 70, -1, -1));

        jPanel1.setBackground(new java.awt.Color(45, 68, 86));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nextQuestionBotton.setBackground(new java.awt.Color(70, 202, 255));
        nextQuestionBotton.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        nextQuestionBotton.setForeground(new java.awt.Color(255, 255, 255));
        nextQuestionBotton.setText("Next Ques.");
        nextQuestionBotton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nextQuestionBotton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextQuestionBottonActionPerformed(evt);
            }
        });
        jPanel1.add(nextQuestionBotton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 500, 140, 50));

        ans4Correct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/accept.png"))); // NOI18N
        jPanel1.add(ans4Correct, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 420, -1, 40));

        ans1Correct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/accept.png"))); // NOI18N
        jPanel1.add(ans1Correct, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, -1, 40));

        ans2Correct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/accept.png"))); // NOI18N
        jPanel1.add(ans2Correct, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, -1, 40));

        ans3Correct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/accept.png"))); // NOI18N
        jPanel1.add(ans3Correct, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, -1, 40));

        jLabel3.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Your Answer");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 170, 120, 30));

        jLabel1.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Correct Answer");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 330, 130, 30));

        r1.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        r1.setForeground(new java.awt.Color(255, 255, 255));
        r1.setText("Answer1");
        r1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1ActionPerformed(evt);
            }
        });
        jPanel1.add(r1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 760, 40));

        r3.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        r3.setForeground(new java.awt.Color(255, 255, 255));
        r3.setText("Answer3");
        jPanel1.add(r3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 760, 40));

        r4.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        r4.setForeground(new java.awt.Color(255, 255, 255));
        r4.setText("Answer4");
        r4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4ActionPerformed(evt);
            }
        });
        jPanel1.add(r4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, 760, 40));

        r2.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        r2.setForeground(new java.awt.Color(255, 255, 255));
        r2.setText("Answer2");
        r2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2ActionPerformed(evt);
            }
        });
        jPanel1.add(r2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 760, 40));

        Question.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        Question.setForeground(new java.awt.Color(255, 255, 255));
        Question.setText("jLabel3");
        jPanel1.add(Question, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 1110, -1));

        QuestionNumber.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        QuestionNumber.setForeground(new java.awt.Color(255, 255, 255));
        QuestionNumber.setText("1)");
        jPanel1.add(QuestionNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, -1, -1));

        submitQuestionBotton.setBackground(new java.awt.Color(70, 202, 255));
        submitQuestionBotton.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        submitQuestionBotton.setForeground(new java.awt.Color(255, 255, 255));
        submitQuestionBotton.setText("Submit");
        submitQuestionBotton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        submitQuestionBotton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitQuestionBottonActionPerformed(evt);
            }
        });
        jPanel1.add(submitQuestionBotton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 500, 140, 50));

        answerTextArea.setColumns(20);
        answerTextArea.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        answerTextArea.setRows(5);
        answerTextArea.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        answerTextArea.setFocusable(false);
        jScrollPane1.setViewportView(answerTextArea);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 360, 450, -1));

        answerTextArea1.setColumns(20);
        answerTextArea1.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        answerTextArea1.setRows(5);
        answerTextArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        answerTextArea1.setFocusable(false);
        jScrollPane2.setViewportView(answerTextArea1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 200, 450, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 1370, 570));

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
        getContentPane().add(goBackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 6, 46, 45));

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

    private void nextQuestionBottonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextQuestionBottonActionPerformed
        // TODO add your handling code here:
        r1.setSelected(false);
        r2.setSelected(false);
        r3.setSelected(false);
        r4.setSelected(false);
        getQuestions();

    }//GEN-LAST:event_nextQuestionBottonActionPerformed

    private void r1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r1ActionPerformed

    private void r4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r4ActionPerformed

    private void r2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r2ActionPerformed

    private void submitQuestionBottonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitQuestionBottonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_submitQuestionBottonActionPerformed

    private void goBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackButtonActionPerformed
        // TODO add your handling code here:

        setVisible(false);
        StudentHome studentHome = new StudentHome();
        studentHome.setVisible(true);
        studentHome.jTabbedPane1.setSelectedIndex(1);
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
            java.util.logging.Logger.getLogger(ShowCorrectedTest.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowCorrectedTest.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowCorrectedTest.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowCorrectedTest.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if (loggedIn()) {

                    new ShowCorrectedTest().setVisible(true);
                } else {
                    new StudentLogin().setVisible(true);
                }
            }
        });
    }

    private static boolean loggedIn() {
        if (Student.getName() != null) {
            return true;
        } else {
            return false;
        }
    }

    void setCorrectPhotoNoVisible() {
        ans1Correct.setVisible(false);
        ans2Correct.setVisible(false);
        ans3Correct.setVisible(false);
        ans4Correct.setVisible(false);
    }

    int questionFrom = 1;
    String answer = "";
    String studentAnswer = "";

    void getQuestions() {
        try {
            if (rs1.next()) {
                answerTextArea1.setText("");

                answerTextArea.setText("");
                setCorrectPhotoNoVisible();
                QuestionNumber.setText(questionFrom + ") ");
                Question.setText(rs1.getString(6));
                answer = rs1.getString(11);
                studentAnswer = rs1.getString(1);
//                StudentTest.setQuestionID(rs1.getInt(1));

                if (rs1.getString(9) == null) {
                    r1.setText("");
                    r2.setText("");
                    r3.setText("");
                    r4.setText("");

                } else {
                    r1.setText(rs1.getString(7));
                    r2.setText(rs1.getString(8));
                    r3.setText(rs1.getString(9));
                    r4.setText(rs1.getString(10));
                }

                if (answer.equals("Answer 1")) {
                    ans1Correct.setVisible(true);
                } else if (answer.equals("Answer 2")) {
                    ans2Correct.setVisible(true);
                } else if (answer.equals("Answer 3")) {
                    ans3Correct.setVisible(true);
                } else if (answer.equals("Answer 4")) {
                    ans4Correct.setVisible(true);
                } else {
                    answerTextArea.setText(answer);
                }
                if (studentAnswer.equals("Answer 1")) {
                    r1.setSelected(true);
                } else if (studentAnswer.equals("Answer 2")) {
                    r2.setSelected(true);
                } else if (studentAnswer.equals("Answer 3")) {
                    r3.setSelected(true);
                } else if (studentAnswer.equals("Answer 4")) {
                    r4.setSelected(true);
                } else {
                    answerTextArea1.setText(studentAnswer);
                    answerTextArea.setText(answer);
                }

            } else {
                ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (2).png"));
                int a = JOptionPane.showOptionDialog(null, "This Was the Last Question you have answerd\n go back to the Student Home?", "GoBack!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, image, null, 0);
                if (a == 0) {
                    setVisible(false);
                    StudentHome studentHome = new StudentHome();
                    studentHome.setVisible(true);
                    studentHome.jTabbedPane1.setSelectedIndex(1);
                }
            }
            questionFrom++;

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ShowCorrectedTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Question;
    private javax.swing.JLabel QuestionNumber;
    private javax.swing.JLabel ans1Correct;
    private javax.swing.JLabel ans2Correct;
    private javax.swing.JLabel ans3Correct;
    private javax.swing.JLabel ans4Correct;
    private javax.swing.JTextArea answerTextArea;
    private javax.swing.JTextArea answerTextArea1;
    private javax.swing.JButton closeApplication;
    private javax.swing.JButton goBackButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel markOutOf;
    private javax.swing.JButton nextQuestionBotton;
    private javax.swing.JRadioButton r1;
    private javax.swing.JRadioButton r2;
    private javax.swing.JRadioButton r3;
    private javax.swing.JRadioButton r4;
    private javax.swing.JButton submitQuestionBotton;
    // End of variables declaration//GEN-END:variables
}
