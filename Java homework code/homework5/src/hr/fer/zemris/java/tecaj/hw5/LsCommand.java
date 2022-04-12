package hr.fer.zemris.java.tecaj.hw5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Lists directory. Shows file attributes, size, creation date and time, and names.
 * 
 * @author Josip Sivrić
 *
 */
public class LsCommand implements ShellCommand {

	/**
	 * @see hr.fer.zemris.java.tecaj.hw5.ShellCommand#executeCommand(java.io.BufferedReader, java.io.BufferedWriter, java.lang.String[])
	 * @param arguments Recieves path to the directory that should be listed.
	 */
	@Override
	public ShellStatus executeCommand(BufferedReader in, BufferedWriter out,
			String[] arguments) {
		
		String firstColumn = null;
		String secondColumn = null;
		String thirdColumn = null;
		String fourthColumn = null;
		
		File directory = new File(arguments[0]);
		
		File[] files = directory.listFiles();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		
		for(int index = 0; index < files.length; index++){
			if(files[index].isDirectory())
				firstColumn += "d";
			else
				firstColumn += "-";
			
			if(files[index].canRead())
				firstColumn += "r";
			else
				firstColumn += "-";
			
			if(files[index].canWrite())
				firstColumn += "w";
			else
				firstColumn += "-";
			
			if(files[index].canExecute())
				firstColumn += "x";
			else
				firstColumn += "-";
			
			secondColumn = Long.toString(files[index].length());
			
			Path path = Paths.get(files[index].getPath());
			BasicFileAttributeView faView = Files.getFileAttributeView(path,
					BasicFileAttributeView.class, LinkOption.NOFOLLOW_LINKS);
			
			BasicFileAttributes attributes;
			try {
				attributes = faView.readAttributes();
			} catch (IOException e) {
				System.err.println("Cannot read file atributes!");
				return ShellStatus.CONTINUE;
			}
			
			FileTime fileTime = attributes.creationTime();
			String formattedDateTime = sdf.format(new Date(fileTime.toMillis()));
			
			thirdColumn = formattedDateTime;
			
			fourthColumn = files[index].getName();
			
			String outputFormatted = String.format("%1$s %2$10s %3$s %4$s", firstColumn, secondColumn, thirdColumn, fourthColumn);
			
			try {
				out.write(outputFormatted);
				out.newLine();
			} catch (IOException e) {
				System.err.println("Unable to write!");
				return ShellStatus.CONTINUE;
			}
		}
		return ShellStatus.CONTINUE;
	}
}
