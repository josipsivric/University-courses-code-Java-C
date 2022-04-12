package hr.fer.zemris.java.tecaj.hw4.problem1b;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores provided integer values and initalized observers
 * 
 * @author Josip Sivrić
 *
 */
public class IntegerStorage {

	private int value;
	private List<IntegerStorageObserver> observerList = new ArrayList<IntegerStorageObserver>();

	public IntegerStorage(int initialValue) {
		this.value = initialValue;
	}

	/**
	 * Clears all observers.
	 */
	public void clearObserver() {
		this.observerList.clear();
	}

	/**
	 * Retrieves current integer value.
	 * @return Returns integer value.
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Notifies all initialized observers about changed value.
	 * @param value Receieves integer value.
	 */
	public void setValue(int value) {
		IntegerStorageChange valChange = new IntegerStorageChange(getValue(), value);
		int i = 0;
		if (this.value != value) {
			this.value = value;
			while (true) {
				try {
					observerList.get(i).valueChanged(valChange);
					i++;
				} catch (IndexOutOfBoundsException e1) {
					break;
				}
			}
		}
	}

	/**
	 * Adds new observer to the list.
	 * @param observer Recieves observer.
	 */
	public  void addObserver(IntegerStorageObserver observer) {
		observerList.add(observer);
	}
	
	/**
	 * Removes specific observer from the list.
	 * @param observer Recieves observer scheduled for removal.
	 */
	public void removeObserver(IntegerStorageObserver observer) {
		if (observer != null)
			observerList.remove(observer);
	}
	
	
}
