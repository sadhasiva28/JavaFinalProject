package com.dal.hibproj;

import java.util.Scanner;

import com.dal.controller.EmployeeController;

public class App {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		EmployeeController ec = new EmployeeController();
		String c = null;
		do {
			System.out.println("Enter your Choice :");
			System.out.println("1. Add Employee");
			System.out.println("2. View Employee");
			System.out.println("3. Update Employee");
			System.out.println("4. Search Employee By ID");
			System.out.println("5. Search Employee Using Criteria Query");
			int choice = sc.nextInt();

			switch (choice) {
			case 1: {
				ec.addEmployee();
				break;
			}
			case 2: {
				ec.viewEmployee();
				break;
			}
			case 3: {
				ec.updateEmployee();
				break;
			}
			case 4: {
				ec.searchEmpByIDusingNamedQuery();
				break;
			}

			case 5: {
				ec.searchUsingCriteriaQuery();
				break;
			}

			default: {
				System.out.println("Choose the right choice !!!");
			}
			}
			System.out.println("Do you want to continue? Y or y");
			c = sc.next();
		} while (c.equals("y") || c.equals("Y"));
		System.out.println("Exited from application.");
		System.exit(0);

	}

}
