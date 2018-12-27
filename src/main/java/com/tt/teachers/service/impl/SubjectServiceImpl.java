package com.tt.teachers.service.impl;

import com.tt.teachers.dao.SubjectDao;
import com.tt.teachers.pojo.Subject;
import com.tt.teachers.service.SubjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("subjectService")
public class SubjectServiceImpl implements SubjectService{
    @Resource
    private SubjectDao subjectDao;

    @Override
    public List<Subject> findSubAll() {
        return subjectDao.findSubAll();
    }

    @Transactional
    public int deleteSubject(Integer subjectNo) {
        return subjectDao.deleteSubject(subjectNo);
    }
}
