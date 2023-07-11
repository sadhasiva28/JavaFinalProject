package StructuralPattern.composite;

import java.util.ArrayList;
import java.util.List;

//Composite class
public class Manager implements Employee {
	private String name;
	private String department;
	private double salary;
	private List<Employee> subordinates;

	public Manager(String name, String department, double salary) {
		this.name = name;
		this.department = department;
		this.salary = salary;
		subordinates = new ArrayList<>();
	}

	@Override
	public void add(Employee employee) {
		subordinates.add(employee);
	}

	@Override
	public void remove(Employee employee) {
		subordinates.remove(employee);
	}

	@Override
	public List<Employee> getSubordinates() {
		return subordinates;
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
		double totalSalary = salary;
		for (Employee subordinate : subordinates) {
			totalSalary += subordinate.getSalary();
		}
		return totalSalary;
	}
}
