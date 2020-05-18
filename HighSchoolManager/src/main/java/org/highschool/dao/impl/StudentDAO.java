package org.highschool.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.highschool.model.impl.Gender;
import org.highschool.model.impl.Student;
import org.highschool.util.Utils;

public class StudentDAO extends DAO<Student> {
	
	private Logger LOG = Logger.getLogger(StudentDAO.class.getName());
	
	private static String INSERT_SQL = "INSERT INTO STUDENT ('FIRSTNAME', 'LASTNAME', 'EMAIL', 'GENDER', 'HEIGHT', 'BIRTHDATE', 'SUBJECT') VALUES (";
	private static String UPDATE_SQL = "UPDATE STUDENT SET";
	private static String SELECT_SQL = "SELECT * FROM STUDENT" + 
										" LEFT JOIN COURSE ON COURSE.STUDENT_NUMBER = STUDENT.STUDENT_NUMBER" + 
										" LEFT JOIN SESSION ON SESSION.STUDENT_NUMBER = STUDENT.STUDENT_NUMBER";
	
	@Override
	public boolean create(Student student) {
		int result = 0;
		boolean success = false;
		try {
			
	        String birthDate = Utils.parseDate(student.getBirthDate());
			
			String request = INSERT_SQL 
					+ "'" + student.getFirstName() +  "', "
					+ " '" + student.getLastName() +  "', "
					+ " '" + student.getEmail() +  "', " 
					+ " '" + student.getGender() +  "', " 
					+ " '" + student.getHeight()	+  "', " 
					+ " '" + birthDate + "', " 
					+ "'" + student.getSubject() +  "'"
			+ ");" ;
			LOG.log(Level.FINE, request);
			result = this.connect.createStatement()
					.executeUpdate(request);
		} catch (SQLException ex) {
			LOG.log(Level.SEVERE, "Erreur SQL", ex);
		} catch (ParseException ex) {
			LOG.log(Level.SEVERE, "Error Parsing Date", ex);
		}

		if (result != 0)
			success = true;
		return success;
	}
	
	public boolean delete(int id) {
		return this.delete(id, "STUDENT", "STUDENT_NUMBER");
	}

	@Override
	public Student findById(int id) {
		Student student = null;
		try {
			ResultSet result = this.connect
					.createStatement()
					.executeQuery(SELECT_SQL
							+ " WHERE STUDENT_NUMBER =" + id);
			if (result.next()) {

				student = new Student(id, result.getString("FIRSTNAME"), result.getString("LASTNAME"),
						result.getString("EMAIL"), Gender.valueOf(result.getString("GENDER")), result.getInt("HEIGHT"),
						result.getDate("BIRTHDATE"), result.getString("SUBJECT"));
				CourseDAO courseDao = new CourseDAO();

				while (result.next())
					student.getCourses().add(courseDao.findById(student.getStudentNumber()));

				SessionDAO sessionDao = new SessionDAO();

				while (result.next())
					student.getSessions().add(sessionDao.findById(student.getStudentNumber()));
			}
		} catch (SQLException ex) {
			LOG.log(Level.SEVERE, "Erreur SQL", ex);
		}
		return student;
	}
	
	@Override
	public List<Student> findAll() {
		List<Student> studentsList = null;
		try {
			ResultSet result = this.connect
					.createStatement()
					.executeQuery(SELECT_SQL);
			
			studentsList = new ArrayList<Student>();
			
			while (result.next()) {

				Student student = new Student(result.getInt("STUDENT_NUMBER"), result.getString("FIRSTNAME"), result.getString("LASTNAME"),
						result.getString("EMAIL"), Gender.valueOf(result.getString("GENDER")), result.getInt("HEIGHT"),
						result.getDate("BIRTHDATE"), result.getString("SUBJECT"));
				CourseDAO courseDao = new CourseDAO();

				student.setCourses(courseDao.findByStudentNumber(student.getStudentNumber()));

				SessionDAO sessionDao = new SessionDAO();

				student.setSessions(sessionDao.findByStudentNumber(student.getStudentNumber()));
				
				studentsList.add(student);
			}
		} catch (SQLException ex) {
			LOG.log(Level.SEVERE, "Erreur SQL", ex);
		}
		return studentsList;
	}
	
	@Override
	public boolean update(Student student) {
		int result = 0;
		boolean success = false;
		try {
			
			String birthDate = Utils.parseDate(student.getBirthDate());
			
			String request = UPDATE_SQL
					+ " FIRSTNAME='" + student.getFirstName() + "',"
					+ " LASTNAME='" + student.getLastName() + "',"
					+ " EMAIL='" + student.getEmail() + "',"
					+ " GENDER='" + student.getGender() + "',"
					+ " BIRTHDATE='" + birthDate + "',"
					+ " HEIGHT=" + student.getHeight() + ","
					+ " SUBJECT='" + student.getSubject() + "'"
					+ " WHERE STUDENT_NUMBER = " + student.getStudentNumber()
			+ ";";
			LOG.log(Level.FINE, request);
			
			result = this.connect.createStatement()
					.executeUpdate(request);
		} catch (SQLException ex) {
			LOG.log(Level.SEVERE, "Erreur SQL", ex);
		} catch (ParseException ex) {
			LOG.log(Level.SEVERE, "Error Parsing Date", ex);
		}

		if (result != 0)
			success=true;
		return success;
	}
}
