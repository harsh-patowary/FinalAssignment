package ExerciseOne;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Bamboo extends Tree{

    Bamboo(int h) {
        super(h);
    }

    @Override
    String getSegment(int seg) {
        if (seg == getHeight()) return " ^ ";
        else return " | ";
    }
}
