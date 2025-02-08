package com.testannotationassignmenttesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.testannotationassignment.MathematicalOperations;




class MathematicalOperationTesting {
	private final MathematicalOperations mathOperations = new MathematicalOperations();
	
	@Test
	void testAdd() {
		assertEquals(10, mathOperations.add(5, 5));
		System.out.println("Addition Tested...");
	}

	@Test
	void testSubstract() {
		assertEquals(3, mathOperations.substract(8,5));
		System.out.println("Subtraction Tested...");
	}
	
	@Test
	void testMultiply() {
		assertEquals(20, mathOperations.multiply(4, 5));
		System.out.println("Multipliaction Tested...");
	}
	
	@Test
	void testDivide() {
		 assertEquals(5, mathOperations.divide(10, 2));
		System.out.println("Division Tested...");
	}

}
