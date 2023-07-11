package Behaviuorpattrn.simplem;

abstract class Employee {
    protected String name;
    protected int salary;
    
    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
    
    // This is the template method that defines the algorithm for calculating the net salary
    public final int calculateNetSalary() {
        int tax = calculateTax();
        int insurance = calculateInsurance();
        int netSalary = salary - tax - insurance;
        return netSalary;
    }
    
    // These are the steps that are common to all types of employees
    protected abstract int calculateTax();
    protected abstract int calculateInsurance();
    
    // This is a hook that subclasses can override to provide additional functionality
    protected void printPaySlip(int netSalary) {
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
        System.out.println("Net Salary: " + netSalary);
    }
}

class PermanentEmployee extends Employee {
    public PermanentEmployee(String name, int salary) {
        super(name, salary);
    }
    
    // Override the abstract methods to provide implementation for calculating tax and insurance for permanent employees
    @Override
    protected int calculateTax() {
        return (int)(0.2 * salary);
    }
    
    @Override
    protected int calculateInsurance() {
        return (int)(0.1 * salary);
    }
    
    // Override the hook to provide additional functionality for printing payslips for permanent employees
    @Override
    protected void printPaySlip(int netSalary) {
        super.printPaySlip(netSalary);
        System.out.println("Employee Type: Permanent");
    }
}

class ContractEmployee extends Employee {
    public ContractEmployee(String name, int salary) {
        super(name, salary);
    }
    
    // Override the abstract methods to provide implementation for calculating tax and insurance for contract employees
    @Override
    protected int calculateTax() {
        return (int)(0.1 * salary);
    }
    
    @Override
    protected int calculateInsurance() {
        return (int)(0.05 * salary);
    }
    
    // Override the hook to provide additional functionality for printing payslips for contract employees
    @Override
    protected void printPaySlip(int netSalary) {
        super.printPaySlip(netSalary);
        System.out.println("Employee Type: Contract");
    }
}

public class TemplateMethodExample {
    public static void main(String[] args) {
        PermanentEmployee permanentEmployee = new PermanentEmployee("John", 50000);
        int permanentEmployeeNetSalary = permanentEmployee.calculateNetSalary();
        permanentEmployee.printPaySlip(permanentEmployeeNetSalary);
        
        ContractEmployee contractEmployee = new ContractEmployee("Jane", 30000);
        int contractEmployeeNetSalary = contractEmployee.calculateNetSalary();
        contractEmployee.printPaySlip(contractEmployeeNetSalary);
    }
}


/*
 In this example, we have an abstract Employee class that defines the template method calculateNetSalary(),
  which calls other abstract methods calculateTax() and calculateInsurance(). These methods are 
  implemented by the subclasses, PermanentEmployee and ContractEmployee, to provide their
   own tax and insurance calculation logic. The printPaySlip() method is a hook that the subclasses 
   can override to provide additional functionality. Finally, we have a main method that 
   creates instances of the Employee subclasses and calculates their net salaries using the template method. 
 
 
 */
