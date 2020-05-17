package org.highschool.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.highschool.model.impl.Gender;
import org.highschool.model.impl.Teacher;

public class TeacherDAO extends DAO<Teacher> {

	private Logger LOG = Logger.getLogger(TeacherDAO.class.getName());

	private static String INSERT_SQL = "INSERT INTO TEACHER ('FIRSTNAME', 'LASTNAME', 'EMAIL', 'GENDER', 'HEIGHT', 'BIRTHDATE') VALUES (";
	private static String UPDATE_SQL = "UPDATE TEACHER SET";
	private static String DELETE_SQL = "DELETE FROM TEACHER";
	private static String SELECT_SQL = "SELECT * FROM TEACHER LEFT JOIN COURSE ON COURSE.TEACHER_NUMBER = TEACHER.TEACHER_NUMBER";

	public boolean create(Teacher teacher) {
		int result = 0;
		boolean success = false;
		try {
			result = this.connect.createStatement()
					.executeUpdate(INSERT_SQL 
							+ teacher.getFirstName() + ", "
							+ teacher.getLastName() + ", "
							+ teacher.getEmail() + ", " 
							+ teacher.getGender() + ", " 
							+ teacher.getHeight()	+ ", " 
							+ teacher.getBirthDate() 
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

	public Teacher findById(int id) {
		Teacher teacher = null;
		try {
			ResultSet result = this.connect.createStatement()
					.executeQuery(SELECT_SQL
								+ "WHERE TEACHER_NUMBER =" + id);
			if (result.first()) {
				teacher = new Teacher(id, result.getString("firstName"), result.getString("lastName"),
						result.getString("email"), Gender.valueOf(result.getString("gender")), result.getInt("height"),
						new Date());
				result.beforeFirst();
				CourseDAO courseDao = new CourseDAO();

				while (result.next())
					teacher.getCourses().add(courseDao.findById(teacher.getTeacherNumber()));
			}
		} catch (SQLException ex) {
			LOG.log(Level.SEVERE, "Erreur SQL", ex);
		}
		return teacher;
	}

	public List<Teacher> findAll() {
		List<Teacher> teachersList = null;

		try {
			ResultSet result = this.connect.createStatement().executeQuery(SELECT_SQL);
			teachersList = new ArrayList<Teacher>();
			while (result.next()) {

				Date birthDate = null;
				if (result.getDate("BIRTHDATE") != null)
					birthDate = new Date(result.getDate("BIRTHDATE").getTime());

				Teacher teacher = new Teacher(result.getInt("TEACHER_NUMBER"), result.getString("FIRSTNAME"),
						result.getString("LASTNAME"), result.getString("EMAIL"),
						Gender.valueOf(result.getString("GENDER")), result.getInt("HEIGHT"), birthDate);

				CourseDAO courseDao = new CourseDAO();
				teacher.setCourses(courseDao.findByTeacherNumber(result.getInt("TEACHER_NUMBER")));
				teachersList.add(teacher);
			}
		} catch (SQLException ex) {
			LOG.log(Level.SEVERE, "Erreur SQL", ex);
		}

		return teachersList;
	}

	public boolean update(Teacher teacher) {
		int result = 0;
		boolean success = false;
		try {
			result = this.connect.createStatement()
					.executeUpdate(UPDATE_SQL
							+ "FIRSTNAME=" + teacher.getFirstName()
							+ "LASTNAME=" + teacher.getLastName()
							+ "EMAIL=" + teacher.getEmail()
							+ "GENDER=" + teacher.getGender()
							+ "HEIGHT=" + teacher.getHeight()
							+ "WHERE TEACHER_NUMBER = " + teacher.getTeacherNumber()
					+ ";");
		} catch (SQLException ex) {
			LOG.log(Level.SEVERE, "Erreur SQL", ex);
		}

		if (result != 0)
			success=true;
		return success;
	}

}
