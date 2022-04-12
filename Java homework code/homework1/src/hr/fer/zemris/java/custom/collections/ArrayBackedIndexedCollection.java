package hr.fer.zemris.java.custom.collections;

/**
 * Implementation of resizable array-backed collection of objects.
 *  
 * @author Josip Sivrić
 * 
 */
public class ArrayBackedIndexedCollection {

	private Integer size = 0;
	private Integer capacity;
	private Object[] elements = new Object[this.capacity];
	
	/**
	 * @param initialCapacity Sets initial capacity of array on given value, otherwise on default (16).
	 */
	public ArrayBackedIndexedCollection(Integer initialCapacity) {
		if (initialCapacity < 1)
			throw new IllegalArgumentException("Argument too small! Argument must be greater than 1!");
		else
			this.capacity = initialCapacity;
	}
	
	public ArrayBackedIndexedCollection() {
		this.capacity = 16;
	}
	
	/**
	 * Used for checking if collection is empty.
	 * 
	 * @return Returns "False" if collection is empty, else "True".
	 */
	public boolean isEmpty() {
		if (elements[0] == null)
			return true;
		else
			return false;
	}
	
	/**
	 * Used for checking of current number of objects in array.
	 * 
	 * @return Returns current number of objects in array.
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Adds Object into array on first empty space.
	 * 
	 * @param value Object that is added into first empty space of collection.
	 */
	public void add (Object value) {
		if (value == null)
			throw new IllegalArgumentException("Element cannot be null!");
		if (size == capacity) {
			capacity = 2* capacity;
			Object[] pom = elements;
			elements = new Object[capacity];
			System.arraycopy(pom, 0, elements, 0, size);
		}
		elements[size] = value;
		size++;
	}
	
	/**
	 * Provides an object at some position in array.
	 * 
	 * @param index Position of object you want to get.
	 * @return Returns object at provided position if possible.
	 */
	public Object get(int index) {
		if (index < 0 || index > (size - 1))
			throw new IndexOutOfBoundsException("Index must non-negative and smaller than size of the collection");
		else
			return elements[index];
	}
	
	/**
	 * Removes object at provided position from array,
	 * all objects on higher places are shifted down to fill void.
	 * 
	 * @param index Removes object at provided position from array.
	 */
	public void remove(int index) {
		if (index >= size || index < 0)
			throw new IndexOutOfBoundsException("Cannot remove! Element at that index does not exist!");
		elements[index] = null;	
		System.arraycopy(elements, index + 1, elements, index, size - index);
		size--;
	}
	
	/**
	 * Inserts object at specified position,
	 * all objects on same and higher places designated by position
	 * are shifted to make a void for new object.
	 * 
	 * @param value Object provided for insertion.
	 * @param position Position at which object will be inserted.
	 */
	public void insert(Object value, int position) {
		if (value == null || position < 0 || position > size)
			throw new IllegalArgumentException("Element cannot be null and/or position is invalid!");
		if (size == capacity) {
			capacity = 2* capacity;
			Object[] pom = elements;
			elements = new Object[capacity];
			System.arraycopy(pom, 0, elements, 0, size);
		}
		System.arraycopy(elements, position, elements, position + 1, size - position + 1);
		elements[position] = value;
		size++;
	}
	
	/**
	 * Searches the array for provided object. 
	 * 
	 * @param value Object that is searched for.
	 * @return Returns position of first found object.
	 */
	public int indexOf(Object value) {
		int j = 0;
		while (elements[j] != null) {
			if (value.equals(elements[j]))
				return j;
			j++;
		}
		return -1;
	}
	
	/**
	 * Searches the array for provided object.
	 * 
	 * @param value Object that is searched for.
	 * @return Returns "True" if found, else "False".
	 */
	public boolean contains(Object value) {
		int j = 0;
		while (elements[j] != null) {
			if (value.equals(elements[j]))
				return true;
			j++;
		}
		return false;
	}
	
	/**
	 * Clears all objects from entire array.
	 */
	public void clear() {
		int j = 0;
		while (elements[j] != null) {
			elements[j] = null;
			j++;
		}
	}
}