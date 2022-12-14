package GUI;

import CustomComponent.RoundedJTextFieldTest;
import ProjectApplication.DbConnection;
import java.awt.Color;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import UsersClasses.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TeacherHome extends javax.swing.JFrame {

    DbConnection dbConnection = new DbConnection();
    Test test = new Test();
    Question question = new Question();

    public TeacherHome() {
        initComponents();

        getContentPane().setBackground(Color.white);                                                 // set new background color
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 15, 15)); // make rounded corners

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                if (LoggedIn()) {
                    jLabel2.setText("Welcome " + Teacher.getName());
                    TestTable();

                } else {
                    jLabel2.setText("Teacher");

                }
                getTeacherAllSubjects();

            }
        });

    }

    public void TestTable() {

        try {
            Connection connection = dbConnection.getConnection();
            PreparedStatement pst;
            pst = connection.prepareStatement("select ID,name,noOfQuestions,time,Subject from Test where teacherID = " + Teacher.getID());

            ResultSet rs = pst.executeQuery();
            ResultSetMetaData RSM = rs.getMetaData();

            int c;
            c = RSM.getColumnCount();

            DefaultTableModel DF = (DefaultTableModel) TestTable.getModel();
            DF.setRowCount(0);
            String[] colName = new String[c];
            for (int i = 0; i < c; i++) {
                colName[i] = RSM.getColumnName(i + 1);
            }
            DF.setColumnIdentifiers(colName);

            Object[] rows;
            while (rs.next()) {
                DF.addRow(rows = new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)});
            }
            setQuestionTableNoRow();


        } catch (SQLException ex) {
            Logger.getLogger(TeacherHome.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void QuestionTable() {

        try {
            Connection connection = dbConnection.getConnection();
            PreparedStatement pst;
            pst = connection.prepareStatement("select * from Questions where testID = " + test.getListTestID());

            ResultSet rs = pst.executeQuery();
            ResultSetMetaData RSM = rs.getMetaData();

            int c;
            c = RSM.getColumnCount() - 1;                //use this if you use *

            int numberOfRows = 0;

            DefaultTableModel DF = (DefaultTableModel) QuestionTable.getModel();
            DF.setRowCount(0);
            String[] colName = new String[c];
            for (int i = 1; i <= c; i++) {
                colName[i - 1] = RSM.getColumnName(i);
            }
            DF.setColumnIdentifiers(colName);

            Object[] rows;
            while (rs.next()) {
                DF.addRow(rows = new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)});
                numberOfRows++;

            }

            listNumberOfQuestions.setText(numberOfRows + "");

            QuestionTable.getColumnModel().getColumn(0).setMinWidth(0);
            QuestionTable.getColumnModel().getColumn(0).setMaxWidth(0);

        } catch (SQLException ex) {
            Logger.getLogger(TeacherHome.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel10 = new javax.swing.JPanel();
        listTests = new javax.swing.JButton();
        goBackButton = new javax.swing.JButton();
        closeApplication = new javax.swing.JButton();
        addTest = new javax.swing.JButton();
        Profile = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        updateTest = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        Subject = new javax.swing.JComboBox<>();
        noOfQuestions = new RoundedJTextFieldTest(50);
        testDuration = new RoundedJTextFieldTest(50);
        testName = new RoundedJTextFieldTest(50);
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        addTestButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        newNoOfQuestions = new RoundedJTextFieldTest(50);
        newTimeDuration = new RoundedJTextFieldTest(50);
        testID = new RoundedJTextFieldTest(50);
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        addQuestionButton = new javax.swing.JButton();
        testIDSearch = new javax.swing.JButton();
        questionClearButton = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        answer4 = new RoundedJTextFieldTest(50);
        answer1 = new RoundedJTextFieldTest(50);
        addQuestion = new RoundedJTextFieldTest(50);
        updateClearBotton = new javax.swing.JButton();
        updateTestButton = new javax.swing.JButton();
        answer2 = new RoundedJTextFieldTest(50);
        jLabel21 = new javax.swing.JLabel();
        answer3 = new RoundedJTextFieldTest(50);
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        newTestName = new RoundedJTextFieldTest(50);
        jLabel24 = new javax.swing.JLabel();
        updateDeleteBotton = new javax.swing.JButton();
        answerTxtField = new RoundedJTextFieldTest(50);
        answer = new javax.swing.JComboBox<>();
        isMCQQuesion = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        testTable = new javax.swing.JLabel();
        questionTable = new javax.swing.JLabel();
        updateQuestionFromTable = new javax.swing.JButton();
        deleteQuestionFromTable = new javax.swing.JButton();
        answer1FromTable = new RoundedJTextFieldTest(50);
        jLabel29 = new javax.swing.JLabel();
        answer2FromTable = new RoundedJTextFieldTest(50);
        jLabel30 = new javax.swing.JLabel();
        answer3FromTable = new RoundedJTextFieldTest(50);
        jLabel31 = new javax.swing.JLabel();
        answerFromTable = new javax.swing.JComboBox<>();
        answer4FromTable = new RoundedJTextFieldTest(50);
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        questionFromTable = new RoundedJTextFieldTest(50);
        jLabel34 = new javax.swing.JLabel();
        listNumberOfQuestions = new javax.swing.JLabel();
        answerFromTableTxt = new RoundedJTextFieldTest(50);
        jScrollPane3 = new javax.swing.JScrollPane();
        TestTable = new CustomComponent.TableTextCenter();
        jScrollPane1 = new javax.swing.JScrollPane();
        QuestionTable = new CustomComponent.TableTextCenter();
        jPanel3 = new javax.swing.JPanel();
        TeacherID = new CustomComponent.ReadField(50);
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TeacherName = new CustomComponent.ReadField(50);
        jLabel5 = new javax.swing.JLabel();
        TeacherEmail = new CustomComponent.ReadField(50);
        jLabel13 = new javax.swing.JLabel();
        TeacherSubject1 = new CustomComponent.ReadField(50);
        jLabel25 = new javax.swing.JLabel();
        TeacherSubject2 = new CustomComponent.ReadField(50);
        jLabel26 = new javax.swing.JLabel();
        TeacherSubject3 = new CustomComponent.ReadField(50);
        TeacherUpdateInfo = new javax.swing.JButton();
        TeacherReportStudent = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
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

        listTests.setBackground(new java.awt.Color(70, 202, 255));
        listTests.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        listTests.setForeground(new java.awt.Color(255, 255, 255));
        listTests.setText("List Tests");
        listTests.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listTests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listTestsActionPerformed(evt);
            }
        });
        getContentPane().add(listTests, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 160, 178, 50));

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

        addTest.setBackground(new java.awt.Color(70, 202, 255));
        addTest.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        addTest.setForeground(new java.awt.Color(255, 255, 255));
        addTest.setText("Add Test");
        addTest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTestActionPerformed(evt);
            }
        });
        getContentPane().add(addTest, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 178, 50));

        Profile.setBackground(new java.awt.Color(70, 202, 255));
        Profile.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        Profile.setForeground(new java.awt.Color(255, 255, 255));
        Profile.setText("Profile");
        Profile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfileActionPerformed(evt);
            }
        });
        getContentPane().add(Profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 160, 178, 50));

        logout.setBackground(new java.awt.Color(70, 202, 255));
        logout.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        logout.setForeground(new java.awt.Color(255, 255, 255));
        logout.setText("Log-out");
        logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        getContentPane().add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 160, 178, 50));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/teacher (2).png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, -1, -1));

        updateTest.setBackground(new java.awt.Color(70, 202, 255));
        updateTest.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        updateTest.setForeground(new java.awt.Color(255, 255, 255));
        updateTest.setText("Update Test");
        updateTest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateTestActionPerformed(evt);
            }
        });
        getContentPane().add(updateTest, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 178, 50));

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

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Subject.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        Subject.setForeground(new java.awt.Color(45, 68, 86));
        Subject.setBorder(null);
        Subject.setLightWeightPopupEnabled(false);
        jPanel4.add(Subject, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 360, 378, 80));

        noOfQuestions.setBackground(new java.awt.Color(45, 68, 86));
        noOfQuestions.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        noOfQuestions.setForeground(new java.awt.Color(153, 153, 153));
        noOfQuestions.setText("Number of Questions");
        noOfQuestions.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                noOfQuestionsFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                noOfQuestionsFocusLost(evt);
            }
        });
        jPanel4.add(noOfQuestions, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 260, 378, 80));

        testDuration.setBackground(new java.awt.Color(45, 68, 86));
        testDuration.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        testDuration.setForeground(new java.awt.Color(153, 153, 153));
        testDuration.setText("Time in Min.");
        testDuration.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                testDurationFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                testDurationFocusLost(evt);
            }
        });
        jPanel4.add(testDuration, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 160, 378, 80));

        testName.setBackground(new java.awt.Color(45, 68, 86));
        testName.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        testName.setForeground(new java.awt.Color(153, 153, 153));
        testName.setText("TestName");
        testName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                testNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                testNameFocusLost(evt);
            }
        });
        jPanel4.add(testName, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 60, 378, 80));

        jLabel6.setFont(new java.awt.Font("Lato", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Test Duration:");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, -1, -1));

        jLabel7.setFont(new java.awt.Font("Lato", 3, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("NOQuestions:");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, -1, -1));

        jLabel8.setFont(new java.awt.Font("Lato", 3, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Test Name:");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, -1, -1));

        addTestButton.setBackground(new java.awt.Color(70, 202, 255));
        addTestButton.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        addTestButton.setForeground(new java.awt.Color(255, 255, 255));
        addTestButton.setText("Add Test");
        addTestButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addTestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTestButtonActionPerformed(evt);
            }
        });
        jPanel4.add(addTestButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 460, 180, 60));

        clearButton.setBackground(new java.awt.Color(70, 202, 255));
        clearButton.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        clearButton.setForeground(new java.awt.Color(255, 255, 255));
        clearButton.setText("Clear");
        clearButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        jPanel4.add(clearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 460, 180, 60));

        jLabel9.setText("Note: test time can't be zero");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 180, 150, -1));

        jLabel10.setText("if it set as zero it will converted to 10Min.");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 200, -1, -1));

        jLabel11.setText("Note: can't be less than 0 and more than 60.");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 270, -1, 20));

        jLabel12.setText("else will be 10 Questions.");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 290, -1, -1));

        jLabel14.setText("This by defult is set to the Teacher subject!");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 90, -1, -1));

        jLabel35.setFont(new java.awt.Font("Lato", 3, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(51, 51, 51));
        jLabel35.setText("Subject:");
        jPanel4.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, 70, -1));

        jTabbedPane1.addTab("tab1", jPanel4);

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        newNoOfQuestions.setBackground(new java.awt.Color(45, 68, 86));
        newNoOfQuestions.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        newNoOfQuestions.setForeground(new java.awt.Color(153, 153, 153));
        newNoOfQuestions.setText("Number of Questions");
        newNoOfQuestions.setFocusable(false);
        newNoOfQuestions.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                newNoOfQuestionsFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                newNoOfQuestionsFocusLost(evt);
            }
        });
        newNoOfQuestions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newNoOfQuestionsActionPerformed(evt);
            }
        });
        jPanel6.add(newNoOfQuestions, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 260, 220, 70));

        newTimeDuration.setBackground(new java.awt.Color(45, 68, 86));
        newTimeDuration.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        newTimeDuration.setForeground(new java.awt.Color(153, 153, 153));
        newTimeDuration.setText("Time in Min.");
        newTimeDuration.setFocusable(false);
        newTimeDuration.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                newTimeDurationFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                newTimeDurationFocusLost(evt);
            }
        });
        jPanel6.add(newTimeDuration, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 220, 70));

        testID.setBackground(new java.awt.Color(45, 68, 86));
        testID.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        testID.setForeground(new java.awt.Color(153, 153, 153));
        testID.setText("Search Test ID");
        testID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                testIDFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                testIDFocusLost(evt);
            }
        });
        jPanel6.add(testID, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 220, 70));

        jLabel15.setFont(new java.awt.Font("Lato", 3, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("New Test Duration:");
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, 180, 30));

        jLabel16.setFont(new java.awt.Font("Lato", 3, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("New NOQuestions:");
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, 170, 30));

        jLabel17.setFont(new java.awt.Font("Lato", 3, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("Test ID:");
        jPanel6.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 90, 30));

        addQuestionButton.setBackground(new java.awt.Color(70, 202, 255));
        addQuestionButton.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        addQuestionButton.setForeground(new java.awt.Color(255, 255, 255));
        addQuestionButton.setText("Add Question");
        addQuestionButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addQuestionButton.setEnabled(false);
        addQuestionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addQuestionButtonActionPerformed(evt);
            }
        });
        jPanel6.add(addQuestionButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 500, 190, 60));

        testIDSearch.setBackground(new java.awt.Color(70, 202, 255));
        testIDSearch.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        testIDSearch.setForeground(new java.awt.Color(255, 255, 255));
        testIDSearch.setText("Search");
        testIDSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        testIDSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testIDSearchActionPerformed(evt);
            }
        });
        jPanel6.add(testIDSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 30, 100, 50));

        questionClearButton.setBackground(new java.awt.Color(70, 202, 255));
        questionClearButton.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        questionClearButton.setForeground(new java.awt.Color(255, 255, 255));
        questionClearButton.setText("Clear");
        questionClearButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        questionClearButton.setEnabled(false);
        questionClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionClearButtonActionPerformed(evt);
            }
        });
        jPanel6.add(questionClearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 500, 200, 60));

        jLabel18.setFont(new java.awt.Font("Lato", 3, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("AddQuestion:");
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 40, -1, 30));

        jLabel19.setFont(new java.awt.Font("Lato", 3, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("answer1:");
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 120, 70, 30));

        jLabel20.setFont(new java.awt.Font("Lato", 3, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 51, 51));
        jLabel20.setText("answer4:");
        jPanel6.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 360, -1, 30));

        answer4.setBackground(new java.awt.Color(45, 68, 86));
        answer4.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        answer4.setForeground(new java.awt.Color(153, 153, 153));
        answer4.setText("answer4");
        answer4.setEnabled(false);
        answer4.setFocusable(false);
        answer4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                answer4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                answer4FocusLost(evt);
            }
        });
        jPanel6.add(answer4, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 340, 420, 70));

        answer1.setBackground(new java.awt.Color(45, 68, 86));
        answer1.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        answer1.setForeground(new java.awt.Color(153, 153, 153));
        answer1.setText("answer1");
        answer1.setEnabled(false);
        answer1.setFocusable(false);
        answer1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                answer1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                answer1FocusLost(evt);
            }
        });
        jPanel6.add(answer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 100, 420, 70));

        addQuestion.setBackground(new java.awt.Color(45, 68, 86));
        addQuestion.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        addQuestion.setForeground(new java.awt.Color(153, 153, 153));
        addQuestion.setText("Question");
        addQuestion.setFocusable(false);
        addQuestion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                addQuestionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                addQuestionFocusLost(evt);
            }
        });
        addQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addQuestionActionPerformed(evt);
            }
        });
        jPanel6.add(addQuestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 20, 420, 70));

        updateClearBotton.setBackground(new java.awt.Color(70, 202, 255));
        updateClearBotton.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        updateClearBotton.setForeground(new java.awt.Color(255, 255, 255));
        updateClearBotton.setText("Clear");
        updateClearBotton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateClearBotton.setEnabled(false);
        updateClearBotton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateClearBottonActionPerformed(evt);
            }
        });
        jPanel6.add(updateClearBotton, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 350, 110, 60));

        updateTestButton.setBackground(new java.awt.Color(70, 202, 255));
        updateTestButton.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        updateTestButton.setForeground(new java.awt.Color(255, 255, 255));
        updateTestButton.setText("Update Test");
        updateTestButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateTestButton.setEnabled(false);
        updateTestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateTestButtonActionPerformed(evt);
            }
        });
        jPanel6.add(updateTestButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 350, 130, 60));

        answer2.setBackground(new java.awt.Color(45, 68, 86));
        answer2.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        answer2.setForeground(new java.awt.Color(153, 153, 153));
        answer2.setText("answer2");
        answer2.setEnabled(false);
        answer2.setFocusable(false);
        answer2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                answer2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                answer2FocusLost(evt);
            }
        });
        answer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answer2ActionPerformed(evt);
            }
        });
        jPanel6.add(answer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 180, 420, 70));

        jLabel21.setFont(new java.awt.Font("Lato", 3, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setText("answer2:");
        jPanel6.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 200, -1, 30));

        answer3.setBackground(new java.awt.Color(45, 68, 86));
        answer3.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        answer3.setForeground(new java.awt.Color(153, 153, 153));
        answer3.setText("answer3");
        answer3.setEnabled(false);
        answer3.setFocusable(false);
        answer3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                answer3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                answer3FocusLost(evt);
            }
        });
        jPanel6.add(answer3, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 260, 420, 70));

        jLabel22.setFont(new java.awt.Font("Lato", 3, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 51, 51));
        jLabel22.setText("answer3:");
        jPanel6.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 280, -1, 30));

        jLabel23.setFont(new java.awt.Font("Lato", 3, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(51, 51, 51));
        jLabel23.setText("answer:");
        jPanel6.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 440, -1, 30));

        newTestName.setBackground(new java.awt.Color(45, 68, 86));
        newTestName.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        newTestName.setForeground(new java.awt.Color(153, 153, 153));
        newTestName.setText("Test Name");
        newTestName.setFocusable(false);
        newTestName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                newTestNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                newTestNameFocusLost(evt);
            }
        });
        newTestName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newTestNameActionPerformed(evt);
            }
        });
        jPanel6.add(newTestName, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 220, 70));

        jLabel24.setFont(new java.awt.Font("Lato", 3, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(51, 51, 51));
        jLabel24.setText("New Test Name:");
        jPanel6.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 170, 30));

        updateDeleteBotton.setBackground(new java.awt.Color(70, 202, 255));
        updateDeleteBotton.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        updateDeleteBotton.setForeground(new java.awt.Color(255, 255, 255));
        updateDeleteBotton.setText("Delete");
        updateDeleteBotton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateDeleteBotton.setEnabled(false);
        updateDeleteBotton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateDeleteBottonActionPerformed(evt);
            }
        });
        jPanel6.add(updateDeleteBotton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, 130, 60));

        answerTxtField.setBackground(new java.awt.Color(45, 68, 86));
        answerTxtField.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        answerTxtField.setForeground(new java.awt.Color(153, 153, 153));
        answerTxtField.setText("answer");
        answerTxtField.setFocusable(false);
        answerTxtField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                answerTxtFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                answerTxtFieldFocusLost(evt);
            }
        });
        jPanel6.add(answerTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 420, 420, 70));

        answer.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        answer.setForeground(new java.awt.Color(45, 68, 86));
        answer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Answer 1", "Answer 2", "Answer 3", "Answer 4" }));
        answer.setBorder(null);
        answer.setEnabled(false);
        answer.setLightWeightPopupEnabled(false);
        jPanel6.add(answer, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 420, 420, 70));

        isMCQQuesion.setText("MCQ");
        isMCQQuesion.setEnabled(false);
        isMCQQuesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isMCQQuesionActionPerformed(evt);
            }
        });
        jPanel6.add(isMCQQuesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 40, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 1540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab2", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        testTable.setFont(new java.awt.Font("Lato", 1, 18)); // NOI18N
        testTable.setForeground(new java.awt.Color(45, 68, 86));
        testTable.setText("Test Table");
        jPanel2.add(testTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, -1));

        questionTable.setFont(new java.awt.Font("Lato", 1, 18)); // NOI18N
        questionTable.setForeground(new java.awt.Color(45, 68, 86));
        questionTable.setText("Question Table");
        jPanel2.add(questionTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 10, -1, -1));

        updateQuestionFromTable.setBackground(new java.awt.Color(70, 202, 255));
        updateQuestionFromTable.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        updateQuestionFromTable.setForeground(new java.awt.Color(255, 255, 255));
        updateQuestionFromTable.setText("Update");
        updateQuestionFromTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateQuestionFromTable.setEnabled(false);
        updateQuestionFromTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateQuestionFromTableActionPerformed(evt);
            }
        });
        jPanel2.add(updateQuestionFromTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 500, 270, 60));

        deleteQuestionFromTable.setBackground(new java.awt.Color(255, 44, 107));
        deleteQuestionFromTable.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        deleteQuestionFromTable.setForeground(new java.awt.Color(255, 255, 255));
        deleteQuestionFromTable.setText("Delete");
        deleteQuestionFromTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteQuestionFromTable.setEnabled(false);
        deleteQuestionFromTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteQuestionFromTableActionPerformed(evt);
            }
        });
        jPanel2.add(deleteQuestionFromTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 500, 270, 60));

        answer1FromTable.setBackground(new java.awt.Color(45, 68, 86));
        answer1FromTable.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        answer1FromTable.setForeground(new java.awt.Color(153, 153, 153));
        answer1FromTable.setText("answer");
        answer1FromTable.setFocusable(false);
        answer1FromTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                answer1FromTableFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                answer1FromTableFocusLost(evt);
            }
        });
        answer1FromTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answer1FromTableActionPerformed(evt);
            }
        });
        jPanel2.add(answer1FromTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, 560, 60));

        jLabel29.setFont(new java.awt.Font("Lato", 3, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(51, 51, 51));
        jLabel29.setText("Answer1:");
        jPanel2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, -1, -1));

        answer2FromTable.setBackground(new java.awt.Color(45, 68, 86));
        answer2FromTable.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        answer2FromTable.setForeground(new java.awt.Color(153, 153, 153));
        answer2FromTable.setText("answer");
        answer2FromTable.setFocusable(false);
        answer2FromTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                answer2FromTableFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                answer2FromTableFocusLost(evt);
            }
        });
        jPanel2.add(answer2FromTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 360, 560, 60));

        jLabel30.setFont(new java.awt.Font("Lato", 3, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(51, 51, 51));
        jLabel30.setText("Answer3:");
        jPanel2.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 450, -1, -1));

        answer3FromTable.setBackground(new java.awt.Color(45, 68, 86));
        answer3FromTable.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        answer3FromTable.setForeground(new java.awt.Color(153, 153, 153));
        answer3FromTable.setText("answer");
        answer3FromTable.setFocusable(false);
        answer3FromTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                answer3FromTableFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                answer3FromTableFocusLost(evt);
            }
        });
        jPanel2.add(answer3FromTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 430, 560, 60));

        jLabel31.setFont(new java.awt.Font("Lato", 3, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(51, 51, 51));
        jLabel31.setText("Answer2:");
        jPanel2.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 380, -1, -1));

        answerFromTable.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        answerFromTable.setForeground(new java.awt.Color(45, 68, 86));
        answerFromTable.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Answer 1", "Answer 2", "Answer 3", "Answer 4" }));
        answerFromTable.setBorder(null);
        answerFromTable.setEnabled(false);
        answerFromTable.setLightWeightPopupEnabled(false);
        jPanel2.add(answerFromTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 500, 560, 60));

        answer4FromTable.setBackground(new java.awt.Color(45, 68, 86));
        answer4FromTable.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        answer4FromTable.setForeground(new java.awt.Color(153, 153, 153));
        answer4FromTable.setText("answer");
        answer4FromTable.setFocusable(false);
        answer4FromTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                answer4FromTableFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                answer4FromTableFocusLost(evt);
            }
        });
        jPanel2.add(answer4FromTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 430, 560, 60));

        jLabel32.setFont(new java.awt.Font("Lato", 3, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(51, 51, 51));
        jLabel32.setText("Answer4:");
        jPanel2.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 450, -1, -1));

        jLabel33.setFont(new java.awt.Font("Lato", 3, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(51, 51, 51));
        jLabel33.setText("Answer:");
        jPanel2.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 520, -1, -1));

        questionFromTable.setBackground(new java.awt.Color(45, 68, 86));
        questionFromTable.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        questionFromTable.setForeground(new java.awt.Color(153, 153, 153));
        questionFromTable.setText("Question");
        questionFromTable.setFocusable(false);
        questionFromTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                questionFromTableFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                questionFromTableFocusLost(evt);
            }
        });
        questionFromTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionFromTableActionPerformed(evt);
            }
        });
        jPanel2.add(questionFromTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, 1230, 60));

        jLabel34.setFont(new java.awt.Font("Lato", 3, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(51, 51, 51));
        jLabel34.setText("Question:");
        jPanel2.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, -1, -1));

        listNumberOfQuestions.setBackground(new java.awt.Color(45, 68, 86));
        listNumberOfQuestions.setForeground(new java.awt.Color(255, 255, 255));
        listNumberOfQuestions.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        listNumberOfQuestions.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        listNumberOfQuestions.setOpaque(true);
        jPanel2.add(listNumberOfQuestions, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 10, 40, 20));

        answerFromTableTxt.setBackground(new java.awt.Color(45, 68, 86));
        answerFromTableTxt.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        answerFromTableTxt.setForeground(new java.awt.Color(153, 153, 153));
        answerFromTableTxt.setText("answer");
        answerFromTableTxt.setFocusable(false);
        answerFromTableTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                answerFromTableTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                answerFromTableTxtFocusLost(evt);
            }
        });
        jPanel2.add(answerFromTableTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 500, 560, 60));

        TestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TestTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TestTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TestTable);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 640, 240));

        QuestionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        QuestionTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                QuestionTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(QuestionTable);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 40, 650, 240));

        jTabbedPane1.addTab("tab3", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TeacherID.setBackground(new java.awt.Color(45, 68, 86));
        TeacherID.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        TeacherID.setForeground(new java.awt.Color(255, 255, 255));
        TeacherID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TeacherID.setText("TeacherID");
        TeacherID.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TeacherID.setFocusable(false);
        TeacherID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TeacherIDFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TeacherIDFocusLost(evt);
            }
        });
        jPanel3.add(TeacherID, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 380, 60));

        jLabel1.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(45, 68, 86));
        jLabel1.setText("ID");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(45, 68, 86));
        jLabel3.setText("Name");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 60, 50, -1));

        TeacherName.setBackground(new java.awt.Color(45, 68, 86));
        TeacherName.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        TeacherName.setForeground(new java.awt.Color(255, 255, 255));
        TeacherName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TeacherName.setText("Name");
        TeacherName.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TeacherName.setFocusable(false);
        TeacherName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TeacherNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TeacherNameFocusLost(evt);
            }
        });
        jPanel3.add(TeacherName, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 80, 380, 60));

        jLabel5.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(45, 68, 86));
        jLabel5.setText("Email");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 60, 40, -1));

        TeacherEmail.setBackground(new java.awt.Color(45, 68, 86));
        TeacherEmail.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        TeacherEmail.setForeground(new java.awt.Color(255, 255, 255));
        TeacherEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TeacherEmail.setText("Email");
        TeacherEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TeacherEmail.setFocusable(false);
        TeacherEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TeacherEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TeacherEmailFocusLost(evt);
            }
        });
        jPanel3.add(TeacherEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 80, 380, 60));

        jLabel13.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(45, 68, 86));
        jLabel13.setText("Subject1");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, -1, -1));

        TeacherSubject1.setBackground(new java.awt.Color(45, 68, 86));
        TeacherSubject1.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        TeacherSubject1.setForeground(new java.awt.Color(255, 255, 255));
        TeacherSubject1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TeacherSubject1.setText("Subject1");
        TeacherSubject1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TeacherSubject1.setFocusable(false);
        TeacherSubject1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TeacherSubject1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TeacherSubject1FocusLost(evt);
            }
        });
        jPanel3.add(TeacherSubject1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 380, 60));

        jLabel25.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(45, 68, 86));
        jLabel25.setText("Subject2");
        jPanel3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 150, 60, -1));

        TeacherSubject2.setBackground(new java.awt.Color(45, 68, 86));
        TeacherSubject2.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        TeacherSubject2.setForeground(new java.awt.Color(255, 255, 255));
        TeacherSubject2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TeacherSubject2.setText("Subject2");
        TeacherSubject2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TeacherSubject2.setFocusable(false);
        TeacherSubject2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TeacherSubject2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TeacherSubject2FocusLost(evt);
            }
        });
        jPanel3.add(TeacherSubject2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 170, 380, 60));

        jLabel26.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(45, 68, 86));
        jLabel26.setText("Subject3");
        jPanel3.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 150, 60, -1));

        TeacherSubject3.setBackground(new java.awt.Color(45, 68, 86));
        TeacherSubject3.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        TeacherSubject3.setForeground(new java.awt.Color(255, 255, 255));
        TeacherSubject3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TeacherSubject3.setText("Subject3");
        TeacherSubject3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TeacherSubject3.setFocusable(false);
        TeacherSubject3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TeacherSubject3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TeacherSubject3FocusLost(evt);
            }
        });
        TeacherSubject3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TeacherSubject3ActionPerformed(evt);
            }
        });
        jPanel3.add(TeacherSubject3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 170, 380, 60));

        TeacherUpdateInfo.setBackground(new java.awt.Color(70, 202, 255));
        TeacherUpdateInfo.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        TeacherUpdateInfo.setForeground(new java.awt.Color(255, 255, 255));
        TeacherUpdateInfo.setText("Update Info");
        TeacherUpdateInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TeacherUpdateInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TeacherUpdateInfoActionPerformed(evt);
            }
        });
        jPanel3.add(TeacherUpdateInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 470, 180, 60));

        TeacherReportStudent.setBackground(new java.awt.Color(255, 71, 71));
        TeacherReportStudent.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        TeacherReportStudent.setForeground(new java.awt.Color(255, 255, 255));
        TeacherReportStudent.setText("Report Student");
        TeacherReportStudent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TeacherReportStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TeacherReportStudentActionPerformed(evt);
            }
        });
        jPanel3.add(TeacherReportStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 470, 180, 60));

        jTabbedPane1.addTab("tab4", jPanel3);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-210, 190, 1580, 610));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void listTestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listTestsActionPerformed
        // TODO add your handling code here:

        jTabbedPane1.setSelectedIndex(2);


    }//GEN-LAST:event_listTestsActionPerformed

    private void goBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackButtonActionPerformed
        // TODO add your handling code here:

        setVisible(false);
        new TeacherLogin().setVisible(true);
    }//GEN-LAST:event_goBackButtonActionPerformed

    private void closeApplicationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeApplicationActionPerformed
        // TODO add your handling code here:
        ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
        int a = JOptionPane.showOptionDialog(null, "Are you Sure to Exit The Program?", "Exit!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, image, null, 0);
        if (a == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_closeApplicationActionPerformed

    private void addTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTestActionPerformed
        // TODO add your handling code here:

        jTabbedPane1.setSelectedIndex(0);

    }//GEN-LAST:event_addTestActionPerformed

    private void ProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProfileActionPerformed
        // TODO add your handling code here:

        jTabbedPane1.setSelectedIndex(3);

    }//GEN-LAST:event_ProfileActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        JFrame jf = new JFrame();
        jf.setAlwaysOnTop(true);
        ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
        int a = JOptionPane.showConfirmDialog(jf, "Are you Sure you want to log-out?", "Logout!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, image);
        if (a == 0) {
            setVisible(false);
            new MainApplication().setVisible(true);
        }

    }//GEN-LAST:event_logoutActionPerformed

    private void updateTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateTestActionPerformed
        // TODO add your handling code here:

        jTabbedPane1.setSelectedIndex(1);

    }//GEN-LAST:event_updateTestActionPerformed

    private void noOfQuestionsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_noOfQuestionsFocusGained
        // TODO add your handling code here:

        PlaceHolderOF(noOfQuestions, "Number of Questions");

    }//GEN-LAST:event_noOfQuestionsFocusGained

    private void noOfQuestionsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_noOfQuestionsFocusLost
        // TODO add your handling code here:

        PlaceHolderOFL(noOfQuestions, "Number of Questions");

    }//GEN-LAST:event_noOfQuestionsFocusLost

    private void testDurationFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_testDurationFocusGained
        // TODO add your handling code here:

        PlaceHolderOF(testDuration, "Time in Min.");

    }//GEN-LAST:event_testDurationFocusGained

    private void testDurationFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_testDurationFocusLost
        // TODO add your handling code here:

        PlaceHolderOFL(testDuration, "Time in Min.");

    }//GEN-LAST:event_testDurationFocusLost

    private void testNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_testNameFocusGained
        // TODO add your handling code here:

        PlaceHolderOF(testName, "TestName");

    }//GEN-LAST:event_testNameFocusGained

    private void testNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_testNameFocusLost
        // TODO add your handling code here:
        PlaceHolderOFL(testName, "TestName");

    }//GEN-LAST:event_testNameFocusLost

    private void addTestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTestButtonActionPerformed
        // TODO add your handling code here:

        if (LoggedIn()) {

            String testN = testName.getText().trim().equals("TestName") || testName.getText().trim().equals("") ? Subject.getSelectedItem().toString() : testName.getText();
            int testTime;
            int noOfQuestionsi;
            try {
                testTime = Integer.parseInt(testDuration.getText()) > 0 ? Integer.parseInt(testDuration.getText()) : 10;
                noOfQuestionsi = Integer.parseInt(noOfQuestions.getText()) > 0 && Integer.parseInt(noOfQuestions.getText()) <= 60 ? Integer.parseInt(noOfQuestions.getText()) : 10;

                try {
                    Connection connection = dbConnection.ConnectDB();
                    PreparedStatement pst = connection.prepareStatement("insert into Test(name,teacherID,noOfQuestions,time,subject) values(?,?,?,?,?)");
                    pst.setString(1, testN);
                    pst.setInt(2, Teacher.getID());
                    pst.setInt(3, noOfQuestionsi);
                    pst.setInt(4, testTime);
                    pst.setString(5, Subject.getSelectedItem().toString());
                    if (!Subject.getSelectedItem().toString().equals("NONE")) {
                        int k = pst.executeUpdate();
                        if (k == 1) {
                            addTestClearButton();
                            JOptionPane.showMessageDialog(this, "Test Addedd To add test Question go to Update test.");
                            TestTable();
                            listNumberOfQuestions.setText("0");

                        } else {
                            JOptionPane.showMessageDialog(this, "Failed to Add Test!", "Error", JOptionPane.ERROR_MESSAGE);
                            addTestClearButton();
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Failed to Add Test you must have Subjects first!", "Error", JOptionPane.ERROR_MESSAGE);

                    }

                } catch (SQLException ex) {
                    addTestClearButton();
                    JOptionPane.showMessageDialog(this, "Failed to Add Test!", "Error", JOptionPane.ERROR_MESSAGE);

                    Logger.getLogger(TeacherHome.class.getName()).log(Level.SEVERE, null, ex);
                }

            } catch (NumberFormatException e) {
                ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
                JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Wrong input please Enter Correct integar Number!</p></html>", "Try Again!", JOptionPane.INFORMATION_MESSAGE, image);
            }

        } else {
            String[] options = {"Login", "Exit"};
            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
            int a = JOptionPane.showOptionDialog(null, "To Add test you must Login as Teacher first?", "Login or Exit!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, image, options, 0);
            if (a == 0) {
                setVisible(false);
                new TeacherLogin().setVisible(true);
            } else if (a == 1) {
                System.exit(0);

            }
        }
        afterRefreshQuestionTable();

    }//GEN-LAST:event_addTestButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:

        addTestClearButton();

    }//GEN-LAST:event_clearButtonActionPerformed

    private void testIDSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testIDSearchActionPerformed
        // TODO add your handling code here:

        if (LoggedIn()) {
            try {
                test.setupdateTestID(Integer.parseInt(testID.getText()));
                Connection connection = dbConnection.ConnectDB();
                PreparedStatement pst;

                try {
                    pst = connection.prepareStatement("select * from Test where (teacherID = " + Teacher.getID() + " and ID = " + test.getupdateTestID() + ")");
                    ResultSet rs = pst.executeQuery();
                    if (rs.next()) {
                        test.setName(rs.getString(2));
                        test.setNumberOfQuestions(rs.getInt(4));
                        test.setTimeInMin(rs.getInt(5));
                        updateTestButtons(true);
                        newTestName.setText(test.getName());
                        newTestName.setForeground(Color.white);
                        newTimeDuration.setText(test.getTimeInMin() + "");
                        newTimeDuration.setForeground(Color.white);
                        newNoOfQuestions.setText(test.getNumberOfQuestions() + "");
                        newNoOfQuestions.setForeground(Color.white);
                        testID.setFocusable(false);
                    } else {
                        testID.setFocusable(true);
                        updateTestButtons(true);
                        updateTestClearButton();
                        ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
                        JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Test ID is NOT found!</p></html>", "Try Again!", JOptionPane.INFORMATION_MESSAGE, image);
                        updateTestButtons(false);

                    }

                } catch (SQLException ex) {
                    Logger.getLogger(TeacherHome.class.getName()).log(Level.SEVERE, null, ex);

                }
            } catch (NumberFormatException ex) {
                testID.setFocusable(true);
                updateTestButtons(false);

                ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
                JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Wrong input please Enter Correct integar Number!</p></html>", "Try Again!", JOptionPane.INFORMATION_MESSAGE, image);
            }

        }

    }//GEN-LAST:event_testIDSearchActionPerformed

    private void addQuestionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addQuestionButtonActionPerformed
        // TODO add your handling code here:

        if (LoggedIn()) {
            Connection connection = dbConnection.ConnectDB();
            PreparedStatement pst;
            int currentNumberOfQuestions = -1;
            try {

                pst = connection.prepareStatement("SELECT COUNT(testID) FROM Questions WHERE testID = ?;");
                pst.setString(1, test.getupdateTestID() + "");
                ResultSet rs = pst.executeQuery();
                rs.next();
                currentNumberOfQuestions = (rs.getInt(1));

            } catch (SQLException ex) {
                Logger.getLogger(TeacherHome.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (currentNumberOfQuestions != -1) {
                if (test.getNumberOfQuestions() > currentNumberOfQuestions) {
                    if (isMCQQuesion.isSelected()) {
                        String Question = addQuestion.getText().trim().length() > 4 && !(addQuestion.getText().equals("Question")) ? addQuestion.getText().trim() : null;
                        String ans1 = answer1.getText().trim().length() > 0 && answer1.getText().trim().length() < 255 ? answer1.getText() : null;
                        String ans2 = answer2.getText().trim().length() > 0 && answer2.getText().trim().length() < 255 ? answer2.getText() : null;
                        String ans3 = answer3.getText().trim().length() > 0 && answer3.getText().trim().length() < 255 ? answer3.getText() : null;
                        String ans4 = answer4.getText().trim().length() > 0 && answer4.getText().trim().length() < 255 ? answer4.getText() : null;
                        int ans = answer.getSelectedIndex();
                        if (Question == null || ans1 == null || ans2 == null || ans3 == null || ans4 == null) {
                            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
                            JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Wrong input please Question cant be less than 4<br> charcters and not more than 255 characters and<br>Answers can't be less than 1 character!</p></html>", "Try Again!", JOptionPane.INFORMATION_MESSAGE, image);
                        } else if (ans1.equals(ans2) || ans1.equals(ans3) || ans1.equals(ans4) || ans2.equals(ans3) || ans2.equals(ans4) || ans3.equals(ans4)) {

                            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
                            JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Wrong input The Answers can't be simmilar!</p></html>", "Try Again!", JOptionPane.INFORMATION_MESSAGE, image);

                        } else {
                            Question = Question.charAt(Question.length() - 1) == '?' ? Question : Question.concat("?");
                            try {
                                pst = connection.prepareStatement("insert into Questions(question,answer1,answer2,answer3,answer4,answer,testID) values(?,?,?,?,?,?,?)");
                                pst.setString(1, Question.substring(0, 1).toUpperCase() + Question.substring(1));
                                pst.setString(2, ans1.substring(0, 1).toUpperCase() + ans1.substring(1));
                                pst.setString(3, ans2.substring(0, 1).toUpperCase() + ans2.substring(1));
                                pst.setString(4, ans3.substring(0, 1).toUpperCase() + ans3.substring(1));
                                pst.setString(5, ans4.substring(0, 1).toUpperCase() + ans4.substring(1));

                                switch (ans) {
                                    case 0:
                                        pst.setString(6, "Answer 1");
                                        break;
                                    case 1:
                                        pst.setString(6, "Answer 2");
                                        break;
                                    case 2:
                                        pst.setString(6, "Answer 3");
                                        break;
                                    case 3:
                                        pst.setString(6, "Answer 4");
                                        break;
                                    default:
                                        throw new AssertionError();
                                }

                                pst.setInt(7, test.getupdateTestID());
                                int k = pst.executeUpdate();
                                if (k == 1) {
                                    questionsClearButton();
                                    ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (2).png"));
                                    JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Question added Successfully!</p></html>", "Done!", JOptionPane.INFORMATION_MESSAGE, image);
                                    TestTable();
                                    listNumberOfQuestions.setText("0");

                                } else {
                                    questionsClearButton();
                                    ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
                                    JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Failed to Add Question<br>Check the DB!</p></html>", "Error!", JOptionPane.INFORMATION_MESSAGE, image);

                                }

                            } catch (SQLException ex) {
                                Logger.getLogger(TeacherHome.class.getName()).log(Level.SEVERE, null, ex);

                            }

                        }
                    } else {
                        String Question = addQuestion.getText().trim().length() > 4 && !(addQuestion.getText().equals("Question")) ? addQuestion.getText().trim() : null;
//                        String ans1 = "null";
//                        String ans2 = "null";
//                        String ans3 = "null";
//                        String ans4 = "null";
                        String ans = answerTxtField.getText().trim().length() > 0 && answerTxtField.getText().trim().length() < 255 ? answerTxtField.getText() : null;
                        if (Question == null || ans == null) {
                            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
                            JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Wrong input Question cant be less than 4<br> charcters and not more than 255 characters and<br>Answer can't be less than 1 character!</p></html>", "Try Again!", JOptionPane.INFORMATION_MESSAGE, image);
                        } else {
                            Question = Question.charAt(Question.length() - 1) == '?' ? Question : Question.concat("?");
                            try {
                                pst = connection.prepareStatement("insert into Questions(question,answer1,answer2,answer3,answer4,answer,testID) values(?,?,?,?,?,?,?)");
                                pst.setString(1, Question.substring(0, 1).toUpperCase() + Question.substring(1));
                                pst.setNull(2, Types.NULL);
                                pst.setNull(3, Types.NULL);
                                pst.setNull(4, Types.NULL);
                                pst.setNull(5, Types.NULL);
                                pst.setString(6, ans);
                                pst.setInt(7, test.getupdateTestID());

                                int k = pst.executeUpdate();
                                if (k == 1) {
                                    questionsClearButton();
                                    ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (2).png"));
                                    JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Question added Successfully!</p></html>", "Done!", JOptionPane.INFORMATION_MESSAGE, image);
                                    TestTable();
                                    listNumberOfQuestions.setText("0");

                                } else {
                                    questionsClearButton();
                                    ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
                                    JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Failed to Add Question<br>Check the DB!</p></html>", "Error!", JOptionPane.INFORMATION_MESSAGE, image);

                                }

                            } catch (SQLException ex) {
                                Logger.getLogger(TeacherHome.class.getName()).log(Level.SEVERE, null, ex);

                            }

                        }
                    }
                } else {
                    ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
                    JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Failed to Add Question<br>you Excede the maximum number of questions!</p></html>", "Error!", JOptionPane.INFORMATION_MESSAGE, image);
                }
            } else {
                ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
                JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Failed to connect to the DataBase!</p></html>", "Bad Connection!", JOptionPane.INFORMATION_MESSAGE, image);

            }

        } else {
            String[] options = {"Login", "Exit"};
            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
            int a = JOptionPane.showOptionDialog(null, "To Add test you must Login as Teacher first?", "Login or Exit!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, image, options, 0);
            if (a == 0) {
                setVisible(false);
                new TeacherLogin().setVisible(true);
            } else if (a == 1) {
                System.exit(0);

            }
        }
        afterRefreshQuestionTable();


    }//GEN-LAST:event_addQuestionButtonActionPerformed

    private void testIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_testIDFocusLost
        // TODO add your handling code here:

        PlaceHolderOFL(testID, "Search Test ID");

    }//GEN-LAST:event_testIDFocusLost

    private void testIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_testIDFocusGained
        // TODO add your handling code here:

        PlaceHolderOF(testID, "Search Test ID");

    }//GEN-LAST:event_testIDFocusGained

    private void newTimeDurationFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newTimeDurationFocusLost
        // TODO add your handling code here:

        PlaceHolderOFL(newTimeDuration, "Time in Min.");

    }//GEN-LAST:event_newTimeDurationFocusLost

    private void newTimeDurationFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newTimeDurationFocusGained
        // TODO add your handling code here:

        PlaceHolderOF(newTimeDuration, "Time in Min.");

    }//GEN-LAST:event_newTimeDurationFocusGained

    private void newNoOfQuestionsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newNoOfQuestionsFocusLost
        // TODO add your handling code here:

        PlaceHolderOFL(newNoOfQuestions, "Number of Questions");

    }//GEN-LAST:event_newNoOfQuestionsFocusLost

    private void newNoOfQuestionsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newNoOfQuestionsFocusGained
        // TODO add your handling code here:

        PlaceHolderOF(newNoOfQuestions, "Number of Questions");

    }//GEN-LAST:event_newNoOfQuestionsFocusGained

    private void questionClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionClearButtonActionPerformed
        // TODO add your handling code here:

        questionsClearButton();

    }//GEN-LAST:event_questionClearButtonActionPerformed

    private void answer4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_answer4FocusGained
        // TODO add your handling code here:

        PlaceHolderOF(answer4, "answer4");

    }//GEN-LAST:event_answer4FocusGained

    private void answer4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_answer4FocusLost
        // TODO add your handling code here:

        PlaceHolderOFL(answer4, "answer4");

    }//GEN-LAST:event_answer4FocusLost

    private void answer1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_answer1FocusGained
        // TODO add your handling code here:

        PlaceHolderOF(answer1, "answer1");

    }//GEN-LAST:event_answer1FocusGained

    private void answer1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_answer1FocusLost
        // TODO add your handling code here:

        PlaceHolderOFL(answer1, "answer1");

    }//GEN-LAST:event_answer1FocusLost

    private void addQuestionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addQuestionFocusGained
        // TODO add your handling code here:

        PlaceHolderOF(addQuestion, "Question");

    }//GEN-LAST:event_addQuestionFocusGained

    private void addQuestionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addQuestionFocusLost
        // TODO add your handling code here:

        PlaceHolderOFL(addQuestion, "Question");

    }//GEN-LAST:event_addQuestionFocusLost

    private void updateClearBottonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateClearBottonActionPerformed
        // TODO add your handling code here:
        testID.setFocusable(true);
        updateTestButtons(true);

        updateTestClearButton();
        questionsClearButton();
        isMCQQuesion.setSelected(false);
        ComboBoxIsMCQ();
        answerTxtField.requestFocus();

        ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (2).png"));
        JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Clearing Done!</p></html>", "Done!", JOptionPane.INFORMATION_MESSAGE, image);

        updateTestButtons(false);

    }//GEN-LAST:event_updateClearBottonActionPerformed

    private void updateTestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateTestButtonActionPerformed
        // TODO add your handling code here:

        if (LoggedIn()) {
            int testTime;
            int noOfQuestionsi;
            String testName;

            try {
                testTime = (Integer.parseInt(newTimeDuration.getText()) > 0) ? Integer.parseInt(newTimeDuration.getText()) : -1;
                noOfQuestionsi = (Integer.parseInt(newNoOfQuestions.getText()) > 0 && Integer.parseInt(newNoOfQuestions.getText()) <= 60) ? Integer.parseInt(newNoOfQuestions.getText()) : -1;
                testName = newTestName.getText().trim();
                if (testTime == -1 || noOfQuestionsi == -1) {
                    ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
                    JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Wrong input! please make sure<br>that the NO. of Questions<br>is between [1,60]<br>and the test Duration is more than 0!</p></html>", "Try Again!", JOptionPane.INFORMATION_MESSAGE, image);
                } else {
                    try {
                        Connection connection = dbConnection.ConnectDB();
                        PreparedStatement pst;
                        pst = connection.prepareStatement("update Test set noOfQuestions = ?, time = ?,name = ? where id = ?");
                        pst.setInt(1, noOfQuestionsi);
                        pst.setInt(2, testTime);
                        pst.setString(3, testName);
                        pst.setInt(4, test.getupdateTestID());
                        int k = pst.executeUpdate();
                        if (k == 1) {
                            test.setNumberOfQuestions(noOfQuestionsi);
                            test.setTimeInMin(testTime);
                            test.setName(testName);
                            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (2).png"));
                            JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Test Updated Successfully!</p></html>", "Done!", JOptionPane.INFORMATION_MESSAGE, image);
                            TestTable();
                            listNumberOfQuestions.setText("0");

                        } else {
                            testID.setFocusable(true);
                            updateTestButtons(true);
                            updateTestClearButton();
                            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
                            JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Failed to Update test!</p></html>", "Error!", JOptionPane.INFORMATION_MESSAGE, image);
                            updateTestButtons(false);

                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(TeacherHome.class.getName()).log(Level.SEVERE, null, ex);

                    }
                }

            } catch (NumberFormatException ex) {
                ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
                JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Wrong input please Enter Correct integar Number!</p></html>", "Try Again!", JOptionPane.INFORMATION_MESSAGE, image);
            }
        } else {
            String[] options = {"Login", "Exit"};
            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
            int a = JOptionPane.showOptionDialog(null, "To Add test you must Login as Teacher first?", "Login or Exit!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, image, options, 0);
            if (a == 0) {
                setVisible(false);
                new TeacherLogin().setVisible(true);
            } else if (a == 1) {
                System.exit(0);

            }
        }
        afterRefreshQuestionTable();


    }//GEN-LAST:event_updateTestButtonActionPerformed

    private void answer2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_answer2FocusGained
        // TODO add your handling code here:

        PlaceHolderOF(answer2, "answer2");
    }//GEN-LAST:event_answer2FocusGained

    private void answer2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_answer2FocusLost
        // TODO add your handling code here:

        PlaceHolderOFL(answer2, "answer2");

    }//GEN-LAST:event_answer2FocusLost

    private void answer3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_answer3FocusGained
        // TODO add your handling code here:

        PlaceHolderOF(answer3, "answer3");

    }//GEN-LAST:event_answer3FocusGained

    private void answer3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_answer3FocusLost
        // TODO add your handling code here:

        PlaceHolderOFL(answer3, "answer3");

    }//GEN-LAST:event_answer3FocusLost

    private void answer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answer2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_answer2ActionPerformed

    private void newNoOfQuestionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newNoOfQuestionsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newNoOfQuestionsActionPerformed

    private void newTestNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newTestNameFocusGained
        // TODO add your handling code here:

        PlaceHolderOF(newTestName, "Test Name");

    }//GEN-LAST:event_newTestNameFocusGained

    private void newTestNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newTestNameFocusLost
        // TODO add your handling code here:

        PlaceHolderOFL(newTestName, "Test Name");

    }//GEN-LAST:event_newTestNameFocusLost

    private void newTestNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newTestNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newTestNameActionPerformed

    private void addQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addQuestionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addQuestionActionPerformed

    private void updateDeleteBottonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateDeleteBottonActionPerformed
        // TODO add your handling code here:

        if (LoggedIn()) {
            String[] options = {"Yes", "No"};

            ImageIcon imageExclamation = new ImageIcon(getClass().getResource("/Images/exclamation-mark.png"));
            int a = JOptionPane.showOptionDialog(this, "Are you sure that you want to delete this Exam?", "Delete Alert!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, imageExclamation, options, 0);
            if (a == 0) {
                try {

                    Connection connection = dbConnection.ConnectDB();
                    PreparedStatement pst;
                    pst = connection.prepareStatement("delete from Questions where testID = ? delete from Test where ID = ?");
                    pst.setInt(1, test.getupdateTestID());
                    pst.setInt(2, test.getupdateTestID());
                    int k = pst.executeUpdate();

                    if (k == 1) {

                        testID.setFocusable(true);
                        updateTestButtons(true);
                        testID.setText("");
                        newTestName.setText("Test Name");
                        newTestName.setForeground(new Color(153, 153, 153));
                        newTimeDuration.setText("Time in Min.");
                        newTimeDuration.setForeground(new Color(153, 153, 153));
                        newNoOfQuestions.setText("Number of Questions");
                        newNoOfQuestions.setForeground(new Color(153, 153, 153));
                        testID.requestFocus();

                        ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (2).png"));
                        JOptionPane.showMessageDialog(this, "<html><p style=\"text-align: center;\">Test Deleted Successfully!</p></html>", "Done!", JOptionPane.INFORMATION_MESSAGE, image);
                        updateTestButtons(false);
                        isMCQQuesion.setSelected(false);
                        ComboBoxIsMCQ();

                        TestTable();
                        listNumberOfQuestions.setText("0");

                    } else {
                        testID.setFocusable(true);
                        updateTestButtons(true);
                        updateTestClearButton();
                        ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
                        JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Failed to delete test!</p></html>", "Error!", JOptionPane.INFORMATION_MESSAGE, image);
                        updateTestButtons(false);

                    }

                } catch (SQLException ex) {
                    Logger.getLogger(TeacherHome.class.getName()).log(Level.SEVERE, null, ex);

                }
            }

        } else {
            String[] options = {"Login", "Exit"};
            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
            int a = JOptionPane.showOptionDialog(null, "To Add test you must Login as Teacher first?", "Login or Exit!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, image, options, 0);
            if (a == 0) {
                setVisible(false);
                new TeacherLogin().setVisible(true);
            } else if (a == 1) {
                System.exit(0);

            }
        }
        afterRefreshQuestionTable();
    }//GEN-LAST:event_updateDeleteBottonActionPerformed

    private void deleteQuestionFromTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteQuestionFromTableActionPerformed
        // TODO add your handling code here:

        if (LoggedIn()) {
            String[] options = {"Yes", "No"};

            ImageIcon imageExclamation = new ImageIcon(getClass().getResource("/Images/exclamation-mark.png"));
            int a = JOptionPane.showOptionDialog(this, "Are you sure that you want to delete this Question?", "Delete Alert!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, imageExclamation, options, 0);
            if (a == 0) {
                try {

                    Connection connection = dbConnection.ConnectDB();
                    PreparedStatement pst;
                    pst = connection.prepareStatement("delete from Questions where (testID = ? and ID = ?)");
                    pst.setInt(1, test.getListTestID());
                    pst.setInt(2, question.getQuestionID());

                    int k = pst.executeUpdate();

                    if (k == 1) {

                        ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (2).png"));
                        JOptionPane.showMessageDialog(this, "<html><p style=\"text-align: center;\">Question Deleted Successfully!</p></html>", "Done!", JOptionPane.INFORMATION_MESSAGE, image);
                        QuestionTable();
                        answerFromTable.setVisible(true);
                        answerFromTableTxt.setVisible(false);
                        answerFromTableTxt.setFocusable(false);
                        afterRefreshQuestionTable();

                    } else {

                        ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
                        JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Failed to delete Question!</p></html>", "Error!", JOptionPane.INFORMATION_MESSAGE, image);
                        QuestionTable();
                        afterRefreshQuestionTable();

                    }

                } catch (SQLException ex) {
                    Logger.getLogger(TeacherHome.class.getName()).log(Level.SEVERE, null, ex);

                }
            }

        } else {
            String[] options = {"Login", "Exit"};
            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
            int a = JOptionPane.showOptionDialog(null, "To Add test you must Login as Teacher first?", "Login or Exit!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, image, options, 0);
            if (a == 0) {
                setVisible(false);
                new TeacherLogin().setVisible(true);
            } else if (a == 1) {
                System.exit(0);

            }
        }


    }//GEN-LAST:event_deleteQuestionFromTableActionPerformed

    private void updateQuestionFromTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateQuestionFromTableActionPerformed
        // TODO add your handling code here:

        Connection connection = dbConnection.ConnectDB();
        PreparedStatement pst;
        if (!question.getIsMCQ()) {
            String Question = questionFromTable.getText().trim().length() > 4 && !(questionFromTable.getText().equals("Question")) ? questionFromTable.getText().trim() : null;
            String ans1 = answer1FromTable.getText().trim().length() > 0 && answer1FromTable.getText().trim().length() < 255 ? answer1FromTable.getText() : null;
            String ans2 = answer2FromTable.getText().trim().length() > 0 && answer2FromTable.getText().trim().length() < 255 ? answer2FromTable.getText() : null;
            String ans3 = answer3FromTable.getText().trim().length() > 0 && answer3FromTable.getText().trim().length() < 255 ? answer3FromTable.getText() : null;
            String ans4 = answer4FromTable.getText().trim().length() > 0 && answer4FromTable.getText().trim().length() < 255 ? answer4FromTable.getText() : null;
            int ans = answerFromTable.getSelectedIndex();
            if (Question == null || ans1 == null || ans2 == null || ans3 == null || ans4 == null) {
                ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
                JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Wrong input please Question cant be less than 4<br> charcters and not more than 255 characters and<br>Answers can't be less than 1 character!</p></html>", "Try Again!", JOptionPane.INFORMATION_MESSAGE, image);
            } else if (ans1.equals(ans2) || ans1.equals(ans3) || ans1.equals(ans4) || ans2.equals(ans3) || ans2.equals(ans4) || ans3.equals(ans4)) {

                ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
                JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Wrong input The Answers can't be simmilar!</p></html>", "Try Again!", JOptionPane.INFORMATION_MESSAGE, image);

            } else {
                Question = Question.charAt(Question.length() - 1) == '?' ? Question : Question.concat("?");
                try {
                    pst = connection.prepareStatement("update Questions set question = ?, answer1 = ?, answer2 = ?, answer3 = ?, answer4 = ?, answer = ? where ID = ?");
                    pst.setString(1, Question.substring(0, 1).toUpperCase() + Question.substring(1));
                    pst.setString(2, ans1.substring(0, 1).toUpperCase() + ans1.substring(1));
                    pst.setString(3, ans2.substring(0, 1).toUpperCase() + ans2.substring(1));
                    pst.setString(4, ans3.substring(0, 1).toUpperCase() + ans3.substring(1));
                    pst.setString(5, ans4.substring(0, 1).toUpperCase() + ans4.substring(1));

                    switch (ans) {
                        case 0:
                            pst.setString(6, "Answer 1");
                            break;
                        case 1:
                            pst.setString(6, "Answer 2");
                            break;
                        case 2:
                            pst.setString(6, "Answer 3");
                            break;
                        case 3:
                            pst.setString(6, "Answer 4");
                            break;
                        default:
                            throw new AssertionError();
                    }

                    pst.setInt(7, question.getQuestionID());
                    int k = pst.executeUpdate();
                    if (k == 1) {
                        questionsClearButton();
                        ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (2).png"));
                        JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Question Updated Successfully!</p></html>", "Done!", JOptionPane.INFORMATION_MESSAGE, image);
                        QuestionTable();

//                        TestTable();
//                        listNumberOfQuestions.setText("0");
//                        answerFromTable.setVisible(true);
//                        answerFromTableTxt.setVisible(false);
//                        answerFromTableTxt.setFocusable(false);
//                        afterRefreshQuestionTable();
                    } else {
                        questionsClearButton();
                        ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
                        JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Failed to Ubdate Question<br>Check the DB!</p></html>", "Error!", JOptionPane.INFORMATION_MESSAGE, image);

                    }

                } catch (SQLException ex) {
                    Logger.getLogger(TeacherHome.class.getName()).log(Level.SEVERE, null, ex);

                }

            }
        } else {
            String Question = questionFromTable.getText().trim().length() > 4 && !(questionFromTable.getText().equals("Question")) ? questionFromTable.getText().trim() : null;

            String ans = answerFromTableTxt.getText().trim().length() > 0 && answerFromTableTxt.getText().trim().length() < 255 ? answerFromTableTxt.getText() : null;
            if (Question == null || ans == null) {
                ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
                JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Wrong input Question cant be less than 4<br> charcters and not more than 255 characters and<br>Answer can't be less than 1 character!</p></html>", "Try Again!", JOptionPane.INFORMATION_MESSAGE, image);
            } else {
                Question = Question.charAt(Question.length() - 1) == '?' ? Question : Question.concat("?");
                try {
                    pst = connection.prepareStatement("update Questions set question = ?, answer = ? where ID = ?");
                    pst.setString(1, Question.substring(0, 1).toUpperCase() + Question.substring(1));
                    pst.setString(2, ans);
                    pst.setInt(3, question.getQuestionID());

                    int k = pst.executeUpdate();
                    if (k == 1) {
                        questionsClearButton();
                        ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (2).png"));
                        JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Question Updated Successfully!</p></html>", "Done!", JOptionPane.INFORMATION_MESSAGE, image);
                        QuestionTable();


                    } else {
                        questionsClearButton();
                        ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
                        JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Failed to Update Question<br>Check the DB!</p></html>", "Error!", JOptionPane.INFORMATION_MESSAGE, image);

                    }

                } catch (SQLException ex) {
                    Logger.getLogger(TeacherHome.class.getName()).log(Level.SEVERE, null, ex);

                }

            }
        }


    }//GEN-LAST:event_updateQuestionFromTableActionPerformed

    private void answer1FromTableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_answer1FromTableFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_answer1FromTableFocusGained

    private void answer1FromTableFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_answer1FromTableFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_answer1FromTableFocusLost

    private void answer2FromTableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_answer2FromTableFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_answer2FromTableFocusGained

    private void answer2FromTableFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_answer2FromTableFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_answer2FromTableFocusLost

    private void answer3FromTableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_answer3FromTableFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_answer3FromTableFocusGained

    private void answer3FromTableFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_answer3FromTableFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_answer3FromTableFocusLost

    private void answer4FromTableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_answer4FromTableFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_answer4FromTableFocusGained

    private void answer4FromTableFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_answer4FromTableFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_answer4FromTableFocusLost

    private void answer1FromTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answer1FromTableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_answer1FromTableActionPerformed

    private void questionFromTableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_questionFromTableFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_questionFromTableFocusGained

    private void questionFromTableFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_questionFromTableFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_questionFromTableFocusLost

    private void questionFromTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionFromTableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_questionFromTableActionPerformed

    private void answerTxtFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_answerTxtFieldFocusGained
        // TODO add your handling code here:

        PlaceHolderOF(answerTxtField, "answer");

    }//GEN-LAST:event_answerTxtFieldFocusGained

    private void answerTxtFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_answerTxtFieldFocusLost
        // TODO add your handling code here:

        PlaceHolderOFL(answerTxtField, "answer");


    }//GEN-LAST:event_answerTxtFieldFocusLost

    private void isMCQQuesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isMCQQuesionActionPerformed
        // TODO add your handling code here:

        ComboBoxIsMCQ();

    }//GEN-LAST:event_isMCQQuesionActionPerformed

    private void answerFromTableTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_answerFromTableTxtFocusGained
        // TODO add your handling code here:

        PlaceHolderOF(answerFromTableTxt, "answer");

    }//GEN-LAST:event_answerFromTableTxtFocusGained

    private void answerFromTableTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_answerFromTableTxtFocusLost
        // TODO add your handling code here:

        PlaceHolderOFL(answerFromTableTxt, "answer");


    }//GEN-LAST:event_answerFromTableTxtFocusLost

    private void TeacherIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TeacherIDFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_TeacherIDFocusGained

    private void TeacherIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TeacherIDFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_TeacherIDFocusLost

    private void TeacherNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TeacherNameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_TeacherNameFocusGained

    private void TeacherNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TeacherNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_TeacherNameFocusLost

    private void TeacherEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TeacherEmailFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_TeacherEmailFocusGained

    private void TeacherEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TeacherEmailFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_TeacherEmailFocusLost

    private void TeacherSubject1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TeacherSubject1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_TeacherSubject1FocusGained

    private void TeacherSubject1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TeacherSubject1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_TeacherSubject1FocusLost

    private void TeacherSubject2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TeacherSubject2FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_TeacherSubject2FocusGained

    private void TeacherSubject2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TeacherSubject2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_TeacherSubject2FocusLost

    private void TeacherSubject3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TeacherSubject3FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_TeacherSubject3FocusGained

    private void TeacherSubject3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TeacherSubject3FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_TeacherSubject3FocusLost

    private void TeacherSubject3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TeacherSubject3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TeacherSubject3ActionPerformed

    private void TeacherUpdateInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TeacherUpdateInfoActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new TeacherUpdateInfoPanal().setVisible(true);

    }//GEN-LAST:event_TeacherUpdateInfoActionPerformed

    private void TeacherReportStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TeacherReportStudentActionPerformed
        // TODO add your handling code here:

        setVisible(false);
        new TeacherReportStudent().setVisible(true);

    }//GEN-LAST:event_TeacherReportStudentActionPerformed

    private void TestTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TestTableMouseClicked
        // TODO add your handling code here:

        DefaultTableModel d1 = (DefaultTableModel) TestTable.getModel();
        int SelectIndex = TestTable.getSelectedRow();
        test.setListID(Integer.parseInt(d1.getValueAt(SelectIndex, 0).toString()));
        QuestionTable();
        afterRefreshQuestionTable();

    }//GEN-LAST:event_TestTableMouseClicked

    private void QuestionTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_QuestionTableMouseClicked
        // TODO add your handling code here:
        
                DefaultTableModel d1 = (DefaultTableModel) QuestionTable.getModel();
        int SelectIndex = QuestionTable.getSelectedRow();
        question.IsMCQ(d1.getValueAt(SelectIndex, 2) == null && d1.getValueAt(SelectIndex, 3) == null && d1.getValueAt(SelectIndex, 4) == null && d1.getValueAt(SelectIndex, 5) == null);
