package GUI;

import ProjectApplication.DbConnection;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import UsersClasses.Student;
import UsersClasses.StudentTest;
import java.awt.Color;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;

public class StudentHome extends javax.swing.JFrame {

    DbConnection dbConnection = new DbConnection();
    StudentTest studentTest = new StudentTest();

public StudentHome() {

        initComponents();
        getContentPane().setBackground(Color.white);                                                 // set new background color
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 15, 15));
        addWindowListener(new WindowAdapter() {                                                        // make auto focus on username field
            @Override
            public void windowOpened(WindowEvent e) {
                if (loggedIn()) {
                    jLabel2.setText("Welcome " + Student.getName());
                } else {
                    jLabel2.setText("Student");
                }
                getStudentAllSubjects();
                getAllDoneTests();
            }
        });
    }
    

    public void TestTable(String subject) {

        try {
            Connection connection = dbConnection.getConnection();

            PreparedStatement pst;
            pst = connection.prepareStatement("select count(Questions.testID) as Number_of_Questions,Test.[name] as 'Test Name',Test.[subject],Test.noOfQuestions,Test.[time],Teacher.[name] as 'Teacher Name',Test.ID\n"
                    + "from Test \n"
                    + "Inner join Teacher\n"
                    + "on Teacher.ID = Test.teacherID \n"
                    + "inner join Questions\n"
                    + "on Questions.testID = Test.ID\n"
                    + "group by Test.ID,Test.[name],test.noOfQuestions,Test.[subject],Test.[time],Teacher.[name]\n"
                    + "having (Test.[subject] = '" + Subjects.getSelectedItem().toString() + "' and count(Questions.testID) = Test.noOfQuestions)");

            ResultSet rs = pst.executeQuery();
            ResultSetMetaData RSM = rs.getMetaData();

            int c;
            c = RSM.getColumnCount();

            DefaultTableModel DF = (DefaultTableModel) studentTestTable.getModel();
            DF.setRowCount(0);
            String[] colName = new String[c];
            for (int i = 0; i < c; i++) {
                colName[i] = RSM.getColumnName(i + 1);
            }
            DF.setColumnIdentifiers(colName);

            Object[] rows;
            while (rs.next()) {
                PreparedStatement pst1;
                pst1 = connection.prepareStatement("select * from StudentsTestOnce Where (testID = " + rs.getString(7) + " and studentID = " + Student.getID() + " )");
                ResultSet rs1 = pst1.executeQuery();
                if (!rs1.next()) {

                    DF.addRow(rows = new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)});
                }
            }

            studentTestTable.getColumnModel().getColumn(6).setMinWidth(0);
            studentTestTable.getColumnModel().getColumn(6).setMaxWidth(0);
            studentTestTable.getColumnModel().getColumn(0).setMinWidth(0);
            studentTestTable.getColumnModel().getColumn(0).setMaxWidth(0);

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(TeacherHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        studentProfile = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        studentTestDone = new javax.swing.JButton();
        goBackButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        studentInbox = new javax.swing.JButton();
        studentTests = new javax.swing.JButton();
        closeApplication = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        Subjects = new javax.swing.JComboBox<>();
        testIDSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentTestTable = new javax.swing.JTable();
        studentEnterTestButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        studentDoneTestTable = new javax.swing.JTable();
        showDoneTestButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        studentID = new CustomComponent.ReadField(50);
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        studentSubject1 = new CustomComponent.ReadField(50);
        studentName = new CustomComponent.ReadField(50);
        jLabel3 = new javax.swing.JLabel();
        studentSubject2 = new CustomComponent.ReadField(50);
        jLabel25 = new javax.swing.JLabel();
        studentSubject3 = new CustomComponent.ReadField(50);
        jLabel26 = new javax.swing.JLabel();
        studentEmail = new CustomComponent.ReadField(50);
        jLabel5 = new javax.swing.JLabel();
        studentUpdateInfo = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        studentAge = new CustomComponent.ReadField(50);
        studentPhoneNumber = new CustomComponent.ReadField(50);
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1366, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        studentProfile.setBackground(new java.awt.Color(70, 202, 255));
        studentProfile.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        studentProfile.setForeground(new java.awt.Color(255, 255, 255));
        studentProfile.setText("Profile");
        studentProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        studentProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentProfileActionPerformed(evt);
            }
        });
        getContentPane().add(studentProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 160, 178, 50));

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
        getContentPane().add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 160, 178, 50));

        studentTestDone.setBackground(new java.awt.Color(70, 202, 255));
        studentTestDone.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        studentTestDone.setForeground(new java.awt.Color(255, 255, 255));
        studentTestDone.setText("Tests Done");
        studentTestDone.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        studentTestDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentTestDoneActionPerformed(evt);
            }
        });
        getContentPane().add(studentTestDone, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 178, 50));

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

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/student (1)_1.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 30, 52, -1));

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

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, -1, -1));

        jLabel2.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(45, 68, 86));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Student");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, 324, -1));

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

        getContentPane().add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 70, -1, -1));

        studentInbox.setBackground(new java.awt.Color(70, 202, 255));
        studentInbox.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        studentInbox.setForeground(new java.awt.Color(255, 255, 255));
        studentInbox.setText("Inbox");
        studentInbox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        studentInbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentInboxActionPerformed(evt);
            }
        });
        getContentPane().add(studentInbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 160, 178, 50));

        studentTests.setBackground(new java.awt.Color(70, 202, 255));
        studentTests.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        studentTests.setForeground(new java.awt.Color(255, 255, 255));
        studentTests.setText("Tests");
        studentTests.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        studentTests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentTestsActionPerformed(evt);
            }
        });
        getContentPane().add(studentTests, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 178, 50));

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
        getContentPane().add(closeApplication, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 20, -1, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Subjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubjectsActionPerformed(evt);
            }
        });
        jPanel1.add(Subjects, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 250, 70));

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
        jPanel1.add(testIDSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 50, 100, 50));

        studentTestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        studentTestTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                studentTestTableFocusLost(evt);
            }
        });
        studentTestTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentTestTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(studentTestTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 40, 760, 450));

        studentEnterTestButton.setBackground(new java.awt.Color(70, 202, 255));
        studentEnterTestButton.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        studentEnterTestButton.setForeground(new java.awt.Color(255, 255, 255));
        studentEnterTestButton.setText("Enter Test");
        studentEnterTestButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        studentEnterTestButton.setEnabled(false);
        studentEnterTestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentEnterTestButtonActionPerformed(evt);
            }
        });
        jPanel1.add(studentEnterTestButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 430, 370, 60));

        jTabbedPane1.addTab("tab1", jPanel1);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        studentDoneTestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        studentDoneTestTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                studentDoneTestTableFocusLost(evt);
            }
        });
        studentDoneTestTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentDoneTestTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(studentDoneTestTable);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 760, 450));

        showDoneTestButton.setBackground(new java.awt.Color(70, 202, 255));
        showDoneTestButton.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        showDoneTestButton.setForeground(new java.awt.Color(255, 255, 255));
        showDoneTestButton.setText("Show Test");
        showDoneTestButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        showDoneTestButton.setEnabled(false);
        showDoneTestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showDoneTestButtonActionPerformed(evt);
            }
        });
        jPanel3.add(showDoneTestButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 490, 370, 60));

        jTabbedPane1.addTab("tab2", jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1620, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 579, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab3", jPanel4);

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        studentID.setBackground(new java.awt.Color(45, 68, 86));
        studentID.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        studentID.setForeground(new java.awt.Color(255, 255, 255));
        studentID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        studentID.setText("StudentID");
        studentID.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        studentID.setFocusable(false);
        studentID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                studentIDFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                studentIDFocusLost(evt);
            }
        });
        jPanel6.add(studentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 380, 60));

        jLabel1.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(45, 68, 86));
        jLabel1.setText("Age");
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, -1, -1));

        jLabel13.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(45, 68, 86));
        jLabel13.setText("Subject1");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 150, -1, -1));

        studentSubject1.setBackground(new java.awt.Color(45, 68, 86));
        studentSubject1.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        studentSubject1.setForeground(new java.awt.Color(255, 255, 255));
        studentSubject1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        studentSubject1.setText("Subject1");
        studentSubject1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        studentSubject1.setFocusable(false);
        studentSubject1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                studentSubject1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                studentSubject1FocusLost(evt);
            }
        });
        jPanel6.add(studentSubject1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 170, 380, 60));

        studentName.setBackground(new java.awt.Color(45, 68, 86));
        studentName.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        studentName.setForeground(new java.awt.Color(255, 255, 255));
        studentName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        studentName.setText("Name");
        studentName.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        studentName.setFocusable(false);
        studentName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                studentNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                studentNameFocusLost(evt);
            }
        });
        jPanel6.add(studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 80, 380, 60));

        jLabel3.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(45, 68, 86));
        jLabel3.setText("Name");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 60, 50, -1));

        studentSubject2.setBackground(new java.awt.Color(45, 68, 86));
        studentSubject2.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        studentSubject2.setForeground(new java.awt.Color(255, 255, 255));
        studentSubject2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        studentSubject2.setText("Subject2");
        studentSubject2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        studentSubject2.setFocusable(false);
        studentSubject2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                studentSubject2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                studentSubject2FocusLost(evt);
            }
        });
        jPanel6.add(studentSubject2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 380, 60));

        jLabel25.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(45, 68, 86));
        jLabel25.setText("Subject2");
        jPanel6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 60, -1));

        studentSubject3.setBackground(new java.awt.Color(45, 68, 86));
        studentSubject3.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        studentSubject3.setForeground(new java.awt.Color(255, 255, 255));
        studentSubject3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        studentSubject3.setText("Subject3");
        studentSubject3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        studentSubject3.setFocusable(false);
        studentSubject3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                studentSubject3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                studentSubject3FocusLost(evt);
            }
        });
        studentSubject3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentSubject3ActionPerformed(evt);
            }
        });
        jPanel6.add(studentSubject3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 260, 380, 60));

        jLabel26.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(45, 68, 86));
        jLabel26.setText("Subject3");
        jPanel6.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 240, 60, -1));

        studentEmail.setBackground(new java.awt.Color(45, 68, 86));
        studentEmail.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        studentEmail.setForeground(new java.awt.Color(255, 255, 255));
        studentEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        studentEmail.setText("Email");
        studentEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        studentEmail.setFocusable(false);
        studentEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                studentEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                studentEmailFocusLost(evt);
            }
        });
        jPanel6.add(studentEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 80, 380, 60));

        jLabel5.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(45, 68, 86));
        jLabel5.setText("Email");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 60, 40, -1));

        studentUpdateInfo.setBackground(new java.awt.Color(70, 202, 255));
        studentUpdateInfo.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        studentUpdateInfo.setForeground(new java.awt.Color(255, 255, 255));
        studentUpdateInfo.setText("Update Info");
        studentUpdateInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        studentUpdateInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentUpdateInfoActionPerformed(evt);
            }
        });
        jPanel6.add(studentUpdateInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 470, 180, 60));

        jLabel6.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(45, 68, 86));
        jLabel6.setText("ID");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, -1, -1));

        studentAge.setBackground(new java.awt.Color(45, 68, 86));
        studentAge.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        studentAge.setForeground(new java.awt.Color(255, 255, 255));
        studentAge.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        studentAge.setText("Age");
        studentAge.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        studentAge.setFocusable(false);
        studentAge.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                studentAgeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                studentAgeFocusLost(evt);
            }
        });
        jPanel6.add(studentAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 380, 60));

        studentPhoneNumber.setBackground(new java.awt.Color(45, 68, 86));
        studentPhoneNumber.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        studentPhoneNumber.setForeground(new java.awt.Color(255, 255, 255));
        studentPhoneNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        studentPhoneNumber.setText("PhoneNumber");
        studentPhoneNumber.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        studentPhoneNumber.setFocusable(false);
        studentPhoneNumber.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                studentPhoneNumberFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                studentPhoneNumberFocusLost(evt);
            }
        });
        jPanel6.add(studentPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 170, 380, 60));

        jLabel7.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(45, 68, 86));
        jLabel7.setText("Phone Number");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 150, -1, -1));

        jTabbedPane1.addTab("tab4", jPanel6);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-250, 190, 1620, 610));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void studentProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentProfileActionPerformed
        // TODO add your handling code here:

        jTabbedPane1.setSelectedIndex(3);
        setStudentTestTableNoRow();
        disableButton();


    }//GEN-LAST:event_studentProfileActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        setStudentTestTableNoRow();

        ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
        int a = JOptionPane.showConfirmDialog(this, "Are you Sure you want to log-out?", "Logout!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, image);
        if (a == 0) {
            setVisible(false);
            new MainApplication().setVisible(true);
        }


    }//GEN-LAST:event_logoutActionPerformed

    private void studentTestDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentTestDoneActionPerformed
        // TODO add your handling code here:

        jTabbedPane1.setSelectedIndex(1);
        setStudentTestTableNoRow();
