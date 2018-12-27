package com.tt.teachers.dao;

import com.tt.teachers.pojo.Subject;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SubjectDao {
    @Select("select * from subject")
    List<Subject> findSubAll();
    @Delete("delete from subject where subjectNo=#{subjectNo}")
    int deleteSubject(Integer subjectNo);
}
