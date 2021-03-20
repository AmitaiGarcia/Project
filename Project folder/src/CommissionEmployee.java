import java.util.Objects;

public class CommissionEmployee extends Employee {
    private float grossSales;
    private float comission;

    public CommissionEmployee(String firstName, String lastName, int id, float grossSales, float comission) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setId(id);
        this.setGrossSales(grossSales);
        this.setComission(comission);
    }

    public CommissionEmployee() {
        this.setFirstName("plony");
        this.setLastName("almony");
        this.setId(0);
        this.setGrossSales(0);
        this.setComission(0);
    }

    public float getGrossSales() {
        return grossSales;
    }

    public float getComission() {
        return comission;
    }

    public void setGrossSales(float grossSales) throws IllegalArgumentException {
        if (grossSales < 0) {
            throw new IllegalArgumentException("can't be below 0");
        }
        this.grossSales = grossSales;
    }

    public void setComission(float comission) throws IllegalArgumentException {
        if (comission < 0) {
            throw new IllegalArgumentException("can't be below 0");
        }
        this.comission = comission;
    }

    @Override
    public String toString() {
        return getId() + " " + getFirstName() + " " + getLastName() + " " + grossSales + " " + comission;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CommissionEmployee)) {
            return false;
        }
        return getId() == ((CommissionEmployee) o).getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(grossSales, comission);
    }

    @Override
    public float earnings() {
        return ((this.grossSales * this.comission) / 100);
    }
}
