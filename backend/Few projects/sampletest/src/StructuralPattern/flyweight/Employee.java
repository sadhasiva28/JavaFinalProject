package StructuralPattern.flyweight;

public class Employee {
	private String name;
	private String department;

	public Employee(String name, String department) {
		this.name = name;
		this.department = department;
	}

	public void printDetails() {
		System.out.println("Name: " + name + ", Department: " + department);
	}
}