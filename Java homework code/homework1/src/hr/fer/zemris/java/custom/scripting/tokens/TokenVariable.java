package hr.fer.zemris.java.custom.scripting.tokens;

/**
 * Used for storing variables.
 * 
 * @author Josip Sivrić
 *
 */
public class TokenVariable extends Token {
	
	private String name;
	
	/**
	 * Used for getting a variable names.
	 * 
	 * @return Returns a variable name.
	 */
	public String getName() {
		return name;
	}

	public TokenVariable (String name) {

	}
	
	/**
	 * Overriden method asText().
	 * 
	 * @see hr.fer.zemris.java.custom.scripting.tokens.Token#asText()
	 * @return Returns a variable name.
	 */
	public String asText() {
		super.asText();
		return getName();
	}
}