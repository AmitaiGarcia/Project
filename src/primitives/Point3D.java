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
    return new vector(new point3D(x.coordinate - gp.x.coordinate, y.coordinate - gp.y.coordinate, z.coordinate - gp.z.coordinate));

    }

    public add(Point3D gv){// gv = given vector
        return (new point3D(this.x + gv.x, this.y + gv.y, this.z + gv.z));
    }

    public distanceSquared(Point3D gp){ // gp = given point
        double dx = this.x - gp.x;
        double dy = this.y - gp.y;
        double dz = this.z - gp.z;
        return dx * dx + dy * dy + dz * dz;
    }

    public distance(Point3D gp){ // gp = given point
    return math.sqrt(this.distanceSquared(gp));
    }
}
