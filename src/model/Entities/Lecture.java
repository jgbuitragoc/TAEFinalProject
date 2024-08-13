package model.Entities;

import model.users.Student;
import model.users.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Lecture {
    private String name;
    private String classroom;
    private List<Student> students = new ArrayList<>();
    private Teacher teacher;

    public Lecture(String name) {
        this.name = name;
    }

    public String enrollStudent(Student student) {
        student.enroll(this);
        this.students.add(student);
        return student.getName() + " enrolled at " + this.getName() + " successfully.";
    }

    public String getLectureData() {
        String classroomInfo = this.classroom != null ? "in classroom " + this.classroom :
                "with no classroom yet";
        String teacherInfo = this.teacher != null ? "with teacher "
                + this.teacher.getName() : "with no teacher yet";
        String studentsInfo = this.students.isEmpty() ? "with no students yet." :
                "with the following students:\n" + getStudentsInfo();
        return this.name + " class " + classroomInfo + " " + teacherInfo + " " + studentsInfo;
    }

    private String getStudentsInfo() {
        StringBuilder studentsInfo = new StringBuilder();
        for (Student student : this.students) {
            studentsInfo.append(student.getStudentData()).append("\n");
        }
        return studentsInfo.toString();
    }



    // getter & setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
