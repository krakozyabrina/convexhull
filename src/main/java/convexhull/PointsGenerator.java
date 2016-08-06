package convexhull;

import polygon.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arybasova on 23.07.16.
 */
public class PointsGenerator {

    public List<Point> generate(int numberPoints) {
        List<Point> points = new ArrayList<>();
        for (int i=0; i<numberPoints; i++) {
            points.add(new Point(Math.random()*100,Math.random()*100));
        }
        return points;
    }

}
