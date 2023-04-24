package ExerciseOne;

public class PineTree extends Tree{
    PineTree(int h){
        super(h);
    }
    @Override
    String getSegment(int seg) {
        if (seg == getHeight()) return "  ^  ";
        return " /|\\ ";
    }
}
