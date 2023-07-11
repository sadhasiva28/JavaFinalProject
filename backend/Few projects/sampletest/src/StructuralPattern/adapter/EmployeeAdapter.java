package StructuralPattern.adapter;

//Accepts old system , implements new system
//Adapter class
public class EmployeeAdapter implements Person {
    private Employee employee;

    public EmployeeAdapter(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String getFullName() {
        return employee.getFirstName() + " " + employee.getLastName();
    }

    @Override
    public int getAge() {
        return employee.getAge();
    }
}