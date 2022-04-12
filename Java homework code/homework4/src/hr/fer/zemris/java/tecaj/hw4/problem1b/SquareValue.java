package hr.fer.zemris.java.tecaj.hw4.problem1b;

/**
 * Used printing a square of the provided value.
 * 
 * @author Josip Sivrić
 *
 */
public class SquareValue implements IntegerStorageObserver{

	/**
	 * {@inheritDoc}
	 * @see hr.fer.zemris.java.tecaj.hw4.problem1a.IntegerStorageObserver#valueChanged(hr.fer.zemris.java.tecaj.hw4.problem1a.IntegerStorage)
	 */
	@Override
	public void valueChanged(IntegerStorageChange istorage) {
		
		System.out.println("Provided new value: " + istorage.getCurrentInt() + 
				", square is " + istorage.getCurrentInt()*istorage.getCurrentInt());
		
	}
}
