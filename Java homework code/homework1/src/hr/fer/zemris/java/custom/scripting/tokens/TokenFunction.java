package hr.fer.zemris.java.custom.scripting.tokens;

/**
 * Token used for storing functions.
 * 
 * @author Josip Sivrić
 *
 */
public class TokenFunction extends Token{
	
	private String name;
	
	/**
	 * Used for passing string name.
	 * 
	 * @return Returns a name.
	 */
	public String getName() {
		return name;
	}

	public TokenFunction (String name) {

	}
	
	/**
	 * Overriden method asText()
	 * 
	 * @see hr.fer.zemris.java.custom.scripting.tokens.Token#asText()
	 * @return Returns a function name
	 */
	public String asText() {
		super.asText();
		return getName();
	}
}