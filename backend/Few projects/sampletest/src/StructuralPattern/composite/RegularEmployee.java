package StructuralPattern.composite;

import java.util.List;

//Leaf class
public class RegularEmployee implements Employee {
	private String name;
	private String department;
	private double salary;

	public RegularEmployee(String name, String department, double salary) {
		this.name = name;
		this.department = department;
		this.salary = salary;
	}

	@Override
	public void add(Employee employee) {
		// Leaf node cannot have subordinates
	}

	@Override
	public void remove(Employee employee) {
		// Leaf node cannot have subordinates
	}

	@Override
	public List<Employee> getSubordinates() {
		// Leaf node does not have subordinates
		return null;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDepartment() {
		return department;
	}

	@Override
	public double getSalary() {
		return salary;
	}
}
