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
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
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
        
   
        
        public void insertUserList(String Branchname){
            /*New Modifications done by Nuwanga, Repeats will not be repeated. Branch name will also be saved. Online table modified accordingly*/
            ArrayList<User> uList = new ArrayList<>();
            Controller ut = new Controller();
            uList = ut.userList();

            String INSERT_USERS_SQL = "INSERT INTO Employees" +
            "  (userId, UserName, Gender, deptName, branchName) VALUES " +
            " (?, ?, ?, ?,?);";
    
            try{
                connection = ServerConnection.openConnection();

                 for(int i=0; i<uList.size(); i++){
                    PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);

                    preparedStatement.setString(1, uList.get(i).getuID().toString());
                    preparedStatement.setString(2, uList.get(i).getuName().toString());
                    preparedStatement.setString(3, uList.get(i).getGender().toString());
                    preparedStatement.setString(4, uList.get(i).getUserdepart().toString());
                    preparedStatement.setString(5, Branchname);

                     System.out.println(preparedStatement);
                    // Step 3: Execute the query or update query
                    result = preparedStatement.executeUpdate(); 

                 }
                 
                  if(result > 0){
                        JOptionPane.showMessageDialog(null, "Records Updated!");
                    }

            }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Records Updated!");
                    
                }
             try { connection.close(); } catch (Exception e) { /* ignored */ }

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
                   try { connection.close(); } catch (Exception e) { /* ignored */ }

               return rs;
        }        
               
        public void viewreport(String path){
               
               Connection connection = null;
               ResultSet rs = null;
               PreparedStatement ps = null;

            try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(path + "\\Reports-Employees.pdf"));
            document.open();

            //com.itextpdf.text.Image image = com.itextpdf.text.Image.getInstance("E:\\netbeans\\itpfinal5.0\\itpproject\\src\\images\\Untitled-3.png");
            //document.add(new Paragraph("image"));
            //document.add(image);

            
            document.add(new Paragraph(new Date().toString()));
            document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));

            PdfPTable table = new PdfPTable(4);

            PdfPCell cell = new PdfPCell(new Paragraph("Report - Employees"));
            cell.setColspan(4);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.BLUE);
            table.addCell(cell);
            
            PdfPTable table1 = new PdfPTable(1);

            PdfPCell cell1 = new PdfPCell(new Paragraph("User ID"));
            cell.setColspan(1);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            //cell.setBackgroundColor(BaseColor.BLUE);
            table.addCell(cell1);
            
            PdfPTable table2 = new PdfPTable(1);

            PdfPCell cell2 = new PdfPCell(new Paragraph("User Name"));
            cell.setColspan(1);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            //cell.setBackgroundColor(BaseColor.BLUE);
            table.addCell(cell2);
            
            PdfPTable table3 = new PdfPTable(1);

            PdfPCell cell3 = new PdfPCell(new Paragraph("Gender"));
            cell.setColspan(1);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            //cell.setBackgroundColor(BaseColor.BLUE);
            table.addCell(cell3);
            
            PdfPTable table4 = new PdfPTable(1);

            PdfPCell cell4 = new PdfPCell(new Paragraph("Create Date"));
            cell.setColspan(1);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            //cell.setBackgroundColor(BaseColor.BLUE);
            table.addCell(cell4);
            
           
            
            
            
            
            String sql = "SELECT userId, UserName, Gender, CreateDate\n" +
                                "from Employees";
           connection = ServerConnection.openConnection();
           st = connection.createStatement();
           rs = st.executeQuery(sql);
            while (rs.next()) {
                table.addCell(Integer.toString(rs.getInt("userId")));
                table.addCell((rs.getString("UserName")));
                table.addCell(rs.getString("Gender"));
                table.addCell((rs.getString("CreateDate")));
             
            }
            //table.addCell("item7");
            document.add(table);
            
           

            document.close();
            //deleted from here
            
        } catch (Exception e) {

        }try { connection.close(); } catch (Exception e) { /* ignored */ }

         }
        
            public void insertAttList(String BranchName){
      
            ArrayList<Attendance> attL = new ArrayList<>();
            Controller ut = new Controller();
            attL = ut.getattL();

            String INSERT_USERS_SQL = "INSERT INTO Attendance" +
            "  (userId, userName, clock, remarks, branchName) VALUES " +
            " (?, ?, ?,?, ?);";
    
            try{
                connection = ServerConnection.openConnection();

                 for(int i=0; i<attL.size(); i++){
                    PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);

                    preparedStatement.setString(1, attL.get(i).getuId().toString());
                    preparedStatement.setString(2, attL.get(i).getuName().toString());
                    preparedStatement.setString(3, attL.get(i).getAttTime().toString());
                    preparedStatement.setString(4, attL.get(i).getRemark().toString());
                    preparedStatement.setString(5, BranchName);
                   
                    /*preparedStatement.setString(1, "23");
                    preparedStatement.setString(2, "fd");
                    preparedStatement.setString(3, "342");
                    preparedStatement.setString(4, "re");
                    preparedStatement.setString(5, BranchName);*/

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
            try { connection.close(); } catch (Exception e) { /* ignored */ }

    }
            
            
            
            public void viewreportatt(String path){
               
               Connection connection = null;
               ResultSet rs = null;
               PreparedStatement ps = null;

            try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(path + "\\Reports-Attendance.pdf"));
            document.open();

            //com.itextpdf.text.Image image = com.itextpdf.text.Image.getInstance("E:\\netbeans\\itpfinal5.0\\itpproject\\src\\images\\Untitled-3.png");
            //document.add(new Paragraph("image"));
            //document.add(image);

            
            document.add(new Paragraph(new Date().toString()));
            document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));

            PdfPTable table = new PdfPTable(5);

            PdfPCell cell = new PdfPCell(new Paragraph("Report - Attendance"));
            cell.setColspan(5);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.BLUE);
            table.addCell(cell);
            
            PdfPTable table1 = new PdfPTable(1);

            PdfPCell cell1 = new PdfPCell(new Paragraph("PIN"));
            cell.setColspan(1);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            //cell.setBackgroundColor(BaseColor.BLUE);
            table.addCell(cell1);
            
            PdfPTable table2 = new PdfPTable(1);

            PdfPCell cell2 = new PdfPCell(new Paragraph("User Name"));
            cell.setColspan(1);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            //cell.setBackgroundColor(BaseColor.BLUE);
            table.addCell(cell2);
            
            PdfPTable table3 = new PdfPTable(1);

            PdfPCell cell3 = new PdfPCell(new Paragraph("Department"));
            cell.setColspan(1);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            //cell.setBackgroundColor(BaseColor.BLUE);
            table.addCell(cell3);
            
            PdfPTable table4 = new PdfPTable(1);

            PdfPCell cell4 = new PdfPCell(new Paragraph("Clock"));
            cell.setColspan(1);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            //cell.setBackgroundColor(BaseColor.BLUE);
            table.addCell(cell4);
            
            PdfPTable table5 = new PdfPTable(1);

            PdfPCell cell5 = new PdfPCell(new Paragraph("Remark"));
            cell.setColspan(1);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            //cell.setBackgroundColor(BaseColor.BLUE);
            table.addCell(cell5);
            

            String sql = "SELECT pin, uname, depart, clock, remark\n" +
                                "from attendnce";
           connection = ServerConnection.openConnection();
           st = connection.createStatement();
           rs = st.executeQuery(sql);
            while (rs.next()) {
                table.addCell(Integer.toString(rs.getInt("pin")));
                table.addCell((rs.getString("uname")));
                table.addCell(rs.getString("depart"));
                table.addCell((rs.getString("clock")));
                table.addCell((rs.getString("remark")));
             
            }
            //table.addCell("item7");
            document.add(table);
            
           

            document.close();
            //deleted from here
            
        } catch (Exception e) {

        }
            try { connection.close(); } catch (Exception e) { /* ignored */ }

         }
  
           

                public void insertLeaveList(String BranchName){
                    
            ArrayList<User> leaveL = new ArrayList<>();
            Controller ut = new Controller();
            leaveL = ut.leaveList();

            String INSERT_USERS_SQL = "INSERT INTO Leaves" +
            "  (userId, userName, fromDtae, toDate, submittedDate, branchName, remarks) VALUES " +
            " (?, ?, ?, ?, ?,?,?);";
    
            try{
                connection = ServerConnection.openConnection();

                 for(int i=0; i<leaveL.size(); i++){
                    PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);

                    preparedStatement.setString(1, leaveL.get(i).getuID().toString());
                    preparedStatement.setString(2, leaveL.get(i).getuName().toString());
                    preparedStatement.setString(3, leaveL.get(i).getLeaveStart().toString());
                    preparedStatement.setString(4, leaveL.get(i).getLeaveEnd().toString());
                    preparedStatement.setString(5, leaveL.get(i).getLeaveSubmitted().toString());
                    preparedStatement.setString(6, BranchName);
                    preparedStatement.setString(7, leaveL.get(i).getLeaveRemark().toString());

                     System.out.println(preparedStatement);
                    // Step 3: Execute the query or update query
                    result = preparedStatement.executeUpdate(); 

                 }
                 
                  if(result > 0){
                        JOptionPane.showMessageDialog(null, "Records Updated!");
                    }

            }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Records Updated!");
                   
                }
            try { connection.close(); } catch (Exception e) { /* ignored */ }

    }
                
                
                 public void viewreportleave(String path){
               
               Connection connection = null;
               ResultSet rs = null;
               PreparedStatement ps = null;

            try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(path + "\\Reports-Leaves.pdf"));
            document.open();

            //com.itextpdf.text.Image image = com.itextpdf.text.Image.getInstance("E:\\netbeans\\itpfinal5.0\\itpproject\\src\\images\\Untitled-3.png");
            //document.add(new Paragraph("image"));
            //document.add(image);

            
            document.add(new Paragraph(new Date().toString()));
            document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));

            PdfPTable table = new PdfPTable(5);

            PdfPCell cell = new PdfPCell(new Paragraph("Report - Leaves"));
            cell.setColspan(5);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.BLUE);
            table.addCell(cell);
            
            PdfPTable table1 = new PdfPTable(1);

            PdfPCell cell1 = new PdfPCell(new Paragraph("PIN"));
            cell.setColspan(1);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            //cell.setBackgroundColor(BaseColor.BLUE);
            table.addCell(cell1);
            
            PdfPTable table2 = new PdfPTable(1);

            PdfPCell cell2 = new PdfPCell(new Paragraph("User Name"));
            cell.setColspan(1);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            //cell.setBackgroundColor(BaseColor.BLUE);
            table.addCell(cell2);
            
            PdfPTable table3 = new PdfPTable(1);

            PdfPCell cell3 = new PdfPCell(new Paragraph("From Date"));
            cell.setColspan(1);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            //cell.setBackgroundColor(BaseColor.BLUE);
            table.addCell(cell3);
            
            PdfPTable table4 = new PdfPTable(1);

            PdfPCell cell4 = new PdfPCell(new Paragraph("To Date"));
            cell.setColspan(1);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            //cell.setBackgroundColor(BaseColor.BLUE);
            table.addCell(cell4);
            
            PdfPTable table5 = new PdfPTable(1);

            PdfPCell cell5 = new PdfPCell(new Paragraph("Leave Submitted"));
            cell.setColspan(1);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            //cell.setBackgroundColor(BaseColor.BLUE);
            table.addCell(cell5);
            
           
            
            
            
            
            String sql = "SELECT pin, uname, fromDtae, toDate, leaveSubmitted\n" +
                                "from leaves";
           connection = ServerConnection.openConnection();
           st = connection.createStatement();
           rs = st.executeQuery(sql);
            while (rs.next()) {
                table.addCell(Integer.toString(rs.getInt("pin")));
                table.addCell((rs.getString("uname")));
                table.addCell(rs.getString("fromDtae"));
                table.addCell((rs.getString("toDate")));
                table.addCell((rs.getString("leaveSubmitted")));
             
            }
            //table.addCell("item7");
            document.add(table);
            
           

            document.close();
            //deleted from here
            
        } catch (Exception e) {

        }
               try { connection.close(); } catch (Exception e) { /* ignored */ }
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
        
