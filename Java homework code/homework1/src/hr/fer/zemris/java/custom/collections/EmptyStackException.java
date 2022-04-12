package hr.fer.zemris.java.custom.collections;

/**
 * Implementation of exception in case of pop() operation from empty stack.
 * 
 * @author Josip Sivrić
 *
 */
public class EmptyStackException extends RuntimeException{
	
	public EmptyStackException(String message) {
		super(message);
	}
	
	public EmptyStackException(String message, Throwable t) {
		super(message, t);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 5019575938076748881L;

}