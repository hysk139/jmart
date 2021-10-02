package fakhriJmartBO;
import java.util.ArrayList;


/**
 * Write a description of class Filter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Filter
{
    // instance variables - replace the example below with your own
    public ArrayList<PriceTag> filterPriceTag(PriceTag[] list, int value, boolean less){
        ArrayList<PriceTag> priceTags = new ArrayList<>();
        for (PriceTag e : list) {
            if (less && e.getAdjustedPrice() < value || !less && e.getAdjustedPrice() >= value)
            {
                priceTags.add(e);
            }
        }
        return priceTags;
    }
    
    public static void filterProductRating(ArrayList<ProductRating> list, double value, boolean less) 
    {
        for (int i = 0; i < list.size(); ++i) 
        {
            final ProductRating e = list.get(i);
            if (less && e.getAverage() < value || !less && e.getAverage() >= value)
            {
                list.remove(i);
            }
        }
    }
}
