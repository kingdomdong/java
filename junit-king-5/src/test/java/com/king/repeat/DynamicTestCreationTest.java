package com.king.repeat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import com.king.base.Multiply;

public class DynamicTestCreationTest {

	@TestFactory
	Stream<DynamicTest> testMultipleException() {
		int[][] data = new int[][] { { 1, 2, 2 }, { 5, 3, 15 }, { 121, 4, 484 } };

		return Arrays.stream(data).map(entry -> { // TODO to-be understood
			int m1 = entry[0];
			int m2 = entry[1];
			int expected = entry[2];
			return dynamicTest(m1 + "*" + m2 + "=" + expected, () -> {
				assertEquals(expected, Multiply.multiply(m1, m2));
			});
		});
	}
	
}
