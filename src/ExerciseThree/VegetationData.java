package ExerciseThree;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VegetationData {
    private int[][] dataArray; // 2D array to store the tree density values
    private Map<Double, Map<Double, Integer>> dataMap;
    private double lonMin, latMin, lonMax, latMax; // min and max longitude and latitude values in the data
    int resolution; // resolution of the 2D array

    public VegetationData(String filename, int resolution) throws IOException{
        // Read the data from the file and store it as a list of arrays
        List<String> lines = Files.readAllLines(Paths.get(filename));
        List<double[]> data = lines.stream()
                .map(line -> line.split(" "))
                .map(values -> new double[] {
                        Double.parseDouble(values[0]),
                        Double.parseDouble(values[1]),
                        Double.parseDouble(values[2])
                })
                .collect(Collectors.toList());

        // Calculate the minimum and maximum values for longitude and latitude
        double lonMin = data.stream().mapToDouble(values -> values[0]).min().getAsDouble();
        double latMin = data.stream().mapToDouble(values -> values[1]).min().getAsDouble();
        double lonMax = data.stream().mapToDouble(values -> values[0]).max().getAsDouble();
        double latMax = data.stream().mapToDouble(values -> values[1]).max().getAsDouble();

        // Set the resolution and initialize the dataArray
        this.resolution = resolution;
        this.dataArray = new int[resolution][resolution/2];

        // Loop through the data and add each point to the dataArray
        for (double[] values : data) {
            int x = (int) ((values[0] - lonMin) / (lonMax - lonMin) * resolution);
            int y = (int) ((values[1] - latMin) / (latMax - latMin) * resolution / 2);
            int density = (int) values[2];
            this.dataArray[x][y] = density;

        }
    }

    public int getFromArray(int x, int y){
        return this.dataArray[x][y];
    }

}
