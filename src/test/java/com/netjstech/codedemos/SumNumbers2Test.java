package com.netjstech.codedemos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

//execute all test methods on the same test instance
@TestInstance(Lifecycle.PER_CLASS)
public class SumNumbers2Test {
	private SumNumbers obj;
	@BeforeAll
	void setUpBeforeClass() throws Exception {
		obj = new SumNumbers();
		System.out.println("In the beginning");
	}

	@AfterAll
	void tearDownAfterClass() throws Exception {
		obj = null;
		System.out.println("At the end");
	}

	@BeforeEach
	void setUp() throws Exception {
		//SumNumbers obj = new SumNumbers();
		System.out.println("Before each test");
	}

	@AfterEach
	void tearDown() throws Exception {
		//obj = null;
		System.out.println("After each test");
	}

	@Test
	//@RepeatedTest(10)
	public void testSum() {
		assertEquals(5, obj.sum(2, 3));
	}
	
	@Test
	public void testNegativeSum() {
		assertNotEquals(6, obj.sum(2, 3));
	}
	
	@DisplayName("TestForException")
	@Test
	public void testError() {
		Exception exception = assertThrows(IllegalArgumentException.class,  ()->obj.sum(12, 3));
		assertEquals("Value should be less than 10", exception.getMessage());
	}
}
