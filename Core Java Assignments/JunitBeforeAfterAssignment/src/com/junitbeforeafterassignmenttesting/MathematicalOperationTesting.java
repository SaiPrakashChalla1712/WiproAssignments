package com.junitbeforeafterassignmenttesting;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.junitbeforeafterassignment.MathematicalOperations;

class MathematicalOperationTesting {
	private final MathematicalOperations mathOperations = new MathematicalOperations();

	@BeforeAll
	public static  void beforeAll() {
		


		System.out.println("Before All test cases...");

	}


	@AfterAll
	public  static void  afterAll() {

		System.out.println("After All test cases...");

	}



	@BeforeEach
	public  void before() {

		System.out.println("Before Each test case");

	}


	@AfterEach
	public  void after() {

		System.out.println("After Each test case");

	}
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
