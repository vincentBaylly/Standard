package org.highschool.dao;
import java.util.List;

/**
 *
 * @author vbaylly
 */
public interface IDAO<T> {

    boolean create(T o);

    boolean delete(int id, String tableName, String conditionFields);

    boolean update(T o);

    List<T> findAll();

    T findById(int id);

}