package hr.fer.zemris.java.tecaj.hw4.problem1b;

/**
 * 
 * Main program that inflicts changes; Initializes observers and sets the value.
 * 
 * @author Josip Sivrić
 *
 */
public class ObserverExample {

	public static void main(String[] args) {
		
		IntegerStorage istorage = new IntegerStorage(20);
		
		IntegerStorageObserver observer1 = new SquareValue();
		IntegerStorageObserver observer2 = new ChangeCounter();
		
		istorage.addObserver(observer1);
		istorage.addObserver(observer2);
		
		istorage.setValue(5);
		istorage.setValue(2);
		istorage.setValue(25);
		istorage.setValue(13);
		istorage.setValue(22);
		istorage.setValue(15);
	}
}
