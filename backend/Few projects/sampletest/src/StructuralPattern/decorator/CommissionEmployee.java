package StructuralPattern.decorator;

public class CommissionEmployee extends EmployeeDecorator {
	private double commissionRate;
	private double sales;

	public CommissionEmployee(Employee employee, double commissionRate, double sales) {
		super(employee);
		this.commissionRate = commissionRate;
		this.sales = sales;
	}

	public double getSalary() {
		return employee.getSalary() + commissionRate * sales;
	}
}