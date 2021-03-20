import java.util.Objects;

public class HourlyEmployee extends Employee {

    private float hours;
    private float wages;

    /* constructors */
    public HourlyEmployee(String firstName, String lastName, int id, float hours, float wages) {

        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setId(id);
        this.setHours(hours);
        this.setWages(wages);
    }

    public HourlyEmployee() {
        this.setFirstName("plony");
        this.setLastName("almony");
        this.setId(0);
        this.setHours(0);
        this.setWages(0);
    }

    /* get functions */
    public float getHours() {
        return hours;
    }

    public float getWages() {
        return wages;
    }

    /* set functions */
    public void setHours(float hours) throws IllegalArgumentException {
        if (hours < 0) {
            throw new IllegalArgumentException("can't be below 0");
        }
        this.hours = hours;
    }

    public void setWages(float wages) throws IllegalArgumentException {
        if (wages < 0) {
            throw new IllegalArgumentException("can't be below 0");
        }
        this.wages = wages;
    }

    /* other functions */
    @Override
    public String toString() {
        return getId() + " " + getFirstName() + " " + getLastName() + " " + hours + " " + wages;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof HourlyEmployee)) {
            return false;
        }
        return getId() == ((HourlyEmployee) o).getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(hours, wages);
    }

    @Override
    public float earnings() {
        return (this.wages * this.hours);
    }

}