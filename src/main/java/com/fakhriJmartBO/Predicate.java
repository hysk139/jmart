package com.fakhriJmartBO;

/**
 * Class Predicate
 *
 * @author Ahmad Fakhri
 * 
 */

@FunctionalInterface
public interface Predicate<T> {
	public abstract boolean predicate (T arg);
}
