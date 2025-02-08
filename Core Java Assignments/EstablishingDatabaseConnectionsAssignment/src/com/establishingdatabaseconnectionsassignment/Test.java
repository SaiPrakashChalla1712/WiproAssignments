package com.establishingdatabaseconnectionsassignment;

import java.sql.Connection;

public class Test {
	public static void main(String[] args) {
		Connection conn=DatabaseConnection.getDBConnection();
		
		if(conn!=null) {
			System.out.println("Database Connected Successfully.");
		}
		else {
			System.out.println("Database Connection Failed.");
		}
	}

}
