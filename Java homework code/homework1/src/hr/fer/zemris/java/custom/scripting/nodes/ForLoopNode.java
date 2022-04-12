package hr.fer.zemris.java.custom.scripting.nodes;

import hr.fer.zemris.java.custom.scripting.tokens.Token;
import hr.fer.zemris.java.custom.scripting.tokens.TokenVariable;

/**
 * A node representing single "for" loop.
 * 
 * @author Josip Sivrić
 *
 */
public class ForLoopNode extends Node {
	
	private TokenVariable variable;
	private Token startExpression;
	private Token endExpression;
	private Token setExpression;
	
	public ForLoopNode() {
		
	}
	
	/**
	 * Variable from for-loop construct.
	 * 
	 * @return Returns a variable used in for-loop construct.
	 */
	public TokenVariable getVariable() {
		return variable;
	}
	
	/**
	 * Start expression from for-loop construct.
	 * 
	 * @return Returns start expression from for-loop.
	 */
	public Token getStartExpression() {
		return startExpression;
	}
	
	/**
	 * End expression used in for-loop.
	 * 
	 * @return Returns end expression from for-loop.
	 */
	public Token getEndExpression() {
		return endExpression;
	}
	
	/**
	 * Step expression used in for-loop.
	 * 
	 * @return Returns step expression from for-loop.
	 */
	public Token getStepExpression() {
		return setExpression;
	}
}