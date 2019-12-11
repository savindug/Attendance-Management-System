/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

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

                System.out.println("User id \tUsername \tGender \t\tCreateDate \t\t\tLastLoggedIn");
                System.out.println("_____________________________________________________________________________________________________");
                System.out.println("");
                

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
                e.printStackTrace();
            }

        return rs;
    }
    
}
