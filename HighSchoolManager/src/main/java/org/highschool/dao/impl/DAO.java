package org.highschool.dao.impl;

import java.sql.Connection;
import java.util.List;

import org.highschool.dao.IDAO;
import org.highschool.jdbc.ConnectionSQLite;

public abstract class DAO<T> implements IDAO<T> {
	
	public Connection connect = ConnectionSQLite.getInstance();
	
	public abstract boolean create(T o);

	public abstract boolean delete(int id);

	public abstract boolean update(T o);

	public abstract List<T> findAll();

	public abstract T findById(int id);
	
}
