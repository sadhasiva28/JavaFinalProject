package StructuralPattern.composite;

import java.util.ArrayList;
import java.util.List;

// Component interface
public interface Employee {
    public void add(Employee employee);
    public void remove(Employee employee);
    public List<Employee> getSubordinates();
    public String getName();
    public String getDepartment();
    public double getSalary();
}
