package hr.fer.zemris.java.tecaj.hw4.problem1a;

/**
 * Observer interface.
 * 
 * @author Josip
 *
 */
public interface IntegerStorageObserver {
	
	/**
	 * Interface used for notification about changed value;
	 * 
	 * @param istorage Recieves object whose value is changed.
	 */
	public void valueChanged(IntegerStorage istorage);
	
}
