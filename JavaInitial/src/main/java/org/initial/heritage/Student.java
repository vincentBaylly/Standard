package org.initial.heritage;

public class Student extends Person{

	private Integer studentNumber;
	
	public Student() {
		super();
	}
	
	public Student(String firstName, String lastName, Gender gender, Integer height) {
		super(firstName, lastName, gender, height);
	}
	
	public Integer getStudentNumber() {
		return studentNumber;
	}
	
	public void setStudentNumber(Integer studentNumber) {
		this.studentNumber = studentNumber;
	}
}

