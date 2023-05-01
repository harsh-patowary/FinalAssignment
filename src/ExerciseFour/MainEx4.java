package ExerciseFour;

import javax.swing.*;
import java.io.FileNotFoundException;

public class MainEx4 {
    public static void main(String[] args) throws FileNotFoundException {

        TreePricePlot tPlot = new TreePricePlot("C:\\Users\\ASUS\\IdeaProjects\\FinAss\\FinalAssignment\\src\\ex4\\treePrices.csv");
        tPlot.setScaleX(0.0, 150);
        tPlot.setScaleY(0.0, 79.0);

        JFrame jFrame = new JFrame("TreePlot Lines");

        jFrame.add(tPlot);
        jFrame.setSize(tPlot.width+20, tPlot.height+40);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
