package StructuralPattern.flyweight;

import java.util.HashMap;

public class EmployeeFactory {
    private static HashMap<String, Employee> employees = new HashMap<>();

    public static Employee getEmployee(String name, String department) {
        String key = name + "_" + department;

        if (!employees.containsKey(key)) {
            employees.put(key, new Employee(name, department));
        }

        return employees.get(key);
    }
}