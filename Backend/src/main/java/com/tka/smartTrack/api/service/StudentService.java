package com.tka.smartTrack.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.smartTrack.api.dao.StudentDao;
import com.tka.smartTrack.api.entity.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDao dao;

	// ✅ get by multiple ids
	public List<Student> getAllStudentsById(List<Long> studentIds) {
		return dao.findByIdIn(studentIds);
	}

	// ✅ get all
	public List<Student> getAllStudents() {
		return dao.findAll();
	}

	// ✅ create
	public Student createStudent(Student student) {
		return dao.save(student);
	}

	// ✅ get by id
	public Student getStudentById(long id) {
		return dao.findById(id).orElse(null);
	}

	// ✅ update
	public Student updateStudent(Student studentDetails) {
		return dao.save(studentDetails);
	}

	// ✅ delete
	public String deleteStudent(long id) {
		if (dao.existsById(id)) {
			dao.deleteById(id);
			return "Deleted !!";
		}
		return "Not Exists !!";
	}
}