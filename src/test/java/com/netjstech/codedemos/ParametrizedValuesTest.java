package com.netjstech.codedemos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.EnumSet;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

public class ParametrizedValuesTest {
	private final SumNumbers obj = new SumNumbers();	
    public static int[][] getData() {
        return new int[][] {{1, 2, 3}, {5, 3, 8}, { 6, 7, 13}};
    }
    
    @ParameterizedTest
    @MethodSource("getData")
    void testWithStringParameter(int[] data) {
        int a = data[0];
        int b = data[1];
        int sum = data[2];
        assertEquals(sum, obj.sum(a, b));
    }
    
	@ParameterizedTest
	@EnumSource(
		value = TimeUnit.class,
		names = {"NANOSECONDS", "MICROSECONDS"})
	void withSomeEnumValues(TimeUnit unit) {
		// executed once for TimeUnit.NANOSECONDS
		// and once for TimeUnit.MICROSECONDS
		 assertNotNull(unit);
	}
	
	
	@DisplayName("Sum Method Test")
	@ParameterizedTest
	@CsvSource({ "1, 2, 3", "6, 7, 13", "9, 5, 14"})
	void testWithCSV(int num1, int num2, int result) { 
		assertEquals(result, obj.sum(num1, num2));
	}

}
