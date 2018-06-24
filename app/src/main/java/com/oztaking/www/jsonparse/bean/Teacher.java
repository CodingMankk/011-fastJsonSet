package com.oztaking.www.jsonparse.bean;

/**
 * @function:
 */

import java.util.List;

/**
 *
 * {
 * "teacherName": "crystall",
 * "teacherAge": 27,
 * "course": {
 *        "courseName": "english",
 *        "code": 1270
 *              },
 * "students": [
 *       {
 *        "studentName": "lily",
 *        "studentAge": 12
 *        },
 *       {
 *        "studentName": "lucy",
 *        "studentAge": 15
 *        }
 *             ]
 *    }
 *
 */

public class Teacher {

    public String  teacherName;
    public Integer teacherAge;
    public Course course;
    public List<Student> students;

    public Teacher() {
    }

    public Teacher(String teacherName, Integer teacherAge, Course course, List<Student> students) {
        this.teacherName = teacherName;
        this.teacherAge = teacherAge;
        this.course = course;
        this.students = students;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getTeacherAge() {
        return teacherAge;
    }

    public void setTeacherAge(Integer teacherAge) {
        this.teacherAge = teacherAge;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherName='" + teacherName + '\'' +
                ", teacherAge=" + teacherAge +
                ", course=" + course +
                ", students=" + students +
                '}';
    }
}
