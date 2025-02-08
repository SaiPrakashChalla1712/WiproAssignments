package com.singletonassignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singleton {
	private static Singleton singletonObj=null;
	private Connection conn;

	private Singleton() {

		try {
			DriverManager.registerDriver( new com.mysql.cj.jdbc.Driver() );
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/wipro","root","root");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public Connection getConn() {
		return conn;
	}

	public static Singleton getSingletonObj() {
		if(singletonObj==null) {
			singletonObj=new Singleton();
		}
		return singletonObj;
	}



}
