package convexhull;

import polygon.Point;

/**
 * Created by arybasova on 12.09.16.
 */
public class AngleToPoint implements Comparable<AngleToPoint>{
        double angle;
        Point point;
        public void setNPoint(Point n){
            this.point = n;
        }
        public void setAngle(double angle) {
            this.angle = angle;
        }
        public Point getNPoint() {
            return point;
        }
        public double getAngle(){
            return angle;
        }

        @Override
        public int compareTo(AngleToPoint o) {
            return Double.compare(this.angle,o.angle);
        }
}
