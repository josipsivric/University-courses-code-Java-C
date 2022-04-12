package hr.fer.zemris.java.tecaj.hw4.problem1a;

/**
 * Used for tracing number of value changes.
 * 
 * @author Josip Sivrić
 *
 */
public class ChangeCounter implements IntegerStorageObserver{
	
	private int counter = 0;

	/**
	 * {@inheritDoc}
	 * @see hr.fer.zemris.java.tecaj.hw4.problem1a.IntegerStorageObserver#valueChanged(hr.fer.zemris.java.tecaj.hw4.problem1a.IntegerStorage)
	 */
	@Override
	public void valueChanged(IntegerStorage istorage) {
		counter++;
		System.out.println("Number of value changes since tracking: " + counter );
		
	}
}
