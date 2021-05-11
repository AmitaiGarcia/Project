package elements;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static primitives.Util.isZero;

/**
 * Camera class representing the camera that shoots ray through the view plane
 * system
 *
 * @author Amitai Rodrigues Garcia
 * @author Mengistu Kerew
 */
public class Camera {
    Point3D p0;
    Vector vUp;
    Vector vTo;
    Vector vRight;

    double width;
    double height;
    double distance;

    /**
     * @param P0 = camera position
     * @param up = vUp vector
     * @param to = vTo vector
     */
    public Camera(Point3D p0, Vector up, Vector to) {

        if (!isZero(to.dotProduct(up))) {
            throw new IllegalArgumentException("vTo and Vup are not orthoganal");
        }
        this.p0 = p0;

        this.vTo = to.normalized();
        this.vUp = up.normalized();
        this.vRight = vTo.crossProduct(vUp).normalized();
    }

    /**
     * Set function for the View plane size.
     *
     * @param width
     * @param height
     * @return Camera
     */
    public Camera setViewPlaneSize(double width, double height) {
        this.width = width;
        this.height = height;

        return this;
    }

    /**
     * @param distance
     * @return Camera
     */
    public Camera setDistance(double distance) {

        if (isZero(distance)) {
            throw new IllegalArgumentException("distance cannot be 0");
        }
        this.distance = distance;

        return this;

    }

    /**
     * This method cosntructs a ray through certain pixels and return the ray
     * 
     * @param nX
     * @param nY
     * @param j
     * @param i
     * @return Ray
     */
    public Ray constructRayThroughPixel(int nX, int nY, int j, int i) {

        Point3D pc = p0.add(vTo.scale(distance));

        double ry = height / nY;
        double rx = width / nX;

        double yi = -((i - ((nY - 1) / 2d)) * ry);
        double xj = (j - ((nX - 1) / 2d)) * rx;

        Point3D Pij = pc;

        if (!isZero(xj)) {
            Pij = Pij.add(vRight.scale(xj));
        }

        if (!isZero(yi)) {
            Pij = Pij.add(vUp.scale(yi));
        }

        Vector v = Pij.subtract(p0);

        return new Ray(p0, v);

    }

    /**
     * This method return the camera location P0
     *
     * @return Point3D
     */
    public Point3D getP0() {
        return this.p0;
    }

    /**
     * This method returns vector Vup
     *
     * @return Vector
     */
    public Vector getVUp() {
        return this.vUp;
    }

    /**
     * This method returns vector vTo
     *
     * @return Vector
     */
    public Vector getVTo() {
        return this.vTo;
    }

    /**
     * This Method return Vector Vright
     *
     * @return Vector
     */
    public Vector getVRight() {
        return this.vRight;
    }

}
