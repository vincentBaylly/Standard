package org.initial.heritage;

import java.util.Date;

/**
 * abstract
 * 
 *
 */
public abstract class Person implements Comparable<Person>{
	
	private String firstName;
	
	private String lastName;
	
	private Date birthDate;
	
	private Gender gender;
	
	private Integer height;
	
	public Person() {
		super();
	}
	
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Person(String firstName, String lastName, Gender gender, Integer height) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.height = height;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate + ", gender="
				+ gender + ", height=" + height + "]";
	}

	@Override
	public int compareTo(Person s) {
		if (!this.getLastName().equals(s.getLastName()))
			return this.getLastName().compareTo(s.getLastName());
		else
			return this.getFirstName().compareTo(s.getFirstName());
	}

}
