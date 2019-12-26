/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.Savindu.Controller.ServerController;
import com.Savindu.Entity.User;
import java.sql.Connection;
import com.Savindu.Util.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.empmodel;
import util.DBConnect;

/**
 *
 * @author Nuwanga
 */
public class empservice {
    
     private static Connection con;
     private PreparedStatement ps,ps1;
     
     
     public boolean validateuser(empmodel em){
         
        con = DBConnect.connect();
        boolean status = false;
        ResultSet rs;
        String un = null;
        String pw = null;
        try {           
            
            ps = con.prepareStatement("Select username,password from users where branchname = ?");
            ps.setString(1, em.getBranchname());
            rs = ps.executeQuery();
            
           
         
           
            while(rs.next()){
                un = rs.getString(1);
              
                pw = rs.getString(2);
            }
            
           
            if(un.equals(em.getUsername()) && pw.equals(em.getPassword())){
                status = true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(empservice.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
         
     }
     
     public boolean changepw(empmodel em){
         
        con = DBConnect.connect();
        boolean status = false;
        ResultSet rs;
        String un = null;
        String pw = null;
        try {           
            
            ps = con.prepareStatement("Select username,password from users where branchname = ?");
            ps.setString(1, em.getBranchname());
            rs = ps.executeQuery();
            
           
         
           
            while(rs.next()){
                un = rs.getString(1);
              
                pw = rs.getString(2);
            }
            
           
            if(un.equals(em.getUsername()) && pw.equals(em.getPassword())){
                
                ps1 = con.prepareStatement("update users set password = ? where branchname = ?");
                    ps1.setString(1,em.getNewpassword());
                    ps1.setString(2,em.getBranchname());
                    int row = ps1.executeUpdate();
                    
                    if(row != 0){
                        status = true;
                    }
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(empservice.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return status;
         
     }
     
     
     public boolean changeun(empmodel em){
         
        con = DBConnect.connect();
        boolean status = false;
        ResultSet rs;
        String un = null;
        String pw = null;
        try {           
            
            ps = con.prepareStatement("Select password from users where branchname = ?");
            ps.setString(1, em.getBranchname());
            rs = ps.executeQuery();
            
           
         
           
            while(rs.next()){
                pw = rs.getString(1);
              
            }
            
           
            if( pw.equals(em.getPassword())){
                
                ps1 = con.prepareStatement("update users set username = ? where branchname = ?");
                    ps1.setString(1,em.getNewusername());
                    ps1.setString(2,em.getBranchname());
                    int row = ps1.executeUpdate();
                    
                    if(row != 0){
                        status = true;
                    }
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(empservice.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return status;
         
     }
     
     
     public ResultSet viewemployees(empmodel em){
         
        con = DBConnect.connect();
       
        ResultSet rs = null;
        
        try {           
            
            ps = con.prepareStatement("Select userId, UserName, Gender, deptName, branchName from Employees where branchname = ? Order by userId");
            ps.setString(1, em.getSearchbranchname());
            rs = ps.executeQuery();
            
           
        } catch (SQLException ex) {
            Logger.getLogger(empservice.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        return rs;
         
     }
     
     
     public ResultSet viewatt(empmodel em){
         
        con = DBConnect.connect();
       
        ResultSet rs = null;
        
        try {           
            
            ps = con.prepareStatement("Select a.userId, a.UserName, a.branchName, e.deptName, a.clock, a.remarks from \n"
                    + "Employees e, Attendance a \n"
                    + "where a.userId = e.userId and a.branchname = ? and a.clock like ? \n"
                    + "Order by a.clock");
            ps.setString(1, em.getSearchbranchname());
            ps.setString(2, em.getSearchyear().toString()+"-"+em.getSearchmonth().toString()+"%");
            rs = ps.executeQuery();
            
           
        } catch (SQLException ex) {
            Logger.getLogger(empservice.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        return rs;
         
     }
     
     public ResultSet viewleave(empmodel em){
         
        con = DBConnect.connect();
       
        ResultSet rs = null;
        
        try {           
            
            ps = con.prepareStatement("Select l.userId, l.UserName, l.branchName, e.deptName, l.submittedDate, l.fromDtae ,l.toDate ,l.remarks \n"
                    + " from Employees e, Leaves l\n"
                    + "where l.userId = e.userId and l.branchname = ? and l.submittedDate like ? \n"
                    + "Order by l.submittedDate");
            ps.setString(1, em.getSearchbranchname());
            ps.setString(2, em.getSearchyear().toString()+"-"+em.getSearchmonth().toString()+"%");
            rs = ps.executeQuery();
            
           
        } catch (SQLException ex) {
            Logger.getLogger(empservice.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        return rs;
         
     }
     
     public ResultSet getemployees(){
        Connection connection = null;
        ResultSet rs = null;
        Statement st = null;
        
        String sql = "select * from ras_Users";
            
            try{
                connection = DBConnection.openConnection();
                st = connection.createStatement();
                rs = st.executeQuery(sql);

                System.out.println("User id \tUsername \tGender \t\tCreateDate \t\t\tLastLoggedIn");
                System.out.println("_____________________________________________________________________________________________________");
                System.out.println("");
                

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
                e.printStackTrace();
            }
       
        return rs;
        
    }
     
     public ResultSet getleave(){
       Connection connection = null;
        ResultSet rs = null;
        Statement st = null;
        
        String sql = "  select usr.pin, usr.UserName, att.FromDate, att.ToDate, att.LastUpdatedDate, att.Remark  from \n" +
                     "  ras_AttLeaveRecord att\n" +
                     "  inner join ras_Users usr \n" +
                     "  on att.UID = usr.UID \n"+
                     "  order by usr.PIN";
            
            try{
                connection = DBConnection.openConnection();
                st = connection.createStatement();
                rs = st.executeQuery(sql);

                

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
                e.printStackTrace();
            }
        
        return rs;
    }
    
      public ResultSet getatt(){
       Connection connection = null;
        ResultSet rs = null;
        Statement st = null;
        
      String sql = "  select u.PIN, u.UserName, d.DeptName, a.Clock, a.Remark  from \n" +
                    "  ras_AttRecord a, ras_Dept d, ras_Users u \n" +
                  "  where d.DeptId = u.DeptId and u.UID = a.ID ";
                    /*"  order by usr.PIN";*/
                     
                    /* String sql = "select * from ras_AttRecord";*/
            
            try{
                connection = DBConnection.openConnection();
                st = connection.createStatement();
                rs = st.executeQuery(sql);     

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
                e.printStackTrace();
            }

            System.out.println(rs);
           
        return rs;
    }
}
