//Nedovršeno
package hr.fer.zemris.java.custom.scripting.exec;

import java.util.LinkedHashMap;
import java.util.Map;

public class ObjectMultistack {
	
	private MultistackEntry head;
	private int numOfElements;
	private Map<String, MultistackEntry> stack = new LinkedHashMap<String, MultistackEntry>();
	
	private void LinkedList() {
		head = new MultistackEntry(null);
	}
	
	
	public void push(String name, ValueWrapper valueWrapper) {
		
		MultistackEntry temp = new MultistackEntry(valueWrapper);
	}

	public ValueWrapper pop(String name) {
		return null;
		
	}

	public ValueWrapper peek(String name) {
		return null;
		
	}

	public boolean isEmpty(String name) {
		return false;
		
	}
	
	private class MultistackEntry {
		
		private ValueWrapper value;
		private MultistackEntry next;
		
		public MultistackEntry(ValueWrapper value) {
			this.value = value;
			this.next = null;
		}
		
		public MultistackEntry(ValueWrapper value, MultistackEntry next) {
			this.value = value;
			this.next = next;
		}
		
		public ValueWrapper getValue() {
			return value;
		}

		public void setValue(ValueWrapper value) {
			this.value = value;
		}

		public MultistackEntry getNext() {
			return next;
		}

		public void setNext(MultistackEntry next) {
			this.next = next;
		}
	}
}