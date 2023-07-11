package multiton;

import java.util.HashMap;
import java.util.Map;

public class EmployeeMultiton {
    private static Map<String, EmployeeMultiton> instances = new HashMap<>();
    private String name;
    private int id;
    
    private EmployeeMultiton(String name, int id) {
        this.name = name;
        this.id = id;
    }
    
    public static synchronized EmployeeMultiton getInstance(String key, String name, int id) {
        if (!instances.containsKey(key)) {
            instances.put(key, new EmployeeMultiton(name, id));
        }
        return instances.get(key);
    }
    
    public void displayInfo() {
        System.out.println("Name: " + name + ", ID: " + id);
    }
}
