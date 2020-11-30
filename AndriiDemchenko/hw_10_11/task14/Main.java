package collectionsTasks.task14;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.*;

public class Main {

    static Point getCommonPoint(Segment s1, Segment s2){
        /*
         * We have to initialize the line equation for each segment
         * which looks like:
         * y = k*x + b, where
         * k - tan of angle beetween lines;
         *
         * k = (y1 - y2) / (x1 - x2)
         */
        double newX, newY;
        double k1, k2, b1, b2;

        // when two segments are vertical
        if ((s1.a.x - s1.b.x == 0) && (s2.a.x - s2.b.x == 0))
        {
            if (s1.a.x == s2.a.x){
                if (s1.getLY() > s2.getUY() || s1.getUY() < s2.getLY()) {
                    return null;
                }
                newX = s1.a.x;
                newY = Math.min(s1.getUY(), s2.getUY());
            } else {
                return null;
            }
        }
        // when first segment is vertical
        else if (s1.a.x - s1.b.x == 0)
        {
            k2 = (s2.a.y - s2.b.y) / (s2.a.x - s2.b.x);
            b2 = s2.a.y - k2 * s2.a.x;

            newX = s1.a.x;
            newY = k2 * newX + b2;

            if (s2.getLX() > newX || s2.getRX() < newX || s2.getLY() > s1.getUY() || s2.getUY() < s1.getLY())
                return null;
        }
        // when second segment is vertical
        else if (s2.a.x - s2.b.x == 0)
        {
            k1 = (s1.a.y - s1.b.y) / (s1.a.x - s1.b.x);
            b1 = s1.a.y - k1 * s1.a.x;

            newX = s2.a.x;
            newY = k1 * newX + b1;

            if (s1.getLX() > newX || s1.getRX() < newX || s1.getLY() > s2.getUY() || s1.getUY() < s2.getLY())
                return null;
        }
        //
        else
        {
            k1 = (s1.a.y - s1.b.y) / (s1.a.x - s1.b.x);
            k2 = (s2.a.y - s2.b.y) / (s2.a.x - s2.b.x);
            b1 = s1.a.y - k1 * s1.a.x;
            b2 = s2.a.y - k2 * s2.a.x;

            // when segments are parallel
            if (k1 == k2) {
                return null;
            }

            newX = (b2 - b1) / (k1 - k2);
            newY = k1 * newX + b1;

            // when result point lie on line projection
            if (newX < Math.min(s1.a.x, s2.a.x) || newX > Math.max(s1.b.x, s2.b.x)){
                return null;
            }
        }

        Point cp = new Point(newX, newY);
        return cp;
    }



    public static void main(String[] args) throws FileNotFoundException {
        /*
         * Data input format:
         * First line - integer number n
         * n lines looks like that - "xi1 yi1 xi2 yi2"
         * each line - each segment;
         */

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        TreeMap<Integer, Segment> segments = new TreeMap<>();
        int [] indexes = new int[n];

        for (int i = 0; i < n; i++){
            double x1, y1, x2, y2;

            x1 = sc.nextDouble();
            y1 = sc.nextDouble();
            x2 = sc.nextDouble();
            y2 = sc.nextDouble();

            Segment s = new Segment(x1, y1, x2, y2);
            segments.put(i, s);
            indexes[i] = i;
        }

        boolean swapped = true;
        while (swapped){
            swapped = false;

            for (int i = 0; i < n - 1; i++){
                if (segments.get(indexes[i]).getLX() > segments.get(indexes[i+1]).getLX()){
                    int tmp = indexes[i];
                    indexes[i] = indexes[i+1];
                    indexes[i+1] = tmp;
                    swapped = true;
                }
            }
        }

        Segment s1 = segments.get(indexes[0]);
        Segment s2 = segments.get(indexes[1]);
        Point cp = getCommonPoint(s1, s2);

        if (cp == null){
            System.out.println("Segments have no intersection and common point;");
        } else {
            System.out.println("Segments intersection common point: " + cp);
        }
    }
}
