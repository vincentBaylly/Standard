package org.highschool.model.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends Person {

	private Integer studentNumber;

	private String subject;

	private List<Session> sessions = new ArrayList<Session>();

	private List<Course> listCourses = new ArrayList<Course>();

	public Student(Integer studentNumber, String firstName, String lastName, String email, Gender gender,
			Integer height, Date birthDate, String subject) {
		super(firstName, lastName, email, gender, height, birthDate);
		this.studentNumber = studentNumber;
		this.subject = subject;
	}

	public Integer getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(Integer studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	public List<Course> getCourses() {
		return listCourses;
	}

	public void setCourses(List<Course> courses) {
		this.listCourses = courses;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((listCourses == null) ? 0 : listCourses.hashCode());
		result = prime * result + ((sessions == null) ? 0 : sessions.hashCode());
		result = prime * result + ((studentNumber == null) ? 0 : studentNumber.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
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
		Student other = (Student) obj;
		if (studentNumber == null) {
			if (other.studentNumber != null)
				return false;
		} else if (!studentNumber.equals(other.studentNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + " Student [studentNumber=" + studentNumber + ", subject=" + subject + ", sessions="
				+ sessions + ", courses=" + listCourses + "]";
	}

}
