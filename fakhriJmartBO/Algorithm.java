package fakhriJmartBO;

import java.util.Arrays;
import java.util.Iterator;

public class Algorithm {
	private Algorithm() {
		
	}
	
	
	
	
	public static <T> int count(T[] array, T value) {
		final Iterator<T> x= Arrays.stream(array).iterator();
		return count(x, value);
	}
	public static <T> int count(Iterable<T> iterable, T value) {
		final Iterator <T> x  = iterable.iterator();
		return count(x,value);
	}
	public static <T> int count(Iterator<T> iterator, T value) {
		final Predicate <T> pred = value::equals;
		return count(iterator,value);
	}
	public static <T> int count(T[] array, Predicate<T> pred) {
		final Iterator<T> x = Arrays.stream(array).iterator();
		return count(x, pred);
	}
	public static <T> int count(Iterable<T> iterable, Predicate<T> pred) {
		final Iterator<T> x = iterable.iterator();
		return count(x, pred);
	}
	public static <T> int count(Iterator<T> iterator, Predicate<T> pred) {
		return count(iterator,pred);
	}
	
	
	public static <T> boolean exists(T[] array, T value) {
		final Iterator<T> x = Arrays.stream(array).iterator();
		return exists(x, value);
	}
	public static <T> boolean exists(Iterable<T> iterable, T value) {
		final Iterator <T> x  = iterable.iterator();
		return exists(x,value);
	}
	public static <T> boolean exists(Iterator<T> iterator, T value) {
		final Predicate <T> pred = value::equals;
		return exists(iterator,value);
	}
	public static <T> boolean exists(T[] array, Predicate<T> pred) {
		final Iterator<T> x = Arrays.stream(array).iterator();
		return exists(x, pred);
	}
	public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred) {
		final Iterator <T> x = iterable.iterator();
		return exists(x,pred);
	}
	public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred) {
		return exists(iterator,pred);
	}
	
	
	public static <T> T find(T[] array, T value) {
		final Iterator<T> x = Arrays.stream(array).iterator();
		return find(x, value);
	}
	public static <T> T find(Iterable<T> iterable, T value) {
		final Iterator <T> x = iterable.iterator();
		return find(x, value);
	}
	public static <T> T find(Iterator<T> iterator, T value) {
		final Predicate <T> pred = value::equals;
		return find(iterator,value);
	}
	public static <T> T find(T[] array, Predicate<T> pred) {
		final Iterator<T> x = Arrays.stream(array).iterator();
		return find(x, pred);
	}
	public static <T> T find(Iterable<T> iterable, Predicate<T> pred) {
		final Iterator <T> x = iterable.iterator();
		return find(x, pred);
	}
	
	
	public static <T> T find(Iterator<T> iterator, Predicate<T> pred) {
		return find(iterator,pred);
	}
	
	public <T extends Comparable<? super T>> T max(T first, T  second)
    {
        T maximum;
		if(first.compareTo(second) > 0)
        {
            maximum = first;
        }
		else {
			maximum = second;
		}
        return maximum;
    }

    public <T extends Comparable<? super T>> T min(T  first, T  second)
    {
    	T minimum;
		if(first.compareTo(second) < 0)
        {
			minimum = first;
        }
		else {
			minimum = second;
		}
        return minimum;
    }




	





	
}