//                disableButton();


    }//GEN-LAST:event_studentTestDoneActionPerformed

    private void goBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackButtonActionPerformed
        // TODO add your handling code here:

        setVisible(false);
        new StudentLogin().setVisible(true);
    }//GEN-LAST:event_goBackButtonActionPerformed

    private void studentInboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentInboxActionPerformed
        // TODO add your handling code here:

        jTabbedPane1.setSelectedIndex(2);
        setStudentTestTableNoRow();
        disableButton();


    }//GEN-LAST:event_studentInboxActionPerformed

    private void studentTestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentTestsActionPerformed
        // TODO add your handling code here:

        jTabbedPane1.setSelectedIndex(0);
        disableButton();

    }//GEN-LAST:event_studentTestsActionPerformed

    private void closeApplicationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeApplicationActionPerformed
        // TODO add your handling code here:
        ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
        int a = JOptionPane.showOptionDialog(null, "Are you Sure to Exit The Program?", "Exit!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, image, null, 0);
        if (a == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_closeApplicationActionPerformed

    private void studentIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentIDFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_studentIDFocusGained

    private void studentIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentIDFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_studentIDFocusLost

    private void studentSubject1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentSubject1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_studentSubject1FocusGained

    private void studentSubject1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentSubject1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_studentSubject1FocusLost

    private void studentNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentNameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_studentNameFocusGained

    private void studentNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_studentNameFocusLost

    private void studentSubject2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentSubject2FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_studentSubject2FocusGained

    private void studentSubject2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentSubject2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_studentSubject2FocusLost

    private void studentSubject3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentSubject3FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_studentSubject3FocusGained

    private void studentSubject3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentSubject3FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_studentSubject3FocusLost

    private void studentSubject3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentSubject3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentSubject3ActionPerformed

    private void studentEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentEmailFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_studentEmailFocusGained

    private void studentEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentEmailFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_studentEmailFocusLost

    private void studentUpdateInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentUpdateInfoActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new StudentUpdateInfoPanal().setVisible(true);
    }//GEN-LAST:event_studentUpdateInfoActionPerformed

    private void studentAgeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentAgeFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_studentAgeFocusGained

    private void studentAgeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentAgeFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_studentAgeFocusLost

    private void studentPhoneNumberFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentPhoneNumberFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_studentPhoneNumberFocusGained

    private void studentPhoneNumberFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentPhoneNumberFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_studentPhoneNumberFocusLost

    private void testIDSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testIDSearchActionPerformed
        // TODO add your handling code here:

        if (loggedIn()) {
            TestTable(Subjects.getSelectedItem().toString());
        }


    }//GEN-LAST:event_testIDSearchActionPerformed

    private void studentTestTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentTestTableMouseClicked
        // TODO add your handling code here:

        DefaultTableModel d1 = (DefaultTableModel) studentTestTable.getModel();
        int SelectIndex = studentTestTable.getSelectedRow();
        studentTest.setTestID(Integer.parseInt(d1.getValueAt(SelectIndex, 6).toString()));
        studentTest.setTestName(d1.getValueAt(SelectIndex, 1).toString());
        studentTest.setTestTime(Integer.parseInt(d1.getValueAt(SelectIndex, 4).toString()));
        studentTest.setTestMark(Integer.parseInt(d1.getValueAt(SelectIndex, 3).toString()));
        try {
            Connection connection = dbConnection.getConnection();
            PreparedStatement pst;
            pst = connection.prepareStatement("select * from StudentsTestOnce Where (testID = " + studentTest.getTestID() + " and studentID = " + Student.getID() + " )");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                studentEnterTestButton.setEnabled(false);
            } else {
                studentEnterTestButton.setEnabled(true);

            }

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(TeacherHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_studentTestTableMouseClicked

    private void studentEnterTestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentEnterTestButtonActionPerformed
        // TODO add your handling code here:
        ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (2).png"));
        int a = JOptionPane.showOptionDialog(null, "The test is " + studentTest.getTestTime() + " Minutes\n are you sure you want to Enter the test?", "Warning!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, 0);
        if (a == 0) {
            setVisible(false);
            new StudentTestForm().setVisible(true);
        }


    }//GEN-LAST:event_studentEnterTestButtonActionPerformed

    private void studentTestTableFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentTestTableFocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_studentTestTableFocusLost

    private void SubjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubjectsActionPerformed
        // TODO add your handling code here:

        setStudentTestTableNoRow();

    }//GEN-LAST:event_SubjectsActionPerformed

    private void studentDoneTestTableFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentDoneTestTableFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_studentDoneTestTableFocusLost

    private void studentDoneTestTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentDoneTestTableMouseClicked
        // TODO add your handling code here:

        DefaultTableModel d1 = (DefaultTableModel) studentDoneTestTable.getModel();
        int SelectIndex = studentDoneTestTable.getSelectedRow();
        StudentTest.setTestID(Integer.parseInt(d1.getValueAt(SelectIndex, 0).toString()));
        StudentTest.setTestName(d1.getValueAt(SelectIndex, 1).toString());
        StudentTest.setTestTime(Integer.parseInt(d1.getValueAt(SelectIndex, 3).toString()));
        StudentTest.setStudentMark(Integer.parseInt(d1.getValueAt(SelectIndex, 6).toString()));
        StudentTest.setTestMark(Integer.parseInt(d1.getValueAt(SelectIndex, 2).toString()));
        showDoneTestButton.setEnabled(true);

    }//GEN-LAST:event_studentDoneTestTableMouseClicked

    private void showDoneTestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showDoneTestButtonActionPerformed
        // TODO add your handling code here:

        setVisible(false);
        new ShowCorrectedTest().setVisible(true);

    }//GEN-LAST:event_showDoneTestButtonActionPerformed

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
            java.util.logging.Logger.getLogger(StudentHome.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentHome.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentHome.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentHome.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if (loggedIn()) {
                    new StudentHome().setVisible(true);
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

    void getStudentAllSubjects() {

        String[] subjects = {Student.getSubject1(), Student.getSubject2(), Student.getSubject3()};
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

        Subjects.setModel(new javax.swing.DefaultComboBoxModel(rows));
        studentSubject1.setText(subjects[0] == null ? "NONE" : subjects[0]);
        studentSubject2.setText(subjects[1] == null ? "NONE" : subjects[1]);
        studentSubject3.setText(subjects[2] == null ? "NONE" : subjects[2]);
        studentID.setText(Student.getID() + "");
        studentName.setText(Student.getName());
        studentID.setText(Student.getID() + "");
        studentEmail.setText(Student.getEmail());
        studentAge.setText(Student.getAge() + "");
        studentPhoneNumber.setText(Student.getPhoneNumber() + "");

    }

    void setStudentTestTableNoRow() {
        DefaultTableModel DF = (DefaultTableModel) studentTestTable.getModel();
        DF.setRowCount(0);
        studentEnterTestButton.setEnabled(false);
    }

    void getAllDoneTests() {

        Connection connection = dbConnection.getConnection();
        PreparedStatement pst;
        try {
            pst = connection.prepareStatement("select Test.ID,Test.[name] as Test_Name,Test.noOfQuestions,Test.[time],Test.[subject],Teacher.[name] as Teacher_Name,StudentsTestOnce.degree\n"
                    + "from Test\n"
                    + "INNER JOIN StudentsTestOnce\n"
                    + "on Test.ID = StudentsTestOnce.testID\n"
                    + "INNER JOIN Teacher\n"
                    + "on Teacher.ID = Test.teacherID\n"
                    + " Where studentID = " + Student.getID());

            ResultSet rs = pst.executeQuery();
            ResultSetMetaData RSM = rs.getMetaData();
            int c;
            c = RSM.getColumnCount();
            DefaultTableModel DF = (DefaultTableModel) studentDoneTestTable.getModel();
            DF.setRowCount(0);
            String[] colName = new String[c];
            for (int i = 0; i < c; i++) {
                colName[i] = RSM.getColumnName(i + 1);
            }
            DF.setColumnIdentifiers(colName);

            Object[] rows;
            while (rs.next()) {
                DF.addRow(rows = new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)});

            }

            studentDoneTestTable.getColumnModel().getColumn(0).setMinWidth(0);
            studentDoneTestTable.getColumnModel().getColumn(0).setMaxWidth(0);

        } catch (SQLException ex) {
            Logger.getLogger(StudentHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void disableButton() {
        showDoneTestButton.setEnabled(false);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Subjects;
    private javax.swing.JButton closeApplication;
    private javax.swing.JButton goBackButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton logout;
    private javax.swing.JButton showDoneTestButton;
    private javax.swing.JTextField studentAge;
    private javax.swing.JTable studentDoneTestTable;
    private javax.swing.JTextField studentEmail;
    private javax.swing.JButton studentEnterTestButton;
    private javax.swing.JTextField studentID;
    private javax.swing.JButton studentInbox;
    private javax.swing.JTextField studentName;
    private javax.swing.JTextField studentPhoneNumber;
    private javax.swing.JButton studentProfile;
    private javax.swing.JTextField studentSubject1;
    private javax.swing.JTextField studentSubject2;
    private javax.swing.JTextField studentSubject3;
    private javax.swing.JButton studentTestDone;
    private javax.swing.JTable studentTestTable;
    private javax.swing.JButton studentTests;
    private javax.swing.JButton studentUpdateInfo;
    private javax.swing.JButton testIDSearch;
    // End of variables declaration//GEN-END:variables
}
