package com.proxyassignment;

import java.util.Scanner;

public class TestProxy {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Password : ");
		String password = sc.nextLine();
		PasswordCheck pc=new PasswordCheck();
		String result=pc.getSecret(password);
		if(result!=null) {
			System.out.println("Secret Key : "+result);
		}
		else {
			System.out.println("Password Incorrect. Access Denied.");
		}
		sc.close();
		
	}

}
