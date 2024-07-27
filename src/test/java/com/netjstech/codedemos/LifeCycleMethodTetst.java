package com.netjstech.codedemos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class LifeCycleMethodTetst {
	private SumNumbers obj;
	@BeforeAll
	void setUpBeforeClass() throws Exception {
		obj = new SumNumbers();
	}

	@AfterAll
	void tearDownAfterClass() throws Exception {
		
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}
	@Test
	public void sumTest() {
		assertEquals(11, obj.sum(5, 6));
	}
	
	@Test
	public void sumNegativeTest() {
		assertNotEquals(11, obj.sum(6, 7));
	}

}
