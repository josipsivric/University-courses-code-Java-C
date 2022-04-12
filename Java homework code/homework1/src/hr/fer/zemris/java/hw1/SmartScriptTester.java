package hr.fer.zemris.java.hw1;

import hr.fer.zemris.java.custom.scripting.nodes.DocumentNode;
import hr.fer.zemris.java.custom.scripting.parser.SmartScriptParser;
import hr.fer.zemris.java.custom.scripting.parser.SmartScriptParserException;

/**
 * @author Josip Sivrić (generic scriptlet by Marko Čupić)
 *
 */
public class SmartScriptTester {

	public static void main(String[] args) {
		
		String docBody = "....";
		SmartScriptParser parser = null;
		
		try {
			parser = new SmartScriptParser(docBody);
		} catch(SmartScriptParserException e) {
			System.out.println("Unable to parse document!");
			System.exit(-1);
		} catch(Exception e) {
			System.out.println("If this line ever executes, you have failed this class!");
			System.exit(-1);
		}
		
		DocumentNode document = parser.getDocumentNode();
		String originalDocumentBody = createOriginalDocumentBody(document);
		System.out.println(originalDocumentBody); // should write something like original
		                                          // content of docBody
	}

	private static String createOriginalDocumentBody(DocumentNode document) {
		// Nedovršeno
		return null;
	}
}