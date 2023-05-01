package ExerciseFour;

public class TreePrice implements Comparable<TreePrice>{
    private double realPrice, nominalPrice;
    private PriceDate priceDate;

    public TreePrice(PriceDate priceDate,  double nominalPrice, double realPrice) {
        this.realPrice = realPrice;
        this.nominalPrice = nominalPrice;
        this.priceDate = priceDate;
    }

    public double getRealPrice() {
        return realPrice;
    }

    public double getNominalPrice() {
        return nominalPrice;
    }

    public PriceDate getPriceDate() {
        return priceDate;
    }

    @Override
    public int compareTo(TreePrice other) {
        return this.priceDate.compareTo(other.priceDate);
    }

    @Override
    public String toString(){
        return priceDate.toString()+" Nominal: "+this.nominalPrice+" Real Price: "+ this.realPrice;
    }
}
