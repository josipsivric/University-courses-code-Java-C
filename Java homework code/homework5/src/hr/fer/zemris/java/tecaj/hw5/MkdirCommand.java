package hr.fer.zemris.java.tecaj.hw5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

/**
 * Creates specified directory. If necessary, all parent directories are created.
 * 
 * @author Josip Sivrić
 *
 */
public class MkdirCommand implements ShellCommand {

	/**
	 * @see hr.fer.zemris.java.tecaj.hw5.ShellCommand#executeCommand(java.io.BufferedReader, java.io.BufferedWriter, java.lang.String[])
	 * @param arguments Recieves path to the directory that should be created.
	 */
	@Override
	public ShellStatus executeCommand(BufferedReader in, BufferedWriter out,
			String[] arguments) {
		
		boolean isCreated = (new File(arguments[0])).mkdirs();
		
		if(!isCreated)
			System.err.println("Cannot create one or more directories!");
		
		return ShellStatus.CONTINUE;
	}

}
