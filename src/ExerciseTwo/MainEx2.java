package ExerciseTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainEx2 {
    public static void main(String[] args) throws FileNotFoundException {
        TreeData td = new TreeData(new File("src/ExerciseTwo/treesPruned.csv"));

        Scanner _in = new Scanner(System.in);
        String str = "";
        while (str != "quit"){
            System.out.print("""
                    Please enter:
                    1 to print number of trees per borough
                    2 to print most common tree age
                    3 to print least common tree age
                    4 to print average height per tree name
                    5 to enter tree name and print average height
                    quit to quit
                                        
                    """);
            System.out.print(">>>");
            str = _in.nextLine();
            switch (str.toLowerCase()) {
                case "1":
                    td.printTreesPerBorough();
                    break;
                case "2":
                    td.printMostCommonAge();
                    break;
                case "3":
                    td.printLeastCommonAge();
                    break;
                case "4":
                    td.printAverageHeightPerTreeName();
                    break;
                case "5":
                    System.out.println("Enter Tree Name: ");
                    String treeName = _in.nextLine();
                    td.printAverageHeightForTree(treeName);
                    break;
                default:
                    try{
                        Integer.parseInt(str);
                        System.out.println("Invalid Option!");
                    } catch (NumberFormatException e){
                        System.out.println("Invalid Entry!");
                    }

                    break;
            }

        }
        System.out.println("Bye! Thank you!");
    }

}
