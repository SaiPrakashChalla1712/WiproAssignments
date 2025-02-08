package com.factorymethodassignment;

public class ShapeFactory {
	public static Shape getShape(String clientInput) {
		if(clientInput.equalsIgnoreCase("Circle")) {
			return new Circle();
		}
		else if(clientInput.equalsIgnoreCase("Square")) {
			return new Square();
		}
		else if(clientInput.equalsIgnoreCase("Rectangle")) {
			return new Rectangle();
		}
		else {
			return null;
		}
	}
}
