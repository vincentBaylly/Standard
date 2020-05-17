package org.highschool.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.highschool.model.impl.Gender;
import org.highschool.model.impl.Student;

public class StudentDAO extends DAO<Student> {
	
	private Logger LOG = Logger.getLogger(StudentDAO.class.getName());
	
	private static String INSERT_SQL = "INSERT INTO STUDENT ('FIRSTNAME', 'LASTNAME', 'EMAIL', 'GENDER', 'HEIGHT', 'BIRTHDATE') VALUES (";
	private static String UPDATE_SQL = "UPDATE STUDENT SET";
	private static String DELETE_SQL = "DELETE FROM STUDENT WHERE";
	private static String SELECT_SQL = "SELECT * FROM STUDENT" + 
										"LEFT JOIN COURSE ON COURSE.STUDENT_NUMBER = STUDENT.TEACHER_NUMBER" + 
										"LEFT JOIN SESSION ON SESSION.STUDENT_NUMBER = STUDENT.TEACHER_NUMBER";

	public boolean create(Student student) {
		int result = 0;
		boolean success = false;
		try {
			result = this.connect.createStatement()
					.executeUpdate(INSERT_SQL 
							+ student.getFirstName() + ", "
							+ student.getLastName() + ", "
							+ student.getEmail() + ", " 
							+ student.getGender() + ", " 
							+ student.getHeight()	+ ", " 
							+ student.getBirthDate() 
					+ ";");
		} catch (SQLException ex) {
			LOG.log(Level.SEVERE, "Erreur SQL", ex);
		}

		if (result != 0)
			success = true;
		return success;
	}

	public boolean delete(int id) {
		int result = 0;
		boolean success = false;
		try {
			result = this.connect.createStatement()
					.executeUpdate(DELETE_SQL  
							+ "WHERE TEACHER_NUMBER = " + id 
					+ ";");
		} catch (SQLException ex) {
			LOG.log(Level.SEVERE, "Erreur SQL", ex);
		}

		if (result != 0)
			success = true;
		return success;
	}

	public Student findById(int id) {
		Student student = null;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery(SELECT_SQL
							+ "WHERE STUDENT_NUMBER =" + id);
			if (result.first()) {

				student = new Student(id, result.getString("firstName"), result.getString("lastName"),
						result.getString("email"), Gender.valueOf(result.getString("gender")), result.getInt("height"),
						result.getDate("birthDate"), result.getString("Subject"));
				result.beforeFirst();
				CourseDAO courseDao = new CourseDAO();

				while (result.next())
					student.getCourses().add(courseDao.findById(student.getStudentNumber()));

				SessionDAO sessionDao = new SessionDAO();

				while (result.next())
					student.getSessions().add(sessionDao.findById(result.getInt("student_id")));
			}
		} catch (SQLException ex) {
			LOG.log(Level.SEVERE, "Erreur SQL", ex);
		}
		return student;
	}
	
	public List<Student> findAll() {
		List<Student> studentsList = null;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM STUDENT"
							+ "LEFT JOIN COURSE ON COURSE.STUDENT_NUMBER = STUDENT.TEACHER_NUMBER"
							+ "LEFT JOIN SESSION ON SESSION.STUDENT_NUMBER = STUDENT.TEACHER_NUMBER");
			
			studentsList = new ArrayList<Student>();
			
			while (result.next()) {

				Student student = new Student(result.getInt("STUDENT_NUMBER"), result.getString("firstName"), result.getString("lastName"),
						result.getString("email"), Gender.valueOf(result.getString("gender")), result.getInt("height"),
						result.getDate("birthDate"), result.getString("Subject"));
				result.beforeFirst();
				CourseDAO courseDao = new CourseDAO();

				while (result.next())
					student.getCourses().add(courseDao.findById(student.getStudentNumber()));

				SessionDAO sessionDao = new SessionDAO();

				while (result.next())
					student.getSessions().add(sessionDao.findById(student.getStudentNumber()));
				
				studentsList.add(student);
			}
		} catch (SQLException ex) {
			LOG.log(Level.SEVERE, "Erreur SQL", ex);
		}
		return studentsList;
	}
	
	public boolean update(Student student) {
		int result = 0;
		boolean success = false;
		try {
			result = this.connect.createStatement()
					.executeUpdate(UPDATE_SQL
							+ "FIRSTNAME=" + student.getFirstName()
							+ "LASTNAME=" + student.getLastName()
							+ "EMAIL=" + student.getEmail()
							+ "GENDER=" + student.getGender()
							+ "HEIGHT=" + student.getHeight()
							+ "WHERE STUDENT_NUMBER = " + student.getStudentNumber()
					+ ";");
		} catch (SQLException ex) {
			LOG.log(Level.SEVERE, "Erreur SQL", ex);
		}

		if (result != 0)
			success=true;
		return success;
	}
}
