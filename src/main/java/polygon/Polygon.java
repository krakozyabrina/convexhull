package polygon;

import java.util.ArrayList;
import java.util.List;


public class Polygon {

    private static final double THRESHOLD = 0.001;

    private Point[] points;

    public Polygon(Point... points) {
        this.points = points;
    }

    public int getPointCount() {
        return points.length;
    }

    public boolean isRegular() {

        List<Vector> vectors = getEdges();

        double lenV = vectors.get(0).getLength();
        for (Vector v : vectors) {

            if (Math.abs(lenV - v.getLength()) > THRESHOLD) {
                return false;
            }

        }

        double angleV = vectors.get(0).angleWith(vectors.get(vectors.size() - 1));
        for (int k = 0; k < vectors.size() - 1; k++) {
            double angleV2 = vectors.get(k).angleWith(vectors.get(k + 1));
            if (Math.abs(angleV - angleV2) > THRESHOLD) {
                return false;
            }
        }

        return true;
    }

    public List<Vector> getEdges() {

        int count = points.length;

        List<Vector> vectors = new ArrayList<>();

        int i = 0, j = 1;
        Vector v2 = new Vector(points[points.length-1],points[0]);
        vectors.add(v2);
        while (count > 1) {
            Vector v1 = new Vector(points[i], points[j]);
            vectors.add(v1);
            i++;
            j++;
            count--;
        }

        return vectors;
    }

    public double getPerimeter(){
        double per = 0;
        for (Vector w: getEdges()){
            per += w.getLength();
        }
        return per;
    }

    @Override
    public String toString() {
        String rez = new String();
        for (Point p: points){
            rez = rez + p.getX() + ",";
            rez = rez + p.getY() + " ";
        }
        return rez;
    }
}
