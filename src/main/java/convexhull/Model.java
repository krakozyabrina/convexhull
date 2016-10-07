package convexhull;

import polygon.Point;

import java.util.List;

/**
 * Created by arybasova on 22.07.16.
 */
public class Model {
    private List<Point> pointList;

    private List<Point> sortedPointList;

    public List<Point> getPointList() {
        return pointList;
    }

    public List<Point> getSortedPointList() {
        return sortedPointList;
    }

    public void setPointList(List<Point> pointList) {
        this.pointList = pointList;
    }

    public void setSortedPointList(List<Point> pointList) {
        this.sortedPointList = pointList;
    }


}
