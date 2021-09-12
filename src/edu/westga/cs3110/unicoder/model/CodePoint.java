package edu.westga.cs3110.unicoder.model;

/**
 * Stores Codepoint values and converts to different UTF encodings.
 * 
 * @author DavidWalker
 *
 */
public class CodePoint {

	
	/**
	 * Creates a new Codepoint
	 * 
	 * @param codepoint the codepoint string
	 * @precondition codepoint != null && !codepoint.isEmpty()
	 * 
	 * @postcondition none
	 */
	public CodePoint() {
		
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
