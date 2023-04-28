package ExerciseFour;

package ex4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TreePriceData {
    private List<TreePrice> prices;

    public TreePriceData(String filename) {
        prices = new ArrayList<TreePrice>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine(); // Skip header line
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                double nominalPrice = Double.parseDouble(parts[1]);
                double realPrice = Double.parseDouble(parts[2]);
                String[] dateParts = parts[0].split("-");
                int day = Integer.parseInt(dateParts[0]);
                int month = convertMonth(dateParts[1]);
                int year = Integer.parseInt(dateParts[2]) + 2000;
                PriceDate priceDate = new PriceDate(day, month, year);
                TreePrice price = new TreePrice(realPrice, nominalPrice, priceDate);
                prices.add(price);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<TreePrice> getPrices() {
        return prices;
    }

    private int convertMonth(String monthString) {
        switch (monthString) {
            case "Jan":
                return 1;
            case "Feb":
                return 2;
            case "Mar":
                return 3;
            case "Apr":
                return 4;
            case "May":
                return 5;
            case "Jun":
                return 6;
            case "Jul":
                return 7;
            case "Aug":
                return 8;
            case "Sep":
                return 9;
            case "Oct":
                return 10;
            case "Nov":
                return 11;
            case "Dec":
                return 12;
            default:
                return -1;
        }
    }
}
