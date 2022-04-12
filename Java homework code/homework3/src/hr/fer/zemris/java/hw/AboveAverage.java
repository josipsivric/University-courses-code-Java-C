package hr.fer.zemris.java.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AboveAverage {
	
	public static void main(String[] args) throws IOException {
		
		String maybeNumber;
		String exitSeq = "quit";
		Double[] allNumbers = new Double[16];
		int i = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			if ((maybeNumber = br.readLine()).equals(exitSeq))
				break;
			else 
				allNumbers[i] = Double.parseDouble(maybeNumber);
			i++;
		}
		
		findAboveAverage(allNumbers);
	}
	
	static void findAboveAverage(Double[] numbers) {
		double sum = 0;
		double average = 0;
		double aboveFor20 = 0;
		
		for(Double element : numbers) {
			if(element == null)
				break;
			sum = sum + element;
		}
		
		average = sum/numbers.length;
		
		aboveFor20 = average*0.2 + average;
		
		List<Double> aboveAverage = new ArrayList<Double>();
		
		for(Double elem : numbers) {
			if(elem == null)
				break;
			if(elem > aboveFor20) 
				aboveAverage.add(elem);
		}
	
		Collections.sort(aboveAverage);
		
		for(Double el : aboveAverage)
			System.out.println(el);
	}
}
