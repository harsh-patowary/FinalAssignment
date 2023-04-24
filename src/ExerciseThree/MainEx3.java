package ExerciseThree;

import java.io.IOException;

public class MainEx3 {


    public static void main(String[] args) throws IOException {
        VegetationData vegData = new VegetationData("src/ExerciseThree/vegetationData.csv", 2000);
        for (int i = 0; i < vegData.resolution; i++) {
            for (int j = 0; j < vegData.resolution / 2; j++) {
                System.out.print(vegData.getFromArray(i, j) + " ");
            }
            System.out.println();
        }
    }
}
