package org.highschool.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.highschool.model.impl.Session;

public class SessionDAO extends DAO<Session> {
	
	private Logger LOG = Logger.getLogger(SessionDAO.class.getName());
	
	private static String INSERT_SQL = "INSERT INTO STUDENT ('FIRSTNAME', 'LASTNAME', 'EMAIL', 'GENDER', 'HEIGHT', 'BIRTHDATE') VALUES (";
	private static String UPDATE_SQL = "UPDATE STUDENT SET";
	private static String DELETE_SQL = "DELETE FROM STUDENT WHERE";
	private static String SELECT_SQL = "SELECT * FROM STUDENT" + 
										"LEFT JOIN COURSE ON COURSE.STUDENT_NUMBER = STUDENT.TEACHER_NUMBER" + 
										"LEFT JOIN SESSION ON SESSION.STUDENT_NUMBER = STUDENT.TEACHER_NUMBER";
	
	public boolean create(Session session) {
		int result = 0;
		boolean success = false;
		try {
			result = this.connect.createStatement()
					.executeUpdate(INSERT_SQL 
							+ session.getLabel()
							+ session.getSubmitDate()
					+ ";");
		} catch (SQLException ex) {
			LOG.log(Level.SEVERE, "Erreur SQL", ex);
		}

		if (result != 0)
			success = true;
		return success;
	}

	public boolean delete(int id) {
		return false;
	}

	public Session findById(int id) {
		Session Session = null;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM SESSION " + "LEFT JOIN STUDENT ON student_pk = student_id "
							+ "AND student_id = " + id);
			if (result.first()) {
				Session = new Session(id, result.getString("label"), result.getDate("submitDate"));
				result.beforeFirst();
			}
		} catch (SQLException ex) {
			LOG.log(Level.SEVERE, "Erreur SQL", ex);
		}
		return Session;
	}

	public boolean update(Session session) {
		return false;
	}

	@Override
	public List<Session> findAll() {
		return null;
	}

}
