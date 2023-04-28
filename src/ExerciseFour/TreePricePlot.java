package ExerciseFour;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;

import javax.swing.JComponent;

public class TreePricePlot extends JComponent {

    private static final long serialVersionUID = 1L;
    private static final int PADDING = 50;

    private TreePriceData data;
    private double xScale;
    private double yScale;

    public TreePricePlot() throws IOException {
        data = new TreePriceData("treePrices.csv");
        setPreferredSize(new Dimension(800, 600));
        addMouseListener(new PriceMouseListener());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        // Draw x and y axis
        g.drawLine(PADDING, height - PADDING, width - PADDING, height - PADDING);
        g.drawLine(PADDING, height - PADDING, PADDING, PADDING);

        // Get max and min prices
        double maxPrice = data.getMaxPrice();
        double minPrice = data.getMinPrice();

        // Calculate x and y scales
        xScale = (double) (width - 2 * PADDING) / (data.getNumPrices() - 1);
        yScale = (double) (height - 2 * PADDING) / (maxPrice - minPrice);

        // Plot nominal prices
        List<TreePrice> nominalPrices = data.getNominalPrices();
        g.setColor(Color.BLUE);
        plotPrices(g, nominalPrices);

        // Plot real prices
        List<TreePrice> realPrices = data.getRealPrices();
        g.setColor(Color.RED);
        plotPrices(g, realPrices);
    }

    private void plotPrices(Graphics g, List<TreePrice> prices) {
        for (int i = 0; i < prices.size(); i++) {
            TreePrice price = prices.get(i);
            int x = (int) (PADDING + i * xScale);
            int y = (int) (getHeight() - PADDING - (price.getNominalPrice() - data.getMinPrice()) * yScale);
            g.fillOval(x - 2, y - 2, 4, 4);
            g.drawString(price.getPriceDate().toString(), x, getHeight() - PADDING + 15);
        }
    }

    private class PriceMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            Point clickPoint = e.getPoint();
            TreePrice closestPrice = data.getClosestPrice(clickPoint.x, xScale);
            System.out.println("Closest price to click: " + closestPrice);
        }
    }
}
