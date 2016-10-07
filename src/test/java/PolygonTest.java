import convexhull.Manager;
import convexhull.Model;
import convexhull.PointsGenerator;
import org.junit.Ignore;
import org.junit.Test;
import polygon.Point;
import polygon.Vector;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class PolygonTest {

    @Test
    public void shouldGeneratePoints() throws Exception {
        List testPoints = new PointsGenerator().generate(5);
        assertEquals(5, testPoints.size());
    }

    @Test
    public  void testCanFindStartPoint() throws Exception {
        List<Point> testPoints = new ArrayList<>();
        Model model = new Model();
        testPoints.add(new Point(5.0,1.0));
        testPoints.add(new Point(1.0,1.0));
        testPoints.add(new Point(10.0,10.0));
        testPoints.add(new Point(12.0,3.0));
        testPoints.add(new Point(100.0,11.0));
        model.setPointList(testPoints);
        int startPoint = new Manager().findStart(model, 4);
        assertTrue(startPoint == 1);
    }

    @Test
    public void testCanFindStartOnY() throws Exception {
        List<Point> testPoints = new ArrayList<>();
        testPoints.add(new Point(1.0,1.0));
        testPoints.add(new Point(1.0,2.0));
        Model model = new Model();
        model.setPointList(testPoints);
        int startPoint = new Manager().findStart(model, 1);
        assertTrue(startPoint == 0);
    }

    @Test
    public void testCalculateAngle() throws Exception {
        Point a = new Point(2.0,2.732);
        Point b = new Point(2.0, 1.0);
        Point startPoint = new Point(1.0, 1.0);
        double angle = new Manager().calculateAngle(startPoint,a,b);
        assertEquals(60.0, angle, 0.01);
    }

    @Test
    public void testCalculateShiftedAngle() throws Exception {
        Point a = new Point(0.0,2.0);
        Point b = new Point(2.0, 0.0);
        Point startPoint = new Point(1.0, 1.0);
        double angle = new Manager().calculateAngle(startPoint,a,b);
        assertEquals(90.0, angle, 0.1);
    }

    @Test
    public void testCalculatesAngles() throws Exception {
        List<Point> testPoints = new ArrayList<>();
        testPoints.add(new Point(0,2.0));
        testPoints.add(new Point(2.0,2.0));
        testPoints.add(new Point(3.0,1.0));
        testPoints.add(new Point(1.5,2.0));
        Model model = new Model();
        model.setPointList(testPoints);
        Point startPoint = new Point(1.0, 1.0);
        Manager manager = new Manager();
        manager.prepare(model, startPoint);
        assertEquals(1.5, model.getSortedPointList().get(0).getX(), 0.01 );
        assertEquals(2.0, model.getSortedPointList().get(0).getY(), 0.01 );
    }

    @Test
    public void testSignDotProductT() throws Exception{
        Point a = new Point(1.0,1.0);
        Point b = new Point(1.0,2.0);
        Point c = new Point(1.0,1.0);
        Vector first = new Vector(a,b);
        Vector second = new Vector(a,c);
        boolean take;
        if (first.dotProduct(second)<0){
            take = true;
        }
        assertTrue(take=true);
    }

    @Test
    public void testSignDotProductF() throws Exception{
        Point a = new Point(1.0,3.0);
        Point b = new Point(2.0,2.0);
        Point c = new Point(3.0,3.0);
        Vector first = new Vector(a,b);
        Vector second = new Vector(a,c);
        boolean take;
        if (first.dotProduct(second)<0){
            take = true;
        }
        assertTrue(take=false);
    }

    /*
    @Test
    public void testConvexHull() throws Exception {
        List<Point> testPoints = new ArrayList<>();
        testPoints.add(new Point(0,2.0));
        testPoints.add(new Point(2.0,2.0));
        testPoints.add(new Point(3.0,1.0));
        testPoints.add(new Point(1.5,2.0));
        Model model = new Model();
        model.setPointList(testPoints);
        Point startPoint = new Point(1.0, 1.0);
        Manager manager = new Manager();
        manager.prepare(model, startPoint);
        model.getConvexHull();
    }
    **/

}
