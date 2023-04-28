package ExerciseFour;

public class TreePrice implements Comparable<TreePrice> {
    private double realPrice;
    private double nominalPrice;
    private PriceData priceDate;

    public TreePrice(double realPrice, double nominalPrice, PriceData priceDate) {
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

    public PriceData getPriceDate() {
        return priceDate;
    }

    @Override
    public int compareTo(TreePrice other) {
//        return this.priceDate.compareTo(other.getPriceDate());
        return this.priceDate.compareTo(other.getPriceDate());
    }

    @Override
    public String toString() {
        return priceDate.toString() + " Nominal: " + nominalPrice + " Real: " + realPrice;
    }
}

