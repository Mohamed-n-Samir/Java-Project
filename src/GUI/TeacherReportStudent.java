package GUI;

import UsersClasses.Teacher;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ProjectApplication.DbConnection;
import CustomComponent.TableTextCenter;

public class TeacherReportStudent extends javax.swing.JFrame {

    DbConnection dbConnection = new DbConnection();

    public TeacherReportStudent() {
        initComponents();
        getContentPane().setBackground(Color.white);                                                 // set new background color
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 15, 15)); // make rounded corners

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                getSubject();
                StudentTable();
            }
        });
    }

    void StudentTable() {

        try {
            Connection connection = dbConnection.getConnection();
            PreparedStatement pst;
            PreparedStatement pst1;

            pst = connection.prepareStatement("select Students.ID as Student_ID,Students.[name] as Student_Name,Students.phone as Student_PhoneNumber,StudentsTestOnce.degree as Student_Degree,Test.noOfQuestions as Full_Mark,Test.[subject] as Test_Subject,Test.[name] as Test_Name\n "
                    + "from StudentsTestOnce\n"
                    + "INNER JOIN Test\n"
                    + "on Test.ID = StudentsTestOnce.testID\n"
                    + "INNER JOIN Students\n"
                    + "on Students.ID = StudentsTestOnce.studentID\n"
                    + "where (Test.teacherID = " + Teacher.getID() + "and Test.[subject] = '" + Subject.getSelectedItem().toString() + "')\n"
                    + "order by StudentsTestOnce.degree asc");

            ResultSet rs = pst.executeQuery();

            ResultSetMetaData RSM = rs.getMetaData();

            int c;
            c = RSM.getColumnCount();                //use this if you use *

            int numberOfRows = 0;

            DefaultTableModel DF = (DefaultTableModel) studentDataTable.getModel();
            DF.setRowCount(0);
            String[] colName = new String[c];
            for (int i = 1; i <= c; i++) {
                colName[i - 1] = RSM.getColumnName(i);
            }
            DF.setColumnIdentifiers(colName);

            Object[] rows;
            while (rs.next()) {
                pst1 = connection.prepareStatement("select * from studentReport where (studentID = " + rs.getString(1) + " and testName = '" + rs.getString(7) + "' )");
                ResultSet rs1 = pst1.executeQuery();
                if (!rs1.next()) {

                    DF.addRow(rows = new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)});
                    numberOfRows++;
                }
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7));
            }
            studentDataTable.fixTable(jScrollPane1);

        } catch (SQLException ex) {
            Logger.getLogger(TeacherHome.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    int studentID;
    int fullMark;
    int studentDegree;
    String studentName;
    String studentPhoneNumber;
    String testName;
    String testSubject;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel10 = new javax.swing.JPanel();
        goBackButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        closeApplication = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        reportTextArea = new javax.swing.JTextArea();
        SubmitReport = new javax.swing.JButton();
        clearReport = new javax.swing.JButton();
        Subject = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentDataTable = new CustomComponent.TableTextCenter();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1370, 800));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1370, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        getContentPane().add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 70, -1, -1));

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
        getContentPane().add(goBackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 46, 45));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/teacher (2).png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, -1, -1));

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

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, -1, -1));

        jLabel2.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(45, 68, 86));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Teacher");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, 290, -1));

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

        jLabel1.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        jLabel1.setText("Subject:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 170, 150, 20));

        reportTextArea.setColumns(20);
        reportTextArea.setRows(5);
        reportTextArea.setFocusable(false);
        jScrollPane2.setViewportView(reportTextArea);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 330, 440, 330));

        SubmitReport.setBackground(new java.awt.Color(70, 202, 255));
        SubmitReport.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        SubmitReport.setForeground(new java.awt.Color(255, 255, 255));
        SubmitReport.setText("Submit");
        SubmitReport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SubmitReport.setEnabled(false);
        SubmitReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitReportActionPerformed(evt);
            }
        });
        getContentPane().add(SubmitReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 680, 220, 60));

        clearReport.setBackground(new java.awt.Color(255, 44, 107));
        clearReport.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        clearReport.setForeground(new java.awt.Color(255, 255, 255));
        clearReport.setText("Clear");
        clearReport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearReport.setEnabled(false);
        clearReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearReportActionPerformed(evt);
            }
        });
        getContentPane().add(clearReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 680, 210, 60));

        Subject.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        Subject.setForeground(new java.awt.Color(45, 68, 86));
        Subject.setBorder(null);
        Subject.setLightWeightPopupEnabled(false);
        Subject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubjectActionPerformed(evt);
            }
        });
        getContentPane().add(Subject, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 200, 440, 80));

        jLabel3.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        jLabel3.setText("Write The Report:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 300, 150, 20));

        studentDataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        studentDataTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentDataTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(studentDataTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 790, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void goBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackButtonActionPerformed
        // TODO add your handling code here:

        setVisible(false);
        TeacherHome teacherHome = new TeacherHome();
        teacherHome.jTabbedPane1.setSelectedIndex(3);
        teacherHome.setVisible(true);
    }//GEN-LAST:event_goBackButtonActionPerformed

    private void closeApplicationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeApplicationActionPerformed
        // TODO add your handling code here:
        ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
        int a = JOptionPane.showOptionDialog(null, "Are you Sure to Exit The Program?", "Exit!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, image, null, 0);
        if (a == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_closeApplicationActionPerformed

    private void SubmitReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitReportActionPerformed
        // TODO add your handling code here:

        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);

        if (!reportTextArea.getText().equals("") && reportTextArea.getText().length() > 6) {
            try {
                Connection connection = dbConnection.ConnectDB();
                PreparedStatement pst = connection.prepareStatement("insert into studentReport values(?,?,?,?,?,?,?,?,?,?,?)");
                pst.setInt(1, studentID);
                pst.setString(2, studentName);
                pst.setInt(3, studentDegree);
                pst.setInt(4, fullMark);
                pst.setString(5, testSubject);
                pst.setString(6, testName);
                pst.setString(7, reportTextArea.getText());
                pst.setBoolean(8, false);
                pst.setString(9, Teacher.getName());
                pst.setInt(10, Teacher.getID());
                pst.setDate(11, date);

                int k = pst.executeUpdate();
                if (k == 1) {
                    tableUnFocus(false);
                    StudentTable();
                    reportTextArea.setText("");
                    JOptionPane.showMessageDialog(this, "Report Submitted Successfully!", "Done", JOptionPane.OK_OPTION);

                } else {
                    JOptionPane.showMessageDialog(this, "Failed to submit the Report!", "Submit Error", JOptionPane.ERROR_MESSAGE);

                }
            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(this, "Failed to Add Test!", "Error", JOptionPane.ERROR_MESSAGE);

                Logger.getLogger(TeacherHome.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
            JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Failed to Submit the Report Cheak the the Report<br>length is more than the 6 characters!</p></html>", "Submit falid!", JOptionPane.INFORMATION_MESSAGE, image);

        }


    }//GEN-LAST:event_SubmitReportActionPerformed

    private void clearReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearReportActionPerformed
        // TODO add your handling code here:

        reportTextArea.setText("");


    }//GEN-LAST:event_clearReportActionPerformed

    private void SubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubjectActionPerformed
        // TODO add your handling code here:

        StudentTable();
        tableUnFocus(false);


    }//GEN-LAST:event_SubjectActionPerformed

    private void studentDataTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentDataTableMouseClicked
        // TODO add your handling code here:

        DefaultTableModel d1 = (DefaultTableModel) studentDataTable.getModel();
        int SelectIndex = studentDataTable.getSelectedRow();
        studentID = (Integer.parseInt(d1.getValueAt(SelectIndex, 0).toString()));
        studentName = d1.getValueAt(SelectIndex, 1).toString();
        studentPhoneNumber = d1.getValueAt(SelectIndex, 2).toString();
        studentDegree = (Integer.parseInt(d1.getValueAt(SelectIndex, 3).toString()));
        fullMark = (Integer.parseInt(d1.getValueAt(SelectIndex, 4).toString()));
        testSubject = d1.getValueAt(SelectIndex, 5).toString();
        testName = d1.getValueAt(SelectIndex, 6).toString();

        tableUnFocus(true);
        reportTextArea.requestFocus();

    }//GEN-LAST:event_studentDataTableMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TeacherReportStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeacherReportStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeacherReportStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeacherReportStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if (LoggedIn()) {
                    new TeacherReportStudent().setVisible(true);

                } else {
                    new TeacherLogin().setVisible(true);

                }
            }
        });
    }

    static boolean LoggedIn() {
        if (Teacher.getName() != null) {
            return true;
        } else {
            return false;
        }
    }

    void getSubject() {
        String[] subjects = {Teacher.getSubject1(), Teacher.getSubject2(), Teacher.getSubject3()};
//        System.out.println(Arrays.toString(subjects));

        Object[] rows;
        if (subjects[0] != null && subjects[1] == null && subjects[2] == null) {
            rows = new Object[]{subjects[0]};
        } else if (subjects[0] == null && subjects[1] != null && subjects[2] == null) {
            rows = new Object[]{subjects[1]};
        } else if (subjects[0] == null && subjects[1] == null && subjects[2] != null) {
            rows = new Object[]{subjects[2]};
        } else if (subjects[0] != null && subjects[1] == null && subjects[2] != null) {
            rows = new Object[]{subjects[0], subjects[2]};
        } else if (subjects[0] == null && subjects[1] != null && subjects[2] != null) {
            rows = new Object[]{subjects[1], subjects[2]};
        } else if (subjects[0] != null && subjects[1] != null && subjects[2] == null) {
            rows = new Object[]{subjects[0], subjects[1]};
        } else if (subjects[0] != null && subjects[1] != null && subjects[2] != null) {
            rows = new Object[]{subjects[0], subjects[1], subjects[2]};
        } else {
            rows = new Object[]{"NONE"};
        }

        Subject.setModel(new javax.swing.DefaultComboBoxModel(rows));
    }

    void tableUnFocus(boolean b) {
        clearReport.setEnabled(b);
        SubmitReport.setEnabled(b);
        reportTextArea.setFocusable(b);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Subject;
    private javax.swing.JButton SubmitReport;
    private javax.swing.JButton clearReport;
    private javax.swing.JButton closeApplication;
    private javax.swing.JButton goBackButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea reportTextArea;
    private CustomComponent.TableTextCenter studentDataTable;
    // End of variables declaration//GEN-END:variables

}
