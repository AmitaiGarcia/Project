package primitives;

public class Material {
    public double kD;
    public double kS;
    public int nShininess;

    public Material(double kD, double kS, int nShininess) {
        this.kD = kD;
        this.kS = kS;
        this.nShininess = nShininess;
    }

    public Material() {
        this.kD = 0;
        this.kS = 0;
        this.nShininess = 0;
    }

    public Material(Material material) {
        this(material.kD, material.kS, material.nShininess);
    }

    public Material setkD(double kD) {
        this.kD = kD;
        return this;
    }

    public Material setkS(double kS) {
        this.kS = kS;
        return this;
    }

    public Material setShininess(int nShininess) {
        this.nShininess = nShininess;
        return this;
    }
}
