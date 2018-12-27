package com.tt.teachers.service;

import com.tt.teachers.pojo.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> findSubAll();

    int deleteSubject(Integer subjectNo);
}
