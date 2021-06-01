package primitives;

public class Material {

    /**
     * kT = Transparancy coefficient, kR = reflection coefficient
     *
     */
    public double kT;
    public double kR;
    public double kD;
    public double kS;
    public int nShininess;

    /**
     * constructor for Material class
     *
     * @param kD
     * @param kS
     * @param nShininess
     * @param kT
     * @param kR
     *
     */
    public Material(double kD, double kS, int nShininess, double kT, double kR) {
        this.kD = kD;
        this.kS = kS;
        this.nShininess = nShininess;
        this.kT = kT;
        this.kR = kR;
    }

    /**
     * constructor for Material class where all of the parameters are by default 0
     *
     * @param kD
     * @param kS
     * @param nShininess
     * @param kT
     * @param kR
     *
     */
    public Material() {
        this.kD = 0;
        this.kS = 0;
        this.nShininess = 0;
        this.kT = 0.0;
        this.kR = 0.0;
    }

    public Material(Material material) {
        this(material.kD, material.kS, material.nShininess, material.kT, material.kR);
    }

    /**
     * Method to set kD and return the object
     *
     * @param kD
     * @return Material
     */
    public Material setkD(double kD) {
        this.kD = kD;
        return this;
    }

    /**
     * Method to set kS and return the object
     *
     * @param kS
     * @return Material
     */
    public Material setkS(double kS) {
        this.kS = kS;
        return this;
    }

    /**
     * Method to set nShininess and return the object
     *
     * @param nShininess
     * @return Material
     */
    public Material setShininess(int nShininess) {
        this.nShininess = nShininess;
        return this;
    }

    /**
     * Method to set Transparancy coefficient and return the object
     *
     * @param kT
     * @return Material
     */
    public Material setKT(double kT) {
        this.kT = kT;
        return this;
    }

    /**
     * Method to set Reflection coefficient and return the object
     *
     * @param kR
     * @return Material
     */
    public Material setKR(double kR) {
        this.kR = kR;
        return this;
    }

}
