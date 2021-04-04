package primitives;

import static primitives.Util.*;

public class Point3D {
    public final coordinate x;
    public final coordinate y;
    public final coordinate z;
    static final Point3D ZERO = new Point3D(0, 0, 0);

    public Point3D(coordinate x, coordinate y, coordinate z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public subtract(Point3D gp){ // gp = given point


    }
}
