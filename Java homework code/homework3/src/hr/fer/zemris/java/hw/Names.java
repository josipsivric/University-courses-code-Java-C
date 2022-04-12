package hr.fer.zemris.java.hw;

import java.io.BufferedReader;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Names {
	
	void readAndCompare() throws IOException, FileNotFoundException {
		
		String file1;
		String file2;
		ArrayList<String> names1 = new ArrayList<String>();
		ArrayList<String> names2 = new ArrayList<String>();
		int flag;
		
		System.out.println("Please enter name of the first file: ");
		BufferedReader read1 = new BufferedReader(new InputStreamReader(System.in));
		
		file1 = read1.readLine();
		
		System.out.println("Please enter name of the second file: ");
		BufferedReader read2 = new BufferedReader(new InputStreamReader(System.in));
		
		file2 = read2.readLine();
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						new BufferedInputStream(new FileInputStream(file1)), "UTF-8"));
		
			while(true) {
			    String line = br.readLine();
			    
			    if(line==null)
			    	break;
			    line = line.trim();
			    
			    if(line.isEmpty())
			    	continue;
			    names1.add(line);
			    System.out.println("Got line: "+line);
			}
			br.close();
			
			BufferedReader br2 = new BufferedReader(
					new InputStreamReader(
							new BufferedInputStream(new FileInputStream(file2)), "UTF-8"));
			
			while(true) {
			    String line = br2.readLine();
			    
			    if(line==null)
			    	break;
			    line = line.trim();
			    
			    if(line.isEmpty())
			    	continue;
			    names2.add(line);
			    System.out.println("Got line: "+line);
			}
			br.close();
			
			System.out.println("Names that are in first file but aren't in second: ");
			for (String element1 : names1) {
				flag = 1;
				for(String element2 : names2) {
					if (element1 == element2) {
						flag = 0;
						break;
					}
				}
				if (flag == 1)
					System.out.println("element1");
			}
	}
}
