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

    public static Point findStart(List<Point> pointList, int numberPoints) {
        double startX = pointList.get(0).getX();
        double startY = pointList.get(0).getY();
        for (int i=0;i< numberPoints; i++) {
            if (pointList.get(i+1).getX()<pointList.get(i).getX()) {
                startX = pointList.get(i+1).getX();
                startY = pointList.get(i+1).getY();
            }
            else if (pointList.get(i+1).getX()==pointList.get(i).getX()) {
                if (pointList.get(i+1).getY() < pointList.get(i).getY()) {
                    startX = pointList.get(i+1).getX();
                    startY = pointList.get(i+1).getY();
                }
            }
        }
        return new Point(startX,startY);
    }
}
