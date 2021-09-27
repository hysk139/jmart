package fakhriJmartBO;



public class Product extends Recognizable implements FileParser
{
    //private static int idCounter;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public ProductRating rating;
    public int storeId;
    Shipment.MultiDuration multiDuration;
    
    public Product(int id, int storeId, String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category, Shipment.MultiDuration multiDuration){
        super(id);
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.rating = new ProductRating();
        this.storeId = storeId;
        this.multiDuration = multiDuration;
    }
    
    public Product(int id, Store store, String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category){
        super(id);
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.rating = new ProductRating();
    }
    @Override
    public boolean read(String content){
        return false;
    }
    @Override
    public String toString(){
        return "Name: " + this.name + "\nWeight: "+ this.weight + "\nconditionUsed: " + this.conditionUsed + "\npriceTag: " + this.priceTag.price + "\ncategory: " + this.category + "\nrating: " + this.rating.getAverage() + "\nstoreId: " + this.storeId;
    }
    

    
}
