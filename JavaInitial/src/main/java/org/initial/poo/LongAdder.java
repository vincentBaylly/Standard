package org.initial.poo;

public class LongAdder {
	
	private int sum;
	
	public void add(int value) {
		sum += value;
	}
	
	public String toString() {
		return "la somme est de: " + sum;
	}
}
