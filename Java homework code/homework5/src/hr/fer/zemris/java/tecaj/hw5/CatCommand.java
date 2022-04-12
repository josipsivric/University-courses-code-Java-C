package hr.fer.zemris.java.tecaj.hw5;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Displays file in provided charset.
 * 
 * @author Josip Sivrić
 *
 */
public class CatCommand implements ShellCommand {

	/**
	 * @see hr.fer.zemris.java.tecaj.hw5.ShellCommand#executeCommand(java.io.BufferedReader, java.io.BufferedWriter, java.lang.String[])
	 * @param arguments Recieves path to the file and charset for dispaying a file.
	 */
	@Override
	public ShellStatus executeCommand(BufferedReader in, BufferedWriter out,
			String[] arguments) {
		
		Path filepath = Paths.get(arguments[0]);
		
		Charset charset = Charset.defaultCharset();
		if(arguments[1] != null)
			if (Charset.isSupported(arguments[1])) {
				charset = Charset.forName(arguments[1]);
			}
		try {
			char[] buff = new char[2048];
			BufferedReader br = new BufferedReader(new InputStreamReader(
								new BufferedInputStream(new FileInputStream(filepath.toFile())),
								charset));
			while(br.read(buff) != -1)
				out.write(buff);
		} catch (IOException e) {
			System.err.println("File not found or cannot write output!");
			return ShellStatus.CONTINUE;
		}
		return ShellStatus.CONTINUE;
	}

}
