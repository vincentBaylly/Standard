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
		private static String UPDATE_SQL = "UPDATE COURSE SET";
		private static String SELECT_SQL = "SELECT * FROM COURSE";
		
		@Override
		public boolean create(Course course) {
			int result = 0;
			boolean success = false;
			try {
				String request = INSERT_SQL 
						+ course.getLabel()
				+ ");" ;
				LOG.log(Level.FINE, request);
				result = this.connect.createStatement()
						.executeUpdate(request);
			} catch (SQLException ex) {
				LOG.log(Level.SEVERE, "Erreur SQL", ex);
			}

			if (result != 0)
				success = true;
			return success;
		}
		
		public boolean delete(int id) {
			return this.delete(id, "COURSE", "ID");
		}
		
		@Override
		public List<Course> findAll() {
			List<Course> coursesList = new ArrayList<Course>();
			
			try {
				ResultSet result = this.connect
						.createStatement()
						.executeQuery(SELECT_SQL);
				while(result.next()) {
					Course course = new Course(result.getInt("ID"), result.getString("LABEL"));
					coursesList.add(course);
				}
			} catch (SQLException ex) {
				LOG.log(Level.SEVERE, "Erreur SQL", ex);
			}
			return coursesList;
		}
		
		@Override
		public Course findById(int id) {
			Course Course = null;
			try {
				ResultSet result = this.connect
						.createStatement()
						.executeQuery(SELECT_SQL + " WHERE ID=" + id);
				if (result.next()) {
					Course = new Course(id, result.getString("label"));
					result.beforeFirst();
				}
			} catch (SQLException ex) {
				LOG.log(Level.SEVERE, "Erreur SQL", ex);
			}
			return Course;
		}
		
		public List<Course> findByStudentNumber(int studentNumber) {
			
			List<Course> coursesList = new ArrayList<Course>();
			
			try {
				ResultSet result = this.connect
						.createStatement()
						.executeQuery(SELECT_SQL + " WHERE STUDENT_NUMBER = " + studentNumber);
				while(result.next()) {
					Course course = new Course(result.getInt("ID"), result.getString("LABEL"));
					coursesList.add(course);
				}
			} catch (SQLException ex) {
				LOG.log(Level.SEVERE, "Erreur SQL", ex);
			}
			return coursesList;
		}
		
		public List<Course> findByTeacherNumber(int teacherNumber) {
			
			List<Course> coursesList = new ArrayList<Course>();
			
			try {
				ResultSet result = this.connect
						.createStatement()
						.executeQuery(SELECT_SQL + " WHERE TEACHER_NUMBER = " + teacherNumber);
				while(result.next()) {
					Course course = new Course(result.getInt("ID"), result.getString("LABEL"));
					coursesList.add(course);
				}
			} catch (SQLException ex) {
				LOG.log(Level.SEVERE, "Erreur SQL", ex);
			}
			return coursesList;
		}
		
		@Override
		public boolean update(Course course) {
			int result = 0;
			boolean success = false;
			try {
				result = this.connect.createStatement()
						.executeUpdate(UPDATE_SQL
								+ " LABEL=" + course.getLabel()
						+ ";");
			} catch (SQLException ex) {
				LOG.log(Level.SEVERE, "Erreur SQL", ex);
			}

			if (result != 0)
				success=true;
			return success;
		}
}
