package com.tka.smartTrack.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.smartTrack.api.dao.SubjectDao;
import com.tka.smartTrack.api.entity.Subject;

@Service
public class SubjectService {

	@Autowired
	private SubjectDao dao;

	// ✅ get by id
	public Subject getSubjectById(long subjectId) {
		return dao.findById(subjectId).orElse(null);
	}

	// ✅ get all
	public List<Subject> getAllSubjects() {
		return dao.findAll();
	}

	// ✅ create with duplicate name check
	public Subject createSubject(Subject subject) {
		if (dao.findByName(subject.getName()).isPresent()) {
			return null; // already exists
		}
		return dao.save(subject);
	}

	// ✅ update
	public Subject updateSubject(Subject subjectDetails) {
		return dao.save(subjectDetails);
	}

	// ✅ delete
	public String deleteSubject(long id) {
		if (dao.existsById(id)) {
			dao.deleteById(id);
			return "deleted";
		}
		return "not exists";
	}
}