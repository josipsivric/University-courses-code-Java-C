package hr.fer.zemris.java.hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LikeMedian<T extends Comparable<? super T>> {

	private List<T> data = new ArrayList<T>();
	
	public void add(T object) {
		data.add(object); 
	}
	
	public T get() {
		Collections.sort(data);
		int size = data.size();
		
		if(size%2 == 1)
			return data.get((size/2));
		else
			return data.get(size/2-1);
	}
}
