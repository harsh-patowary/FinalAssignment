package ExerciseThree;

import java.io.*;
import java.util.*;

public class VegetationData {
    private int resolution;
    private int[][] dataArray;
    private NavigableMap<Double, Map<Double, Integer>> dataMap;

    public VegetationData(String filename, int i) {
        readData(filename);
    }

    private void readData(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            double lat, lon;
            int density;
            double latIndex, lonIndex;
            double latMin = -90.0;
            double latMax = 90.0;
            double lonMin = -180.0;
            double lonMax = 180.0;
            double latRange = latMax - latMin;
            double lonRange = lonMax - lonMin;
            int resolutionX = 2000;
            this.resolution = resolutionX;
            int resolutionY = 1000;
            dataArray = new int[resolutionY][resolutionX];
            dataMap = new TreeMap<>();

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                lon = Double.parseDouble(parts[0]);
                lat = Double.parseDouble(parts[1]);
                density = Integer.parseInt(parts[2]);
                latIndex = (lat - latMin) / latRange * (resolutionY - 1);
                lonIndex = (lon - lonMin) / lonRange * (resolutionX - 1);
                dataArray[(int)latIndex][(int)lonIndex] = density;

                if (!dataMap.containsKey(lon)) {
                    Map<Double, Integer> hm= new HashMap<>();
                    hm.put(lat, density);
                    dataMap.put(lon, hm);
                }
                dataMap.get(lon).put(lat, density);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getFromArray(int x, int y) {
        return dataArray[y][x];
    }

    public Map<Double, Integer> getFromMap(double lon) {
//        Map.Entry<Double, Map<Double, Integer>> lonEntry = dataMap.floorEntry(lon);
////        if (lonEntry == null) {
////            return null;
////        }
//        NavigableMap<Double, Integer> latMap = (NavigableMap<Double, Integer>) lonEntry.getValue();
//        Map.Entry<Double, Integer> latEntry = latMap.floorEntry(lon);
        Map<Double, Integer> hm = this.dataMap.get(lon);

        return hm;
    }

    public int getResolution() {
        return this.resolution;
    }


}


