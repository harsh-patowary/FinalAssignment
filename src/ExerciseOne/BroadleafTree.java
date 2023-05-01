package ExerciseOne;

public class BroadleafTree extends Tree{
    BroadleafTree(int h){
        super(h);
    }

    @Override
    String getSegment(int seg) {
        if (seg == getHeight()) return "  |  ";
        else if(seg%2==0) return " \\|  ";
        else return "  |/ ";
    }
}
