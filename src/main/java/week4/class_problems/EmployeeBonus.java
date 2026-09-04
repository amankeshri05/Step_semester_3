package week4.class_problems;

public class EmployeeBonus {
    String empId;
    double salary;

    public EmployeeBonus(String empId, double salary) {
        this.empId = empId;
        this.salary = salary;
    }

    void raiseSalary(double salary) {
        this.salary += salary;
    }

    public static void main(String[] args) {
        String[] empIds = {"E-101", "E-102", "E-103", "E-104"};
        double[] startingSalaries = {40000, 55000, 62000, 48000};

        EmployeeBonus[] employees = new EmployeeBonus[empIds.length];
        for (int i = 0; i < empIds.length; i++) {
            employees[i] = new EmployeeBonus(empIds[i], startingSalaries[i]);
        }

        for (EmployeeBonus emp : employees) {
            emp.raiseSalary(5000);
            System.out.println(emp.empId + " | Final Salary: Rs " + emp.salary);
        }
    }
}