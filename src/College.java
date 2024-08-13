import model.Entities.Lecture;
import model.users.FullTimeTeacher;
import model.users.PartTimeTeacher;
import model.users.Student;
import model.users.Teacher;

import java.util.ArrayList;
import java.util.List;

import static utils.inputs.*;
import static utils.inputs.getIntFromInput;

public class College {
    private String name;
    private final List<Lecture> globalLectures = new ArrayList<>();
    private final List<Student> globalStudents = new ArrayList<>();
    private final List<Teacher> globalTeachers = new ArrayList<>();

    public College(String name) {
        this.name = name;
    }


    public Student createStudent() {
        System.out.print("Enter student's name: ");
        String name = getStringFromInput();
        System.out.println(" ");
        System.out.print("Enter student's age: ");
        int age = getIntFromInput();
        System.out.println(" ");
        System.out.print("Enter student's identification: ");
        String identification = getStringFromInput();
        return new Student(name, age, identification);
    }

    public Teacher createTeacher(int teacherType) {
        System.out.print("Enter teacher's name: ");
        String name = getStringFromInput();
        System.out.println(" ");
        System.out.print("Enter teacher's age: ");
        int age = getIntFromInput();
        System.out.println(" ");
        System.out.print("Enter teacher's identification: ");
        String identification = getStringFromInput();
        System.out.println(" ");
        System.out.print("Enter teacher's base salary in pesos: $");
        double baseSalary = getFloatFromInput();
        Teacher newTeacher;
        switch (teacherType) {
            case 1:
                System.out.print("Enter teacher's experience years:");
                int experienceYears = getIntFromInput();
                newTeacher = new FullTimeTeacher(name, age, identification, baseSalary, experienceYears);
                return newTeacher;
            case 2:
                System.out.print("Enter teacher's hours per week:");
                int weeklyHours = getIntFromInput();
                newTeacher = new PartTimeTeacher(name, age, identification, baseSalary, weeklyHours);
                return newTeacher;
            default:
                break;
        }
        return null;
    }


    public List<Lecture> getGlobalLectures() {
        return globalLectures;
    }

    public List<Teacher> getGlobalTeachers() {
        return globalTeachers;
    }

    public List<Student> getGlobalStudents() {
        return globalStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
