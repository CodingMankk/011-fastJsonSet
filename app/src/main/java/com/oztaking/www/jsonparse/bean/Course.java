package com.oztaking.www.jsonparse.bean;

/**
 * @function:
 */

public class Course {

    public String courseName;
    public Integer code;

    public Course() {
    }

    public Course(String courseName, Integer code) {
        this.courseName = courseName;
        this.code = code;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", code=" + code +
                '}';
    }
}
