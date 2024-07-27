package com.netjstech.codedemos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SumNumberTest {
	public SumNumberTest(){
		
	}
	private SumNumbers obj = new SumNumbers();
	@Test
	public void sumTest() {
		assertEquals(11, obj.sum(5, 6));
	}
	
	@Test
	public void sumNegativeTest() {
		assertNotEquals(11, obj.sum(6, 7));
	}
}
