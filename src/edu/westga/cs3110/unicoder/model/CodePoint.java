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
		return "";
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
		return "";
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
		return "";
	}
}
