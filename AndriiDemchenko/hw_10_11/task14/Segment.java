package collectionsTasks.task14;

public class Segment {
    Point a, b;

    Segment(Point a, Point b){
        this.a = a;
        this.b = b;
    }

    Segment(double x1, double y1, double x2, double y2){
        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);

        a = p1;
        b = p2;
    }

    public double getLX(){ return (a.x < b.x) ? a.x : b.x; }
    public double getRX(){ return (a.x > b.x) ? a.x : b.x; }
    public double getLY(){ return (a.y < b.y) ? a.y : b.y; }
    public double getUY(){ return (a.y > b.y) ? a.y : b.y; }

    @Override
    public String toString(){
        return String.format("[%s, %s]", a, b);
    }

}
