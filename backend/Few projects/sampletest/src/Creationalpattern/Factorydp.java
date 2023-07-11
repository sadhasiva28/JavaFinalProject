package designpattern;


interface Employee {
    void doWork();
}

class Manager implements Employee {
    public void doWork() {
        System.out.println("The manager is managing the team.");
    }
}

class Developer implements Employee {
    public void doWork() {
        System.out.println("The developer is writing code.");
    }
}

class Tester implements Employee {
    public void doWork() {
        System.out.println("The tester is testing the code.");
    }
}

class EmployeeFactory {
    public Employee getEmployee(String employeeType) {
        if (employeeType == null) {
            return null;
        }
        if (employeeType.equalsIgnoreCase("MANAGER")) {
            return new Manager();
        } else if (employeeType.equalsIgnoreCase("DEVELOPER")) {
            return new Developer();
        } else if (employeeType.equalsIgnoreCase("TESTER")) {
            return new Tester();
        }
        return null;
    }
}

public class Factorydp {
    public static void main(String[] args) {
        EmployeeFactory employeeFactory = new EmployeeFactory();

        Employee employee1 = employeeFactory.getEmployee("MANAGER");
        employee1.doWork();

        Employee employee2 = employeeFactory.getEmployee("DEVELOPER");
        employee2.doWork();

        Employee employee3 = employeeFactory.getEmployee("TESTER");
        employee3.doWork();
    }
}


/*
  the Factory Method pattern allows us to create objects 
  without exposing the creation logic to the client 
  and decouples the client code from the specific types of objects it creates, 
  such as Employee objects 
  in this example.





 * *
 */