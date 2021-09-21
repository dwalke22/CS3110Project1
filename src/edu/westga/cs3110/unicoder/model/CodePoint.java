package edu.westga.cs3110.unicoder.model;

/**
 * Stores Codepoint values and converts to different UTF encodings.
 * 
 * @author DavidWalker
 *
 */
public class CodePoint {

	private String codepoint;
	
	/**
	 * Creates a new Codepoint
	 * 
	 * @param codepoint the codepoint string
	 * @precondition codepoint != null && !codepoint.isEmpty()
	 * 
	 * @postcondition none
	 */
	public CodePoint(String codepoint) {
		if (codepoint == null) {
			throw new NullPointerException("Codepoint cannot be null.");
		}
		if (codepoint.isEmpty()) {
			throw new IllegalArgumentException("Codepoint cannot be empty.");
		}
		
		if (!codepoint.matches("0*((1[0-9A-F]{1,5})|([0-9A-F]{1,5}))")) {
			throw new IllegalArgumentException("Codepoint is not in the proper formatt.");
		}
		
		this.codepoint = codepoint;
	}
	
	/**
	 * Converts the Codepoint to UTF-8 encoding
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return Encoding hexadecimal string as UTF-8 encoding
	 */
	public String toUTF8() {
		int parsed = Integer.parseUnsignedInt(this.codepoint, 16);
		if (parsed > 0x007F && parsed < 0x0800) {
			int byteOne = 0b11000000 + ((parsed & 0b11111000000) >> 6);
			int byteTwo = 0b10000000 + (parsed & 0b00000111111);
			return String.format("%04X", (byteOne << 8) + byteTwo);
		} else if (parsed > 0x07FF && parsed < 0x10000) {
			int byteOne = 0b11100000 + ((parsed & 0b1111000000000000) >> 12);
			int byteTwo = 0b10000000 + ((parsed & 0b0000111111000000) >> 6);
			int byteThree = 0b10000000 + (parsed & 0b0000000000111111);
			return String.format("%06X", (byteOne << 16) + (byteTwo << 8) + byteThree);
		} else if (parsed > 0xFFFF) {
			int byteOne = 0b11110000 + ((parsed & 0b111000000000000000000) >> 18);
			int byteTwo = 0b10000000 + ((parsed & 0b000111111000000000000) >> 12);
			int byteThree = 0b10000000 + ((parsed & 0b000000000111111000000) >> 6);
			int byteFour = 0b10000000 + (parsed & 0b000000000000000111111);
			return String.format("%08X", (byteOne << 24) + (byteTwo << 16) + (byteThree << 8) + byteFour);
		} else {
			return String.format("%02X", parsed);
		} 
	}
	
	/**
	 * Converts the Codepoint to UTF-16 encoding
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return Encoding hexadecimal string as UTF-16 encoding
	 */
	public String toUTF16() {
		int parsed = Integer.parseUnsignedInt(this.codepoint, 16);
		if (parsed < 0x10000) {
			if (parsed > 0xD7FF && parsed < 0xE000) {
				return null;
			} else {
				return String.format("%04X", parsed);
			}
		} else {
			parsed -= 0x10000;
			int highSurrogate = 0xD800 + (parsed >> 10);
			int lowSurrogate = 0xDC00 + (parsed & 0b00000000001111111111);
			return String.format("%04X", highSurrogate) + String.format("%04X", lowSurrogate);
		}
	}
	
	/**
	 * Converts the Codepoint to UTF-32 encoding
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return Encoding hexadecimal string as UTF-32 encoding
	 */
	public String toUTF32() {
		int parsed = Integer.parseUnsignedInt(this.codepoint, 16);
		return String.format("%08X", parsed);
	}
}
