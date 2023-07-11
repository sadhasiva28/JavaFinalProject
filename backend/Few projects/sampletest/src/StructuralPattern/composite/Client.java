package StructuralPattern.composite;

import java.util.List;

//Client code
public class Client {
	public static void main(String[] args) {
		Employee john = new RegularEmployee("John", "Sales", 5000);
		Employee jane = new RegularEmployee("Jane", "Marketing", 6000);

		Employee bob = new Manager("Bob", "Sales", 10000);
		bob.add(john);

		Employee sarah = new Manager("Sarah", "Marketing", 12000);
		sarah.add(jane);

		Employee alice = new Manager("Alice", "CEO", 20000);
		alice.add(bob);
		alice.add(sarah);

		System.out.println("Employee details:");
		System.out.println(alice.getName() + ", " + alice.getDepartment() + ", " + alice.getSalary());

		List<Employee> subordinates = alice.getSubordinates();
		for (Employee subordinate : subordinates) {
			System.out.println(
					"\t" + subordinate.getName() + ", " + subordinate.getDepartment() + ", " + subordinate.getSalary());
			List<Employee> subSubordinates = subordinate.getSubordinates();
			if (subSubordinates != null) {
				for (Employee subSubordinate : subSubordinates) {
					System.out.println("\t\t" + subSubordinate.getName() + ", " + subSubordinate.getDepartment() + ", "
							+ subSubordinate.getSalary());
				}
			}
		}
	}
}