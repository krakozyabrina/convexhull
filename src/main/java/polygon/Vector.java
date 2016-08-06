package polygon;


public class Vector {

    private final Point end;
    private final Point start;

    public Vector(Point start, Point end) {
        this.start = start;
        this.end = end;

    }

    public double getLength() {
        double x = start.getX() - end.getX();
        double y = start.getY() - end.getY();
        return Math.sqrt(x * x + y * y);
    }

    public double angleWith(Vector vector) {
        return Math.toDegrees(Math.acos(this.dotProduct(vector)/(this.getLength() * vector.getLength())));
    }

    public double dotProduct(Vector vector) {
        double x1 = start.getX() - end.getX();
        double y1 = start.getY() - end.getY();
        double x2 = vector.start.getX() - vector.end.getX();
        double y2 = vector.start.getY() - vector.end.getY();
        return x1 * x2 + y1 * y2;
    }
}
