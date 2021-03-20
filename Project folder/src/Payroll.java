public class Payroll {
    public static void main(String[] args) {

        Employee[] Employees = new Employee[3];
        Employees[0] = new HourlyEmployee("James", "Logan", 12003, 20, 20);
        Employees[1] = new CommissionEmployee("Itay", "John", 30001, 30, 30);
        Employees[2] = new BasePlusComissionEmployee("Base", "Comission", 40002, 10, 10, 10);

        for (int i = 0; i < Employees.length; i++) {
            System.out.println(Employees[i]);
            if (Employees[i] instanceof BasePlusComissionEmployee) {
                System.out.println("salary: " + Employees[i].earnings() * 1.1);
            } else {
                System.out.println("salary: " + Employees[i].earnings());
            }
        }

    }
}
