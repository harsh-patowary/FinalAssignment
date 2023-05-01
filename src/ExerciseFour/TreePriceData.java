package ExerciseFour;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class TreePriceData {
    private ArrayList<TreePrice> treePrices = new ArrayList<>();

    TreePriceData(String fileName) throws FileNotFoundException {
        BufferedReader fileReader =
                new BufferedReader(
                        new FileReader(fileName));

        try {
            String line = "";
            int i = 0;
            while ((line = fileReader.readLine()) != null) {
                String[] data = line.split(",");
                if (i > 0) {
                    String[] date = data[0].split("-");
                    PriceDate currPriceDate = new PriceDate(
                            Integer.parseInt(date[0]),
                            date[1],
                            Integer.parseInt(date[2])
                    );
                    TreePrice treePrice = new TreePrice(
                            currPriceDate,
                            Double.parseDouble(data[1]),
                            Double.parseDouble(data[2])
                    );
                    treePrices.add(treePrice);
                }
                i++;
            }
            fileReader.close();
            Collections.sort(treePrices);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public int getDataLength(){
        return this.treePrices.size();
    }
    public TreePrice getPriceObject(int index){
        return treePrices.get(index);
    }
    public TreePrice getMin(){
        return treePrices.get(0);
    }
    public TreePrice getMax(){
        return treePrices.get(treePrices.size()-1);
    }
}
