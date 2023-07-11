package com.dedalus.controller;
import com.dal.dao.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import com.dedalus.model.*;

public class Employeecontroller implements EmployeeInterface,Serializable {
	
	Scanner sc = new Scanner(System.in);
	
	List <Employee> emplist = new ArrayList<Employee>(); 
	EmployeeDao empdao = new EmployeeDao();
	public void addEmployee()
	{		
		Employee emp = new Employee();
		System.out.println("Enter Eno");
		int eno =sc.nextInt();
		emp.setEmpno(eno);
		
		System.out.println("Enter Ename");
		String ename =sc.next();
		emp.setEname(ename);
		emplist.add(emp);
		empdao.insertEmployee(emp);
		System.out.println("Employee Added Successfully");
		
	}
	public List<Employee> getEmplist(){
		return emplist;
	}
	
	public void viewEmployee() {
		
//		System.out.println(emplist);
		emplist.forEach(e -> System.out.println(e));
		System.out.println("Dataas from DB:");
		empdao.showEmployee();
		
	}
	
	public void updateEmployee() {
		 System.out.println("Enter the employee number to update:");
		    int empno = sc.nextInt();

		    System.out.println("Enter the new employee name:");
		    String ename = sc.next();
		    
		    Employee empToUpdate = new Employee();
		    empToUpdate.setEmpno(empno);
		    empToUpdate.setEname(ename);
		    
		    empdao.updateEmployee(empno, empToUpdate);
		    System.out.println("Employee updated successfully!");
	  
	}


	public void deleteEmployee() {
		 System.out.println("Enter the employee number to delete:");
		    int empno = sc.nextInt();

		    empdao.deleteEmployee(empno);
		    System.out.println("Employee deleted successfully!");
		
	}
	
	public void sortByNumber() {
        Employee[] empArray = emplist.toArray(new Employee[0]);
        Arrays.sort(empArray);
        System.out.println("Sorted Employee Array by Number: " + Arrays.toString(empArray));
    }

    public void sortByName() {
        Employee[] empArray = emplist.toArray(new Employee[0]);
        Arrays.sort(empArray, Employee.nameComparator);
        System.out.println("Sorted Employee Array by Name: " + Arrays.toString(empArray));
    }
	public void serialize(List<Employee> emp) throws IOException{
		try {
			
			FileOutputStream fos = new FileOutputStream("dedalus.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(emp);
			System.out.println("Serialized to file dedalus.txt");
			oos.close();
			fos.close();
			
		} catch (FileNotFoundException fnf) {
			System.out.println("No file");
		}
		
	}
	public void deserialize(String filename) throws IOException{
		try {
			FileInputStream fis = new FileInputStream("dedalus.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			List<Employee> emp=(List<Employee>)ois.readObject();
			
			System.out.println("Deserialized from file dedalus.txt");
			Employeecontroller deserializedEC = (Employeecontroller) ois.readObject();
			for(int i=0; i<emp.size();i++){
				System.out.println("employee no."+emp.get(i).getEmpno());
				System.out.println("employee no."+emp.get(i).getEname());
				
			}
			ois.close();
			fis.close();
		} catch (FileNotFoundException fnf) {
			System.out.println("No file");
		} catch (ClassNotFoundException cnf) {
			System.out.println("No EmployeeController class");
		}
		
	}

}