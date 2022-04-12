package hr.fer.zemris.java.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class NoDupLines {
	
	public static void main(String[] args) throws IOException {
		
		List<String> list = new ArrayList<String>();
		String recieved;
		int i = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			if((recieved = br.readLine()).equals(null))
				break;
			list.add(recieved);
		}
		
		String[] enteredLines = new String[list.size()];
		for(String elem : list) {
			if(elem == null)
				break;
			enteredLines[i] = elem;
			i++;
		}
		
		removeDupeLines(enteredLines);
	}
	
	static void removeDupeLines(String[] args) {
		
		Set<String> set = new LinkedHashSet<String>();
		
		for(String element : args)
			set.add(element);
		
		List<String> list = new ArrayList<String>(set);
		Collections.reverse(list);
		
		for(String element : list)
			System.out.println(element);
	}
}
