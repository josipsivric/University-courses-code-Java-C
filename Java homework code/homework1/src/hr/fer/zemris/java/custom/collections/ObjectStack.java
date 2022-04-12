package hr.fer.zemris.java.custom.collections;

/**
 * Implementation of stack using ArrayBackedIndexedCollection class as backbone.
 * Serves as adapter, providing usual stack operations, such as pop() and push().
 * Stack is LIFO style.
 * 
 * @author Josip Sivrić
 *
 */
public class ObjectStack {
	
	private ArrayBackedIndexedCollection collection;
	private Integer sizeOfStack = 0;
	private Object popContainer;
	
	public ObjectStack(Integer capacity) {
		collection = new ArrayBackedIndexedCollection(capacity);
	}
	
	public ObjectStack() {
		collection = new ArrayBackedIndexedCollection();
	}

	/**
	 * Used for checking if the stack is empty.
	 * 
	 * @return Returns "True" if the stack is empty, otherwise "False".
	 */
	boolean isEmpty() {
		return collection.isEmpty();
	}
	
	/**
	 * Used for checking current size of the stack.
	 * 
	 * @return Returns size of the stack.
	 */
	int size() {
		return collection.size();
	}
	
	/**
	 * Puts the object on the top of the stack.
	 * 
	 * @param value Object provided for ppushing on the stack.
	 */
	void push(Object value){
		collection.add(value);
		sizeOfStack++;
	}
	
	/**
	 * Removes the object from the top of the stack and returns it to caller.
	 * 
	 * @return Returns object from top of the stack
	 */
	Object pop() {
		if (sizeOfStack == 0)
			throw new EmptyStackException("Stack is empty! Nothing to pop!");
		popContainer = collection.get(sizeOfStack);
		collection.remove(sizeOfStack);
		return popContainer;
	}
	
	/**
	 * Similarly to the pop(), method returns the object to the caller
	 * but the object is not removed from stack.
	 * 
	 * @return Returns object from top of the stack.
	 */
	Object peek() { 
		if (sizeOfStack == 0)
			throw new EmptyStackException("Stack is empty! Nothing to peek!");
		return collection.get(sizeOfStack);
	}
	
	/**
	 * Clears the stack.
	 */
	void clear() {
		collection.clear();
	}
}