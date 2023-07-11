package StructuralPattern.decorator;

//Define the base Employee class
public class BaseEmployee implements Employee {
	private String name;
	private double salary;

	public BaseEmployee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}
}