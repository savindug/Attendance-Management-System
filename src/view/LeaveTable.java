/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.Savindu.Entity.User;
import com.Savindu.Util.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Savindu
 */
public class LeaveTable extends javax.swing.JFrame {

    /**
     * Creates new form LeaveTable
     */
    public LeaveTable() {
        initComponents();
        displayLeaveList();
    }

     public ArrayList<User> leaveList(){
        
        ArrayList<User> leaveList = new ArrayList<>();
        
        Connection connection = null;
        ResultSet rs = null;
        Statement st = null;
        User leave;
        
        //sql query
        String sql = "  select usr.pin, usr.UserName, att.FromDate, att.ToDate, att.LastUpdatedDate, att.Remark  from \n" +
                     "  ras_AttLeaveRecord att\n" +
                     "  inner join ras_Users usr \n" +
                     "  on att.UID = usr.UID \n"+
                     "  order by usr.PIN";
        
            
            try{
                connection = DBConnection.openConnection();
                st = connection.createStatement();
                rs = st.executeQuery(sql);

                System.out.println("User id \tUsername \tFromDate \t\tToDate \t\t\tLeaveSubmitted \t\tRemark");
                System.out.println("_____________________________________________________________________________________________________");
                System.out.println("");
                while(rs.next()){
                    leave = new User();
                    leave.setuID(rs.getString(1));
                    leave.setuName(rs.getString(2));
                    leave.setLeaveStart(rs.getString(3));
                    leave.setLeaveEnd(rs.getString(4));
                    leave.setLeaveSubmitted(rs.getString(5));
                    leave.setLeaveRemark(rs.getString(6));
                    leaveList.add(leave);
                    System.out.println(leave.getuID()+"\t\t"+leave.getuName()+"\t\t"+leave.getLeaveStart()+"\t\t"+leave.getLeaveEnd()+"\t\t"+leave.getLeaveSubmitted()+"\t\t"+leave.getLeaveRemark());

                }

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
                e.printStackTrace();
            }

        return leaveList;
    }
    
    public void displayLeaveList(){
        
        ArrayList<User> uList = leaveList();
        DefaultTableModel tblModel = (DefaultTableModel)Table_User.getModel();
        
        Object[] row = new Object[6];
        
        for(int i=0; i<uList.size(); i++){
            row[0] = uList.get(i).getuID().toString();
            row[1] = uList.get(i).getuName().toString();
            row[2] = uList.get(i).getLeaveStart().toString();
            row[3] = uList.get(i).getLeaveEnd().toString();
            row[4] = uList.get(i).getLeaveSubmitted().toString();
            row[5] = uList.get(i).getLeaveRemark().toString();
            tblModel.addRow(row);
        }
        
    }
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Table_User = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Table_User.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User ID", "User Name", "Leave Start on", "Leave End on", "Submitted on", "Remark"
            }
        ));
        jScrollPane1.setViewportView(Table_User);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(LeaveTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LeaveTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LeaveTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LeaveTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LeaveTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table_User;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
