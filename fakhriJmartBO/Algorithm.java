package fakhriJmartBO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Algorithm {
	private Algorithm() {
		
	}
	
	
	public static <T> List<T> collect(T[] array, T value) {
        List<T> list = new ArrayList<T>();
        for(T t : array){
            if(t.equals(value)){
                list.add(t);
            }
        }
        return list;
    }
	
	public static <T> List<T> collect(Iterable<T> iterable, T value) {
        List<T> list = new ArrayList<T>();
        final Iterator <T> x  = iterable.iterator();
        while(x.hasNext()){
            if(x.next().equals(value)){
                list.add(x.next());
            }
        }
        return list;
    }
	
    public static<T> List<T> collect(Iterator<T> iterator, T value) {
        List<T> list = new ArrayList<T>();
        while(iterator.hasNext()) {
            T t = iterator.next();
            if(t.equals(value)) {
                list.add(t);
            }
        }
        return list;
    }

    public static<T> List<T> collect(T[] array, Predicate<T> pred) {
        List<T> list = new ArrayList<T>();
        for (T t: array) {
            if(pred.predicate(t)) {
                list.add(t);
            }
        }
        return list;
    }

    public static<T> List<T> collect(Iterable<T> iterable, Predicate<T> pred) {
        List<T> list = new ArrayList<T>();
        for (T t: iterable) {
            if(pred.predicate(t)) {
                list.add(t);
            }
        }
        return list;
    }


    public static<T> List<T> collect(Iterator<T> iterator, Predicate<T> pred) {
        List<T> list = new ArrayList<T>();
        while(iterator.hasNext()) {
            T t = iterator.next();
            if(pred.predicate(t)) {
                list.add(t);
            }
        }
        return list;
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
	
	public static <T extends Comparable<? super T>> T max(T first, T  second)
    {
        T maximum;
		if(first.compareTo(second) >= 0)
        {
            maximum = first;
        }
		else {
			maximum = second;
		}
        return maximum;
    }
	
	public static <T extends Comparable<? super T>> T max(T[] array)
    {
        T maximum = null;
        
        for (T x : array) {
        	if(x.compareTo(maximum) >= 0)
            {
                maximum = x;
            }
    		else {
    			maximum = maximum;
    		}
        }
		
        return maximum;
    }
	
	
	public static <T extends Comparable<? super T>> T max(Iterable<T> iterable)
    {
		final Iterator <T> x  = iterable.iterator();
		T maximum = null;
        while(x.hasNext()) {
        	if (x.next().compareTo(maximum) >= 0)
        	{
        		maximum = x.next();
        	}
        }
		
        return maximum;
    }
	
	public static <T extends Comparable<? super T>> T max(Iterable<T> iterable, Comparator<? super T> comparator)
    {
		final Iterator <T> x  = iterable.iterator();
		T maximum = null;
        while(x.hasNext()) {
        	if (comparator.compare(x.next(), maximum) >= 0)
        	{
        		maximum = x.next();
        	}
        }
		
        return maximum;
    }
	
	public static <T extends Comparable<? super T>> T max(T first, T  second, Comparator<? super T> comparator)
    {
        T maximum;
		if(comparator.compare(first, second) >= 0)
        {
            maximum = first;
        }
		else {
			maximum = second;
		}
        return maximum;
    }
	public static <T extends Comparable<? super T>> T max(T[] array, Comparator<? super T> comparator)
    {
        T maximum = null;
        
        for (T x : array) {
        	if(comparator.compare(x, maximum) >= 0)
            {
                maximum = x;
            }
    		else {
    			maximum = maximum;
    		}
        }
		
        return maximum;
    }
	
	public static <T extends Comparable<? super T>> T max(Iterator <T> iterator, Comparator<? super T> comparator)
    {
        T maximum = null;
        while(iterator.hasNext()) {
        	if(comparator.compare(iterator.next(), maximum)>= 0) {
        		maximum = iterator.next();
        	}
        }
        return maximum;
    }
	
	public static <T extends Comparable<? super T>> T max(Iterator <T> iterator)
    {
        T maximum = null;
        while(iterator.hasNext()) {
        	if(iterator.next().compareTo(maximum) >= 0) {
        		maximum = iterator.next();
        	}
        }
        return maximum;
    }
	
	
	
	

    public static <T extends Comparable<? super T>> T min(T  first, T  second)
    {
    	T minimum;
		if(first.compareTo(second) <= 0)
        {
			minimum = first;
        }
		else {
			minimum = second;
		}
        return minimum;
    }
    
    public static <T extends Comparable<? super T>> T min(T[] array)
    {
        T minimum = null;
        
        for (T x : array) {
        	if(x.compareTo(minimum) <= 0)
            {
                minimum = x;
            }
    		else {
    			minimum = minimum;
    		}
        }
		
        return minimum;
    }
    
    public static <T extends Comparable<? super T>> T min(Iterable<T> iterable)
    {
		final Iterator <T> x  = iterable.iterator();
		T minimum = null;
        while(x.hasNext()) {
        	if (x.next().compareTo(minimum) <= 0)
        	{
        		minimum = x.next();
        	}
        }
		
        return minimum;
    }
    
    public static <T extends Comparable<? super T>> T min(Iterable<T> iterable, Comparator<? super T> comparator)
    {
		final Iterator <T> x  = iterable.iterator();
		T minimum = null;
        while(x.hasNext()) {
        	if (comparator.compare(x.next(), minimum) <= 0)
        	{
        		minimum = x.next();
        	}
        }
		
        return minimum;
    }
    
    public static <T extends Comparable<? super T>> T min(T first, T  second, Comparator<? super T> comparator)
    {
        T minimum;
		if(comparator.compare(first, second) >= 0)
        {
			minimum = first;
        }
		else {
			minimum = second;
		}
        return minimum;
    }
    
    public static <T extends Comparable<? super T>> T min(T[] array, Comparator<? super T> comparator)
    {
        T minimum = null;
        
        for (T x : array) {
        	if(comparator.compare(x, minimum) <= 0)
            {
        		minimum = x;
            }
    		else {
    			minimum = minimum;
    		}
        }
		
        return minimum;
    }
    
    public static <T extends Comparable<? super T>> T min(Iterator <T> iterator, Comparator<? super T> comparator)
    {
        T minimum = null;
        while(iterator.hasNext()) {
        	if(comparator.compare(iterator.next(), minimum)>= 0) {
        		minimum = iterator.next();
        	}
        }
        return minimum;
    }
	
	public static <T extends Comparable<? super T>> T min(Iterator <T> iterator)
    {
        T minimum = null;
        while(iterator.hasNext()) {
        	if(iterator.next().compareTo(minimum) >= 0) {
        		minimum = iterator.next();
        	}
        }
        return minimum;
    }
	




	





	
}
