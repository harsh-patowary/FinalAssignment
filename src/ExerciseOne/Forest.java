package ExerciseOne;

import java.util.Random;

public class Forest {
    private Tree[] trees;

    public Forest(int numTrees, int maxSize){
        trees = new Tree[numTrees];
        Random rand = new Random();
        for (int i=0; i < numTrees; i++){
            int randHeight = rand.nextInt(maxSize);
            int randType = rand.nextInt(3);
//            int randHeight = 6;
//            int randType = 2;
            switch(randType){
                case 0:
                    trees[i] = new Bamboo(randHeight);
                    break;
                case 1:
                    trees[i] = new BroadleafTree(randHeight);
                    break;
                case 2:
                    trees[i] = new PineTree(randHeight);
            }
        }
    }

    @Override
    public String toString(){
        int maxHeight = 0;
        for (Tree tree : trees)
            if (tree.getHeight() > maxHeight) maxHeight = tree.getHeight();

        StringBuilder forest = new StringBuilder();
        for (int i = maxHeight; i > 0; i--){
            for (Tree tree: trees){
                String segments[] = tree.toString().split("\n");
                if (tree.getHeight() >= i) {
                    forest.append(segments[segments.length-i]);
                }
                else if ((tree.getHeight() > 0)&&(tree.getHeight()<=i)){
                    forest.append("     ");
                }
            }
            forest.append("\n");
        }
        return forest.toString();
    }

}
