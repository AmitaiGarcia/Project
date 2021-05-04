package primitives;

import java.util.Objects;

public class Ray {
    public Point3D p0;
    public Vector dir;
    Vector norm;

    public Ray(Point3D p0, Vector dir) {
        this.p0 = p0;
        this.dir = dir;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Ray)) {
            return false;
        }
        Ray ray = (Ray) o;
        return Objects.equals(p0, ray.p0) && Objects.equals(dir, ray.dir) && Objects.equals(norm, ray.norm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(p0, dir, norm);
    }

    @Override
    public String toString() {
        return "{" + " p0='" + p0 + "'" + ", dir='" + dir + "'" + ", norm='" + norm + "'" + "}";
    }

    public Point3D getP0() {
        return this.p0;
    }

    public Vector getDir() {
        return this.dir;
    }

    public Vector getNorm() {
        return this.norm;
    }

}
