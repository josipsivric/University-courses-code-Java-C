package hr.fer.zemris.java.hw;

public class Pointer<T> {
	
	private T object;
	
	public <X extends T> Pointer(X object) {
		super();
		this.object = object;
	}
	
	public T getObject () {
		return object;
	}
	
	public <X extends T> void  setObject(X object) {
		this.object = object;
	}
}
