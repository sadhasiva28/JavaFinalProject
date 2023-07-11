package StructuralPattern.decorator;

//Define the base decorator class
public abstract class EmployeeDecorator implements Employee {
	protected Employee employee;

	public EmployeeDecorator(Employee employee) {
		this.employee = employee;
	}

	public String getName() {
		return employee.getName();
	}

	public double getSalary() {
		return employee.getSalary();
	}
}