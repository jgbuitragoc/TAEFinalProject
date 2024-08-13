package model.users;

import model.Entities.Lecture;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {

    private boolean active = false;
    private List<Lecture> lectures = new ArrayList<>();

    public Student(String name, int age, String identification) {
        super(name, age, identification);
    }

    public void enroll(Lecture lecture) {
        this.lectures.add(lecture);
    }

    public String getStudentData() {
        return this.getName() + " - CC " + this.getIdentification()
                + " - age:" + this.getAge();
    }

    public String getLecturesInfo() {
        StringBuilder lecturesInfo = new StringBuilder();
        for (Lecture lecture : this.lectures) {
            lecturesInfo.append(lecture.getName()).append("\n");
        }
        return lecturesInfo.toString();
    }
}
