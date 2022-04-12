package hr.fer.zemris.java.tecaj.hw5;

import java.io.BufferedReader;
import java.io.BufferedWriter;

/**
 * Interface for executing commands inside shell.
 * 
 * @author Josip Sivrić
 *
 */
public interface ShellCommand {

	/**
	 * @param in Input stream for usage inside commands.
	 * @param out Output stream for usage inside commands.
	 * @param arguments Arguments for some operations that can recieve them.
	 * 
	 * @return In case of completion or error returns to main program (only exit terminates shell).
	 */
	public ShellStatus executeCommand(BufferedReader in, BufferedWriter out, String[] arguments);
}
