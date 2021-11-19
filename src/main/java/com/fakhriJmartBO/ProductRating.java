package com.fakhriJmartBO;



public class ProductRating
{
    private long total;
    private long count;
    
    public ProductRating(){
        this.total = 0L;
        this.count = 0L;
    }
    
    public void insert(int rating){
        this.total += rating;
        count++;
    }
    
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
