package org.highschool.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.highschool.dao.IDAO;
import org.highschool.jdbc.ConnectionSQLite;

public abstract class DAO<T> implements IDAO<T> {
	
	public Connection connect = ConnectionSQLite.getInstance();
	
	private Logger LOG = Logger.getLogger(TeacherDAO.class.getName());
	
	private static String DELETE_SQL = "DELETE FROM";
	
	public abstract boolean create(T o);

	@Override
	public boolean delete(int id, String tableName, String conditionField) {
		int result = 0;
		boolean success = false;
		try {
			result = this.connect.createStatement()
					.executeUpdate(DELETE_SQL  + tableName
							+ " WHERE " + conditionField + id 
					+ ";");
		} catch (SQLException ex) {
			LOG.log(Level.SEVERE, "Erreur SQL", ex);
		}

		if (result != 0)
			success = true;
		return success;
	}

	public abstract boolean update(T o);

	public abstract List<T> findAll();

	public abstract T findById(int id);
	
}
