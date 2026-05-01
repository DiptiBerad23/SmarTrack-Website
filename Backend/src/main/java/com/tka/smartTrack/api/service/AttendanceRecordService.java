package com.tka.smartTrack.api.service;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.smartTrack.api.dao.AttendanceRecordDao;
import com.tka.smartTrack.api.entity.AttendanceRecord;

@Service
public class AttendanceRecordService {

    @Autowired
    private AttendanceRecordDao dao;

    // ✅ get all
    public List<AttendanceRecord> getAllAttendanceRecords() {
        return dao.findAll();
    }

    // ✅ by faculty
    public List<AttendanceRecord> getAttendanceByFaculty(String facultyUsername) {
        return dao.findByUserUsername(facultyUsername);
    }

    // ✅ by date + subject (DISTINCT already handled in repo)
    public List<AttendanceRecord> getAllAttendanceRecords(String date, long subjectId) {
        return dao.findDistinctByDateAndSubjectId(date, subjectId);
    }

    // ✅ save (manual String id mode)
    public AttendanceRecord saveAttendance(AttendanceRecord attendanceRecord) {

        // generate id only if not present
        if (attendanceRecord.getId() == null || attendanceRecord.getId().isEmpty()) {
            String id = new SimpleDateFormat("yyyyMMddHHmmssSSS")
                    .format(new java.util.Date());
            attendanceRecord.setId(id);
        }

        return dao.save(attendanceRecord);
    }

    // ✅ faculty + subject + date
    public List<AttendanceRecord> getAttendanceByFacultySubjectDate(
            String faculty,
            long subjectId,
            String date) {

        return dao.findByUserUsernameAndSubjectIdAndDate(
                faculty, subjectId, date);
    }
}