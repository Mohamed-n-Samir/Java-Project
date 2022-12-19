package GUI;

import CustomComponent.PasswordField;
import java.awt.Color;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import CustomComponent.RoundedJTextFieldTest;
import ProjectApplication.DbConnection;
import UsersClasses.Admin;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import UsersClasses.Student;
import UsersClasses.Teacher;

public class AdminHome extends javax.swing.JFrame {

    DbConnection dbConnection = new DbConnection();
    String subjectCode1;
    String subjectName1;

    public AdminHome() {
        initComponents();
        getContentPane().setBackground(Color.white);                                               // set new background color
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 15, 15)); // make rounded corners

        addWindowListener(new WindowAdapter() {                                                        // make auto focus on username field
            @Override
            public void windowOpened(WindowEvent e) {
                teacherEnabled(false);
                getAllSubs();
                studentEnabled(false);
                subjectEnabled(false);
                updateSubject.setEnabled(false);
                deleteSubject.setEnabled(false);

                if (isLoggedIn()) {
                    jLabel2.setText("Welcome " + Admin.getName());
                    adminUserName.setText(Admin.getUserName());
                    adminName.setText(Admin.getName());
                } else {
                    jLabel2.setText("Admin");
                }
                StudentTable();
                TeacherTable();
                SubjectTable();

            }
        });

    }

    public void StudentTable() {
        try {
            Connection connection = dbConnection.getConnection();

            PreparedStatement pst;
            pst = connection.prepareStatement("select * from Students");

            ResultSet rs = pst.executeQuery();
            ResultSetMetaData RSM = rs.getMetaData();

            int c;
            c = RSM.getColumnCount();

            DefaultTableModel DF = (DefaultTableModel) studentTable.getModel();
            DF.setRowCount(0);
            String[] colName = new String[c];
            for (int i = 0; i < c; i++) {
                colName[i] = RSM.getColumnName(i + 1);
            }
            DF.setColumnIdentifiers(colName);

            Object[] rows;
            while (rs.next()) {

                DF.addRow(rows = new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)});

            }
            studentTable.fixTable(jScrollPane1);

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

    public void TeacherTable() {
        try {
            Connection connection = dbConnection.getConnection();

            PreparedStatement pst;
            pst = connection.prepareStatement("select * from Teacher");

            ResultSet rs = pst.executeQuery();
            ResultSetMetaData RSM = rs.getMetaData();

            int c;
            c = RSM.getColumnCount();

            DefaultTableModel DF = (DefaultTableModel) teacherTable.getModel();
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
            studentTable.fixTable(jScrollPane2);

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(TeacherHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

    public void SubjectTable() {
        try {
            Connection connection = dbConnection.getConnection();

            PreparedStatement pst;
            pst = connection.prepareStatement("select * from Subject");

            ResultSet rs = pst.executeQuery();
            ResultSetMetaData RSM = rs.getMetaData();

            int c;
            c = RSM.getColumnCount();

            DefaultTableModel DF = (DefaultTableModel) subjectTable.getModel();
            DF.setRowCount(0);
            String[] colName = new String[c];
            for (int i = 0; i < c; i++) {
                colName[i] = RSM.getColumnName(i + 1);
            }
            DF.setColumnIdentifiers(colName);

            Object[] rows;
            while (rs.next()) {

                DF.addRow(rows = new Object[]{rs.getString(1), rs.getString(2)});

            }
            subjectTable.fixTable(jScrollPane3);

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(TeacherHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        goBackButton = new javax.swing.JButton();
        closeApplication = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        alterSubjects = new javax.swing.JButton();
        alterStudents = new javax.swing.JButton();
        profile = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        alterTeacher = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentTable = new CustomComponent.TableTextCenter();
        jTextField1 = new RoundedJTextFieldTest(500);
        jLabel1 = new javax.swing.JLabel();
        UpdateName = new RoundedJTextFieldTest(50);
        UpdatepwdTeacherRewrite = new PasswordField(50);
        UpdateEmail = new RoundedJTextFieldTest(50);
        updatePhoneNumber = new RoundedJTextFieldTest(50);
        jLabel35 = new javax.swing.JLabel();
        UpdateSubject1 = new javax.swing.JComboBox<>();
        UpdateSubject2 = new javax.swing.JComboBox<>();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        UpdateSubject3 = new javax.swing.JComboBox<>();
        updateStudent = new javax.swing.JButton();
        boxShowPwd = new javax.swing.JCheckBox();
        UpdatepwdTeacher = new PasswordField(50);
        updateAge = new RoundedJTextFieldTest(50);
        deleteStudent = new javax.swing.JButton();
        addStudent = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        teacherTable = new CustomComponent.TableTextCenter();
        jTextField2 = new RoundedJTextFieldTest(500);
        jLabel3 = new javax.swing.JLabel();
        UpdateSubject4 = new javax.swing.JComboBox<>();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        boxShowPwd1 = new javax.swing.JCheckBox();
        UpdateSubject5 = new javax.swing.JComboBox<>();
        UpdateName1 = new RoundedJTextFieldTest(50);
        UpdateEmail1 = new RoundedJTextFieldTest(50);
        UpdatepwdTeacherRewrite1 = new PasswordField(50);
        jLabel40 = new javax.swing.JLabel();
        UpdateSubject6 = new javax.swing.JComboBox<>();
        UpdatepwdTeacher1 = new PasswordField(50);
        UpdateTeacherButton = new javax.swing.JButton();
        deleteTeacher = new javax.swing.JButton();
        addTeacher = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        subjectTable = new CustomComponent.TableTextCenter();
        jLabel7 = new javax.swing.JLabel();
        jTextField3 = new RoundedJTextFieldTest(500);
        updateSubject = new javax.swing.JButton();
        deleteSubject = new javax.swing.JButton();
        addSubject = new javax.swing.JButton();
        updateSubjectName = new RoundedJTextFieldTest(50);
        updateSubjectCode = new RoundedJTextFieldTest(50);
        subjectName = new RoundedJTextFieldTest(50);
        subjectCode = new RoundedJTextFieldTest(50);
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        adminUserName = new CustomComponent.ReadField(50);
        jLabel5 = new javax.swing.JLabel();
        adminName = new CustomComponent.ReadField(50);
        UpdateName2 = new RoundedJTextFieldTest(50);
        UpdatepwdTeacherRewrite2 = new PasswordField(50);
        UpdatepwdTeacher2 = new PasswordField(50);
        boxShowPwd2 = new javax.swing.JCheckBox();
        updateUserName = new RoundedJTextFieldTest(50);
        updateAdmin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1366, 800));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1366, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        getContentPane().add(closeApplication, new org.netbeans.lib.awtextra.AbsoluteConstraints(1322, 23, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/admin (1).png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 40, 52, -1));

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

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, -1, -1));

        jLabel2.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(45, 68, 86));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Admin");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, 270, -1));

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

        getContentPane().add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 80, -1, -1));

        alterSubjects.setBackground(new java.awt.Color(70, 202, 255));
        alterSubjects.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        alterSubjects.setForeground(new java.awt.Color(255, 255, 255));
        alterSubjects.setText("Subjects");
        alterSubjects.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        alterSubjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterSubjectsActionPerformed(evt);
            }
        });
        getContentPane().add(alterSubjects, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 160, 178, 50));

        alterStudents.setBackground(new java.awt.Color(70, 202, 255));
        alterStudents.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        alterStudents.setForeground(new java.awt.Color(255, 255, 255));
        alterStudents.setText("Students");
        alterStudents.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        alterStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterStudentsActionPerformed(evt);
            }
        });
        getContentPane().add(alterStudents, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 178, 50));

        profile.setBackground(new java.awt.Color(70, 202, 255));
        profile.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        profile.setForeground(new java.awt.Color(255, 255, 255));
        profile.setText("Profile");
        profile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileActionPerformed(evt);
            }
        });
        getContentPane().add(profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 160, 178, 50));

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

        alterTeacher.setBackground(new java.awt.Color(70, 202, 255));
        alterTeacher.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        alterTeacher.setForeground(new java.awt.Color(255, 255, 255));
        alterTeacher.setText("Teacher");
        alterTeacher.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        alterTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterTeacherActionPerformed(evt);
            }
        });
        getContentPane().add(alterTeacher, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 178, 50));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        studentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        studentTable.getTableHeader().setReorderingAllowed(false);
        studentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(studentTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 670, 440));

        jTextField1.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 470, 240, 50));

        jLabel1.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        jLabel1.setText("Search Student :  ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 470, -1, 50));

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
        jPanel1.add(UpdateName, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 20, 280, 70));

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
        jPanel1.add(UpdatepwdTeacherRewrite, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 100, 280, 70));

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
        jPanel1.add(UpdateEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 210, 590, 70));

        updatePhoneNumber.setBackground(new java.awt.Color(45, 68, 86));
        updatePhoneNumber.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        updatePhoneNumber.setForeground(new java.awt.Color(102, 102, 102));
        updatePhoneNumber.setText("Change PhoneNumber");
        updatePhoneNumber.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                updatePhoneNumberFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                updatePhoneNumberFocusLost(evt);
            }
        });
        updatePhoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatePhoneNumberActionPerformed(evt);
            }
        });
        jPanel1.add(updatePhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 290, 590, 70));

        jLabel35.setFont(new java.awt.Font("Lato", 3, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(51, 51, 51));
        jLabel35.setText("Subject1:");
        jPanel1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 370, 190, -1));

        UpdateSubject1.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        UpdateSubject1.setForeground(new java.awt.Color(45, 68, 86));
        UpdateSubject1.setBorder(null);
        UpdateSubject1.setLightWeightPopupEnabled(false);
        jPanel1.add(UpdateSubject1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 400, 190, 60));

        UpdateSubject2.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        UpdateSubject2.setForeground(new java.awt.Color(45, 68, 86));
        UpdateSubject2.setBorder(null);
        UpdateSubject2.setLightWeightPopupEnabled(false);
        jPanel1.add(UpdateSubject2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 400, 190, 60));

        jLabel36.setFont(new java.awt.Font("Lato", 3, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(51, 51, 51));
        jLabel36.setText("Subject2:");
        jPanel1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 370, 190, -1));

        jLabel37.setFont(new java.awt.Font("Lato", 3, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(51, 51, 51));
        jLabel37.setText("Subject3:");
        jPanel1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 370, 190, -1));

        UpdateSubject3.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        UpdateSubject3.setForeground(new java.awt.Color(45, 68, 86));
        UpdateSubject3.setBorder(null);
        UpdateSubject3.setLightWeightPopupEnabled(false);
        jPanel1.add(UpdateSubject3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 400, 190, 60));

        updateStudent.setBackground(new java.awt.Color(12, 69, 92));
        updateStudent.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        updateStudent.setForeground(new java.awt.Color(255, 255, 255));
        updateStudent.setText("Update");
        updateStudent.setIconTextGap(15);
        updateStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateStudentActionPerformed(evt);
            }
        });
        jPanel1.add(updateStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 470, 190, 60));

        boxShowPwd.setFont(new java.awt.Font("Lato", 1, 14)); // NOI18N
        boxShowPwd.setForeground(new java.awt.Color(45, 68, 86));
        boxShowPwd.setText("Show Password");
        boxShowPwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxShowPwdActionPerformed(evt);
            }
        });
        jPanel1.add(boxShowPwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(1500, 180, -1, -1));

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
        jPanel1.add(UpdatepwdTeacher, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 100, 300, 70));

        updateAge.setBackground(new java.awt.Color(45, 68, 86));
        updateAge.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        updateAge.setForeground(new java.awt.Color(102, 102, 102));
        updateAge.setText("Change Age");
        updateAge.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                updateAgeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                updateAgeFocusLost(evt);
            }
        });
        updateAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateAgeActionPerformed(evt);
            }
        });
        jPanel1.add(updateAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 20, 300, 70));

        deleteStudent.setBackground(new java.awt.Color(255, 44, 107));
        deleteStudent.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        deleteStudent.setForeground(new java.awt.Color(255, 255, 255));
        deleteStudent.setText("Delete");
        deleteStudent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteStudentActionPerformed(evt);
            }
        });
        jPanel1.add(deleteStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 470, 190, 60));

        addStudent.setBackground(new java.awt.Color(102, 102, 102));
        addStudent.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        addStudent.setForeground(new java.awt.Color(255, 255, 255));
        addStudent.setText("Add Student");
        addStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentActionPerformed(evt);
            }
        });
        jPanel1.add(addStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 470, 190, 60));

        jTabbedPane2.addTab("tab1", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        teacherTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        teacherTable.getTableHeader().setReorderingAllowed(false);
        teacherTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teacherTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(teacherTable);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 750, 440));

        jTextField2.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 490, 240, 50));

        jLabel3.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        jLabel3.setText("Search Teacher :  ");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 490, -1, 50));

        UpdateSubject4.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        UpdateSubject4.setForeground(new java.awt.Color(45, 68, 86));
        UpdateSubject4.setBorder(null);
        UpdateSubject4.setLightWeightPopupEnabled(false);
        jPanel2.add(UpdateSubject4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 320, 150, 60));

        jLabel38.setFont(new java.awt.Font("Lato", 3, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(51, 51, 51));
        jLabel38.setText("Subject1:");
        jPanel2.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 290, -1, -1));

        jLabel39.setFont(new java.awt.Font("Lato", 3, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(51, 51, 51));
        jLabel39.setText("Subject2:");
        jPanel2.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 290, -1, -1));

        boxShowPwd1.setFont(new java.awt.Font("Lato", 1, 14)); // NOI18N
        boxShowPwd1.setForeground(new java.awt.Color(45, 68, 86));
        boxShowPwd1.setText("Show Password");
        boxShowPwd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxShowPwd1ActionPerformed(evt);
            }
        });
        jPanel2.add(boxShowPwd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 180, -1, -1));

        UpdateSubject5.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        UpdateSubject5.setForeground(new java.awt.Color(45, 68, 86));
        UpdateSubject5.setBorder(null);
        UpdateSubject5.setLightWeightPopupEnabled(false);
        jPanel2.add(UpdateSubject5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 320, 150, 60));

        UpdateName1.setBackground(new java.awt.Color(45, 68, 86));
        UpdateName1.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        UpdateName1.setForeground(new java.awt.Color(102, 102, 102));
        UpdateName1.setText("Change Name");
        UpdateName1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                UpdateName1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                UpdateName1FocusLost(evt);
            }
        });
        UpdateName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateName1ActionPerformed(evt);
            }
        });
        jPanel2.add(UpdateName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 20, 470, 70));

        UpdateEmail1.setBackground(new java.awt.Color(45, 68, 86));
        UpdateEmail1.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        UpdateEmail1.setForeground(new java.awt.Color(102, 102, 102));
        UpdateEmail1.setText("Change Email");
        UpdateEmail1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                UpdateEmail1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                UpdateEmail1FocusLost(evt);
            }
        });
        UpdateEmail1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateEmail1ActionPerformed(evt);
            }
        });
        jPanel2.add(UpdateEmail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 210, 470, 70));

        UpdatepwdTeacherRewrite1.setBackground(new java.awt.Color(45, 68, 86));
        UpdatepwdTeacherRewrite1.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        UpdatepwdTeacherRewrite1.setForeground(new java.awt.Color(102, 102, 102));
        UpdatepwdTeacherRewrite1.setText("New Password");
        UpdatepwdTeacherRewrite1.setEchoChar('\u0000');
        UpdatepwdTeacherRewrite1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                UpdatepwdTeacherRewrite1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                UpdatepwdTeacherRewrite1FocusLost(evt);
            }
        });
        UpdatepwdTeacherRewrite1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdatepwdTeacherRewrite1ActionPerformed(evt);
            }
        });
        jPanel2.add(UpdatepwdTeacherRewrite1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 100, 230, 70));

        jLabel40.setFont(new java.awt.Font("Lato", 3, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(51, 51, 51));
        jLabel40.setText("Subject3:");
        jPanel2.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(1500, 290, -1, -1));

        UpdateSubject6.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        UpdateSubject6.setForeground(new java.awt.Color(45, 68, 86));
        UpdateSubject6.setBorder(null);
        UpdateSubject6.setLightWeightPopupEnabled(false);
        jPanel2.add(UpdateSubject6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1460, 320, 150, 60));

        UpdatepwdTeacher1.setBackground(new java.awt.Color(45, 68, 86));
        UpdatepwdTeacher1.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        UpdatepwdTeacher1.setForeground(new java.awt.Color(102, 102, 102));
        UpdatepwdTeacher1.setText("Rewrite Password");
        UpdatepwdTeacher1.setEchoChar('\u0000');
        UpdatepwdTeacher1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                UpdatepwdTeacher1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                UpdatepwdTeacher1FocusLost(evt);
            }
        });
        UpdatepwdTeacher1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdatepwdTeacher1ActionPerformed(evt);
            }
        });
        jPanel2.add(UpdatepwdTeacher1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1380, 100, 230, 70));

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
        jPanel2.add(UpdateTeacherButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1460, 400, 150, 60));

        deleteTeacher.setBackground(new java.awt.Color(255, 44, 107));
        deleteTeacher.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        deleteTeacher.setForeground(new java.awt.Color(255, 255, 255));
        deleteTeacher.setText("Delete");
        deleteTeacher.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTeacherActionPerformed(evt);
            }
        });
        jPanel2.add(deleteTeacher, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 400, 150, 60));

        addTeacher.setBackground(new java.awt.Color(102, 102, 102));
        addTeacher.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        addTeacher.setForeground(new java.awt.Color(255, 255, 255));
        addTeacher.setText("Add Teahcer");
        addTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTeacherActionPerformed(evt);
            }
        });
        jPanel2.add(addTeacher, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 400, 150, 60));

        jTabbedPane2.addTab("tab2", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        subjectTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        subjectTable.getTableHeader().setReorderingAllowed(false);
        subjectTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subjectTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(subjectTable);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 670, 440));

        jLabel7.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        jLabel7.setText("Search Subject :  ");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 490, -1, 50));

        jTextField3.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });
        jPanel3.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 490, 240, 50));

        updateSubject.setBackground(new java.awt.Color(12, 69, 92));
        updateSubject.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        updateSubject.setForeground(new java.awt.Color(255, 255, 255));
        updateSubject.setText("Update");
        updateSubject.setIconTextGap(15);
        updateSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateSubjectActionPerformed(evt);
            }
        });
        jPanel3.add(updateSubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 180, 190, 60));

        deleteSubject.setBackground(new java.awt.Color(255, 44, 107));
        deleteSubject.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        deleteSubject.setForeground(new java.awt.Color(255, 255, 255));
        deleteSubject.setText("Delete");
        deleteSubject.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSubjectActionPerformed(evt);
            }
        });
        jPanel3.add(deleteSubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 180, 190, 60));

        addSubject.setBackground(new java.awt.Color(102, 102, 102));
        addSubject.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        addSubject.setForeground(new java.awt.Color(255, 255, 255));
        addSubject.setText("Add Subject");
        addSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSubjectActionPerformed(evt);
            }
        });
        jPanel3.add(addSubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 470, 190, 60));

        updateSubjectName.setBackground(new java.awt.Color(45, 68, 86));
        updateSubjectName.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        updateSubjectName.setForeground(new java.awt.Color(102, 102, 102));
        updateSubjectName.setText("Update Subject Name");
        updateSubjectName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                updateSubjectNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                updateSubjectNameFocusLost(evt);
            }
        });
        updateSubjectName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateSubjectNameActionPerformed(evt);
            }
        });
        jPanel3.add(updateSubjectName, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 100, 590, 70));

        updateSubjectCode.setBackground(new java.awt.Color(45, 68, 86));
        updateSubjectCode.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        updateSubjectCode.setForeground(new java.awt.Color(102, 102, 102));
        updateSubjectCode.setText("Update Subject Code");
        updateSubjectCode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                updateSubjectCodeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                updateSubjectCodeFocusLost(evt);
            }
        });
        updateSubjectCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateSubjectCodeActionPerformed(evt);
            }
        });
        jPanel3.add(updateSubjectCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 20, 590, 70));

        subjectName.setBackground(new java.awt.Color(45, 68, 86));
        subjectName.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        subjectName.setForeground(new java.awt.Color(102, 102, 102));
        subjectName.setText("Subject Name");
        subjectName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                subjectNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                subjectNameFocusLost(evt);
            }
        });
        subjectName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectNameActionPerformed(evt);
            }
        });
        jPanel3.add(subjectName, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 390, 590, 70));

        subjectCode.setBackground(new java.awt.Color(45, 68, 86));
        subjectCode.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        subjectCode.setForeground(new java.awt.Color(102, 102, 102));
        subjectCode.setText("Subject Code");
        subjectCode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                subjectCodeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                subjectCodeFocusLost(evt);
            }
        });
        subjectCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectCodeActionPerformed(evt);
            }
        });
        jPanel3.add(subjectCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 310, 590, 70));

        jTabbedPane2.addTab("tab3", jPanel3);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(45, 68, 86));
        jLabel6.setText("UserName");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, -1, -1));

        adminUserName.setBackground(new java.awt.Color(45, 68, 86));
        adminUserName.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        adminUserName.setForeground(new java.awt.Color(255, 255, 255));
        adminUserName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        adminUserName.setText("UserName");
        adminUserName.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        adminUserName.setFocusable(false);
        adminUserName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                adminUserNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                adminUserNameFocusLost(evt);
            }
        });
        jPanel4.add(adminUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 380, 60));

        jLabel5.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(45, 68, 86));
        jLabel5.setText("Name");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 60, 50, -1));

        adminName.setBackground(new java.awt.Color(45, 68, 86));
        adminName.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        adminName.setForeground(new java.awt.Color(255, 255, 255));
        adminName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        adminName.setText("Name");
        adminName.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        adminName.setFocusable(false);
        adminName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                adminNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                adminNameFocusLost(evt);
            }
        });
        jPanel4.add(adminName, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 80, 380, 60));

        UpdateName2.setBackground(new java.awt.Color(45, 68, 86));
        UpdateName2.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        UpdateName2.setForeground(new java.awt.Color(102, 102, 102));
        UpdateName2.setText("Change Name");
        UpdateName2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                UpdateName2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                UpdateName2FocusLost(evt);
            }
        });
        UpdateName2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateName2ActionPerformed(evt);
            }
        });
        jPanel4.add(UpdateName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, 470, 70));

        UpdatepwdTeacherRewrite2.setBackground(new java.awt.Color(45, 68, 86));
        UpdatepwdTeacherRewrite2.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        UpdatepwdTeacherRewrite2.setForeground(new java.awt.Color(102, 102, 102));
        UpdatepwdTeacherRewrite2.setText("New Password");
        UpdatepwdTeacherRewrite2.setEchoChar('\u0000');
        UpdatepwdTeacherRewrite2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                UpdatepwdTeacherRewrite2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                UpdatepwdTeacherRewrite2FocusLost(evt);
            }
        });
        UpdatepwdTeacherRewrite2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdatepwdTeacherRewrite2ActionPerformed(evt);
            }
        });
        jPanel4.add(UpdatepwdTeacherRewrite2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 360, 230, 70));

        UpdatepwdTeacher2.setBackground(new java.awt.Color(45, 68, 86));
        UpdatepwdTeacher2.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        UpdatepwdTeacher2.setForeground(new java.awt.Color(102, 102, 102));
        UpdatepwdTeacher2.setText("Rewrite Password");
        UpdatepwdTeacher2.setEchoChar('\u0000');
        UpdatepwdTeacher2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                UpdatepwdTeacher2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                UpdatepwdTeacher2FocusLost(evt);
            }
        });
        UpdatepwdTeacher2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdatepwdTeacher2ActionPerformed(evt);
            }
        });
        jPanel4.add(UpdatepwdTeacher2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 360, 230, 70));

        boxShowPwd2.setFont(new java.awt.Font("Lato", 1, 14)); // NOI18N
        boxShowPwd2.setForeground(new java.awt.Color(45, 68, 86));
        boxShowPwd2.setText("Show Password");
        boxShowPwd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxShowPwd2ActionPerformed(evt);
            }
        });
        jPanel4.add(boxShowPwd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 440, -1, -1));

        updateUserName.setBackground(new java.awt.Color(45, 68, 86));
        updateUserName.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        updateUserName.setForeground(new java.awt.Color(102, 102, 102));
        updateUserName.setText("Change UserName");
        updateUserName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                updateUserNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                updateUserNameFocusLost(evt);
            }
        });
        updateUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateUserNameActionPerformed(evt);
            }
        });
        jPanel4.add(updateUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, 470, 70));

        updateAdmin.setBackground(new java.awt.Color(12, 69, 92));
        updateAdmin.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        updateAdmin.setForeground(new java.awt.Color(255, 255, 255));
        updateAdmin.setText("Update");
        updateAdmin.setIconTextGap(15);
        updateAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateAdminActionPerformed(evt);
            }
        });
        jPanel4.add(updateAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 470, 150, 60));

        jTabbedPane2.addTab("tab4", jPanel4);

        getContentPane().add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-290, 200, 1670, 600));

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

    private void goBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackButtonActionPerformed
        // TODO add your handling code here:

        setVisible(false);
        new AdminLogin().setVisible(true);
    }//GEN-LAST:event_goBackButtonActionPerformed

    private void alterSubjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterSubjectsActionPerformed
        // TODO add your handling code here:

        jTabbedPane2.setSelectedIndex(2);


    }//GEN-LAST:event_alterSubjectsActionPerformed

    private void alterStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterStudentsActionPerformed
        // TODO add your handling code here:

        jTabbedPane2.setSelectedIndex(0);

    }//GEN-LAST:event_alterStudentsActionPerformed

    private void profileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileActionPerformed
        // TODO add your handling code here:

        jTabbedPane2.setSelectedIndex(3);


    }//GEN-LAST:event_profileActionPerformed

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

    private void alterTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterTeacherActionPerformed
        // TODO add your handling code here:

        jTabbedPane2.setSelectedIndex(1);


    }//GEN-LAST:event_alterTeacherActionPerformed

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

    private void UpdateNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateNameActionPerformed

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

    private void updateStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateStudentActionPerformed
        // TODO add your handling code here:

        String newName = UpdateName.getText().trim().equals("Change Name") ? "" : UpdateName.getText().trim();
        newName = UpdateName.getText().trim().length() < 3 || !UpdateName.getText().trim().matches("[a-zA-Z]*|[a-zA-Z]*\\s[a-zA-Z]*") ? "wrong input" : newName;

        String newEmail = UpdateEmail.getText().trim().matches("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*"
                + "@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$") || UpdateEmail.getText().trim().equals("Change Email") ? UpdateEmail.getText().trim() : "wrong email";

        String newPassword = !UpdatepwdTeacher.getText().trim().equals("Rewrite Password") ? UpdatepwdTeacher.getText().trim() : "";
        newPassword = UpdatepwdTeacher.getText().trim().length() > 5 ? newPassword : "wrong Password";

        String newPasswordRewrite = !UpdatepwdTeacherRewrite.getText().trim().equals("New Password") ? UpdatepwdTeacherRewrite.getText().trim() : "";
        newPasswordRewrite = UpdatepwdTeacherRewrite.getText().trim().length() > 5 ? newPasswordRewrite : "wrong Password";

        String phoneNum = updatePhoneNumber.getText().trim().equals("Change PhoneNumber") ? Student.getPhoneNumber() : updatePhoneNumber.getText().trim().matches("^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$") ? updatePhoneNumber.getText().trim() : "wrong input";

        String sub1 = UpdateSubject1.getSelectedItem().toString();
        String sub2 = UpdateSubject2.getSelectedItem().toString();
        String sub3 = UpdateSubject3.getSelectedItem().toString();

        boolean cheak = true;

        if (newName.equals("")) {
            newName = Student.getName();

        } else if (newName.equals("wrong input")) {
            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
            JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Change the Name Field make sure that<br>the name is more than 3 character with no numbers<br>if you need to leave the name as it is leave it empty!</p></html>", "Error!", JOptionPane.INFORMATION_MESSAGE, image);
            cheak = false;

        } else if (newPassword.equals("wrong Password")) {
            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
            JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Change the password Field make sure that<br>the password is at least 6 characters <br>if you need to leave the name as it is leave it empty!</p></html>", "Error!", JOptionPane.INFORMATION_MESSAGE, image);
            cheak = false;

        } else if (!newPassword.equals(newPasswordRewrite)) {
            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
            JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Change the password Field make sure that<br>the 2 password field is exactly the same!<br>if you need to leave the name as it is leave it empty!</p></html>", "Error!", JOptionPane.INFORMATION_MESSAGE, image);
            cheak = false;

        } else if (newEmail.equals("wrong email")) {
            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
            JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Change the Email Field make sure that<br>the Email you write is in correct form!<br>if you need to leave the name as it is leave it empty!</p></html>", "Error!", JOptionPane.INFORMATION_MESSAGE, image);
            cheak = false;
        }

        int sdAge = -1;
        int sdAge2 = Student.getAge();

        try {
            sdAge = updateAge.getText().trim().equals("Change Age") ? sdAge2 : (Integer.parseInt(updateAge.getText()) >= 17 && Integer.parseInt(updateAge.getText()) <= 24) ? Integer.parseInt(updateAge.getText()) : -1;
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

        if (phoneNum.equals("wrong input")) {
            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
            JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Change the phone Field make sure that<br>you enterd a correct phone format as<br>123-456-7890\n"
                    + "(123) 456-7890\n"
                    + "123 456 7890\n"
                    + "123.456.7890\n"
                    + "+91 (123) 456-7890</p></html>", "Error!", JOptionPane.INFORMATION_MESSAGE, image);
            cheak = false;
        }

        if (sub1.equals(sub2) || sub2.equals(sub3) || sub1.equals(sub3)) {
            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
            JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Change the Subject Fields make sure that<br>the 3 subjects are diffrent or not equal none<br> if you need to leave the subject as it is leave it as Default!</p></html>", "Error!", JOptionPane.INFORMATION_MESSAGE, image);
            cheak = false;
        }

        if (cheak) {

            try {
                boolean emailCheck = true;
                Connection connection = dbConnection.ConnectDB();
                PreparedStatement pst;
                pst = connection.prepareStatement("Select email from Students");

                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    if (newEmail.toLowerCase().equals(rs.getString(1).toLowerCase())) {
                        emailCheck = false;
                        ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
                        JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">This Email is already been taken!<br>if you need to leave the Email as it is leave it empty!</p></html>", "Error!", JOptionPane.INFORMATION_MESSAGE, image);
                    }

                    //                System.out.println(Arrays.toString(rows));
                }

                if (emailCheck) {
                    if (newEmail.equals("Change Email")) {
                        newEmail = Student.getEmail();
                    }
                    pst = connection.prepareStatement("update Students set email = ?, name = ?, password = ?, age = ?, phone = ?, subject1=?,subject2 = ?, subject3 = ? where ID = ?");
                    pst.setString(1, newEmail.toLowerCase());
                    Student.setEmail(newEmail.toLowerCase());
                    pst.setString(2, newName);
                    Student.setName(newName);
                    if (newPassword.equals("")) {
                        pst.setString(3, Student.getPassword());
                    } else {
                        pst.setString(3, newPassword);
                        Student.setPassword(newPassword);
                    }
                    pst.setInt(4, sdAge);
                    pst.setString(5, phoneNum);

                    if (UpdateSubject1.getSelectedItem().toString().equals("NONE")) {
                        pst.setNull(6, Types.NVARCHAR);
                    } else {

                        pst.setString(6, UpdateSubject1.getSelectedItem().toString());
                    }

                    if (UpdateSubject2.getSelectedItem().toString().equals("NONE")) {
                        pst.setNull(7, Types.NVARCHAR);
                    } else {

                        pst.setString(7, UpdateSubject2.getSelectedItem().toString());
                    }

                    if (UpdateSubject3.getSelectedItem().toString().equals("NONE")) {
                        pst.setNull(8, Types.NVARCHAR);
                    } else {

                        pst.setString(8, UpdateSubject3.getSelectedItem().toString());
                    }

                    pst.setInt(9, Student.getID());
                    int k = pst.executeUpdate();
                    if (k == 1) {
                        if (updateAge.getText().equals("Change Age") && updatePhoneNumber.getText().equals("Change PhoneNumber") && UpdateName.getText().equals("Change Name") && UpdatepwdTeacherRewrite.getText().equals("New Password") && UpdatepwdTeacher.getText().equals("Rewrite Password") && UpdateEmail.getText().equals("Change Email")) {

                            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
                            JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Nothing Updated!</p></html>", "Note!", JOptionPane.INFORMATION_MESSAGE, image);
                        } else {
                            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (2).png"));
                            JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Update Done Successfully!</p></html>", "Done!", JOptionPane.INFORMATION_MESSAGE, image);

                        }
                        StudentTable();
                        studentEnabled(false);
                        setDefaultS();

                    }
                }

            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(StudentUpdateInfoPanal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

            }
        }
    }//GEN-LAST:event_updateStudentActionPerformed

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

    private void updateAgeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_updateAgeFocusGained
        // TODO add your handling code here:

        if (updateAge.getText().equals("Change Age")) {
            updateAge.setText("");
            updateAge.setForeground(Color.white);
        }
    }//GEN-LAST:event_updateAgeFocusGained

    private void updateAgeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_updateAgeFocusLost
        // TODO add your handling code here:

        if (updateAge.getText().equals("")) {
            updateAge.setText("Change Age");
            updateAge.setForeground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_updateAgeFocusLost

    private void updateAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateAgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateAgeActionPerformed

    private void updatePhoneNumberFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_updatePhoneNumberFocusGained
        // TODO add your handling code here:

        if (updatePhoneNumber.getText().equals("Change PhoneNumber")) {
            updatePhoneNumber.setText("");
            updatePhoneNumber.setForeground(Color.white);
        }
    }//GEN-LAST:event_updatePhoneNumberFocusGained

    private void updatePhoneNumberFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_updatePhoneNumberFocusLost
        // TODO add your handling code here:

        if (updatePhoneNumber.getText().equals("")) {
            updatePhoneNumber.setText("Change PhoneNumber");
            updatePhoneNumber.setForeground(new Color(102, 102, 102));
        }

    }//GEN-LAST:event_updatePhoneNumberFocusLost

    private void updatePhoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatePhoneNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updatePhoneNumberActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:

        DefaultTableModel table = (DefaultTableModel) studentTable.getModel();
        String search = jTextField1.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        studentTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));

    }//GEN-LAST:event_jTextField1KeyReleased

    private void deleteStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteStudentActionPerformed
        // TODO add your handling code here:

        if (isLoggedIn()) {
            String[] options = {"Yes", "No"};

            ImageIcon imageExclamation = new ImageIcon(getClass().getResource("/Images/exclamation-mark.png"));
            int a = JOptionPane.showOptionDialog(this, "Are you sure that you want to delete this Question?", "Delete Alert!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, imageExclamation, options, 0);
            if (a == 0) {
                try {

                    Connection connection = dbConnection.ConnectDB();
                    PreparedStatement pst;
                    pst = connection.prepareStatement("delete from Students where ID = ?");
                    pst.setInt(1, Student.getID());

                    int k = pst.executeUpdate();

                    if (k == 1) {
                        setDefaultS();
                        studentEnabled(false);
                        StudentTable();
                        ImageIcon image = new ImageIcon(getClass().getResource("/Images/admin (1).png"));
                        JOptionPane.showMessageDialog(this, "<html><p style=\"text-align: center;\">Studnet Deleted Successfully!</p></html>", "Done!", JOptionPane.INFORMATION_MESSAGE, image);

                    } else {
                        ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
                        JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Failed to Deleted Student!</p></html>", "Error!", JOptionPane.INFORMATION_MESSAGE, image);

                    }

                } catch (SQLException ex) {
                    Logger.getLogger(TeacherHome.class.getName()).log(Level.SEVERE, null, ex);

                }
            }

        } else {
            String[] options = {"Login", "Exit"};
            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
            int a = JOptionPane.showOptionDialog(null, "To Add test you must Login as Admin first?", "Login or Exit!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, image, options, 0);
            if (a == 0) {
                setVisible(false);
                new TeacherLogin().setVisible(true);
            } else if (a == 1) {
                System.exit(0);

            }
        }

    }//GEN-LAST:event_deleteStudentActionPerformed

    private void studentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentTableMouseClicked
        // TODO add your handling code here:

        studentEnabled(true);
        UpdateName.setForeground(Color.white);
        updateAge.setForeground(Color.white);
        UpdateEmail.setForeground(Color.white);
        updatePhoneNumber.setForeground(Color.white);
//        DefaultTableModel d1 = (DefaultTableModel) studentTable.getModel();
        int SelectIndex = studentTable.getSelectedRow();
        Student.setID(Integer.parseInt(studentTable.getValueAt(SelectIndex, 0).toString()));
        Student.setName(studentTable.getValueAt(SelectIndex, 1).toString());
        Student.setEmail(studentTable.getValueAt(SelectIndex, 2).toString());
        Student.setPassword(studentTable.getValueAt(SelectIndex, 3).toString());
        Student.setPhoneNumber(studentTable.getValueAt(SelectIndex, 4).toString());
        Student.setAge(Integer.parseInt(studentTable.getValueAt(SelectIndex, 5).toString()));
        String sub1 = studentTable.getValueAt(SelectIndex, 6) == null ? "NONE" : studentTable.getValueAt(SelectIndex, 6).toString();
        String sub2 = studentTable.getValueAt(SelectIndex, 7) == null ? "NONE" : studentTable.getValueAt(SelectIndex, 7).toString();
        String sub3 = studentTable.getValueAt(SelectIndex, 8) == null ? "NONE" : studentTable.getValueAt(SelectIndex, 8).toString();

        UpdateName.setText(Student.getName());
        updateAge.setText(Student.getAge() + "");
        UpdateEmail.setText(Student.getEmail());
        updatePhoneNumber.setText(Student.getPhoneNumber());
        UpdateSubject1.setSelectedItem(sub1);
        UpdateSubject2.setSelectedItem(sub2);
        UpdateSubject3.setSelectedItem(sub3);


    }//GEN-LAST:event_studentTableMouseClicked

    private void addStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentActionPerformed
        // TODO add your handling code here:

        setVisible(false);
        new AdminAddStudent().setVisible(true);

    }//GEN-LAST:event_addStudentActionPerformed

    private void teacherTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teacherTableMouseClicked
        // TODO add your handling code here:

        teacherEnabled(true);

        UpdateName1.setForeground(Color.white);

        UpdateEmail1.setForeground(Color.white);

        int SelectIndex = teacherTable.getSelectedRow();
        Teacher.setID(Integer.parseInt(teacherTable.getValueAt(SelectIndex, 0).toString()));
        Teacher.setName(teacherTable.getValueAt(SelectIndex, 3).toString());
        Teacher.setEmail(teacherTable.getValueAt(SelectIndex, 2).toString());
        Teacher.setPassword(teacherTable.getValueAt(SelectIndex, 1).toString());
        String sub1 = teacherTable.getValueAt(SelectIndex, 4) == null ? "NONE" : teacherTable.getValueAt(SelectIndex, 4).toString();
        String sub2 = teacherTable.getValueAt(SelectIndex, 5) == null ? "NONE" : teacherTable.getValueAt(SelectIndex, 5).toString();
        String sub3 = teacherTable.getValueAt(SelectIndex, 6) == null ? "NONE" : teacherTable.getValueAt(SelectIndex, 6).toString();

        UpdateName1.setText(Teacher.getName());
        UpdateEmail1.setText(Teacher.getEmail());
        UpdateSubject4.setSelectedItem(sub1);
        UpdateSubject5.setSelectedItem(sub2);
        UpdateSubject6.setSelectedItem(sub3);

    }//GEN-LAST:event_teacherTableMouseClicked

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        // TODO add your handling code here:

        DefaultTableModel table = (DefaultTableModel) teacherTable.getModel();
        String search = jTextField2.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        teacherTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));

    }//GEN-LAST:event_jTextField2KeyReleased

    private void UpdateName1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UpdateName1FocusGained
        // TODO add your handling code here:

        if (UpdateName1.getText().equals("Change Name")) {
            UpdateName1.setText("");
            UpdateName1.setForeground(Color.white);
        }
    }//GEN-LAST:event_UpdateName1FocusGained

    private void UpdateName1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UpdateName1FocusLost
        // TODO add your handling code here:

        if (UpdateName1.getText().equals("")) {
            UpdateName1.setText("Change Name");
            UpdateName1.setForeground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_UpdateName1FocusLost

    private void UpdateName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateName1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateName1ActionPerformed

    private void UpdatepwdTeacher1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UpdatepwdTeacher1FocusGained
        // TODO add your handling code here:

        if (UpdatepwdTeacher1.getText().equals("Rewrite Password")) {
            UpdatepwdTeacher1.setText("");
            UpdatepwdTeacher1.setForeground(Color.white);
            if (!boxShowPwd1.isSelected()) {
                UpdatepwdTeacher1.setEchoChar('\u2022');
            }
        }
    }//GEN-LAST:event_UpdatepwdTeacher1FocusGained

    private void UpdatepwdTeacher1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UpdatepwdTeacher1FocusLost
        // TODO add your handling code here:

        if (UpdatepwdTeacher1.getText().equals("")) {
            UpdatepwdTeacher1.setEchoChar('\u0000');
            UpdatepwdTeacher1.setText("Rewrite Password");
            UpdatepwdTeacher1.setForeground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_UpdatepwdTeacher1FocusLost

    private void UpdatepwdTeacher1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdatepwdTeacher1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdatepwdTeacher1ActionPerformed

    private void boxShowPwd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxShowPwd1ActionPerformed
        // TODO add your handling code here:
        if (!(UpdatepwdTeacher1.getText().equals("Rewrite Password"))) {
            if (boxShowPwd1.isSelected()) {
                UpdatepwdTeacher1.setEchoChar((char) 0);
            } else {
                UpdatepwdTeacher1.setEchoChar('\u2022');
            }
        }
        if (!(UpdatepwdTeacherRewrite1.getText().equals("New Password"))) {
            if (boxShowPwd1.isSelected()) {
                UpdatepwdTeacherRewrite1.setEchoChar((char) 0);
            } else {
                UpdatepwdTeacherRewrite1.setEchoChar('\u2022');
            }
        }
    }//GEN-LAST:event_boxShowPwd1ActionPerformed

    private void UpdateTeacherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateTeacherButtonActionPerformed
        // TODO add your handling code here:

        String newName = UpdateName1.getText().trim().equals("Change Name") ? "" : UpdateName1.getText().trim();
        newName = UpdateName1.getText().trim().length() < 3 || !UpdateName1.getText().trim().matches("[a-zA-Z]*|[a-zA-Z]*\\s[a-zA-Z]*") ? "wrong input" : newName;

        String newEmail = UpdateEmail1.getText().trim().matches("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*"
                + "@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$") || UpdateEmail1.getText().trim().equals("Change Email") ? UpdateEmail1.getText().trim() : "wrong email";

        String newPassword = !UpdatepwdTeacher1.getText().trim().equals("Rewrite Password") ? UpdatepwdTeacher1.getText().trim() : "";
        newPassword = UpdatepwdTeacher1.getText().trim().length() > 5 ? newPassword : "wrong Password";

        String newPasswordRewrite = !UpdatepwdTeacherRewrite1.getText().trim().equals("New Password") ? UpdatepwdTeacherRewrite1.getText().trim() : "";
        newPasswordRewrite = UpdatepwdTeacherRewrite1.getText().trim().length() > 5 ? newPasswordRewrite : "wrong Password";

        String sub1 = UpdateSubject4.getSelectedItem().toString();
        String sub2 = UpdateSubject5.getSelectedItem().toString();
        String sub3 = UpdateSubject6.getSelectedItem().toString();

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
                        pst.setString(3, Teacher.getPassword());
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
                        TeacherTable();
                        setDefaultT();
                        teacherEnabled(false);

                        ImageIcon image = new ImageIcon(getClass().getResource("/Images/admin (1).png"));
                        JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Update Done Successfully!</p></html>", "Done!", JOptionPane.INFORMATION_MESSAGE, image);

                    }
                }

            } catch (SQLException ex) {
                Logger.getLogger(TeacherHome.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }//GEN-LAST:event_UpdateTeacherButtonActionPerformed

    private void UpdatepwdTeacherRewrite1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UpdatepwdTeacherRewrite1FocusGained
        // TODO add your handling code here:
        if (UpdatepwdTeacherRewrite1.getText().equals("New Password")) {
            UpdatepwdTeacherRewrite1.setText("");
            UpdatepwdTeacherRewrite1.setForeground(Color.white);
            if (!boxShowPwd1.isSelected()) {
                UpdatepwdTeacherRewrite1.setEchoChar('\u2022');
            }
        }
    }//GEN-LAST:event_UpdatepwdTeacherRewrite1FocusGained

    private void UpdatepwdTeacherRewrite1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UpdatepwdTeacherRewrite1FocusLost
        // TODO add your handling code here:

        if (UpdatepwdTeacherRewrite1.getText().equals("")) {
            UpdatepwdTeacherRewrite1.setEchoChar('\u0000');
            UpdatepwdTeacherRewrite1.setText("New Password");
            UpdatepwdTeacherRewrite1.setForeground(new Color(102, 102, 102));
        }
        //[102,102,102]
    }//GEN-LAST:event_UpdatepwdTeacherRewrite1FocusLost

    private void UpdatepwdTeacherRewrite1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdatepwdTeacherRewrite1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdatepwdTeacherRewrite1ActionPerformed

    private void UpdateEmail1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UpdateEmail1FocusGained
        // TODO add your handling code here:

        if (UpdateEmail1.getText().equals("Change Email")) {
            UpdateEmail1.setText("");
            UpdateEmail1.setForeground(Color.white);
        }
    }//GEN-LAST:event_UpdateEmail1FocusGained

    private void UpdateEmail1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UpdateEmail1FocusLost
        // TODO add your handling code here:

        if (UpdateEmail1.getText().equals("")) {
            UpdateEmail1.setText("Change Email");
            UpdateEmail1.setForeground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_UpdateEmail1FocusLost

    private void UpdateEmail1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateEmail1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateEmail1ActionPerformed

    private void deleteTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTeacherActionPerformed
        // TODO add your handling code here:

        if (isLoggedIn()) {
            String[] options = {"Yes", "No"};

            ImageIcon imageExclamation = new ImageIcon(getClass().getResource("/Images/exclamation-mark.png"));
            int a = JOptionPane.showOptionDialog(this, "Are you sure that you want to delete this Teacher?", "Delete Alert!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, imageExclamation, options, 0);
            if (a == 0) {
                try {

                    Connection connection = dbConnection.ConnectDB();
                    PreparedStatement pst;
                    pst = connection.prepareStatement("delete from Teacher where ID = ?");
                    pst.setInt(1, Teacher.getID());

                    int k = pst.executeUpdate();

                    if (k == 1) {
                        setDefaultT();
                        teacherEnabled(false);
                        TeacherTable();
                        ImageIcon image = new ImageIcon(getClass().getResource("/Images/admin (1).png"));
                        JOptionPane.showMessageDialog(this, "<html><p style=\"text-align: center;\">Teacher Deleted Successfully!</p></html>", "Done!", JOptionPane.INFORMATION_MESSAGE, image);

                    } else {
                        ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
                        JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Failed to Delete Teacher!</p></html>", "Error!", JOptionPane.INFORMATION_MESSAGE, image);

                    }

                } catch (SQLException ex) {
                    Logger.getLogger(TeacherHome.class.getName()).log(Level.SEVERE, null, ex);

                }
            }

        } else {
            String[] options = {"Login", "Exit"};
            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
            int a = JOptionPane.showOptionDialog(null, "To Add test you must Login as Admin first?", "Login or Exit!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, image, options, 0);
            if (a == 0) {
                setVisible(false);
                new TeacherLogin().setVisible(true);
            } else if (a == 1) {
                System.exit(0);

            }
        }

    }//GEN-LAST:event_deleteTeacherActionPerformed

    private void addTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTeacherActionPerformed
        // TODO add your handling code here:

        setVisible(false);
        new AdminAddTeacher().setVisible(true);

    }//GEN-LAST:event_addTeacherActionPerformed

    private void adminUserNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_adminUserNameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_adminUserNameFocusGained

    private void adminUserNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_adminUserNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_adminUserNameFocusLost

    private void adminNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_adminNameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_adminNameFocusGained

    private void adminNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_adminNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_adminNameFocusLost

    private void UpdateName2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UpdateName2FocusGained
        // TODO add your handling code here:

        if (UpdateName2.getText().equals("Change Name")) {
            UpdateName2.setText("");
            UpdateName2.setForeground(Color.white);
        }


    }//GEN-LAST:event_UpdateName2FocusGained

    private void UpdateName2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UpdateName2FocusLost
        // TODO add your handling code here:

        if (UpdateName2.getText().equals("")) {
            UpdateName2.setText("Change Name");
            UpdateName2.setForeground(new Color(102, 102, 102));
        }

    }//GEN-LAST:event_UpdateName2FocusLost

    private void UpdateName2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateName2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateName2ActionPerformed

    private void UpdatepwdTeacherRewrite2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UpdatepwdTeacherRewrite2FocusGained
        // TODO add your handling code here:

        if (UpdatepwdTeacherRewrite2.getText().equals("New Password")) {
            UpdatepwdTeacherRewrite2.setText("");
            UpdatepwdTeacherRewrite2.setForeground(Color.white);
            if (!boxShowPwd2.isSelected()) {
                UpdatepwdTeacherRewrite2.setEchoChar('\u2022');
            }
        }

    }//GEN-LAST:event_UpdatepwdTeacherRewrite2FocusGained

    private void UpdatepwdTeacherRewrite2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UpdatepwdTeacherRewrite2FocusLost
        // TODO add your handling code here:

        if (UpdatepwdTeacherRewrite2.getText().equals("")) {
            UpdatepwdTeacherRewrite2.setEchoChar('\u0000');
            UpdatepwdTeacherRewrite2.setText("New Password");
            UpdatepwdTeacherRewrite2.setForeground(new Color(102, 102, 102));
        }

    }//GEN-LAST:event_UpdatepwdTeacherRewrite2FocusLost

    private void UpdatepwdTeacherRewrite2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdatepwdTeacherRewrite2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdatepwdTeacherRewrite2ActionPerformed

    private void UpdatepwdTeacher2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UpdatepwdTeacher2FocusGained
        // TODO add your handling code here:

        if (UpdatepwdTeacher2.getText().equals("Rewrite Password")) {
            UpdatepwdTeacher2.setText("");
            UpdatepwdTeacher2.setForeground(Color.white);
            if (!boxShowPwd2.isSelected()) {
                UpdatepwdTeacher2.setEchoChar('\u2022');
            }
        }


    }//GEN-LAST:event_UpdatepwdTeacher2FocusGained

    private void UpdatepwdTeacher2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UpdatepwdTeacher2FocusLost
        // TODO add your handling code here:

        if (UpdatepwdTeacher2.getText().equals("")) {
            UpdatepwdTeacher2.setEchoChar('\u0000');
            UpdatepwdTeacher2.setText("Rewrite Password");
            UpdatepwdTeacher2.setForeground(new Color(102, 102, 102));
        }

    }//GEN-LAST:event_UpdatepwdTeacher2FocusLost

    private void UpdatepwdTeacher2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdatepwdTeacher2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdatepwdTeacher2ActionPerformed

    private void boxShowPwd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxShowPwd2ActionPerformed
        // TODO add your handling code here:

        if (!(UpdatepwdTeacher2.getText().equals("Rewrite Password"))) {
            if (boxShowPwd2.isSelected()) {
                UpdatepwdTeacher2.setEchoChar((char) 0);
            } else {
                UpdatepwdTeacher2.setEchoChar('\u2022');
            }
        }
        if (!(UpdatepwdTeacherRewrite2.getText().equals("New Password"))) {
            if (boxShowPwd2.isSelected()) {
                UpdatepwdTeacherRewrite2.setEchoChar((char) 0);
            } else {
                UpdatepwdTeacherRewrite2.setEchoChar('\u2022');
            }
        }

    }//GEN-LAST:event_boxShowPwd2ActionPerformed

    private void updateUserNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_updateUserNameFocusGained
        // TODO add your handling code here:

        if (updateUserName.getText().equals("Change UserName")) {
            updateUserName.setText("");
            updateUserName.setForeground(Color.white);
        }

    }//GEN-LAST:event_updateUserNameFocusGained

    private void updateUserNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_updateUserNameFocusLost
        // TODO add your handling code here:

        if (updateUserName.getText().equals("")) {
            updateUserName.setText("Change UserName");
            updateUserName.setForeground(new Color(102, 102, 102));
        }

    }//GEN-LAST:event_updateUserNameFocusLost

    private void updateUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateUserNameActionPerformed

    private void updateAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateAdminActionPerformed
        // TODO add your handling code here:

        String newName = UpdateName2.getText().trim().equals("Change Name") ? "" : UpdateName2.getText().trim();
        newName = UpdateName2.getText().trim().length() < 3 || !UpdateName2.getText().trim().matches("[a-zA-Z]*|[a-zA-Z]*\\s[a-zA-Z]*") ? "wrong input" : newName;

        String newUserName = updateUserName.getText().trim().length() > 4 ? updateUserName.getText().trim() : "wrong UserName";

        String newPassword = !UpdatepwdTeacher2.getText().trim().equals("Rewrite Password") ? UpdatepwdTeacher2.getText().trim() : "";
        newPassword = UpdatepwdTeacher2.getText().trim().length() > 5 ? newPassword : "wrong Password";

        String newPasswordRewrite = !UpdatepwdTeacherRewrite2.getText().trim().equals("New Password") ? UpdatepwdTeacherRewrite2.getText().trim() : "";
        newPasswordRewrite = UpdatepwdTeacherRewrite2.getText().trim().length() > 5 ? newPasswordRewrite : "wrong Password";

        boolean cheak = true;

        if (newName.equals("")) {
            newName = Admin.getName();

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
        if (newUserName.equals("wrong UserName")) {
            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
            JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Change the UserName Field make sure that<br>the UserName length is more than 3 characters!<br>if you need to leave the name as it is leave it empty!</p></html>", "Error!", JOptionPane.INFORMATION_MESSAGE, image);
            cheak = false;
        }

        if (cheak) {
            System.out.println("aaaaaa");

            try {
                boolean emailCheck = true;
                Connection connection = dbConnection.ConnectDB();
                PreparedStatement pst;
                pst = connection.prepareStatement("Select username from Admin");

                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    if (newUserName.toLowerCase().equals(rs.getString(1))) {
                        emailCheck = false;
                        ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
                        JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">This UserName is already been taken!<br>if you need to leave the UserName as it is leave it empty!</p></html>", "Error!", JOptionPane.INFORMATION_MESSAGE, image);
                    }

                    //                System.out.println(Arrays.toString(rows));
                }

                if (emailCheck) {
                    if (newUserName.equals("Change UserName")) {
                        newUserName = Admin.getUserName();
                    }
                    pst = connection.prepareStatement("update admin set username = ?, name = ?, password = ? where username = ?");
                    pst.setString(1, newUserName.toLowerCase());
                    pst.setString(2, newName);
                    Admin.setName(newName);
                    if (newPassword.equals("")) {
                        pst.setString(3, Admin.getPassword());
                    } else {
                        pst.setString(3, newPassword);
                        Admin.setPassword(newPassword);
                    }
                    pst.setString(4, Admin.getUserName());

                    int k = pst.executeUpdate();
                    if (k == 1) {
                        Admin.setUserName(newUserName.toLowerCase());
                        adminUserName.setText(Admin.getUserName());
                        adminName.setText(Admin.getName());
                        jLabel2.setText(Admin.getName());

                        if (updateUserName.getText().equals("Change UserName") && UpdateName2.getText().equals("Change Name") && UpdatepwdTeacherRewrite2.getText().equals("New Password") && UpdatepwdTeacher2.getText().equals("Rewrite Password")) {
                            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
                            JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Nothing Updated!</p></html>", "Warning!", JOptionPane.INFORMATION_MESSAGE, image);

                        } else {
                            ImageIcon image = new ImageIcon(getClass().getResource("/Images/admin (1).png"));
                            JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Update Done Successfully!</p></html>", "Done!", JOptionPane.INFORMATION_MESSAGE, image);

                        }

                    }
                }

            } catch (SQLException ex) {
                Logger.getLogger(TeacherHome.class.getName()).log(Level.SEVERE, null, ex);

            }
        }


    }//GEN-LAST:event_updateAdminActionPerformed

    private void subjectTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subjectTableMouseClicked
        // TODO add your handling code here:

        subjectEnabled(true);
        updateSubject.setEnabled(true);
        deleteSubject.setEnabled(true);
        updateSubjectCode.setForeground(Color.white);

        updateSubjectName.setForeground(Color.white);
        int SelectIndex = subjectTable.getSelectedRow();
        String subCode = subjectTable.getValueAt(SelectIndex, 0).toString();
        String subName = subjectTable.getValueAt(SelectIndex, 1).toString();

        updateSubjectCode.setText(subCode);
        updateSubjectName.setText(subName);
        subjectCode1 = subCode;
        subjectName1 = subName;

    }//GEN-LAST:event_subjectTableMouseClicked

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        // TODO add your handling code here:

        DefaultTableModel table = (DefaultTableModel) subjectTable.getModel();
        String search = jTextField3.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        subjectTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));

    }//GEN-LAST:event_jTextField3KeyReleased

    private void updateSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateSubjectActionPerformed
        // TODO add your handling code here:
        System.out.println(subjectCode1);
        String subCode = updateSubjectCode.getText().trim().length() > 3 ? updateSubjectCode.getText().trim() : "";
        String subName = updateSubjectName.getText().trim().length() > 3 ? updateSubjectName.getText().trim() : "";

        boolean check = true;

        if (subCode.equals("")) {
            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
            JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">The subCode Must be More than 3 characters!<br>if you need to leave the subCode as it is leave it empty!</p></html>", "Error!", JOptionPane.INFORMATION_MESSAGE, image);
            check = false;
        } else if (subName.equals("")) {
            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
            JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">The subName Must be More than 3 characters!<br>if you need to leave the subName as it is leave it empty!</p></html>", "Error!", JOptionPane.INFORMATION_MESSAGE, image);
            check = false;
        }

        if (check) {
            try {
                boolean codeCheck = true;
                Connection connection = dbConnection.ConnectDB();
                PreparedStatement pst;
                pst = connection.prepareStatement("Select code from Subject");

                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    if (subCode.equals(rs.getString(1))) {
                        codeCheck = false;
                        ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
                        JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">This subCode is already been taken!<br>if you need to leave the subCode as it is leave it empty!</p></html>", "Error!", JOptionPane.INFORMATION_MESSAGE, image);
                    }
                }

                if (subCode.equals("Update Subject Code")) {
                    subCode = subjectCode1;
                }
                if (subName.equals("Update Subject Name")) {
                    subName = subjectName1;
                }

                if (codeCheck) {

                    pst = connection.prepareStatement("update Subject set code = ?, [name] = ? where code = ?");
                    pst.setString(1, subCode);
                    pst.setString(2, subName);
                    pst.setString(3, subjectCode1);
                    int k = pst.executeUpdate();
                    if (k == 1) {
                        if (updateSubjectCode.getText().equals("Update Subject Code") && updateSubjectName.getText().equals("Update Subject Name")) {
                            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
                            JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Nothing Updated!</p></html>", "Warning!", JOptionPane.INFORMATION_MESSAGE, image);

                        } else {
                            ImageIcon image = new ImageIcon(getClass().getResource("/Images/admin (1).png"));
                            JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Update Done Successfully!</p></html>", "Done!", JOptionPane.INFORMATION_MESSAGE, image);

                        }
                        setDefaultSub();
                        subjectEnabled(false);
                        updateSubject.setEnabled(false);
                        deleteSubject.setEnabled(false);
                        SubjectTable();
                        StudentTable();
                        TeacherTable();

                    }
                }

            } catch (SQLException ex) {
                Logger.getLogger(TeacherHome.class.getName()).log(Level.SEVERE, null, ex);

            }

        }


    }//GEN-LAST:event_updateSubjectActionPerformed

    private void deleteSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteSubjectActionPerformed
        // TODO add your handling code here:

        String[] options = {"Yes", "No"};

        ImageIcon imageExclamation = new ImageIcon(getClass().getResource("/Images/exclamation-mark.png"));
        int a = JOptionPane.showOptionDialog(this, "Are you sure that you want to delete this Subject?", "Delete Alert!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, imageExclamation, options, 0);
        if (a == 0) {
            try {

                Connection connection = dbConnection.ConnectDB();
                PreparedStatement pst;

                pst = connection.prepareStatement("delete from [Subject] where code = ?");

                pst.setString(1, subjectCode1);
                int k = pst.executeUpdate();
                if (k == 1) {
                    setDefaultSub();
                    subjectEnabled(false);
                    updateSubject.setEnabled(false);
                    deleteSubject.setEnabled(false);
                    SubjectTable();
                    StudentTable();
                    TeacherTable();
                    getAllSubs();

                    ImageIcon image = new ImageIcon(getClass().getResource("/Images/admin (1).png"));
                    JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Successefully Deleted!</p></html>", "Done!", JOptionPane.INFORMATION_MESSAGE, image);

                }

            } catch (SQLException ex) {
                Logger.getLogger(TeacherHome.class.getName()).log(Level.SEVERE, null, ex);

            }
        }


    }//GEN-LAST:event_deleteSubjectActionPerformed

    private void addSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSubjectActionPerformed
        // TODO add your handling code here:

        String subCode = subjectCode.getText().trim().length() > 3 ? subjectCode.getText().trim() : "";
        String subName = subjectName.getText().trim().length() > 3 ? subjectName.getText().trim() : "";

        boolean check = true;

        if (subCode.equals("")) {
            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
            JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">The subCode Must be More than 3 characters!<br>if you need to leave the subCode as it is leave it empty!</p></html>", "Error!", JOptionPane.INFORMATION_MESSAGE, image);
            check = false;
        } else if (subName.equals("")) {
            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
            JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">The subName Must be More than 3 characters!<br>if you need to leave the subName as it is leave it empty!</p></html>", "Error!", JOptionPane.INFORMATION_MESSAGE, image);
            check = false;
        }

        if (check) {
            try {
                boolean codeCheck = true;
                Connection connection = dbConnection.ConnectDB();
                PreparedStatement pst;
                pst = connection.prepareStatement("Select code from Subject");

                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    if (subCode.equals(rs.getString(1))) {
                        codeCheck = false;
                        ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
                        JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">This subCode is already been taken!<br>if you need to leave the subCode as it is leave it empty!</p></html>", "Error!", JOptionPane.INFORMATION_MESSAGE, image);
                    }
                }

                if (subCode.equals("Subject Code")) {
                    subCode = "";
                }
                if (subName.equals("Subject Name")) {
                    subName = "";
                }

                if (codeCheck) {
                    if (subCode.equals("") || subName.equals("")) {
                        ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
                        JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Wrong input!</p></html>", "Error!", JOptionPane.INFORMATION_MESSAGE, image);

                    } else {
                        pst = connection.prepareStatement("insert into [Subject](code,name) values(?,?)");
                        pst.setString(1, subCode);
                        pst.setString(2, subName);
                        int k = pst.executeUpdate();
                        if (k == 1) {

                            ImageIcon image = new ImageIcon(getClass().getResource("/Images/admin (1).png"));
                            JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">Subject Added Successefully!</p></html>", "Done!", JOptionPane.INFORMATION_MESSAGE, image);

                            setDefaultSub();
                            subjectEnabled(false);
                            SubjectTable();
                            getAllSubs();
                            subjectCode.setForeground(new Color(153, 153, 153));
                            subjectName.setForeground(new Color(153, 153, 153));
                        } else {
                            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
                            JOptionPane.showMessageDialog(null, "<html><p style=\"text-align: center;\">adding Faild!</p></html>", "warning!", JOptionPane.INFORMATION_MESSAGE, image);

                        }

                    }
                }

            } catch (SQLException ex) {
                Logger.getLogger(TeacherHome.class.getName()).log(Level.SEVERE, null, ex);

            }

        }

    }//GEN-LAST:event_addSubjectActionPerformed

    private void updateSubjectNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_updateSubjectNameFocusGained
        // TODO add your handling code here:

        if (updateSubjectName.getText().equals("Update Subject Name")) {
            updateSubjectName.setText("");
            updateSubjectName.setForeground(Color.white);
        }


    }//GEN-LAST:event_updateSubjectNameFocusGained

    private void updateSubjectNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_updateSubjectNameFocusLost
        // TODO add your handling code here:

        if (updateSubjectName.getText().equals("")) {
            updateSubjectName.setText("Update Subject Name");
            updateSubjectName.setForeground(new Color(102, 102, 102));
        }

    }//GEN-LAST:event_updateSubjectNameFocusLost

    private void updateSubjectNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateSubjectNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateSubjectNameActionPerformed

    private void updateSubjectCodeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_updateSubjectCodeFocusGained
        // TODO add your handling code here:

        if (updateSubjectCode.getText().equals("Update Subject Code")) {
            updateSubjectCode.setText("");
            updateSubjectCode.setForeground(Color.white);
        }


    }//GEN-LAST:event_updateSubjectCodeFocusGained

    private void updateSubjectCodeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_updateSubjectCodeFocusLost
        // TODO add your handling code here:

        if (updateSubjectCode.getText().equals("")) {
            updateSubjectCode.setText("Update Subject Code");
            updateSubjectCode.setForeground(new Color(102, 102, 102));
        }


    }//GEN-LAST:event_updateSubjectCodeFocusLost

    private void updateSubjectCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateSubjectCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateSubjectCodeActionPerformed

    private void subjectNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_subjectNameFocusGained
        // TODO add your handling code here:

        if (subjectName.getText().equals("Subject Name")) {
            subjectName.setText("");
            subjectName.setForeground(Color.white);
        }


    }//GEN-LAST:event_subjectNameFocusGained

    private void subjectNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_subjectNameFocusLost
        // TODO add your handling code here:

        if (subjectName.getText().equals("")) {
            subjectName.setText("Subject Name");
            subjectName.setForeground(new Color(102, 102, 102));
        }

    }//GEN-LAST:event_subjectNameFocusLost

    private void subjectNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subjectNameActionPerformed

    private void subjectCodeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_subjectCodeFocusGained
        // TODO add your handling code here:

        if (subjectCode.getText().equals("Subject Code")) {
            subjectCode.setText("");
            subjectCode.setForeground(Color.white);
        }


    }//GEN-LAST:event_subjectCodeFocusGained

    private void subjectCodeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_subjectCodeFocusLost
        // TODO add your handling code here:

        if (subjectCode.getText().equals("")) {
            subjectCode.setText("Subject Code");
            subjectCode.setForeground(new Color(102, 102, 102));
        }

    }//GEN-LAST:event_subjectCodeFocusLost

    private void subjectCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subjectCodeActionPerformed

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
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if (isLoggedIn()) {

                    new AdminHome().setVisible(true);
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

    private void getAllSubs() {
        if (isLoggedIn()) {
            try {
                Connection connection = dbConnection.ConnectDB();
                PreparedStatement pst;
                pst = connection.prepareStatement("Select * from Subject ");

                ResultSet rs = pst.executeQuery();

                Object[] rows = new Object[]{"NONE"};

                int counter = 1;
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
                UpdateSubject4.setModel(new javax.swing.DefaultComboBoxModel(rows));
                UpdateSubject5.setModel(new javax.swing.DefaultComboBoxModel(rows));
                UpdateSubject6.setModel(new javax.swing.DefaultComboBoxModel(rows));

            } catch (SQLException ex) {
                Logger.getLogger(TeacherHome.class.getName()).log(Level.SEVERE, null, ex);

            }

        } else {
            String[] options = {"Login", "Exit"};
            ImageIcon image = new ImageIcon(getClass().getResource("/Images/teacher (3).png"));
            int a = JOptionPane.showOptionDialog(null, "you must login as Admin first!", "Login or Exit!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, image, options, 0);
            if (a == 0 || a == -1) {
                setVisible(false);
                new TeacherLogin().setVisible(true);
            } else if (a == 1) {
                System.exit(0);

            }
        }
    }

    public void studentEnabled(boolean b) {
        UpdateName.setEnabled(b);
        UpdateEmail.setEnabled(b);
        updateAge.setEnabled(b);
        UpdatepwdTeacher.setEnabled(b);
        UpdatepwdTeacherRewrite.setEnabled(b);
        updatePhoneNumber.setEnabled(b);
        UpdateSubject1.setEnabled(b);
        UpdateSubject2.setEnabled(b);
        UpdateSubject3.setEnabled(b);
        updateStudent.setEnabled(b);
//        addStudent.setEnabled(b);
        deleteStudent.setEnabled(b);
        boxShowPwd.setEnabled(b);
    }

    public void teacherEnabled(boolean b) {
        UpdateName1.setEnabled(b);
        UpdateEmail1.setEnabled(b);
        UpdatepwdTeacher1.setEnabled(b);
        UpdatepwdTeacherRewrite1.setEnabled(b);
        UpdateSubject4.setEnabled(b);
        UpdateSubject5.setEnabled(b);
        UpdateSubject6.setEnabled(b);
        UpdateTeacherButton.setEnabled(b);
        deleteTeacher.setEnabled(b);
        boxShowPwd1.setEnabled(b);
    }

    public void subjectEnabled(boolean b) {
        updateSubjectCode.setEnabled(b);
        updateSubjectName.setEnabled(b);
    }

    public void setDefaultS() {
        updateAge.setText("Change Age");
        updatePhoneNumber.setText("Change PhoneNumber");
        UpdateEmail.setText("Change Email");
        UpdatepwdTeacherRewrite.setText("New Password");
        UpdatepwdTeacher.setText("Rewrite Password");
        UpdateName.setText("Change Name");
        UpdateSubject1.setSelectedItem("NONE");
        UpdateSubject2.setSelectedItem("NONE");
        UpdateSubject3.setSelectedItem("NONE");
    }

    public void setDefaultT() {
        UpdateEmail1.setText("Change Email");
        UpdatepwdTeacherRewrite1.setText("New Password");
        UpdatepwdTeacher1.setText("Rewrite Password");
        UpdateName1.setText("Change Name");
        UpdateSubject4.setSelectedItem("NONE");
        UpdateSubject5.setSelectedItem("NONE");
        UpdateSubject6.setSelectedItem("NONE");
    }

    public void setDefaultSub() {
        updateSubjectCode.setText("Update Subject Code");
        updateSubjectName.setText("Update Subject Name");
        subjectName.setText("Subject Name");
        subjectCode.setText("Subject Code");

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField UpdateEmail;
    private javax.swing.JTextField UpdateEmail1;
    private javax.swing.JTextField UpdateName;
    private javax.swing.JTextField UpdateName1;
    private javax.swing.JTextField UpdateName2;
    private javax.swing.JComboBox<String> UpdateSubject1;
    private javax.swing.JComboBox<String> UpdateSubject2;
    private javax.swing.JComboBox<String> UpdateSubject3;
    private javax.swing.JComboBox<String> UpdateSubject4;
    private javax.swing.JComboBox<String> UpdateSubject5;
    private javax.swing.JComboBox<String> UpdateSubject6;
    private javax.swing.JButton UpdateTeacherButton;
    private javax.swing.JPasswordField UpdatepwdTeacher;
    private javax.swing.JPasswordField UpdatepwdTeacher1;
    private javax.swing.JPasswordField UpdatepwdTeacher2;
    private javax.swing.JPasswordField UpdatepwdTeacherRewrite;
    private javax.swing.JPasswordField UpdatepwdTeacherRewrite1;
    private javax.swing.JPasswordField UpdatepwdTeacherRewrite2;
    private javax.swing.JButton addStudent;
    private javax.swing.JButton addSubject;
    private javax.swing.JButton addTeacher;
    private javax.swing.JTextField adminName;
    private javax.swing.JTextField adminUserName;
    private javax.swing.JButton alterStudents;
    private javax.swing.JButton alterSubjects;
    private javax.swing.JButton alterTeacher;
    private javax.swing.JCheckBox boxShowPwd;
    private javax.swing.JCheckBox boxShowPwd1;
    private javax.swing.JCheckBox boxShowPwd2;
    private javax.swing.JButton closeApplication;
    private javax.swing.JButton deleteStudent;
    private javax.swing.JButton deleteSubject;
    private javax.swing.JButton deleteTeacher;
    private javax.swing.JButton goBackButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JButton logout;
    private javax.swing.JButton profile;
    private CustomComponent.TableTextCenter studentTable;
    private javax.swing.JTextField subjectCode;
    private javax.swing.JTextField subjectName;
    private CustomComponent.TableTextCenter subjectTable;
    private CustomComponent.TableTextCenter teacherTable;
    private javax.swing.JButton updateAdmin;
    private javax.swing.JTextField updateAge;
    private javax.swing.JTextField updatePhoneNumber;
    private javax.swing.JButton updateStudent;
    private javax.swing.JButton updateSubject;
    private javax.swing.JTextField updateSubjectCode;
    private javax.swing.JTextField updateSubjectName;
    private javax.swing.JTextField updateUserName;
    // End of variables declaration//GEN-END:variables
}
