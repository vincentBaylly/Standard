package org.highschool.service;

import java.util.List;

import org.highschool.dao.impl.TeacherDAO;
import org.highschool.model.impl.Teacher;

public class TeacherService {
	
	private TeacherDAO teacherDao;
	
	public TeacherService() {
		teacherDao = new TeacherDAO();
    }

	public boolean create(Teacher teacher) {
		return teacherDao.create(teacher);
	}

	public boolean delete(int id) {
		return teacherDao.delete(id);
	}

	public boolean update(Teacher teacher) {
		return teacherDao.update(teacher);
	}

	public List<Teacher> findAll() {
		return teacherDao.findAll();
	}

	public Teacher findById(int id) {
		return teacherDao.findById(id);
	}
}
