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

    public String createLecture() {
        System.out.print("Enter class name:");
        String name = getStringFromInput();
        System.out.println(" ");
        globalLectures.add(new Lecture(name));
        return "Class created successfully.";
    }

    public String createStudent() {
        System.out.print("Enter student's name: ");
        String name = getStringFromInput();
        System.out.println(" ");
        System.out.print("Enter student's age: ");
        int age = getIntFromInput();
        System.out.println(" ");
        System.out.print("Enter student's identification: ");
        String identification = getStringFromInput();
        globalStudents.add(new Student(name, age, identification));
        return "Student created successfully.";
    }

    public String createTeacher() {
        int teacherType = 0;
        while (teacherType == 0) {
            System.out.println("Choose a type of teacher:");
            System.out.println("1. Full time teacher.");
            System.out.println("2. Part time teacher.");
            System.out.print("Type:");
            teacherType = getIntFromInput();
            if (teacherType > 2) { //number of options
                teacherType = 0;
            }
        }

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
                globalTeachers.add(newTeacher);
                return "Teacher created successfully.";
            case 2:
                System.out.print("Enter teacher's hours per week:");
                int weeklyHours = getIntFromInput();
                newTeacher = new PartTimeTeacher(name, age, identification, baseSalary, weeklyHours);
                globalTeachers.add(newTeacher);
                return "Teacher created successfully.";
            default:
                break;
        }
        return "Teacher not created!";
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
