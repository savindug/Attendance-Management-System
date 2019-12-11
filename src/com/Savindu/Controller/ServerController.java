/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Savindu.Controller;

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

               String sql = "select * from Employees";

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
        
//         public void displayLeaveList(){
//            
//            ArrayList<User> uList = new ArrayList<>();
//            Controller ut = new Controller();
//            uList = ut.leaveList();
//        
//             String INSERT_USERS_SQL = "INSERT INTO Employees" +
//            "  (userId, UserName, Gender, CreateDate) VALUES " +
//            " (?, ?, ?, ?);";
//        
//        for(int i=0; i<uList.size(); i++){
//            row[0] = uList.get(i).getuID().toString();
//            row[1] = uList.get(i).getuName().toString();
//            row[2] = uList.get(i).getLeaveStart().toString();
//            row[3] = uList.get(i).getLeaveEnd().toString();
//            row[4] = uList.get(i).getLeaveSubmitted().toString();
//            row[5] = uList.get(i).getLeaveRemark().toString();
//            
//        }
//        
//    }


    
//     public static void main(String args[]) {
//         ServerController ss = new ServerController();
//        ss.insertUserList();
//    }
        
    }
        
