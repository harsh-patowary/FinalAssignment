package ExerciseTwo;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class TreeData{
    private ArrayList<Tree> treeData = new ArrayList<>();
    TreeData(File treeFile) throws FileNotFoundException {
        try {
            String line = "";
            BufferedReader fileReader = new BufferedReader(new FileReader(treeFile));
            int i = 0;
            while ((line = fileReader.readLine()) != null) {
                String[] data = line.split(",");
                if (i > 0) {
                    try {
                        Tree tree = new Tree(data[1], data[2], data[3], Float.parseFloat(data[4]));
                        treeData.add(tree);
                    } catch (NumberFormatException e) {
                        Tree tree = new Tree(data[1], data[2], data[3], Integer.parseInt(data[4]));
                        treeData.add(tree);
                    }
                }
                i++;
            }
            fileReader.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    void printTreesPerBorough(){
        Set<String> boroughs = new HashSet<>();
        for (Tree tree: treeData){
            boroughs.add(tree.getLocation());
        }

        for (String borough : boroughs){
            int numTrees = 0;
            for (Tree tree: treeData){
                if (borough.equals(tree.getLocation())) numTrees++;
            }
            System.out.println(borough+" = "+numTrees);
        }
    }

    void printMostCommonAge(){
        Map<String, Integer> ageGroup = new HashMap<String, Integer>();
        for (Tree tree: treeData) if (ageGroup.containsKey(tree.getAge())) ageGroup.compute(tree.getAge(), (key, value) -> value = value + 1);
        else ageGroup.put(tree.getAge(), 1);
        int maxValueInMap = (Collections.max(ageGroup.values()));
        for (Map.Entry<String, Integer> entry : ageGroup.entrySet()) if (entry.getValue() == maxValueInMap) System.out.println(entry.getKey() + " with " + ageGroup.get(entry.getKey()) + " trees");
    }


    public void printLeastCommonAge() {
        Map<String, Integer> ageGroup = new HashMap<String, Integer>();
        for (Tree tree: treeData) if (ageGroup.containsKey(tree.getAge())) ageGroup.compute(tree.getAge(), (key, value) -> value = value + 1);
            else ageGroup.put(tree.getAge(), 1);
        int maxValueInMap = (Collections.min(ageGroup.values()));
        for (Map.Entry<String, Integer> entry : ageGroup.entrySet()) if (entry.getValue() == maxValueInMap) System.out.println(entry.getKey() + " with " + ageGroup.get(entry.getKey()) + " trees");
    }

    public void printAverageHeightPerTreeName(){
        Set<String> treeNames = new HashSet<>();
        for (Tree tree: treeData){
            treeNames.add(tree.getName());
        }

        for (String treeName : treeNames){
            int numTrees = 0;
            float height = 0, avgTreeHeight = 0;
            for (Tree tree: treeData){
                if (treeName.equals(tree.getName())) {
                    numTrees++;
                    height += tree.getHeight();
                }
                avgTreeHeight = height/numTrees;

            }
            System.out.println(treeName+" = "+avgTreeHeight);
        }
    }

    public void printAverageHeightForTree(String treeName){
        int numTrees = 0;
        double height = 0, avgTreeHeight = 0;
        for (Tree tree: treeData){
            if (treeName.equalsIgnoreCase(tree.getName())) {
                numTrees++;
                height += tree.getHeight();
            }
            avgTreeHeight = height/numTrees;

        }
        if (avgTreeHeight >= 0) System.out.println(avgTreeHeight);
        else System.out.println("Unknown Tree");
    }

}
