package StructuralPattern.facade;

public class Client {
    public static void main(String[] args) {
        EmployeeFacade employeeFacade = new EmployeeFacade("John", "Manager", 50000);

        System.out.println("Employee Details:\n" + employeeFacade.getEmployeeDetails());
        System.out.println("Salary: " + employeeFacade.getSalary());

        employeeFacade.increaseSalary(10000);

        System.out.println("Employee Details:\n" + employeeFacade.getEmployeeDetails());
        System.out.println("Salary: " + employeeFacade.getSalary());
    }
}



