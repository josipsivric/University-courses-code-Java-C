package hr.fer.zemris.java.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NamesCounter {
	
	public static void main(String[] args) throws IOException {
		
		String name;
		String exitSeq = "quit";
		int count;
		List<String> list = new ArrayList<String>();
		Set<String> set = new HashSet<String>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Please enter names (to stop entering type \"quit\" without aphostrophes): ");
		
		while(true) {
			if ((name = br.readLine()).equals(exitSeq))
				break;
			list.add(name);
		}
		
		for (String element : list)
			set.add(element);
		
		for(String elem : set) {
			count = Collections.frequency(list, elem);
			System.out.println(elem + ": " + count);
		}
	}
}
