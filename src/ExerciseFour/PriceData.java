package ExerciseFour;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class PriceData {

    private ArrayList<TreePrice> prices;

    public PriceData(String filename) throws IOException {
        prices = new ArrayList<TreePrice>();
        readData(filename);
    }

    private void readData(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = reader.readLine(); // skip first line with headers
        while ((line = reader.readLine()) != null) {
            String[] tokens = line.split(",");
            String date = tokens[0].trim();
            double nominal = Double.parseDouble(tokens[1].trim());
            double real = Double.parseDouble(tokens[2].trim());
            PriceData priceData = new PriceData(date);
            TreePrice price = new TreePrice(nominal, real, priceData);
            prices.add(price);
        }
        reader.close();
        Collections.sort(prices); // sort prices by date
    }

    public ArrayList<TreePrice> getPrices() {
        return prices;
    }

}

