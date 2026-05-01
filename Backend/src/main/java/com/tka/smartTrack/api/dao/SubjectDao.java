package com.tka.smartTrack.api.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tka.smartTrack.api.entity.Subject;

@Repository
public interface SubjectDao extends JpaRepository<Subject, Long> {

    // 🔍 for duplicate name check
    Optional<Subject> findByName(String name);

}