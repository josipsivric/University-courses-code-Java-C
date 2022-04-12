package hr.fer.zemris.java.custom.scripting.tokens;

/**
 * Token used for storing floating point values.
 * 
 * @author Josip Sivrić
 *
 */
public class TokenConstantDouble extends Token {
	
	private double value;

	/**
	 * Used for getting a value.
	 * 
	 * @return Returns a value.
	 */
	public double getValue() {
		return value;
	}

	public TokenConstantDouble() {
		
	}
	
	/**
	 * Overriden method asText().
	 * 
	 * @see hr.fer.zemris.java.custom.scripting.tokens.Token#asText()
	 * @return Returns an double value as text.
	 */
	public String asText() {
		super.asText();
		return Double.toString(getValue());
	}
}