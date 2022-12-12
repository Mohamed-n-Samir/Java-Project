package GUI;

import ProjectApplication.DbConnection;
import UsersClasses.Student;
import UsersClasses.StudentTest;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class StudentTestForm extends javax.swing.JFrame {

    Timer time;
    public String answer;
    public int min = 0;
    public int sec = 0;

    DbConnection dbConnection = new DbConnection();

    public StudentTestForm() {
        initComponents();
        getContentPane().setBackground(Color.white);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 15, 15));
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                jLabel2.setText("Test: " + StudentTest.getTestName());
                jLabel6.setText("Total Time: " + StudentTest.getTestTime() + " Min");
                jScrollPane1.setVisible(false);

                try {
                    Connection connection = dbConnection.getConnection();
                    pst1 = connection.prepareStatement("select * from Questions where testID = " + StudentTest.getTestID());;
                    rs1 = pst1.executeQuery();
                } catch (SQLException ex) {

                }
                loadQuestions();
                testTimer();
            }
        });

    }
    PreparedStatement pst1;
    ResultSet rs1;
    int questionFrom = 1;
    int mark = 0;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        closeApplication = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        fromQuestion = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        nextQuestionBotton = new javax.swing.JButton();
        r1 = new javax.swing.JRadioButton();
        r3 = new javax.swing.JRadioButton();
        r4 = new javax.swing.JRadioButton();
        r2 = new javax.swing.JRadioButton();
        Question = new javax.swing.JLabel();
        QuestionNumber = new javax.swing.JLabel();
        submitQuestionBotton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        answerTextArea = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1370, 800));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1370, 800));
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
        getContentPane().add(closeApplication, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(45, 68, 86));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Test: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, 450, -1));

        fromQuestion.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        fromQuestion.setText("12/12");
        getContentPane().add(fromQuestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 80, -1));

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

        buttonGroup1.add(r1);
        r1.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        r1.setForeground(new java.awt.Color(255, 255, 255));
        r1.setText("Answer1");
        r1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1ActionPerformed(evt);
            }
        });
        jPanel1.add(r1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 760, 40));

        buttonGroup1.add(r3);
        r3.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        r3.setForeground(new java.awt.Color(255, 255, 255));
        r3.setText("Answer3");
        jPanel1.add(r3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 760, 40));

        buttonGroup1.add(r4);
        r4.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        r4.setForeground(new java.awt.Color(255, 255, 255));
        r4.setText("Answer4");
        r4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4ActionPerformed(evt);
            }
        });
        jPanel1.add(r4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, 760, 40));

        buttonGroup1.add(r2);
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
        jScrollPane1.setViewportView(answerTextArea);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 1100, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 1370, 570));

        jLabel6.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        jLabel6.setText("Test Time:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 190, 210, -1));

        jLabel1.setFont(new java.awt.Font("Lato", 1, 24)); // NOI18N
        jLabel1.setText("00 ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 190, 40, 30));

        jLabel3.setFont(new java.awt.Font("Lato", 1, 24)); // NOI18N
        jLabel3.setText(":");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 190, 10, 30));

        jLabel4.setFont(new java.awt.Font("Lato", 1, 24)); // NOI18N
        jLabel4.setText("00 ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 190, 40, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeApplicationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeApplicationActionPerformed
        // TODO add your handling code here:
        ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
        int a = JOptionPane.showOptionDialog(null, "Are you Sure to Exit The Test?", "Exit Test!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, image, null, 0);
        if (a == 0) {
            System.exit(0);

        }
    }//GEN-LAST:event_closeApplicationActionPerformed

    private void nextQuestionBottonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextQuestionBottonActionPerformed
        // TODO add your handling code here:
        if (!r1.isSelected() && !r2.isSelected() && !r3.isSelected() && !r4.isSelected() && answerTextArea.getText().equals("")) {

            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
            JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">You Must Choose answer First!</p></html>", "Warning!", JOptionPane.INFORMATION_MESSAGE, image);

        } else {
            answerCheck();
            buttonGroup1.clearSelection();
            answerTextArea.setText("");
            System.out.println(mark);
            loadQuestions();
        }

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

        System.out.println(mark);

    }//GEN-LAST:event_submitQuestionBottonActionPerformed

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
            java.util.logging.Logger.getLogger(StudentTestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentTestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentTestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentTestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentTestForm().setVisible(true);
            }
        });
    }

    void loadQuestions() {
        try {
            if (rs1.next()) {
                fromQuestion.setText(questionFrom + " / " + StudentTest.getTestMark());
                QuestionNumber.setText(questionFrom + ") ");
                Question.setText(rs1.getString(2));
                answer = rs1.getString(7);
                System.out.println(answer);
                if (rs1.getString(3) != null) {
                    jScrollPane1.setVisible(false);
                    r1.setVisible(true);
                    r2.setVisible(true);
                    r3.setVisible(true);
                    r4.setVisible(true);
                    r1.setText(rs1.getString(3));
                    r2.setText(rs1.getString(4));
                    r3.setText(rs1.getString(5));
                    r4.setText(rs1.getString(6));
                } else {
                    r1.setVisible(false);
                    r2.setVisible(false);
                    r3.setVisible(false);
                    r4.setVisible(false);
                    jScrollPane1.setVisible(true);

                }

                questionFrom++;
            } else {
                nextQuestionBotton.setVisible(false);
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(TeacherHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    SimpleDateFormat dFromat = new SimpleDateFormat("dd-MM-YYYY");
    Date date = new Date();

    void testTimer() {
        setLocationRelativeTo(this);
        time = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jLabel4.setText(String.valueOf(sec));
                jLabel1.setText(String.valueOf(min));

                if (sec == 60) {
                    sec = 0;
                    min++;
                    if (min == 2) {
                        min = 0;
                        sec = 0;

                        time.stop();
                        answerCheck();
//                        submit();

                    }
                }
                sec++;
            }
        });
        time.start();
    }

    public void answerCheck() {
        String studentAnswer = "";
        if (r1.isSelected()) {
            studentAnswer = "Answer 1";
        } else if (r2.isSelected()) {
            studentAnswer = "Answer 2";
        } else if (r3.isSelected()) {
            studentAnswer = "Answer 3";
        } else if (r4.isSelected()) {
            studentAnswer = "Answer 4";
        } else {
            studentAnswer = answerTextArea.getText();
        }

        if (studentAnswer.equals(answer)) {
            mark++;
        }
    }

    public void question() {

    }

    public void submit() {

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Question;
    private javax.swing.JLabel QuestionNumber;
    private javax.swing.JTextArea answerTextArea;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton closeApplication;
    private javax.swing.JLabel fromQuestion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nextQuestionBotton;
    private javax.swing.JRadioButton r1;
    private javax.swing.JRadioButton r2;
    private javax.swing.JRadioButton r3;
    private javax.swing.JRadioButton r4;
    private javax.swing.JButton submitQuestionBotton;
    // End of variables declaration//GEN-END:variables
}
