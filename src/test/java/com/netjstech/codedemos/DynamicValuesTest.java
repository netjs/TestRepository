package com.netjstech.codedemos;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class DynamicValuesTest {
	private SumNumbers obj;
	private Arithmetic ath;
	@BeforeAll
	void setUpBeforeClass() throws Exception {
		System.out.println("In the beginning");
		obj = new SumNumbers();
		ath = new Arithmetic();
	}
	@BeforeEach
	void setUpBeforMethod() throws Exception{
		System.out.println("In Before each");
	}
	
    @TestFactory
    public Stream<DynamicTest> testAdditions() {
        int[][] data = new int[][] {{1, 2, 3}, {5, 3, 8}, { 6, 7, 13}};
        return Arrays.stream(data).map(entry -> {
            int a = entry[0];
            int b = entry[1];
            int sum = entry[2];
            return dynamicTest(a + " + " + b + " = " + sum, () -> {
                assertEquals(sum, obj.sum(a, b));
            });
        });
    }
    
    @TestFactory
    public List<DynamicTest> testArithmetic() {
        
        return Arrays.asList(dynamicTest("SumTest", () -> 
                assertEquals(11, ath.sum(5, 6))),
        		dynamicTest("SubtractTest", () -> 
                assertEquals(14, ath.subtraction(24, 10))));
    }
}

