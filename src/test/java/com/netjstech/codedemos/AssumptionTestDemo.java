package com.netjstech.codedemos;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class AssumptionTestDemo {

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,-1, 6})
    void testWithStringParameter(int i) {
    	assumeFalse(i >=0);
        System.out.println("Test is executed");
    }
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
