package org.highschool.dao;
import java.util.List;

/**
 *
 * @author vbaylly
 */
public interface IDAO<T> {

    boolean create(T o);

    boolean delete(int id);

    boolean update(T o);

    List<T> findAll();

    T findById(int id);

}