/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.persistence.Query;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import model.empmodel;
import service.empservice;

/**
 *
 * @author Nuwanga
 */
public class AppInterface extends javax.swing.JFrame {

    /**
     * Creates new form AppInterface
     */
    private static String branchname;
    public AppInterface() {
        initComponents();
    }
    
    public AppInterface(String branchname) {
        initComponents();
        this.branchname = branchname;
    }
    
    void viewPanel(String cname) {
        CardLayout cL = (CardLayout) jPanel3.getLayout();
        cL.show(jPanel3, cname);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        btnviewreports = new javax.swing.JButton();
        btnaddreports = new javax.swing.JButton();
        btnchangesettings = new javax.swing.JButton();
        btnmainmenu = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        mainmenucard = new javax.swing.JPanel();
        mainmenuvr = new javax.swing.JButton();
        mainmenuar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        addreportscard = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        viewreportscard = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        viewreportmonth = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        viewreportyear = new javax.swing.JComboBox<>();
        btnsearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablevr = new javax.swing.JTable();
        btngeneratepdf = new javax.swing.JButton();
        changesettingscard = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        settingsun = new javax.swing.JTextField();
        settingscpw = new javax.swing.JPasswordField();
        btnconfirm = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        changepwerror = new javax.swing.JLabel();
        settingsnpw = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1885, 990));
        setPreferredSize(new java.awt.Dimension(1885, 990));

        jPanel1.setBackground(new java.awt.Color(6, 10, 34));
        jPanel1.setPreferredSize(new java.awt.Dimension(265, 990));

        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 4));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/agrilogotrans.png"))); // NOI18N

        btnviewreports.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/viewr.png"))); // NOI18N
        btnviewreports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnviewreportsActionPerformed(evt);
            }
        });

        btnaddreports.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Addr.png"))); // NOI18N
        btnaddreports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddreportsActionPerformed(evt);
            }
        });

        btnchangesettings.setBackground(new java.awt.Color(204, 204, 204));
        btnchangesettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setting.png"))); // NOI18N
        btnchangesettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchangesettingsActionPerformed(evt);
            }
        });

        btnmainmenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/menu.png"))); // NOI18N
        btnmainmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmainmenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnchangesettings, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnviewreports, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnaddreports, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnmainmenu, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 1, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135)
                .addComponent(btnmainmenu, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(btnaddreports, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(btnviewreports, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(btnchangesettings, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(6, 10, 34));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 71)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Department of Agrarian Development - Galle");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 102, 51));
        jPanel3.setLayout(new java.awt.CardLayout());

        mainmenucard.setBackground(new java.awt.Color(255, 255, 51));

        mainmenuvr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/viewreportbutton.png"))); // NOI18N
        mainmenuvr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainmenuvrActionPerformed(evt);
            }
        });

        mainmenuar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttonadddata.png"))); // NOI18N
        mainmenuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainmenuarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("View Reports");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Add Reports");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setText("Main Menu");

        javax.swing.GroupLayout mainmenucardLayout = new javax.swing.GroupLayout(mainmenucard);
        mainmenucard.setLayout(mainmenucardLayout);
        mainmenucardLayout.setHorizontalGroup(
            mainmenucardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainmenucardLayout.createSequentialGroup()
                .addGroup(mainmenucardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainmenucardLayout.createSequentialGroup()
                        .addGap(322, 322, 322)
                        .addComponent(mainmenuvr))
                    .addGroup(mainmenucardLayout.createSequentialGroup()
                        .addGap(392, 392, 392)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(mainmenucardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainmenucardLayout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(mainmenuar))
                    .addGroup(mainmenucardLayout.createSequentialGroup()
                        .addGap(350, 350, 350)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(371, 371, 371))
            .addGroup(mainmenucardLayout.createSequentialGroup()
                .addGap(705, 705, 705)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainmenucardLayout.setVerticalGroup(
            mainmenucardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainmenucardLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129)
                .addGroup(mainmenucardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mainmenuar, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                    .addComponent(mainmenuvr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addGroup(mainmenucardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(374, Short.MAX_VALUE))
        );

        jPanel3.add(mainmenucard, "mainmenucard");

        addreportscard.setBackground(new java.awt.Color(102, 255, 51));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setText("Add Reports");

        javax.swing.GroupLayout addreportscardLayout = new javax.swing.GroupLayout(addreportscard);
        addreportscard.setLayout(addreportscardLayout);
        addreportscardLayout.setHorizontalGroup(
            addreportscardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addreportscardLayout.createSequentialGroup()
                .addGap(664, 664, 664)
                .addComponent(jLabel13)
                .addContainerGap(801, Short.MAX_VALUE))
        );
        addreportscardLayout.setVerticalGroup(
            addreportscardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addreportscardLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(868, Short.MAX_VALUE))
        );

        jPanel3.add(addreportscard, "addreportscard");

        viewreportscard.setBackground(new java.awt.Color(51, 255, 255));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel12.setText("View Reports");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel14.setText("Month");

        viewreportmonth.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        viewreportmonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" }));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel15.setText("Year");

        viewreportyear.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        viewreportyear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045" }));

        btnsearch.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnsearch.setText("Search");

        tablevr.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablevr);

        btngeneratepdf.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btngeneratepdf.setText("Generate PDF Report");

        javax.swing.GroupLayout viewreportscardLayout = new javax.swing.GroupLayout(viewreportscard);
        viewreportscard.setLayout(viewreportscardLayout);
        viewreportscardLayout.setHorizontalGroup(
            viewreportscardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewreportscardLayout.createSequentialGroup()
                .addGroup(viewreportscardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewreportscardLayout.createSequentialGroup()
                        .addGap(670, 670, 670)
                        .addComponent(jLabel12))
                    .addGroup(viewreportscardLayout.createSequentialGroup()
                        .addGap(309, 309, 309)
                        .addGroup(viewreportscardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 954, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(viewreportscardLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(viewreportmonth, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(195, 195, 195)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(viewreportyear, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(227, 227, 227)
                                .addComponent(btnsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(viewreportscardLayout.createSequentialGroup()
                        .addGap(643, 643, 643)
                        .addComponent(btngeneratepdf, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(348, Short.MAX_VALUE))
        );
        viewreportscardLayout.setVerticalGroup(
            viewreportscardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewreportscardLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(viewreportscardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(viewreportscardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnsearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(viewreportmonth, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, viewreportscardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(viewreportyear, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(btngeneratepdf, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(241, Short.MAX_VALUE))
        );

        jPanel3.add(viewreportscard, "viewreportscard");

        changesettingscard.setBackground(new java.awt.Color(255, 204, 204));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Change Password");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("About Software");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel7.setText("Username");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel8.setText("Current Password");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel9.setText("New Password");

        settingsun.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        settingscpw.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        btnconfirm.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnconfirm.setText("Confirm");
        btnconfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconfirmActionPerformed(evt);
            }
        });

        jLabel10.setText("Data about software maintainance and development");

        changepwerror.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        changepwerror.setForeground(new java.awt.Color(255, 0, 51));

        settingsnpw.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        javax.swing.GroupLayout changesettingscardLayout = new javax.swing.GroupLayout(changesettingscard);
        changesettingscard.setLayout(changesettingscardLayout);
        changesettingscardLayout.setHorizontalGroup(
            changesettingscardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changesettingscardLayout.createSequentialGroup()
                .addGroup(changesettingscardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(changesettingscardLayout.createSequentialGroup()
                        .addGap(639, 639, 639)
                        .addComponent(jLabel5))
                    .addGroup(changesettingscardLayout.createSequentialGroup()
                        .addGap(456, 456, 456)
                        .addGroup(changesettingscardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(changesettingscardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(settingsun, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                            .addComponent(settingscpw)
                            .addComponent(settingsnpw)))
                    .addGroup(changesettingscardLayout.createSequentialGroup()
                        .addGap(649, 649, 649)
                        .addGroup(changesettingscardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnconfirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(changesettingscardLayout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 1273, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(changesettingscardLayout.createSequentialGroup()
                        .addGap(584, 584, 584)
                        .addComponent(changepwerror, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(180, Short.MAX_VALUE))
        );
        changesettingscardLayout.setVerticalGroup(
            changesettingscardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changesettingscardLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(changesettingscardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(settingsun, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addGroup(changesettingscardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(settingscpw, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(changesettingscardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(settingsnpw))
                .addGap(39, 39, 39)
                .addComponent(btnconfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(changepwerror, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(277, Short.MAX_VALUE))
        );

        jPanel3.add(changesettingscard, "changesettingscard");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1136, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnmainmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmainmenuActionPerformed
        // TODO add your handling code here:
        viewPanel("mainmenucard");
    }//GEN-LAST:event_btnmainmenuActionPerformed

    private void btnviewreportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnviewreportsActionPerformed
        // TODO add your handling code here:
        viewPanel("viewreportscard");
    }//GEN-LAST:event_btnviewreportsActionPerformed

    private void btnchangesettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchangesettingsActionPerformed
        // TODO add your handling code here:
        viewPanel("changesettingscard");
    }//GEN-LAST:event_btnchangesettingsActionPerformed

    private void btnaddreportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddreportsActionPerformed
        // TODO add your handling code here:
        viewPanel("addreportscard");
    }//GEN-LAST:event_btnaddreportsActionPerformed

    private void mainmenuvrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainmenuvrActionPerformed
        // TODO add your handling code here:
        viewPanel("viewreportscard");
    }//GEN-LAST:event_mainmenuvrActionPerformed

    private void mainmenuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainmenuarActionPerformed
        // TODO add your handling code here:
        viewPanel("addreportscard");
    }//GEN-LAST:event_mainmenuarActionPerformed

    private void btnconfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconfirmActionPerformed
        // TODO add your handling code here:
        empmodel em = new empmodel();
        em.setBranchname(branchname);
        em.setUsername(settingsun.getText());
        em.setPassword(settingscpw.getText());
        em.setNewpassword(settingsnpw.getText());
        
        empservice es = new empservice();
        
        Boolean status = es.changepw(em);
      
      if (status == true){
          viewPanel("mainmenucard");
      }else{
          changepwerror.setText("Username or Password Incorrect");
          
      }
    }//GEN-LAST:event_btnconfirmActionPerformed

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
            java.util.logging.Logger.getLogger(AppInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addreportscard;
    private javax.swing.JButton btnaddreports;
    private javax.swing.JButton btnchangesettings;
    private javax.swing.JButton btnconfirm;
    private javax.swing.JButton btngeneratepdf;
    private javax.swing.JButton btnmainmenu;
    private javax.swing.JButton btnsearch;
    private javax.swing.JButton btnviewreports;
    private javax.swing.JLabel changepwerror;
    private javax.swing.JPanel changesettingscard;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton mainmenuar;
    private javax.swing.JPanel mainmenucard;
    private javax.swing.JButton mainmenuvr;
    private javax.swing.JPasswordField settingscpw;
    private javax.swing.JTextField settingsnpw;
    private javax.swing.JTextField settingsun;
    private javax.swing.JTable tablevr;
    private javax.swing.JComboBox<String> viewreportmonth;
    private javax.swing.JPanel viewreportscard;
    private javax.swing.JComboBox<String> viewreportyear;
    // End of variables declaration//GEN-END:variables

   
    
}
