package hr.fer.zemris.java.custom.scripting.tokens;

/**
 * Used for storing string data.
 * 
 * @author Josip Sivrić
 *
 */
public class TokenString extends Token{
	
	private String value;
	
	/**
	 * Used for passing string data.
	 * 
	 * @return Returns a string.
	 */
	public String getValue() {
		return value;
	}

	public TokenString (String value) {

	}
	
	/**
	 * Overriden method asText().
	 * 
	 * @see hr.fer.zemris.java.custom.scripting.tokens.Token#asText()
	 * @return Returns value.
	 */
	public String asText() {
		super.asText();
		return getValue();
	}
}