package hr.fer.zemris.java.custom.scripting.nodes;

import hr.fer.zemris.java.custom.scripting.tokens.Token;

/**
 * A node representing command that generates text output dynamically.
 * 
 * @author Josip Sivrić
 *
 */
public class EchoNode extends Node {
	
	private Token[] tokens;

	/**
	 * @return Returns tokens.
	 */
	public Token[] getTokens() {
		return tokens;
	}
	
	public EchoNode() {
		
	}
}