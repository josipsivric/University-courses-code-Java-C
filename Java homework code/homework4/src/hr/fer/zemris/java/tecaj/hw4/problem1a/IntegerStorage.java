package hr.fer.zemris.java.tecaj.hw4.problem1a;

/**
 * Stores provided integer value and initialized observer.
 * 
 * @author Josip Sivrić
 *
 */
public class IntegerStorage {

	private int value;
	private IntegerStorageObserver observer;

	public IntegerStorage(int initialValue) {
		this.value = initialValue;
	}

	public void setObserver(IntegerStorageObserver observer) {
		this.observer = observer;
	}

	/**
	 * Clears current observer.
	 */
	public void clearObserver() {
		this.observer = null;
	}

	/**
	 * Retrieves current integer value.
	 * @return Returns integer value.
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Notifies observer about changed value.
	 * @param value Receieves integer value.
	 */
	public void setValue(int value) {
		if(this.value!=value) {
			this.value = value;
			if(observer!=null) {
				observer.valueChanged(this);
			}
		}
	}
}
