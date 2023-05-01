package ExerciseFour;

import java.awt.*;
import java.io.FileNotFoundException;

public class TreePricePlot extends Plot {

    TreePriceData treePriceData;
    TreePricePlot(String fileName) throws FileNotFoundException {
        treePriceData = new TreePriceData(fileName);
    }

    @Override
    public void paintComponent(Graphics graphics){
        Graphics2D g2d = (Graphics2D) graphics;
//        width = getWidth();
//        height = getHeight();
        final int N = treePriceData.getDataLength();
        int[] xNominalPrice = new int[N];
        int[] xRealPrice = new int[N];
        int[] y = new int[N];
        xmax = 200;
        ymax = 80;
         for (int i=0; i<N; i++){
             double xNominal = treePriceData.getPriceObject(i).getNominalPrice();
             double xReal = treePriceData.getPriceObject(i).getRealPrice();
             xNominalPrice[i] = scaleX(xNominal);
             xRealPrice[i] = scaleX(xReal);
             y[i] = scaleY(i);

         }
         g2d.setColor(Color.CYAN);
         g2d.drawPolyline(xRealPrice, y, N);
         g2d.setColor(Color.MAGENTA);
         g2d.drawPolyline(xNominalPrice, y, N);
    }
}
