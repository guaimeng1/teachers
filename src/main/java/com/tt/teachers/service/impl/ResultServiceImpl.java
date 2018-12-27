package com.tt.teachers.service.impl;

import com.tt.teachers.dao.ResultDao;
import com.tt.teachers.pojo.Result;
import com.tt.teachers.pojo.Subject;
import com.tt.teachers.service.ResultService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {
    @Resource
    private ResultDao resultDao;

    public List<Result> findResAll() {
        return resultDao.findResAll();
    }

    @Transactional
    public int deleteResult(Integer resultNo) {
        return resultDao.deleteResult(resultNo);
    }

    @Transactional
    public int updateResult(Result result2) {
        return resultDao.updateResult(result2);
    }

    @Transactional
    public int addResult(Result result2) {
        return resultDao.addResult(result2);
    }

    public List<Subject> getSubjectAll() {
        return resultDao.getSubjectAll();
    }
}
