package hr.fer.zemris.java.tecaj.hw5;

import java.util.HashMap;
import java.util.Map;

public class MyShell {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Welcome to MyShell v 1.0");
		
		Map<String, ShellCommand> commands = new HashMap<String, ShellCommand>();
		
		commands.put("exit", new ExitCommand());
		commands.put("cat", new CatCommand());
		commands.put("ls", new LsCommand());
		commands.put("mkdir", new MkdirCommand());
		commands.put("tree", new TreeCommand());
		commands.put("hexdump", new HexdumpCommand());
		commands.put("copy", new CopyCommand());
		commands.put("charsets", new CharsetsCommand());
		commands.put("copy", new CopyCommand());
		commands.put("symbol", new Symbol());
		
//		repeat {
//			  l = readLineOrLines
//			  String commandName = extract from l
//			  String[] arguments = extract from l
//			  command = commands.get(commandName)
//			  status = command.executeCommand(in, out, arguments)
//			} until status!=TERMINATE

	}
}
