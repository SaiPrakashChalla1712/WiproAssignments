package com.establishingdatabaseconnectionsassignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
		
		
		public static  Connection  getDBConnection() { // factory method
			
			Connection conn = null;
			
			try {
				DriverManager.registerDriver( new com.mysql.cj.jdbc.Driver() );
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/wipro","root","root");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			return conn;

			
		}

	
}
