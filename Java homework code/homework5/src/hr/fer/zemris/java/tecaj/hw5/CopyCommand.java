package hr.fer.zemris.java.tecaj.hw5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.*;

/**
 * Copies file to destination. If directory is destination, files will have same names. If file is destination it can be overwritten.
 * @author Josip Sivrić
 *
 */
public class CopyCommand implements ShellCommand {

	/**
	 * @see hr.fer.zemris.java.tecaj.hw5.ShellCommand#executeCommand(java.io.BufferedReader, java.io.BufferedWriter, java.lang.String[])
	 * @param arguments Recieves file source and file destination as arguments.
	 */
	@Override
	public ShellStatus executeCommand(BufferedReader in, BufferedWriter out,
			String[] arguments) {
		
		Path source = Paths.get(arguments[0]);
		Path destination = Paths.get(arguments[1]);
		File file = new File(arguments[1]);
		String decision = null;
		String yes = "yes";
		String no = "no";
		
		boolean isDir = file.isDirectory();
		
		if(isDir)
			try {
				Files.copy(source, destination.resolve(source.getFileName()));
			} catch (IOException e2) {
				System.err.println("Cannot copy file!");
				return ShellStatus.CONTINUE;
			}
		
		boolean exists = file.exists();
		
		if(exists) {
			try {
				out.write("File already exist! Do you want to over write it? (type \"yes\" or \"no\")");
			} catch (IOException e1) {
				System.err.println("Cannot write output!");
				return ShellStatus.CONTINUE;
			}
			try {
				decision = in.readLine();
			} catch (IOException e1) {
				System.err.println("Cannot read input!");
				return ShellStatus.CONTINUE;
			}
			
			if (decision.equalsIgnoreCase(yes)) {
				try {
					Files.copy(source, destination, REPLACE_EXISTING);
				} catch (IOException e) {
					System.err.println("Cannot copy file!");
					return ShellStatus.CONTINUE;
				}
			} else if (decision.equalsIgnoreCase(no)){
				try {
					out.write("You decided not to overwrite existing file!");
				} catch (IOException e) {
					System.err.println("Cannot read input!");
					return ShellStatus.CONTINUE;
				}
				return ShellStatus.CONTINUE;
			} else {
				try {
					out.write("Unknown command! Copying aborted!");
				} catch (IOException e) {
					System.err.println("Cannot read input!");
					return ShellStatus.CONTINUE;
				}
			}
		}
		return null;
	}

}
