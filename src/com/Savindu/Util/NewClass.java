/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Savindu.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static com.Savindu.Util.DBConnection.openConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Savindu
 */

public class NewClass {
    
        
	private static final String URL = "jdbc:mysql://188.40.66.97:3306/qsslk_AMS";
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	
	private static final String USERNAME = "qsslk";
	
	private static final String PASSWORD = "#Admin@98";
	
	private static Connection connection = null;
	

public static Connection openConnection() {

//checking for the connection---------------------------


	if(connection != null) {

		return connection;
	
	}else {
		
		try {
			
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
                        
                        if(connection != null) {
                            System.out.println("Successfully Connected to the Server!");

                        }
	
		}catch(ClassNotFoundException e){
			
			e.printStackTrace();
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}

		return connection;
	}
}
    public static void main(String args[]) {
      openConnection();
    }
}

