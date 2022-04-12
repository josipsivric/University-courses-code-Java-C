package hr.fer.zemris.java.custom.scripting.tokens;

/**
 * Base Token class. All other Token classes are inherited from this one.
 * 
 * @author Josip Sivrić
 *
 */
public class Token {
	
	public Token () {
		
	}

	/**
	 * SHows empty string.
	 * 
	 * @return Returns empty string.
	 */
	public String asText() {
		return "";
	}
}