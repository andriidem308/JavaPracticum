package collectionsTasks.task14;

public class Point {
    double x;
    double y;

    Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return String.format("(%.3f, %.3f)", x, y);
    }
}
