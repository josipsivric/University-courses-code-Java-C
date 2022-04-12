package hr.fer.zemris.java.custom.scripting.tokens;

/**
 * Used for storing an integer value.
 * 
 * @author Josip Sivrić
 *
 */
public class TokenConstantInteger extends Token {
	
	private int value;

	/**
	 * Used for getting a value.
	 * 
	 * @return Returns a value.
	 */
	public int getValue() {
		return value;
	}

	public TokenConstantInteger() {
		
	}
	
	/**
	 * Overriden method asText().
	 * 
	 * @see hr.fer.zemris.java.custom.scripting.tokens.Token#asText()
	 * @return Returns an integer value as text.
	 */
	public String asText() {
		super.asText();
		return Integer.toString(getValue());
	}
}