package hr.fer.zemris.java.custom.scripting.nodes;

import hr.fer.zemris.java.custom.collections.ArrayBackedIndexedCollection;

/**
 * Base node class. All other node class are inherited from this one.
 * 
 * @author Josip Sivrić
 *
 */
public class Node {
	
	private ArrayBackedIndexedCollection children = null;
	
	public Node() {
		
	}
	
	/**
	 * Adds a new child into tree. If needed creates a subtree.
	 * 
	 * @param child Child for adding into array.
	 */
	void addChildNode(Node child) {
		if (children == null)
			children = new ArrayBackedIndexedCollection();
		children.add(child);
	}
	
	/**
	 * Used for counting of (direct) children.
	 * 
	 * @return Returns a number of children.
	 */
	int numberOfChildren() {
		return children.size();
	}
	
	/**
	 * Used for getting a child at specified position.
	 * 
	 * @param index Position of a child.
	 * @return Returns a child from specified position.
	 */
	Node getChild(int index) {
		return (Node) children.get(index);
	}
}