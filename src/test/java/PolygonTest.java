import convexhull.PointsGenerator;
import org.junit.Test;
import polygon.Point;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class PolygonTest {

    @Test
    public void shouldntFalseEqualsTrue() throws Exception {
        assertTrue(false);
    }

    @Test
    public void shouldGeneratePoints() throws Exception {
        List testPoints = new PointsGenerator().generate(5);
        assertEquals(5, testPoints.size());
    }

    @Test
    public  void canFindStartPoint() throws Exception {
        List<Point> testPoints = new ArrayList<>();
        double x = 1.0;
        double y = 2.0;
        for (int i=0; i<5; i++) {
            testPoints.add(new Point(x,y));
            x++;
            y++;
        }
        Point startPoint = PointsGenerator.findStart(testPoints, 4);
        assertTrue(startPoint.getX() == 1);
    }

    @Test
    public void canFindStartOnY() throws Exception {
        List<Point> testPoints = new ArrayList<>();
        testPoints.add(new Point(1.0,1.0));
        testPoints.add(new Point(1.0,2.0));
        Point startPoint = PointsGenerator.findStart(testPoints, 1);
        assertTrue(startPoint.getY() == 1.0);
    }

}