//        System.out.println(question.getIsMCQ());

        if (question.getIsMCQ()) {
            question.setQuestionID(Integer.parseInt(d1.getValueAt(SelectIndex, 0).toString()));
            question.setQuestion(d1.getValueAt(SelectIndex, 1).toString());
            question.setAnswer(d1.getValueAt(SelectIndex, 6).toString());

            if (SelectIndex != -1) {
                setFromTableField(true);
                setColorForFromTableField(Color.white);
                questionFromTable.setText(question.getQuestion());

                answer1FromTable.setText("answer");
                answer1FromTable.setEnabled(false);
                answer2FromTable.setText("answer");
                answer2FromTable.setEnabled(false);
                answer3FromTable.setText("answer");
                answer3FromTable.setEnabled(false);
                answer4FromTable.setText("answer");
                answer4FromTable.setEnabled(false);

                answerFromTable.setVisible(false);
                answerFromTableTxt.setVisible(true);
                answerFromTableTxt.setFocusable(true);
                answerFromTableTxt.setForeground(Color.white);

                answerFromTableTxt.setText(question.getAnswer());
            }

        } else {

            answerFromTable.setVisible(true);
            answerFromTableTxt.setVisible(false);
            answerFromTableTxt.setFocusable(false);
            question.setQuestionID(Integer.parseInt(d1.getValueAt(SelectIndex, 0).toString()));
            question.setQuestion(d1.getValueAt(SelectIndex, 1).toString());
            question.setAnswer1(d1.getValueAt(SelectIndex, 2).toString());
            question.setAnswer2(d1.getValueAt(SelectIndex, 3).toString());
            question.setAnswer3(d1.getValueAt(SelectIndex, 4).toString());
            question.setAnswer4(d1.getValueAt(SelectIndex, 5).toString());
            question.setAnswer(d1.getValueAt(SelectIndex, 6).toString());
            answer1FromTable.setEnabled(true);

            answer2FromTable.setEnabled(true);

            answer3FromTable.setEnabled(true);

            answer4FromTable.setEnabled(true);

//            System.out.println(d1.getValueAt(SelectIndex, 0).toString() + "   " + d1.getValueAt(SelectIndex, 1).toString() + "   " + d1.getValueAt(SelectIndex, 2).toString() + "   " + d1.getValueAt(SelectIndex, 3).toString() + "   " + d1.getValueAt(SelectIndex, 4).toString() + "   " + d1.getValueAt(SelectIndex, 5).toString() + "   " + "   " + d1.getValueAt(SelectIndex, 6).toString());
            if (SelectIndex != -1) {
                setFromTableField(true);
                setColorForFromTableField(Color.white);
                questionFromTable.setText(question.getQuestion());
                answer1FromTable.setText(question.getAnswer1());
                answer2FromTable.setText(question.getAnswer2());
                answer3FromTable.setText(question.getAnswer3());
                answer4FromTable.setText(question.getAnswer4());

                switch (question.getAnswer()) {
                    case "Answer 1":
                        answerFromTable.setSelectedIndex(0);
                        break;
                    case "Answer 2":
                        answerFromTable.setSelectedIndex(1);
                        break;
                    case "Answer 3":
                        answerFromTable.setSelectedIndex(2);
                        break;
                    case "Answer 4":
                        answerFromTable.setSelectedIndex(3);
                        break;
                    default:
                        break;
                }
            }

        }
        
    }//GEN-LAST:event_QuestionTableMouseClicked

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
            java.util.logging.Logger.getLogger(TeacherHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeacherHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeacherHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeacherHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if (LoggedIn()) {
                    new TeacherHome().setVisible(true);
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

    void addTestClearButton() {
        testName.setText("");
        noOfQuestions.setText("");
        testDuration.setText("");
        noOfQuestions.requestFocus();
        testDuration.requestFocus();
        testName.requestFocus();
        testName.setForeground(Color.white);
    }

    void questionsClearButton() {
        answer.setSelectedIndex(0);
        addQuestion.setText("");
        answer1.setText("");
        answer2.setText("");
        answer3.setText("");
        answer4.setText("");
        answerTxtField.setText("");
        answer1.requestFocus();
        answer2.requestFocus();
        answer3.requestFocus();
        answer4.requestFocus();
        answerTxtField.requestFocus();
        addQuestion.requestFocus();
        addQuestion.setForeground(Color.white);
    }

    void updateTestClearButton() {
        testID.setText("");
        newTestName.setText("");
        newTimeDuration.setText("");
        newNoOfQuestions.setText("");
        newTestName.requestFocus();
        newTimeDuration.requestFocus();
        newNoOfQuestions.requestFocus();
        testID.requestFocus();
        testID.setForeground(Color.white);
    }

    void PlaceHolderOF(JTextField textField, String s) {
        if (textField.getText().equals(s)) {
            textField.setText("");
            textField.setForeground(Color.white);
        }
    }

    void PlaceHolderOFL(JTextField textField, String s) {
        if (textField.getText().equals("")) {
            textField.setText(s);
            textField.setForeground(new Color(153, 153, 153));
        }
    }

    void updateTestButtons(boolean b) {
        updateClearBotton.setEnabled(b);
        updateDeleteBotton.setEnabled(b);
        updateTestButton.setEnabled(b);
        questionClearButton.setEnabled(b);
        addQuestionButton.setEnabled(b);
        addQuestion.setFocusable(b);
//        answer1.setFocusable(b);
//        answer2.setFocusable(b);
//        answer3.setFocusable(b);
//        answer4.setFocusable(b);
        answerTxtField.setFocusable(b);
        answer.setEnabled(b);
//        testID.setFocusable(b);
        newTestName.setFocusable(b);
        newTimeDuration.setFocusable(b);
        newNoOfQuestions.setFocusable(b);
        isMCQQuesion.setEnabled(b);

    }

    void setQuestionTableNoRow() {
        DefaultTableModel DF = (DefaultTableModel) QuestionTable.getModel();
        DF.setRowCount(0);
    }

    void setFromTableField(boolean b) {
        questionFromTable.setFocusable(b);
        answer1FromTable.setFocusable(b);
        answer2FromTable.setFocusable(b);
        answer3FromTable.setFocusable(b);
        answer4FromTable.setFocusable(b);
        answerFromTable.setEnabled(b);
        updateQuestionFromTable.setEnabled(b);
        deleteQuestionFromTable.setEnabled(b);
    }

    void setColorForFromTableField(Color c) {
        questionFromTable.setForeground(c);
        answer1FromTable.setForeground(c);
        answer2FromTable.setForeground(c);
        answer3FromTable.setForeground(c);
        answer4FromTable.setForeground(c);
    }

    void afterRefreshQuestionTable() {
        questionFromTable.setText("Question");
        answer1FromTable.setText("answer");
        answer2FromTable.setText("answer");
        answer3FromTable.setText("answer");
        answer4FromTable.setText("answer");
        answerFromTable.setSelectedIndex(0);
        setFromTableField(false);
        setColorForFromTableField(new Color(153, 153, 153));
    }

    void ComboBoxIsMCQ() {
        if (!isMCQQuesion.isSelected()) {
            answer1.setEnabled(false);
            answer2.setEnabled(false);
            answer3.setEnabled(false);
            answer4.setEnabled(false);
            answerTxtField.setFocusable(true);
            answerTxtField.setVisible(true);
            answer.setVisible(false);

        } else {
            answer1.setEnabled(true);
            answer2.setEnabled(true);
            answer3.setEnabled(true);
            answer4.setEnabled(true);
            answer1.setFocusable(true);
            answer2.setFocusable(true);
            answer3.setFocusable(true);
            answer4.setFocusable(true);
            answerTxtField.setVisible(false);
            answer.setVisible(true);

        }
    }

    void getTeacherAllSubjects() {

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
        TeacherSubject1.setText(subjects[0] == null ? "NONE" : subjects[0]);
        TeacherSubject2.setText(subjects[1] == null ? "NONE" : subjects[1]);
        TeacherSubject3.setText(subjects[2] == null ? "NONE" : subjects[2]);
        TeacherID.setText(Teacher.getID() + "");
        TeacherName.setText(Teacher.getName());
        TeacherID.setText(Teacher.getID() + "");
        TeacherEmail.setText(Teacher.getEmail());

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Profile;
    private CustomComponent.TableTextCenter QuestionTable;
    private javax.swing.JComboBox<String> Subject;
    private javax.swing.JTextField TeacherEmail;
    private javax.swing.JTextField TeacherID;
    private javax.swing.JTextField TeacherName;
    private javax.swing.JButton TeacherReportStudent;
    private javax.swing.JTextField TeacherSubject1;
    private javax.swing.JTextField TeacherSubject2;
    private javax.swing.JTextField TeacherSubject3;
    private javax.swing.JButton TeacherUpdateInfo;
    private CustomComponent.TableTextCenter TestTable;
    private javax.swing.JTextField addQuestion;
    private javax.swing.JButton addQuestionButton;
    private javax.swing.JButton addTest;
    private javax.swing.JButton addTestButton;
    private javax.swing.JComboBox<String> answer;
    private javax.swing.JTextField answer1;
    private javax.swing.JTextField answer1FromTable;
    private javax.swing.JTextField answer2;
    private javax.swing.JTextField answer2FromTable;
    private javax.swing.JTextField answer3;
    private javax.swing.JTextField answer3FromTable;
    private javax.swing.JTextField answer4;
    private javax.swing.JTextField answer4FromTable;
    private javax.swing.JComboBox<String> answerFromTable;
    private javax.swing.JTextField answerFromTableTxt;
    private javax.swing.JTextField answerTxtField;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton closeApplication;
    private javax.swing.JButton deleteQuestionFromTable;
    private javax.swing.JButton goBackButton;
    private javax.swing.JCheckBox isMCQQuesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel listNumberOfQuestions;
    private javax.swing.JButton listTests;
    private javax.swing.JButton logout;
    private javax.swing.JTextField newNoOfQuestions;
    private javax.swing.JTextField newTestName;
    private javax.swing.JTextField newTimeDuration;
    private javax.swing.JTextField noOfQuestions;
    private javax.swing.JButton questionClearButton;
    private javax.swing.JTextField questionFromTable;
    private javax.swing.JLabel questionTable;
    private javax.swing.JTextField testDuration;
    private javax.swing.JTextField testID;
    private javax.swing.JButton testIDSearch;
    private javax.swing.JTextField testName;
    private javax.swing.JLabel testTable;
    private javax.swing.JButton updateClearBotton;
    private javax.swing.JButton updateDeleteBotton;
    private javax.swing.JButton updateQuestionFromTable;
    private javax.swing.JButton updateTest;
    private javax.swing.JButton updateTestButton;
    // End of variables declaration//GEN-END:variables
}
