package ExerciseThree;

import javax.swing.*;
import java.io.IOException;
import java.util.Arrays;

public class MainEx3 {


    public static void main(String[] args) throws IOException {
        VegetationData vegData = new VegetationData("C:\\Users\\ASUS\\IdeaProjects\\FinAss\\FinalAssignment\\src\\ExerciseThree\\vegetationData.csv", 2000);
//
        JFrame jFrame = new JFrame("TreePlot Lines");
        PlotVegetation plotVeg = new PlotVegetation(vegData, true, true);
        jFrame.add(plotVeg);
        jFrame.setSize(plotVeg.width+20, plotVeg.height+40);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
