package CreationPattern;

interface MainProcess {
    void doWork();
}

class Manager implements MainProcess {
    public void doWork() {
        System.out.println("The manager is managing the team.");
    }
}

class Developer implements MainProcess {
    public void doWork() {
        System.out.println("The developer is writing code.");
    }
}

class Tester implements MainProcess {
    public void doWork() {
        System.out.println("The tester is testing the code.");
    }
}

class EmployeeFactorys {
    public MainProcess getMainProcess(String mainProcessType) {
        if (mainProcessType == null) {
            return null;
        }
        if (mainProcessType.equalsIgnoreCase("MANAGER")) {
            return new Manager();
        } else if (mainProcessType.equalsIgnoreCase("DEVELOPER")) {
            return new Developer();
        } else if (mainProcessType.equalsIgnoreCase("TESTER")) {
            return new Tester();
        }
        return null;
    }
}

public class Factorydp {
    public static void main(String[] args) {
        EmployeeFactorys employeeFactory = new EmployeeFactorys();

        MainProcess employee1 = employeeFactory.getMainProcess("MANAGER");
        employee1.doWork();

        MainProcess employee2 = employeeFactory.getMainProcess("DEVELOPER");
        employee2.doWork();

        MainProcess employee3 = employeeFactory.getMainProcess("TESTER");
        employee3.doWork();
    }
}
