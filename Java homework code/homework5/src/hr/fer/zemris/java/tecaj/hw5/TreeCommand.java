package hr.fer.zemris.java.tecaj.hw5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

/**
 * Lists directory tree.
 * 
 * @author Josip Sivrić
 *
 */
public class TreeCommand implements ShellCommand {

	/**
	 * @see hr.fer.zemris.java.tecaj.hw5.ShellCommand#executeCommand(java.io.BufferedReader, java.io.BufferedWriter, java.lang.String[])
	 * @param arguments Recieves directory that is root for listing.
	 */
	@Override
	public ShellStatus executeCommand(BufferedReader in, BufferedWriter out,
			String[] arguments) {
		
		int indent = 1;
		
		File direktorij = new File(arguments[0]);
		recursiveListing(direktorij, indent, out);
		
		return ShellStatus.CONTINUE;
	}
	
	/**
	 * @param direktorij
	 * @param indent
	 * @param out
	 */
	private static void recursiveListing (File direktorij, int indent, BufferedWriter out) {
		
		File[] children = direktorij.listFiles();
		indent++;
		if (children == null)
			return;

		for (File file : children) {
			if (file.isDirectory()) {
				for(int tmpIndent = indent; tmpIndent > 0; tmpIndent--)
					try {
						out.write("    ");
					} catch (IOException e) {
						System.err.println("Cannot write output!");
						System.exit(1);
					}
				try {
					out.write(file.getName());
					out.newLine();
				} catch (IOException e) {
					System.err.println("Cannot write output!");
					System.exit(1);
				}
				recursiveListing(file, indent, out);
			}
			for(int tmpIndent = indent; tmpIndent > 0; tmpIndent--)
				try {
					out.write("    ");
				} catch (IOException e) {
					System.err.println("Cannot write output!");
					return;
				}
			try {
				out.write(file.getName());
				out.newLine();
			} catch (IOException e) {
				System.err.println("Cannot write output!");
				return;
			}
		}
		indent--;
	}
}
