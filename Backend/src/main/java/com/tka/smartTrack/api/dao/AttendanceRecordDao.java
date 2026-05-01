package com.tka.smartTrack.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tka.smartTrack.api.entity.AttendanceRecord;

@Repository
public interface AttendanceRecordDao extends JpaRepository<AttendanceRecord, String> {

    List<AttendanceRecord> findByUserUsername(String facultyUsername);

    List<AttendanceRecord> findByUserUsernameAndSubjectIdAndDate(
            String faculty,
            long subjectId,
            String date
    );

    // ⭐ improved
    List<AttendanceRecord> findDistinctByDateAndSubjectId(String date, long subjectId);
}
