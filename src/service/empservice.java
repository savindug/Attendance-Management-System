/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
}
