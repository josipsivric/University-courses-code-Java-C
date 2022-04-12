package hr.fer.zemris.java.custom.scripting.tokens;

/**
 * Used for storing operators.
 * 
 * @author Josip Sivrić
 *
 */
public class TokenOperator extends Token {
	
	private String symbol;
	
	/**
	 * Used for getting an operator.
	 * @return Returns a symbol representing some operation.
	 */
	public String getSymbol() {
		return symbol;
	}

	public TokenOperator (String symbol) {

	}
	
	/**
	 * Overriden method asText().
	 * 
	 * @see hr.fer.zemris.java.custom.scripting.tokens.Token#asText()
	 * @return Returns an symbol of operation.
	 */
	public String asText() {
		super.asText();
		return getSymbol();
	}
}