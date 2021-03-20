import java.util.Objects;

public abstract class Employee {
    private String firstName;
    private String lastName;
    private int id;

    /* constructors */
    protected Employee(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    protected Employee() {
        this.firstName = "plony";
        this.lastName = "almony";
        this.id = 0;
    }

    /* get functions */
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    /* set functions */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /* other functions */
    @Override
    public String toString() {
        return id + " " + firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Employee)) {
            return false;
        }
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, id);
    }

    public abstract float earnings();
}
