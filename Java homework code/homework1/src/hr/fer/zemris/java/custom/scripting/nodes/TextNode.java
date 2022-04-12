package hr.fer.zemris.java.custom.scripting.nodes;

/**
 * Node containing only text.
 * 
 * @author Josip Sivrić
 *
 */
public class TextNode extends Node {
	
	private String text;
	
	/**
	 * Used for getting stored text.
	 * 
	 * @return Returns stored string.
	 */
	public String getText() {
		return text;
	}

	public TextNode() {
		
	}
}