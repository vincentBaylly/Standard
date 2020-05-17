package org.highschool.model.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.highschool.model.IEmployee;

public class Teacher extends Person implements IEmployee {

	private int teacherNumber;
	private int affectedHours;
	private int rate;
	
	private List<Course> courses = new ArrayList<Course>();
	
	public Teacher(int teacherNumber, String firstName, String lastName, String email, Gender gender, Integer height, Date birthDate) {
		super(firstName, lastName, email, gender, height, birthDate);
		this.teacherNumber = teacherNumber;
	}
	
	public int getTeacherNumber() {
		return teacherNumber;
	}

	public void setTeacherNumber(int teacherNumber) {
		this.teacherNumber = teacherNumber;
	}
	
	public int getAffectedHours() {
		return affectedHours;
	}

	public void setAffectedHours(int affectedHours) {
		this.affectedHours = affectedHours;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public double getSalary() {
		return affectedHours * rate;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + teacherNumber;
		result = prime * result + affectedHours;
		result = prime * result + rate;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher other = (Teacher) obj;
		if (teacherNumber != other.teacherNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + " Teacher [teacheNumber=" + teacherNumber + ", salary=" + getSalary() + ", affectedHours=" + affectedHours + ", rate=" + rate + "]";
	}
	
	
}
