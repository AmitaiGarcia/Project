package primitives;

public class Material {
    public double kD;
    public double kS;
    public int nShininess;

    /**
     * constructor for Material class
     *
     * @param kD
     * @param kS
     * @param nShininess
     *
     */
    public Material(double kD, double kS, int nShininess) {
        this.kD = kD;
        this.kS = kS;
        this.nShininess = nShininess;
    }

    /**
     * constructor for Material class where all of the parameters are by default 0
     *
     * @param kD
     * @param kS
     * @param nShininess
     *
     */
    public Material() {
        this.kD = 0;
        this.kS = 0;
        this.nShininess = 0;
    }

    public Material(Material material) {
        this(material.kD, material.kS, material.nShininess);
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
}
