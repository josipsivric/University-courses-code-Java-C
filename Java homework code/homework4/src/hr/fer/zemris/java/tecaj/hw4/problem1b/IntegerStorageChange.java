package hr.fer.zemris.java.tecaj.hw4.problem1b;

/**
 * Used for encapsulation of values before the change and after.
 * 
 * @author Josip
 *
 */
public class IntegerStorageChange {
	
	private IntegerStorage intStorage;
	private int beforeChange;
	private int currentInt;
	
	public IntegerStorageChange(int beforeChange, int currentInt) {
		super();
		this.beforeChange = beforeChange;
		this.currentInt = currentInt;
	}
	
	public IntegerStorageChange(int currentInt) {
		this.currentInt = currentInt;
	}
	
	public IntegerStorage getIntStorage() {
		return intStorage;
	}
	
	public int getBeforeChange() {
		return beforeChange;
	}
	
	public int getCurrentInt() {
		return currentInt;
	}
}
