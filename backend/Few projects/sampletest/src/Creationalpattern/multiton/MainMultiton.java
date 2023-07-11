package multiton;

public class MainMultiton {

	public static void main(String[] args) {
		EmployeeMultiton employee1 = EmployeeMultiton.getInstance("1", "John", 12345);
		EmployeeMultiton employee2 = EmployeeMultiton.getInstance("2", "James", 54321);
		EmployeeMultiton employee3 = EmployeeMultiton.getInstance("1", "Julie", 67890);

		employee1.displayInfo(); // output: Name: John, ID: 12345
		employee2.displayInfo(); // output: Name: James, ID: 54321
		employee3.displayInfo(); // output: Name: Julie, ID: 12345
	}

}


/*
In this example, we create three instances of the EmployeeMultiton class
 with two instances sharing the same key "1". 
 When we call the displayInfo() method on employee1, employee2, and employee3, 
we see that employee1 and employee3 have the same name and id values, indicating that they are the same instance.

what is the difference between multiton and singleton
The main difference between Multiton and Singleton design patterns is that Multiton pattern creates
 multiple instances of a class with a finite and pre-defined number of possible instances, 
while Singleton pattern creates only one instance of a class throughout the entire lifetime of the application.

In a Multiton pattern, you have a limited number of instances, each identified by a key or name.
 The instances are usually created when they are first requested and cached for future use. 
 This pattern can be useful in cases where you need to manage a finite number of shared resources, 
 such as database connections or thread pools.

On the other hand, a Singleton pattern ensures that there is only one instance of a class in the
 entire application, which can be accessed globally. This pattern is commonly used for managing resources 
 that must be shared across the entire application and should not be replicated, such as a configuration manager
  or a logger.

In summary, while Singleton pattern ensures that there is only one instance of a class in the application, 
Multiton pattern creates a finite and predefined number of instances, each identified by a key or name.
*/