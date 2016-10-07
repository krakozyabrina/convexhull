package convexhull;

import polygon.Point;
import polygon.Vector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Created by arybasova on 07.08.16.
 */
public class Manager {
    public int findStart(Model model, int numberPoints) {
        List<Point> pointList = model.getPointList();
        int j=0;
        double startX = pointList.get(0).getX();
        double startY = pointList.get(0).getY();
        for (int i=0;i< numberPoints; i++) {
            if (pointList.get(i+1).getX()<pointList.get(i).getX()) {
                startX = pointList.get(i+1).getX();
                startY = pointList.get(i+1).getY();
                j = i+1;
            }
            else if (pointList.get(i+1).getX()==pointList.get(i).getX()) {
                if (pointList.get(i+1).getY() < pointList.get(i).getY()) {
                    startX = pointList.get(i+1).getX();
                    startY = pointList.get(i+1).getY();
                    j=i+1;
                }
            }
        }
        return j;
    }

    public double calculateAngle(Point startPoint, Point a, Point b) {
        Vector vertical = new Vector(startPoint,a);
        Vector candidate = new Vector(startPoint,b);
        double angle = vertical.angleWith(candidate);
        /*double newax = a.getX()-startPoint.getX();
        double neway = a.getY()-(a.getY()-startPoint.getY());
        double newbx = b.getX()-(b.getX()-startPoint.getX());
        double newby = b.getY()+startPoint.getY();
        double cosf = (newax*newbx+neway*newby)/(Math.sqrt(newax*newax+neway*neway)*Math.sqrt(newbx*newbx+newby*newby));
        double res = Math.acos(cosf);
        **/
        return angle;
    }

    public List<AngleToPoint> calculateListAngles(List<Point> pointsList, Point startPoint){
        Point vertical = new Point(startPoint.getX(),startPoint.getY()+1.0);
        List<AngleToPoint> listAngleToPoints = new ArrayList<>();
        for (int i=0; i<pointsList.size(); i++) {
            double angle = new Manager().calculateAngle(startPoint, vertical, pointsList.get(i));
            AngleToPoint ap = new AngleToPoint();
            ap.setAngle(angle);
            ap.setNPoint(pointsList.get(i));
            listAngleToPoints.add(ap);
        }
        return listAngleToPoints;
    }

    public List<AngleToPoint> sortAnglesList(List<AngleToPoint> listAngleToPoints) {
        Collections.sort(listAngleToPoints);
        return listAngleToPoints;
    }

    public void prepare(Model model, Point startPoint) {
        //model.setSortedPointList(sortAnglesList(calculateListAngles(model.getPointList(), startPoint)));
        List<AngleToPoint> fin = sortAnglesList(calculateListAngles(model.getPointList(), startPoint));
        List<Point> pointList = new ArrayList<>();
        for (int i=0; i<fin.size(); i++) {
            pointList.add(fin.get(i).getNPoint());
        }
        model.setSortedPointList(pointList);
    }

    public Vector crossProduct(Vector vector){


        return vector;
    }
}

