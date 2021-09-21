package edu.westga.cs3110.unicoder.tests.model.codepoint;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3110.unicoder.model.CodePoint;

class TestCodePointToUTF16 {

	@Test
	void testTwoByteInZoneOne() {
		CodePoint CodePoint = new CodePoint("ABCD");
		assertEquals("ABCD", CodePoint.toUTF16());
	}
	@Test
	void testTwoByteZoneOneMin() {
		CodePoint CodePoint = new CodePoint("0000");
		assertEquals("0000", CodePoint.toUTF16());
	}
	@Test
	void testTwoByteZoneOneMax() {
		CodePoint CodePoint = new CodePoint("D7FF");
		assertEquals("D7FF", CodePoint.toUTF16());
	}
	
	@Test
	void testTwoByteInZoneTwo() {
		CodePoint CodePoint = new CodePoint("E00F");
		assertEquals("E00F", CodePoint.toUTF16());
	}
	
	@Test
	void testTwoByteZoneTwoMin() {
		CodePoint CodePoint = new CodePoint("E000");
		assertEquals("E000", CodePoint.toUTF16());
	}
	
	@Test
	void testTwoByteZoneTwoMax() {
		CodePoint CodePoint = new CodePoint("FFFF");
		assertEquals("FFFF", CodePoint.toUTF16());
	}
	
	@Test
	void testFourByte() {
		CodePoint CodePoint = new CodePoint("0183A5");
		assertEquals("D820DFA5", CodePoint.toUTF16());
	}
	
	@Test
	void testGapByte() {
		CodePoint CodePoint = new CodePoint("D8FF");
		assertEquals(null, CodePoint.toUTF16());
	}

}
