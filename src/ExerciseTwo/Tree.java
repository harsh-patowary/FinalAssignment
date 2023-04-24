package ExerciseTwo;

public class Tree {
    private String Location, Name, Age;
    private double Height;
    Tree(String l, String n, String a, float h){
        this.Location = l;
        this.Name = n;
        this.Age = a;
        this.Height = h;
    }
    String getLocation(){
        return this.Location;
    }
    String getName(){
        return this.Name;
    }
    String getAge(){
        return this.Age;
    }
    double getHeight(){
        return this.Height;
    }
}
