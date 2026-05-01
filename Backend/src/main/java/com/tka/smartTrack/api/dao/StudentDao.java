package com.tka.smartTrack.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tka.smartTrack.api.entity.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Long> {

    // equivalent of getAllStudentsById
    List<Student> findByIdIn(List<Long> studentIds);

}