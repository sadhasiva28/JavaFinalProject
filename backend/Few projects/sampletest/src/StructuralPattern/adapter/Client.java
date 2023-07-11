package StructuralPattern.adapter;

//Client code
public class Client {
    public static void main(String[] args) {
        Employee employee = new Employee("Shiva", "Priya", 30);
        Person person = new EmployeeAdapter(employee);

        System.out.println("Person full name: " + person.getFullName());
        System.out.println("Person age: " + person.getAge());
    }
}


/*
Adapter Pattern: Converts the interface of a class into another interface that clients expect, 
allowing classes with incompatible interfaces to work together.

In this example, Employee is the Adaptee class, which has an existing interface 
that is not compatible with the Person interface. The EmployeeAdapter class is the Adapter, 
which adapts the Employee interface to the Person interface.

The Client class uses the EmployeeAdapter to create a Person object 
from an Employee object and calls the methods defined by the Person interface.

*/
