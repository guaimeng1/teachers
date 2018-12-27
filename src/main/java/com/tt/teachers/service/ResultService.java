package com.tt.teachers.service;

import com.tt.teachers.pojo.Result;
import com.tt.teachers.pojo.Subject;

import java.util.List;

public interface ResultService {
    List<Result> findResAll();

    int deleteResult(Integer resultNo);

    int updateResult(Result result2);

    int addResult(Result result2);

    List<Subject> getSubjectAll();
}
