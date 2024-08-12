package model.users;

import model.Entities.Lecture;

import java.util.List;

public class Student extends Person {

    private boolean active = false;
    private List<Lecture> lectures;

    public Student(String name, int age, String identification) {
        super(name, age, identification);
    }

    public String enroll(Lecture lecture) {
        this.lectures.add(lecture);
        return lecture.getName() + " Enrolled successfully";
    }

    public String getStudentData() {
        return this.getName() + " - CC " + this.getIdentification() + " - age:" + this.getAge();
    }
}
