package StructuralPattern.decorator;

//Define concrete decorator classes
public class BonusEmployee extends EmployeeDecorator {
	private double bonus;

	public BonusEmployee(Employee employee, double bonus) {
		super(employee);
		this.bonus = bonus;
	}

	public double getSalary() {
		return employee.getSalary() + bonus;
	}
}