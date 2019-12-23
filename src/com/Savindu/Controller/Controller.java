/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Savindu.Controller;
import com.Savindu.Entity.Attendance;
import com.Savindu.Entity.User;
import com.Savindu.Util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Savindu
 */
public class Controller {

       
    public ArrayList<User> userList(){
        
        ArrayList<User> userList = new ArrayList<>();
        
        Connection connection = null;
        ResultSet rs = null;
        Statement st = null;
        User user;
        
        //sql query
        String sql = "select * from ras_Users";
            
            try{
                connection = DBConnection.openConnection();
                st = connection.createStatement();
                rs = st.executeQuery(sql);

                System.out.println("User id \tUsername \tGender \t\tCreateDate \t\t\tLastLoggedIn");
                System.out.println("_____________________________________________________________________________________________________");
                System.out.println("");
                while(rs.next()){
                    user = new User();
                    user.setuID(rs.getString(3));
                    user.setuName(rs.getString(4));
                    user.setGender(rs.getString(5));
                    user.setCreateDate(rs.getString(11));
                    user.setLastLoggedIn(rs.getString(12));
                    userList.add(user);
                    System.out.println(user.getuID()+"\t\t"+user.getuName()+"\t\t"+user.getGender()+"\t\t"+user.getCreateDate()+"\t\t"+user.getLastLoggedIn());

                }

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
                e.printStackTrace();
            }

        return userList;
    }
    
     public ArrayList<Attendance> getattL(){
       Connection connection = null;
        ResultSet rs = null;
        Statement st = null;
       Attendance att;
        ArrayList<Attendance> attL = new ArrayList<>();
        
        String sql = "  select u.PIN, u.UserName, d.DeptName, a.Clock, a.Remark  from \n" +
                     "  ras_AttRecord a, ras_Dept d, ras_Users u \n" +
                     "  where d.DeptId = u.DeptId and u.UID = a.ID ";
                     //"  order by usr.PIN";
//                     
                     //String sql = "select * from ras_AttRecord group by pin";
            
            try{
                connection = DBConnection.openConnection();
                st = connection.createStatement();
                rs = st.executeQuery(sql);     
                
                while(rs.next()){
                    att = new Attendance();
                    att.setuId(rs.getString(1));
                    att.setuName(rs.getString(2));
                    att.setDepart(rs.getString(3));
                    att.setAttTime(rs.getString(4));
                    att.setRemark(rs.getString(5));
                    attL.add(att);
                    //System.out.println(user.getuID()+"\t\t"+user.getuName()+"\t\t"+user.getGender()+"\t\t"+user.getCreateDate()+"\t\t"+user.getLastLoggedIn());

                }
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
                e.printStackTrace();
            }

            System.out.println(rs);
        return attL;
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
    
 

}

