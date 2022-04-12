package hr.fer.zemris.java.custom.scripting.parser;

/**
 * Implementation of exception that can happen during parsing.
 * 
 * @author Josip Sivrić
 *
 */
public class SmartScriptParserException extends RuntimeException{

	public SmartScriptParserException(String message) {
		super(message);
	}
	
	public SmartScriptParserException(String message, Throwable t) {
		super(message, t);
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4159952209228690861L;
}