import java.util.Objects;

public class BasePlusComissionEmployee extends CommissionEmployee {

    private float baseSalary;

    public BasePlusComissionEmployee(String firstName, String lastName, int id, float baseSalary, float grossSales,
            float comission) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setId(id);
        this.setGrossSales(grossSales);
        this.setComission(comission);
        this.setBaseSalary(baseSalary);
    }

    public BasePlusComissionEmployee() {
        this.setFirstName("plony");
        this.setLastName("almony");
        this.setId(0);
        this.setGrossSales(0);
        this.setComission(0);
        this.setBaseSalary(0);
    }

    public float getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(float baseSalary) throws IllegalArgumentException {
        if (baseSalary < 0) {
            throw new IllegalArgumentException("can't be below 0");
        }
        this.baseSalary = baseSalary;
    }

    @Override
    public String toString() {
        return getId() + " " + getFirstName() + " " + getLastName() + " " + getGrossSales() + " " + getComission() + " "
                + baseSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BasePlusComissionEmployee)) {
            return false;
        }
        return getId() == ((BasePlusComissionEmployee) o).getId();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(baseSalary);
    }

    @Override
    public float earnings() {
        return ((this.baseSalary + this.getGrossSales()) * getComission() / 100);
    }

}
