package org.highschool.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.highschool.model.impl.Gender;
import org.highschool.model.impl.Teacher;
import org.highschool.util.Utils;

public class TeacherDAO extends DAO<Teacher> {

	private Logger LOG = Logger.getLogger(TeacherDAO.class.getName());

	private static String INSERT_SQL = "INSERT INTO TEACHER ('FIRSTNAME', 'LASTNAME', 'EMAIL', 'GENDER', 'HEIGHT', 'BIRTHDATE') VALUES (";
	private static String UPDATE_SQL = "UPDATE TEACHER SET";
	private static String SELECT_SQL = "SELECT * FROM TEACHER LEFT JOIN COURSE ON COURSE.TEACHER_NUMBER = TEACHER.TEACHER_NUMBER";

	@Override
	public boolean create(Teacher teacher) {
		int result = 0;
		boolean success = false;
		try {
			
			String birthDate = Utils.parseDate(teacher.getBirthDate());
			
			String request = INSERT_SQL 
					+ "'" + teacher.getFirstName() +  "', "
					+ " '" + teacher.getLastName() +  "', "
					+ " '" + teacher.getEmail() +  "', "
					+ " '" + teacher.getGender() +  "', " 
					+ " '" + birthDate + "', "
					+ " '" + teacher.getHeight()	+ "'" 
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
		return this.delete(id, "TEACHER", "TEACHER_NUMBER");
	}
	
	@Override
	public Teacher findById(int id) {
		Teacher teacher = null;
		try {
			ResultSet result = this.connect.createStatement()
					.executeQuery(SELECT_SQL
								+ " WHERE TEACHER_NUMBER =" + id);
			if (result.next()) {
				teacher = new Teacher(id, result.getString("FIRSTNAME"), result.getString("LASTNAME"),
						result.getString("EMAIL"), Gender.valueOf(result.getString("GENDER")), result.getInt("HEIGHT"),
						result.getDate("BIRTHDATE"));
				CourseDAO courseDao = new CourseDAO();

				teacher.setCourses(courseDao.findByTeacherNumber(teacher.getTeacherNumber()));
			}
		} catch (SQLException ex) {
			LOG.log(Level.SEVERE, "Erreur SQL", ex);
		}
		return teacher;
	}
	
	@Override
	public List<Teacher> findAll() {
		List<Teacher> teachersList = null;

		try {
			ResultSet result = this.connect.createStatement().executeQuery(SELECT_SQL);
			teachersList = new ArrayList<Teacher>();
			while (result.next()) {

				Teacher teacher = new Teacher(result.getInt("TEACHER_NUMBER"), result.getString("FIRSTNAME"),
						result.getString("LASTNAME"), result.getString("EMAIL"),
						Gender.valueOf(result.getString("GENDER")), result.getInt("HEIGHT"), result.getDate("BIRTHDATE"));

				CourseDAO courseDao = new CourseDAO();
				teacher.setCourses(courseDao.findByTeacherNumber(result.getInt("TEACHER_NUMBER")));
				teachersList.add(teacher);
			}
		} catch (SQLException ex) {
			LOG.log(Level.SEVERE, "Erreur SQL", ex);
		}

		return teachersList;
	}
	
	@Override
	public boolean update(Teacher teacher) {
		int result = 0;
		boolean success = false;
		try {
			
			String birthDate = Utils.parseDate(teacher.getBirthDate());
			
			result = this.connect.createStatement()
					.executeUpdate(UPDATE_SQL
							+ " FIRSTNAME='" + teacher.getFirstName() + "',"
							+ " LASTNAME='" + teacher.getLastName() + "',"
							+ " EMAIL='" + teacher.getEmail() + "',"
							+ " GENDER='" + teacher.getGender() + "',"
							+ " BIRTHDATE='" + birthDate + "',"
							+ " HEIGHT=" + teacher.getHeight()
							+ " WHERE TEACHER_NUMBER = " + teacher.getTeacherNumber()
					+ ";");
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
