import convexhull.Manager;
import convexhull.PointsGenerator;
import org.junit.Test;
import polygon.Point;

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
        testPoints.add(new Point(5.0,1.0));
        testPoints.add(new Point(1.0,1.0));
        testPoints.add(new Point(10.0,10.0));
        testPoints.add(new Point(12.0,3.0));
        testPoints.add(new Point(100.0,11.0));
        Point startPoint = Manager.findStart(testPoints, 4);
        assertTrue(startPoint.getX() == 1);
    }

    @Test
    public void testCanFindStartOnY() throws Exception {
        List<Point> testPoints = new ArrayList<>();
        testPoints.add(new Point(1.0,1.0));
        testPoints.add(new Point(1.0,2.0));
        Point startPoint = Manager.findStart(testPoints, 1);
        assertTrue(startPoint.getY() == 1.0);
    }

}
