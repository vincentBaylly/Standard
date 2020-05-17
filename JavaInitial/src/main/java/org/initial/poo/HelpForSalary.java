package org.initial.poo;

import java.util.Scanner;

public class HelpForSalary {
	
	public void displayEmployee() {
		System.out.println("================================" + "\n" + "Enter Full Time Employee Details" + "\n"
				+ "================================" + "\n");
		FullTimeEmployee fullTimeEmployees  = new FullTimeEmployee();
		PartTimeEmployee partTimeEmployees = new PartTimeEmployee();
		System.out.println("================================" + "\n" + "Enter Part Time Employee Details" + "\n"
				+ "================================" + "\n");
		fullTimeEmployees.display();
		partTimeEmployees.calculatepay();
		partTimeEmployees.display();
	}
	
	class Employee {
		int age;
		String name, address, gender;
		Scanner get = new Scanner(System.in);

		Employee() {
			System.out.println("Enter Name of the Employee:");
			name = get.nextLine();
			System.out.println("Enter Gender of the Employee:");
			gender = get.nextLine();
			System.out.println("Enter Address of the Employee:");
			address = get.nextLine();
			System.out.println("Enter Age:");
			age = get.nextInt();
		}

		void display() {
			System.out.println("Employee Name: " + name);
			System.out.println("Age: " + age);
			System.out.println("Gender: " + gender);
			System.out.println("Address: " + address);
		}
	}

	class FullTimeEmployee extends Employee {
		float salary;
		int des;

		FullTimeEmployee() {
			System.out.println("Enter Designation:");
			des = get.nextInt();
			System.out.println("Enter Salary:");
			salary = get.nextFloat();
		}

		void display() {
			System.out.println("==============================" + "\n" + "Full Time Employee Details" + "\n"
					+ "==============================" + "\n");
			super.display();
			System.out.println("Salary: " + salary);
			System.out.println("Designation: " + des);
		}
	}

	class PartTimeEmployee extends Employee {
		int workinghrs, rate;

		PartTimeEmployee() {
			System.out.println("Enter Number of Working Hours:");
			workinghrs = get.nextInt();
		}

		void calculatepay() {
			rate = 8 * workinghrs;
		}

		void display() {
			System.out.println("==============================" + "\n" + "Part Time Employee Details" + "\n"
					+ "==============================" + "\n");
			super.display();
			System.out.println("Number of Working Hours: " + workinghrs);
			System.out.println("Salary for " + workinghrs + " working hours is: $" + rate);
		}
	}
	
	public static void main(String args[]) {
		HelpForSalary helpForSalary = new HelpForSalary();
		helpForSalary.displayEmployee();
	}
}
