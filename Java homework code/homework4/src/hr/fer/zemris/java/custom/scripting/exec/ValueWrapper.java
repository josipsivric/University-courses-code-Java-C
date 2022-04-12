// Nedovršeno
package hr.fer.zemris.java.custom.scripting.exec;

public class ValueWrapper {
	
	private Object value;
	private String currentValueType;
	
	public ValueWrapper(Object value) {
		this.value = value;
	}
	
	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	private void determineType(Object value) {
		
	}
	
	public void increment(Object incValue) {
		
	}

	public void decrement(Object decValue) {
		
	}

	public void multiply(Object mulValue) {
		
	}

	public void divide(Object divValue) {
		
	}

	public int numCompare(Object withValue) {
		return 0;
	}

}
