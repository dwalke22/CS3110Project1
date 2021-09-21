package edu.westga.cs3110.unicoder.tests.model.codepoint;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3110.unicoder.model.CodePoint;

class TestCodePointToUTF8 {

	@Test
	void testOneByte() {
		CodePoint test = new CodePoint("15");
		assertEquals("15", test.toUTF8());
	}
	
	@Test
	void testOneByteLimit() {
		CodePoint test = new CodePoint("7F");
		assertEquals("7F", test.toUTF8());
	}
	
	@Test
	void testTwoBytes() {
		CodePoint test = new CodePoint("01A0");
		assertEquals("C6A0", test.toUTF8());
	}
	
	@Test
	void testTwoByteLowerLimit() {
		CodePoint test = new CodePoint("80");
		assertEquals("C280", test.toUTF8());
	}
	
	@Test
	void testTwoByteUpperLimit() {
		CodePoint test = new CodePoint("7FF");
		assertEquals("DFBF", test.toUTF8());
	}

	@Test
	void testThreeBytes() {
		CodePoint test = new CodePoint("4CE3");
		assertEquals("E4B3A3", test.toUTF8());
	}
	
	@Test
	void testThreeByteLowerLimit() {
		CodePoint test = new CodePoint("800");
		assertEquals("E0A080", test.toUTF8());
	}
	
	@Test
	void testThreeByteUpperLimit() {
		CodePoint test = new CodePoint("FFFF");
		assertEquals("EFBFBF", test.toUTF8());
	}
	
	@Test
	void testFourBytes() {
		CodePoint test = new CodePoint("1AB341");
		assertEquals("F6AB8D81", test.toUTF8());
	}
	
	@Test
	void testFourByteLowerLimit() {
		CodePoint test = new CodePoint("10000");
		assertEquals("F0908080", test.toUTF8());
	}
	
	@Test
	void testFourByteUpperLimit() {
		CodePoint test = new CodePoint("10FFFF");
		assertEquals("F48FBFBF", test.toUTF8());
	}
}
