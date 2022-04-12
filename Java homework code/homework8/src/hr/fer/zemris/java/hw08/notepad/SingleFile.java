package hr.fer.zemris.java.hw08.notepad;

import javax.swing.JComponent;
import javax.swing.JScrollPane;

public class SingleFile extends JComponent{

	private static final long serialVersionUID = 1L;
	JComponent panel = new JScrollPane();

	public SingleFile(JComponent panel) {
		super();
		this.panel = panel;
	}
	
	
}
