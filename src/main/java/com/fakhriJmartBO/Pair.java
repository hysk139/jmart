package com.fakhriJmartBO;

/**
 * Class Pair
 *
 * @author Ahmad Fakhri
 * 
 */

public class Pair<T,U>{
	public T first;
	public U second;
	
	public Pair() {
		
	}
	public Pair(T first, U second) {
		this.first = first;
		this.second = second;
	}
}
