package StructuralPattern.flyweight;

public class Client {
	 public static void main(String[] args) {
	        Employee e1 = EmployeeFactory.getEmployee("John", "Sales");
	        e1.printDetails();

	        Employee e2 = EmployeeFactory.getEmployee("Mary", "Marketing");
	        e2.printDetails();

	        Employee e3 = EmployeeFactory.getEmployee("John", "Sales");
	        e3.printDetails();

	        System.out.println("e1 and e3 are the same object: " + (e1 == e3));
	        
	    }
}

/*
 In this implementation, we have an Employee class that represents an employee with a name and department. 
 We also have an EmployeeFactory class that acts as a factory for creating Employee objects. 
 The EmployeeFactory class maintains a HashMap of existing Employee objects, and when getEmployee()
  is called with a name and department, it checks if an Employee object with that name and department 
  already exists in the HashMap. If it does, it returns the existing Employee object; 
  otherwise, it creates a new Employee object and adds it to the HashMap before returning it.

In the Main class, we demonstrate how the Flyweight pattern can be used to share objects 
between multiple clients. We create three Employee objects, but since two of them have the same 
name and department, the EmployeeFactory only creates two distinct Employee objects, 
which are then shared between the three references. We verify this by checking 
if e1 and e3 reference the same object. 
  
 
 */


