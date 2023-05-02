package ExerciseThree;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;

import javax.swing.JComponent;

public class PlotVegetation extends Plot {

    private VegetationData vd;
    private boolean useColour;
    private boolean useMap;

    public PlotVegetation(VegetationData vd, boolean useColour, boolean useMap) {
        this.vd = vd;
        this.useColour = useColour;
        this.useMap = useMap;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        int[][] dataArray = new int[width][height];

        if (useMap) {
            System.out.println("Using Map");
            for (double lon = -180; lon < 180; lon += 0.1) {
                Map<Double, Integer> latMap =  vd.getFromMap(lon);
                if (latMap != null) {
                    for (double lat = -90; lat < 90; lat += 0.1) {
                        Integer vegetation = latMap.get(lat);
                        if (vegetation != null) {
                            int x = (int) (((lon + 180) / 360) * width);
                            int y = (int) (((90 - lat) / 180) * height);
                            dataArray[x][y] = vegetation;
                        }
                    }
                }
            }
        } else {
            int resolution = vd.getResolution();
            double longitudeInterval = 360.0 / resolution;
            double latitudeInterval = 180.0 / (resolution / 2);

            for (int i = 0; i < resolution; i++) {
                for (int j = 0; j < resolution / 2; j++) {
                    double longitude = (i * longitudeInterval) - 180.0;
                    double latitude = 90.0 - (j * latitudeInterval);

                    int x = (int) ((i / (double) resolution) * width);
                    int y = (int) ((j / (double) (resolution / 2)) * height);

                    dataArray[x][y] = vd.getFromArray((int) longitude, (int) latitude);
                }
            }
        }

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int vegetation = dataArray[i][j];

                if (vegetation == 0) {
                    g2d.setColor(Color.BLACK);
                } else if (vegetation == 254) {
                    g2d.setColor(Color.WHITE);
                } else {
                    double t = vegetation / 100.0;

                    if (useColour) {
                        Color color = Color.getHSBColor((float) (0.4 - t * 0.4), 0.8f, 0.9f);
                        g2d.setColor(color);
                    } else {
                        int gray = (int) (255 * (1 - t));
                        g2d.setColor(new Color(gray, gray, gray));
                    }
                }

                g2d.fillRect(i, j, 1, 1);
            }
        }
    }

}
