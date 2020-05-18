package org.highschool.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.highschool.model.impl.Session;

public class SessionDAO extends DAO<Session> {
	
	private Logger LOG = Logger.getLogger(SessionDAO.class.getName());
	
	private static String INSERT_SQL = "INSERT INTO SESSION ('LABEL', 'SUBMIT_DATE') VALUES (";
	private static String UPDATE_SQL = "UPDATE SESSION SET";
	private static String SELECT_SQL = "SELECT * FROM SESSION";
	
	@Override
	public boolean create(Session session) {
		int result = 0;
		boolean success = false;
		try {
			String request = INSERT_SQL 
					+ session.getLabel()
					+ session.getSubmitDate()
			+ ";";
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
		return this.delete(id, "SESSION", "ID");
	}

	@Override
	public List<Session> findAll() {
		List<Session> sessionsList = new ArrayList<Session>();
		
		try {
			ResultSet result = this.connect
					.createStatement()
					.executeQuery(SELECT_SQL);
			while(result.next()) {
				Session session = new Session(result.getInt("ID"), result.getString("LABEL") ,result.getDate("SUBMIT_DATE"));
				sessionsList.add(session);
			}
		} catch (SQLException ex) {
			LOG.log(Level.SEVERE, "Erreur SQL", ex);
		}
		return sessionsList;
	}
	
	@Override
	public Session findById(int id) {
		Session Session = null;
		try {
			ResultSet result = this.connect
					.createStatement()
					.executeQuery(SELECT_SQL + " WHERE ID = " + id);
			if (result.first()) {
				Session = new Session(id, result.getString("LABEL"), result.getDate("SUBMIT_DATE"));
				result.beforeFirst();
			}
		} catch (SQLException ex) {
			LOG.log(Level.SEVERE, "Erreur SQL", ex);
		}
		return Session;
	}
	
	public List<Session> findByStudentNumber(int studentNumber) {
		
		List<Session> sessionsList = new ArrayList<Session>();
		
		try {
			ResultSet result = this.connect
					.createStatement()
					.executeQuery(SELECT_SQL + " WHERE STUDENT_NUMBER = " + studentNumber);
			while(result.next()) {
				Session session = new Session(result.getInt("ID"), result.getString("LABEL"), result.getDate("SUBMIT_DATE"));
				sessionsList.add(session);
			}
		} catch (SQLException ex) {
			LOG.log(Level.SEVERE, "Erreur SQL", ex);
		}
		return sessionsList;
	}
	
	@Override
	public boolean update(Session session) {
		int result = 0;
		boolean success = false;
		try {
			result = this.connect.createStatement()
					.executeUpdate(UPDATE_SQL
							+ " LABEL=" + session.getLabel()
							+ " SUBMIT_DATE=" + session.getSubmitDate()
					+ ";");
		} catch (SQLException ex) {
			LOG.log(Level.SEVERE, "Erreur SQL", ex);
		}

		if (result != 0)
			success=true;
		return success;
	}

}
