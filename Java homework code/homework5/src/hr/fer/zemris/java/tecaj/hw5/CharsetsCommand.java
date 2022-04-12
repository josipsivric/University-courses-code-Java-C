package hr.fer.zemris.java.tecaj.hw5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;

/**
 * Lists all available charsets from system.
 * 
 * @author Josip Sivrić
 *
 */
public class CharsetsCommand implements ShellCommand {

	/**
	 * @see hr.fer.zemris.java.tecaj.hw5.ShellCommand#executeCommand(java.io.BufferedReader, java.io.BufferedWriter, java.lang.String[])
	 * @param arguments Doesn't recieve any arguments.
	 */
	@Override
	public ShellStatus executeCommand(BufferedReader in, BufferedWriter out,
			String[] arguments) {
		
		SortedMap<String, Charset> chars = Charset.availableCharsets();
		Iterator<String> it = chars.keySet().iterator();
		while(it.hasNext()) {
			String charset = it.next();
			try {
				out.write(charset);
				out.newLine();
			} catch (IOException e) {
				System.err.println("I/O Exception occured!");
				return ShellStatus.CONTINUE;
			}
		}
		return ShellStatus.CONTINUE;
	}

}
