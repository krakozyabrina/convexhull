package polygon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("Polygons.txt"));
        List<Polygon> polygons = new ArrayList<>();

        try {
            while (sc.hasNextInt()){
                int count = sc.nextInt();
                Point[] points = new Point[count];
                for (int i=0; i<count; i++)
                {
                    double s = sc.nextDouble();
                    double z = sc.nextDouble();
                    Point x = new Point(s,z);
                    points[i] = x;
                }
                Polygon polygon = new Polygon(points);
                polygons.add(polygon);

            }
        } finally {
            sc.close();
        }

        Collections.sort(polygons, new Comparator<Polygon>() {
            @Override
            public int compare(Polygon o1, Polygon o2) {

                return Double.compare(o1.getPerimeter(), o2.getPerimeter()) ;
            }
        });

        int reg = 0;
        for (Polygon i : polygons){
            if (i.isRegular()){
                System.out.println(i);
                reg++;
            }
        }
        if (reg == 0){
            System.out.println("This file don't contain any regular polygons");
        }
    }

}
