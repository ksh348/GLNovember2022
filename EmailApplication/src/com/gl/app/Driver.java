package com.gl.app;

import java.util.Scanner;

import com.gl.entities.Employee;
import com.gl.interfaces.Credentials;
import com.gl.service.CredentialService;

public class Driver {

	public static void main(String[] args) {
		Employee emp = new Employee("Sridhar", "Kokkula");
		
		Credentials cred = new CredentialService();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("1. Technical");
		System.out.println("2. Human Resource");
		System.out.println("3. Admin");
		System.out.println("4. Legal");
		System.out.println("Select Department ");
		int dept = scan.nextInt();
		
		switch (dept) {
		case 1:
			emp.setEmail(cred.generateEmailAddress(emp.getFirstName(), emp.getLastName(), "tech"));
			break;
		case 2:
			emp.setEmail(cred.generateEmailAddress(emp.getFirstName(), emp.getLastName(), "hr"));
			break;
		case 3:
			emp.setEmail(cred.generateEmailAddress(emp.getFirstName(), emp.getLastName(), "admin"));
			break;
		case 4:
			emp.setEmail(cred.generateEmailAddress(emp.getFirstName(), emp.getLastName(), "legal"));
			break;
		default:
			System.out.println("Invalid department Email Cannot be created");
		}
		emp.setPassword(cred.generatePassword());
		
		cred.showCredentials(emp);
		
		scan.close();
	}
}