package com.tt.teachers.pojo;

import java.io.Serializable;

public class Grade implements Serializable{
    private Integer gradeID;
    private String gradeName;

    public Grade(Integer gradeID) {
        this.gradeID = gradeID;
    }

    public Integer getGradeID() {
        return gradeID;
    }

    public void setGradeID(Integer gradeID) {
        this.gradeID = gradeID;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public Grade() {
    }

    public Grade(Integer gradeID, String gradeName) {
        this.gradeID = gradeID;
        this.gradeName = gradeName;
    }

}
