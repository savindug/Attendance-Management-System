/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Savindu.Controller;

import com.Savindu.Entity.Attendance;
import com.Savindu.Entity.User;
import com.Savindu.Util.ServerConnection;
import static com.Savindu.Util.ServerConnection.openConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Savindu
 */
public class ServerController {
    
        Connection connection = null;
        ResultSet rs = null;
        Statement st = null;
        int result = 0;
        
   
        
        public void insertUserList(){
      
            ArrayList<User> uList = new ArrayList<>();
            Controller ut = new Controller();
            uList = ut.userList();

            String INSERT_USERS_SQL = "INSERT INTO Employees" +
            "  (userId, UserName, Gender, CreateDate) VALUES " +
            " (?, ?, ?, ?);";
    
            try{
                connection = ServerConnection.openConnection();

                 for(int i=0; i<uList.size(); i++){
                    PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);

                    preparedStatement.setString(1, uList.get(i).getuID().toString());
                    preparedStatement.setString(2, uList.get(i).getuName().toString());
                    preparedStatement.setString(3, uList.get(i).getGender().toString());
                    preparedStatement.setString(4, uList.get(i).getCreateDate().toString());

                     System.out.println(preparedStatement);
                    // Step 3: Execute the query or update query
                    result = preparedStatement.executeUpdate(); 

                 }
                 
                  if(result > 0){
                        JOptionPane.showMessageDialog(null, "Records Successfully Updated!");
                    }

            }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                    e.printStackTrace();
                }

    }
        
        public ResultSet getemployees(){
               
               Connection connection = null;
               ResultSet rs = null;
               Statement st = null;

               String sql = "select * from Employees group by userId";

                   try{
                       connection = ServerConnection.openConnection();
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
        
            public void insertAttList(){
      
            ArrayList<Attendance> attL = new ArrayList<>();
            Controller ut = new Controller();
            attL = ut.getattL();

            String INSERT_USERS_SQL = "INSERT INTO attendnce" +
            "  (pin, uname, depart, clock, remark) VALUES " +
            " (?, ?, ?, ?, ?);";
    
            try{
                connection = ServerConnection.openConnection();

                 for(int i=0; i<attL.size(); i++){
                    PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);

                    preparedStatement.setString(1, attL.get(i).getuId().toString());
                    preparedStatement.setString(2, attL.get(i).getuName().toString());
                    preparedStatement.setString(3, attL.get(i).getDepart().toString());
                    preparedStatement.setString(4, attL.get(i).getAttTime().toString());
                    preparedStatement.setString(5, attL.get(i).getRemark().toString());

                     System.out.println(preparedStatement);
                    // Step 3: Execute the query or update query
                    result = preparedStatement.executeUpdate(); 

                 }
                 
                  if(result > 0){
                        JOptionPane.showMessageDialog(null, "Records Successfully Updated!");
                    }

            }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                    e.printStackTrace();
                }

    }
            
             public ResultSet getAttList(){
               
               Connection connection = null;
               ResultSet rs = null;
               Statement st = null;

               String sql = "select * from attendnce group by pin";

                   try{
                       connection = ServerConnection.openConnection();
                       st = connection.createStatement();
                       rs = st.executeQuery(sql);

                       System.out.println("success attendance record retrive");


                   }catch(Exception e){
                       JOptionPane.showMessageDialog(null, e);
                       e.printStackTrace();
                   }

               return rs;
        
         }

                public void insertLeaveList(){
      
            ArrayList<User> leaveL = new ArrayList<>();
            Controller ut = new Controller();
            leaveL = ut.leaveList();

            String INSERT_USERS_SQL = "INSERT INTO leaves" +
            "  (pin, uname, fromDtae, toDate, leaveSubmitted) VALUES " +
            " (?, ?, ?, ?, ?);";
    
            try{
                connection = ServerConnection.openConnection();

                 for(int i=0; i<leaveL.size(); i++){
                    PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);

                    preparedStatement.setString(1, leaveL.get(i).getuID().toString());
                    preparedStatement.setString(2, leaveL.get(i).getuName().toString());
                    preparedStatement.setString(3, leaveL.get(i).getLeaveStart().toString());
                    preparedStatement.setString(4, leaveL.get(i).getLeaveEnd().toString());
                    preparedStatement.setString(5, leaveL.get(i).getLeaveSubmitted().toString());

                     System.out.println(preparedStatement);
                    // Step 3: Execute the query or update query
                    result = preparedStatement.executeUpdate(); 

                 }
                 
                  if(result > 0){
                        JOptionPane.showMessageDialog(null, "Records Successfully Updated!");
                    }

            }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                    e.printStackTrace();
                }

    }
//                
//                public void displayLeaveList(){
//        
//       ArrayList<User> ll = new ArrayList<>();
//            Controller ut = new Controller();
//            ll = ut.leaveList();
//        
//        for(int i=0; i<uList.size(); i++){
//            row[0] = uList.get(i).getuID().toString();
//            row[1] = uList.get(i).getuName().toString();
//            row[2] = uList.get(i).getLeaveStart().toString();
//            row[3] = uList.get(i).getLeaveEnd().toString();
//            row[4] = uList.get(i).getLeaveSubmitted().toString();
//            row[5] = uList.get(i).getLeaveRemark().toString();
//            tblModel.addRow(row);
//        }
//        
//    }

    
//     public static void main(String args[]) {
//         ServerController ss = new ServerController();
//        ss.insertUserList();
//    }
        
    }
        
