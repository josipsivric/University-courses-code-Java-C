package hr.fer.zemris.java.hw;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class DuplicateRemover {
	
	public static void main(String[] args) {
		
		System.out.println("Using HashSet:");
		printSet(removeDupes1(args));
		System.out.println();
		
		System.out.println("Using TreeSet:");
		printSet(removeDupes2(args));
		System.out.println();
		
		System.out.println("Using LinkedHashSet:");
		printSet(removeDupes3(args));
		System.out.println();
		
	}
		
		private static void printSet(Collection<String> col) {
			for (String element : col) {
				System.out.println(element);
			}
		}
		
		private static void printSet2(Collection<String> col) {
			Iterator<String> iterator = col.iterator ();
			
			while(iterator.hasNext()) {
				System.out.println(iterator.next());
			}
		}
		
		private static Collection<String> removeDupes1(String[] array) {
			Set<String> set = new HashSet<String>();
			
			for (String element : array) {
				set.add(element);
			}
			return set;
		}
		
		private static Collection<String> removeDupes2(String[] array) {
			Set<String> set = new TreeSet<String>();
			
			for (String element : array) {
				set.add(element);
			}
			return set;
		}
		
		private static Collection<String> removeDupes3(String[] array) {
			Set<String> set = new LinkedHashSet<String>();
			
			for (String element : array) {
				set.add(element);
			}
			return set;
		}
	}