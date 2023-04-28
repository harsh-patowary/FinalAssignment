package ExerciseFour;
\
import javax.swing.JFrame;

public class MainEx4 {

    public static void main(String[] args) {
        try {
            String filename = "treePrices.csv";
            PriceData priceData = new PriceData(filename);
            TreePricePlot plot = new TreePricePlot(priceData);
            JFrame frame = new JFrame("Tree Price Plot");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(plot);
            frame.pack();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
