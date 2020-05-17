package org.highschool.service;

import java.util.List;

import org.highschool.dao.impl.StudentDAO;
import org.highschool.model.impl.Student;


public class StudentService {
	
	private StudentDAO studentDao;
	
	public StudentService() {
       studentDao = new StudentDAO();
    }

	public boolean create(Student student) {
		return studentDao.create(student);
	}

	public boolean delete(int id) {
		return studentDao.delete(id);
	}

	public boolean update(Student student) {
		return studentDao.update(student);
	}

	public List<Student> findAll() {
		return studentDao.findAll();
	}

	public Student findById(int id) {
		return studentDao.findById(id);
	}
}
