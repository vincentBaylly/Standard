package org.highschool.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.highschool.model.impl.Course;

public class CourseDAO extends DAO<Course> {

		private Logger LOG = Logger.getLogger(CourseDAO.class.getName()); 
		
		private static String INSERT_SQL = "INSERT INTO COURSE ('LABEL') VALUES (";
		private static String UPDATE_SQL = "UPDATE STUDENT SET";
		private static String DELETE_SQL = "DELETE FROM STUDENT WHERE";
		private static String SELECT_SQL = "SELECT * FROM COURSE";
		
		public boolean create(Course course) {
			int result = 0;
			boolean success = false;
			try {
				result = this.connect.createStatement()
						.executeUpdate(INSERT_SQL 
								+ course.getLabel()
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

		@Override
		public Course findById(int id) {
			Course Course = null;
			try {
				ResultSet result = this.connect
						.createStatement()
						.executeQuery("SELECT * FROM COURSE ");
				if (result.first()) {
					Course = new Course(id, result.getString("label"));
					result.beforeFirst();
				}
			} catch (SQLException ex) {
				LOG.log(Level.SEVERE, "Erreur SQL", ex);
			}
			return Course;
		}
		
		public List<Course> findByTeacherNumber(int teacherNumber) {
			
			List<Course> coursesList = new ArrayList<Course>();
			
			try {
				ResultSet result = this.connect
						.createStatement()
						.executeQuery("SELECT * FROM COURSE WHERE TEACHER_NUMBER = " + teacherNumber);
				while(result.next()) {
					Course course = new Course(result.getInt("id"), result.getString("label"));
					coursesList.add(course);
				}
			} catch (SQLException ex) {
				LOG.log(Level.SEVERE, "Erreur SQL", ex);
			}
			return coursesList;
		}

		public boolean update(Course obj) {
			return false;
		}

		@Override
		public List<Course> findAll() {
			return null;
		}
}
