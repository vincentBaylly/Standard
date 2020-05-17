package org.initial.heritage;

public class Teacher extends Person implements IEmployee {

	private double salary;
	
	public Teacher() {
		
	}
	
	public Teacher(String firstName, String lastName) {
		super(firstName,lastName);
	}
	
	public Teacher(String firstName, String lastName, Gender gender, Integer height) {
		super(firstName, lastName, gender, height);
	}

	public void changeStatus() {
		// TODO Auto-generated method stub

	}

	public double getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		
		return super.toString() + " Teacher [salary=" + salary + "]";
	}

}
