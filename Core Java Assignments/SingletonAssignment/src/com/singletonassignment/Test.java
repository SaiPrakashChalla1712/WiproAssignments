package com.singletonassignment;

import java.sql.Connection;

public class Test {

	public static void main(String[] args) {
		Singleton singletonObj=Singleton.getSingletonObj();
		
		Connection conn=singletonObj.getConn();
		if(conn!=null) {
			System.out.println("Database Connected Successfully.");
		}
		else {
			System.out.println("Database Connection Failed.");
		}

	}

}
