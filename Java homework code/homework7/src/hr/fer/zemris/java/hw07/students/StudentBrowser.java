package hr.fer.zemris.java.hw07.students;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.JTable;
import java.awt.BorderLayout;

public class StudentBrowser extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTable table;

	public StudentBrowser() {
		setLocation(20, 20);
		setSize(400, 600);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		initGUI();
	}
	
	public static void main (String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new StudentBrowser().setVisible(true);
			}
		});
	}
	
	private void initGUI() {
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JList list = new JList();
		getContentPane().add(list, BorderLayout.NORTH);
		
		table = new JTable();
		getContentPane().add(table, BorderLayout.SOUTH);
	}

}
