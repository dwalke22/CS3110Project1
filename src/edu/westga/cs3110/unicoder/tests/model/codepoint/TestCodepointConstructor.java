package edu.westga.cs3110.unicoder.tests.model.codepoint;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3110.unicoder.model.CodePoint;

class TestCodepointConstructor {

	@Test
	void testNullCodePoint() {
		assertThrows(NullPointerException.class, () -> {
			new CodePoint(null);
		});
	}

	@Test
	void testEmptyCodePoint() {
		assertThrows(IllegalArgumentException.class, () -> {
			new CodePoint("");
		});
	}
	
	@Test
	void testNonCodePoint() {
		assertThrows(IllegalArgumentException.class, () -> {
			new CodePoint("EXIT");
		});
	}
	
	@Test
	void testValidConstruction() {
		CodePoint testCodePoint = new CodePoint("1F682");
		
		assertFalse(testCodePoint == null);
	}
}
