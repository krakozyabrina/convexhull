package convexhull;

import polygon.Point;

import java.util.List;

/**
 * Created by arybasova on 07.08.16.
 */
public class Manager {
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
