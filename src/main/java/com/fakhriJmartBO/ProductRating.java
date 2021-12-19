package com.fakhriJmartBO;

/**
 * Class ProductRating which is the class for giving ratings to products
 *
 * @author Ahmad Fakhri
 * 
 */

public class ProductRating
{
    private long total;
    private long count;
    
    /**
     * Constructor productrating
     */
    public ProductRating(){
        this.total = 0L;
        this.count = 0L;
    }
    
    /**
     * @param rating
     * Inserting rating
     */
    public void insert(int rating){
        this.total += rating;
        count++;
    }
    
    /**
     * @return
     * Get average score for rating
     */
    public double getAverage(){
        if(count == 0)
        {
            return 0;
        }
        return (double) (total/count);
    }
    
    public long getCount(){
        return count;
    }
    
    public long getTotal(){
        return total;
    }

}
