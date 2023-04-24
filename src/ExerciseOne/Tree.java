package ExerciseOne;

public abstract class Tree {
    private int height;
    Tree(int h){
        this.height = h;
    }
    int getHeight(){
        return this.height;
    }
    abstract String getSegment(int seg);

    @Override
    public String toString(){
        StringBuilder tree = new StringBuilder();
        for (int i = height; i > 0; i--){
            tree.append(getSegment(i)).append("\n");
        }
        return tree.toString();
    }
}
