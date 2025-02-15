package com.factorymethodassignment;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the shape(Circle,Square,Rectangle) : ");
		String clientInput=sc.nextLine();
		Shape shape = ShapeFactory.getShape(clientInput);
		
		if(shape!=null) {
			shape.draw();
		}
		else {
			System.out.println("Please Provide Valid Input.");
		}
		sc.close();

	}

}
